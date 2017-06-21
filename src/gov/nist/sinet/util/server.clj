(ns gov.nist.sinet.util.server
  "Server for sinet: show best Petri net, etc."
  {:author "Peter Denno"}
  (:require
   [ring.middleware.defaults]
   [compojure.core     :as comp :refer (defroutes GET POST)]                     ; POD not sure we'll keep this one
   [compojure.route    :as route]                                                ; POD not sure we'll keep this one
   [hiccup.core        :as hiccup]
   [clojure.core.async :as async  :refer (<! <!! >! >!! put! chan go go-loop)]
   [taoensso.encore    :as encore :refer (have have?)]                           ; POD not sure we'll keep this one
   [taoensso.timbre    :as timbre :refer (tracef debugf infof warnf errorf)]     ; POD not sure we'll keep this one
   [taoensso.sente     :as sente]
   [org.httpkit.server :as http-kit]
   [taoensso.sente.server-adapters.http-kit :refer (get-sch-adapter)]

   [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
   [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

(timbre/set-level! :info) ; Uncomment for more logging
;(reset! sente/debug-mode?_ true) ; Uncomment for extra debug info

;;;; Define our Sente channel socket (chsk) server

(let [;; Serializtion format, must use same val for client + server:
      packer :edn ; Default packer, a good choice in most cases
      ;; (sente-transit/get-transit-packer) ; Needs Transit dep

      chsk-server
      (sente/make-channel-socket-server!
       (get-sch-adapter) {:packer packer})

      {:keys [ch-recv send-fn connected-uids
              ajax-post-fn ajax-get-or-ws-handshake-fn]}
      chsk-server]

  (def ring-ajax-post                ajax-post-fn)
  (def ring-ajax-get-or-ws-handshake ajax-get-or-ws-handshake-fn)
  (def ch-chsk                       ch-recv) ; ChannelSocket's receive channel
  (def chsk-send!                    send-fn) ; ChannelSocket's send API fn
  (def connected-uids                connected-uids) ; Watchable, read-only atom
  )

;; We can watch this atom for changes if we like
(add-watch connected-uids :connected-uids
  (fn [_ _ old new]
    (when (not= old new)
      (infof "Connected uids change: %s" new))))

(defn- active-tab 
  [ & {:keys [tab] :or {tab :process}}]
  "Return HTML div metaltop-teal tabs, marking TAB as active."
  `[:ul
    ~@(map (fn [[k v]]
             (if (= k tab)
               `[:li {:class "active"} [:a {:href ~(str "/FacilitySearch/" (name k))} ~v]]
               `[:li                   [:a {:href ~(str "/FacilitySearch/" (name k))} ~v]]))
           {:process "Process", :product "Product", :equip "Equipment",
            :state "System State", :search "Search" :nb "Notebook"})])

(defmacro app-page-wrapper
  "Wrap pages with stylesheet, start session, etc."
  [args & body]
  `(hiccup/html [:html {:lang "en"}
                 [:head [:title "SINET"]
                  [:meta {:http-equiv "content-type" :content "text/html" :charset="iso-8859-1"}]
                  [:link {:rel "stylesheet" :type "text/css" :href "/style.css"}]] ; Really need /style.css STRANGE!
                 [:div {:id "metaltop-teal"} ~(active-tab :tab (:tab args))]
                 [:body ~@body]]))

;;;; Ring handlers
(defn landing-pg-handler [ring-req]
  (app-page-wrapper
   {:tab :process}
   [:h1 "SINET System Identification from SCADA Messages / Steady-state Behaviour"]
   [:table {:style "width:100%"}
    [:tr
     [:td [:canvas {:id "best-pn"}]]
     [:td [:p [:strong "GP Control"]]
      [:p
       [:button#btn1 {:type "button"} "chsk-send! (w/o reply)"]
       [:button#btn2 {:type "button"} "Update PN"]]
      [:p
       [:button#btn3 {:type "button"} "Test rapid server>user async pushes"]
       [:button#btn4 {:type "button"} "Toggle server>user async broadcast push loop"]]
      [:p
       [:button#btn5 {:type "button"} "Disconnect"]
       [:button#btn6 {:type "button"} "Reconnect"]]]]]
   [:p [:strong "Console"]]
   [:textarea#output {:style "width: 100%; height: 200px;"}]
   [:script {:src "js/main.js"}])) ; Include our cljs target. Must be at end of page.

(defn login-handler
  "Here's where you'll add your server-side login/auth procedure (Friend, etc.).
  In our simplified example we'll just always successfully authenticate the user
  with whatever user-id they provided in the auth request."
  [ring-req]
  (let [{:keys [session params]} ring-req
        {:keys [user-id]} params]
    (debugf "Login request: %s" params)
    {:status 200 :session (assoc session :uid user-id)}))

(defroutes ring-routes
  (GET  "/"      ring-req (landing-pg-handler            ring-req))
  (GET  "/chsk"  ring-req (ring-ajax-get-or-ws-handshake ring-req))
  (POST "/chsk"  ring-req (ring-ajax-post                ring-req))
  (POST "/login" ring-req (login-handler                 ring-req))
  (route/resources "/") ; Static files, notably public/main.js (our cljs target)
  (route/not-found "<h1>Page not found</h1>"))

(def main-ring-handler
  "**NB**: Sente requires the Ring `wrap-params` + `wrap-keyword-params`
  middleware to work. These are included with
  `ring.middleware.defaults/wrap-defaults` - but you'll need to ensure
  that they're included yourself if you're not using `wrap-defaults`."
  (ring.middleware.defaults/wrap-defaults
    ring-routes ring.middleware.defaults/site-defaults))

;(server>user-push-pn (pnml/read-pnml "data/m2-inhib-bbs.xml" :rescale? true))
(defn server>user-push-pn
  "Push Petri net (with its geometry) to the user "
  [pn]
  (doseq [uid (:any @connected-uids)]
    (chsk-send! uid [:sinet/new-pn pn])))

(defonce broadcast-enabled?_ (atom false)) ; POD was true

;;; Sente event handlers
(defmulti -event-msg-handler
  "Multimethod to handle Sente `event-msg`s"
  :id ; Dispatch on event-id
  )

(defn event-msg-handler
  "Wraps `-event-msg-handler` with logging, error catching, etc."
  [{:as ev-msg :keys [id ?data event]}]
  (-event-msg-handler ev-msg) ; Handle event-msgs on a single thread
  ;; (future (-event-msg-handler ev-msg)) ; Handle event-msgs on a thread pool
  )

(def +diag+ (atom nil))

(defmethod -event-msg-handler
  :draw/new-pn
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (reset! +diag+ {:from :draw/new-pn :event event :id id :?data ?data
                    :ring-req ring-req :?reply-fn ?reply-fn :send-fn send-fn})
    (when ?reply-fn
      (?reply-fn (random-pn)))))

(defmethod -event-msg-handler
  :default ; Default/fallback case (no other matching handler)
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (reset! +diag+ {:from :default :event event :id id :?data ?data
                    :ring-req ring-req :?reply-fn ?reply-fn :send-fn send-fn})
    (debugf "Unhandled event: %s" event)
    (when ?reply-fn
      (?reply-fn {:umatched-event-as-echoed-from-from-server event}))))

(defmethod -event-msg-handler :example/toggle-broadcast
  [{:as ev-msg :keys [?reply-fn]}]
  (let [loop-enabled? (swap! broadcast-enabled?_ not)]
    (?reply-fn loop-enabled?)))

;; TODO Add your (defmethod -event-msg-handler <event-id> [ev-msg] <body>)s here...

;;;; Sente event router (our `event-msg-handler` loop)

(defonce router_ (atom nil))
(defn  stop-router! [] (when-let [stop-fn @router_] (stop-fn)))
(defn start-router! []
  (stop-router!)
  (reset! router_
    (sente/start-server-chsk-router!
      ch-chsk event-msg-handler)))

;;; Init stuff ========================================
(defonce    web-server_ (atom nil)) ; (fn stop [])
(defn  stop-web-server! [] (when-let [stop-fn @web-server_] (stop-fn)))
(defn start-web-server! [& [port]]
  (stop-web-server!)
  (let [port (or port 0) ; 0 => Choose any available port
        ring-handler (var main-ring-handler)

        [port stop-fn]
        (let [stop-fn (http-kit/run-server ring-handler {:port port})]
          [(:local-port (meta stop-fn)) (fn [] (stop-fn :timeout 100))])
        uri (format "http://localhost:%s/" port)]
    (infof "Web server is running at `%s`" uri)
    (try
      (.browse (java.awt.Desktop/getDesktop) (java.net.URI. uri))
      (catch java.awt.HeadlessException _))
    (reset! web-server_ stop-fn)))

(defn stop!  []  (stop-router!)  (stop-web-server!))
(defn start! [] (start-router!) (start-web-server!) #_(start-example-broadcaster!))

(defn -main "For `lein run`, etc." [] (start!))

#_(comment
  (start!)
  (test-fast-server>user-pushes))

;;; Drawing stuff ========================================

;;; 14 files
(defn show-n [n] 
  (server>user-push-pn 
   (pnml/read-pnml (str "/Users/pdenno/Documents/git/spntools/data/" 
                        (nth pnml/files n))
                   :rescale? true)))

(defn random-pn []
  (pnml/read-pnml (str "/Users/pdenno/Documents/git/spntools/data/" 
                       (nth pnml/files (rand-int 14)))
                  :rescale? true))

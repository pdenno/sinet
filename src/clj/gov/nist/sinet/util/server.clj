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

   [gov.nist.sinet.util.utils :refer :all]
   [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
   [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

(def +diag+ (atom nil))

(timbre/set-level! :info) ; Uncomment for more logging
;(reset! sente/debug-mode?_ true) ; Uncomment for extra debug info

;;;; Define our Sente channel socket (chsk) server
#_(let [packer :edn ; Default packer, a good choice in most cases
      chsk-server (sente/make-channel-socket-server!
                   (get-sch-adapter) {:packer packer})
      {:keys [ch-recv send-fn connected-uids
              ajax-post-fn ajax-get-or-ws-handshake-fn]}
      chsk-server]
  (def ring-ajax-post                ajax-post-fn)
  (def ring-ajax-get-or-ws-handshake ajax-get-or-ws-handshake-fn)
  (def ch-chsk                       ch-recv) ; ChannelSocket's receive channel
  (def chsk-send!                    send-fn) ; ChannelSocket's send API fn
  (def connected-uids                connected-uids)) ; Watchable, read-only atom

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
  "Return HTML div metaltop-teal tabs, marking TAB as active."
  [ & {:keys [tab] :or {tab :process}}]
  `[:ul
    ~@(map (fn [[k v]]
             (if (= k tab)
               `[:li {:class "active"} [:a {:href ~(str "/sinet/" (name k))} ~v]]
               `[:li                   [:a {:href ~(str "/sinet/" (name k))} ~v]]))
           {:search "Search" :msg "Message Grammar", :console "Console"})])

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
   {:tab :search}
   [:h1 "SINET System Identification from SCADA Messages / Steady-state Behaviour"]
   [:table {:style "width:100%"}
    [:tr
     [:td [:canvas {:id "best-pn"}]]
     [:td [:p [:strong "GP Control"]]
      [:p
       #_[:div {:id "chunky-buttons"}
        [:div {:class "chunky24"} [:a {:href "foo"} "My Chunky Button"]]]
       [:button#btn1 {:type "button"} "chsk-send! (w/o reply)"]]
      [:p
       [:button#pop+ {:type "button"} "View Pop +"]
       [:button#pop- {:type "button"} "View Pop -"]]
      [:p
       [:button#btn5 {:type "button"} "Disconnect"]
       [:button#btn6 {:type "button"} "Reconnect"]]]]]
   #_[:p [:strong "Console"]]
   [:textarea#output {:style "width: 100%; height: 200px;"}]
   [:script {:src "js/main.js"}] ; POD I tried placing these in the head. NG.
   [:script {:type "text/javascript" :src "js/processing.js"}]))

(defn req-individual
  "Push the requested individual to the client"
  [ring-req]
  (reset! +diag+ ring-req))

(defroutes ring-routes
  (GET  "/"      ring-req (landing-pg-handler            ring-req))
  (GET  "/chsk"  ring-req (ring-ajax-get-or-ws-handshake ring-req)) ; POD These are essential; part of how...
  (POST "/chsk"  ring-req (ring-ajax-post                ring-req)) ; ...the protocol works. 
  (route/resources "/") ; Static files, notably public/main.js (our cljs target)
  (route/not-found "<h1>Page not found</h1>"))

(def main-ring-handler
  "**NB**: Sente requires the Ring `wrap-params` + `wrap-keyword-params`
  middleware to work. These are included with
  `ring.middleware.defaults/wrap-defaults` - but you'll need to ensure
  that they're included yourself if you're not using `wrap-defaults`."
  (ring.middleware.defaults/wrap-defaults
    ring-routes ring.middleware.defaults/site-defaults))

;;;(server>gui-push-inv (nth @+pop+ 1))
;;; POD So far, this one is just for debugging. 
(defn server>gui-push-inv
  "Push Petri net (with its geometry) to the GUI."
  [inv]
  (if-let [uid (-> @connected-uids :ws first)]
    (chsk-send! uid [:sinet/new-pn (inv-geom inv)])
    (infof "No uid when pushing PN to GUI.")))

(defn server>gui-push-event
  "Push an event (keyword) to the GUI"
  [event-name]
  (if-let [uid (-> @connected-uids :ws first)]
    (chsk-send! uid [:sinet/event event-name])
    (infof "No uid when pushing event notification to GUI.")))

(defonce broadcast-enabled?_ (atom false)) ; POD was true

; Dispatch on event-id
(defn- -event-msg-handler-dispatch [event]
  (when-not (= (:id event) :chsk/ws-ping)
    ;(println "dispatch, event id =" (:id event)))
  (:id event))

;;; Sente event handlers
(defmulti -event-msg-handler #'-event-msg-handler-dispatch)
  
(defn event-msg-handler
  "Wraps `-event-msg-handler` with logging, error catching, etc."
  [{:as ev-msg :keys [id ?data event]}]
  (-event-msg-handler ev-msg) ; Handle event-msgs on a single thread
  #_(future (-event-msg-handler ev-msg))) ; Handle event-msgs on a thread pool

(declare random-pn) ; POD temporary
(defmethod -event-msg-handler ; POD temporary
  :draw/new-pn
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (when ?reply-fn
      (?reply-fn (random-pn)))))

(defmethod -event-msg-handler
  :example/button1 ; POD added
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (debugf "POD Now handled: %s" event)
    (when ?reply-fn
      (?reply-fn {:yes-handeled event}))))

(defmethod -event-msg-handler
  :sinet/get-individual
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)
        pn-id   (:id ?data)]
    (debugf "get-individual: %s" pn-id)
    (when ?reply-fn
      (when (and (>= pn-id 0) (< pn-id (count @+pop+)))
        (?reply-fn (-> (nth @+pop+ (:id ?data)) inv-geom :pn))))))

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
(defn restart! [] (stop!) (start!))

(defn -main "For `lein run`, etc." [] (start!))

;;; Drawing stuff (temporary)  ========================================

;;; 14 files
(defn show-n [n] 
  (server>gui-push-inv 
   (pnml/read-pnml (str "/Users/pdenno/Documents/git/spntools/data/" (nth pnml/files n)))))

(defn random-pn []
  (pnml/read-pnml (str "/Users/pdenno/Documents/git/spntools/data/" 
                       (nth pnml/files (rand-int 14)))))

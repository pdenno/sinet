(ns gov.nist.sinet.util.client
  "SINET client (user interface sans quil drawing)"
  {:author "Peter Denno"}
  (:require [clojure.string  :as str]
            [cljs.core.async :as async  :refer (<! >! put! chan)]
            [taoensso.encore :as encore :refer-macros (have have?)]
            [taoensso.timbre :as timbre :refer-macros (tracef debugf infof warnf errorf)]
            [taoensso.sente  :as sente  :refer (cb-success?)]
            [gov.nist.sinet.util.draw :as draw :refer (+display-pn+)]
            [quil.core :as quil :include-macros true]
            [quil.middleware :as qm])
  (:require-macros
   [cljs.core.async.macros :as asyncm :refer (go go-loop)]))

(timbre/set-level! :error) ; :trace :debug etc. for more logging

;;; Util for logging output to on-screen console
(def output-el (.getElementById js/document "output"))
(defn ->output! [fmt & args]
  (let [msg (apply encore/format fmt args)]
    (timbre/debug msg)
    (aset output-el "value" (str "• " (.-value output-el) "\n" msg))
    (aset output-el "scrollTop" (.-scrollHeight output-el))))

(->output! "ClojureScript appears to have loaded correctly.")

;;; Define our Sente channel socket (chsk) client
#_(let [{:keys [chsk ch-recv send-fn state]}
      (sente/make-channel-socket-client!
       "/chsk" ; Must match server Ring routing URL
       {:type :auto  ; POD :auto = websocket if possible, I think!
        :packer :edn ; Default packer, used for client & server.
        :ws-kalive-ms 50000})] ; POD added, and I'm guessing.
  (def chsk       chsk)
  (def ch-chsk    ch-recv) ; ChannelSocket's receive channel
  (def chsk-send! send-fn) ; ChannelSocket's send API fn
  (def chsk-state state)   ; Watchable, read-only atom
  )

(let [;; For this example, select a random protocol:
      rand-chsk-type :auto ;(if (>= (rand) 0.5) :ajax :auto)
      _ (->output! "Randomly selected chsk type: %s" rand-chsk-type)

      ;; Serializtion format, must use same val for client + server:
      packer :edn ; Default packer, a good choice in most cases
      ;; (sente-transit/get-transit-packer) ; Needs Transit dep

      {:keys [chsk ch-recv send-fn state]}
      (sente/make-channel-socket-client!
        "/chsk" ; Must match server Ring routing URL
        {:type   rand-chsk-type
         :packer packer})]

  (def chsk       chsk)
  (def ch-chsk    ch-recv) ; ChannelSocket's receive channel
  (def chsk-send! send-fn) ; ChannelSocket's send API fn
  (def chsk-state state)   ; Watchable, read-only atom
  )


; Dispatch on event-id
(defn- -event-msg-handler-dispatch [event]
  (or (:id event) :default))

;;; Sente event handlers
(defmulti -event-msg-handler #'-event-msg-handler-dispatch)

(defn event-msg-handler
  "Wraps `-event-msg-handler` with logging, error catching, etc."
  [{:as ev-msg :keys [id ?data event]}]
  (-event-msg-handler ev-msg))

(defmethod -event-msg-handler
  :default ; Default/fallback case (no other matching handler)
  [{:as ev-msg :keys [event]}]
  (->output! "Unhandled event: %s" event))

(defmethod -event-msg-handler :chsk/state
  [{:as ev-msg :keys [?data]}]
  (let [[old-state-map new-state-map] (have vector? ?data)]
    (if (:first-open? new-state-map)
      (->output! "Channel socket successfully established!: %s" new-state-map)
      (->output! "Channel socket state change: %s"              new-state-map))))

(def +diag+ (atom nil))

;;; This is for things pushed from server
(defmethod -event-msg-handler :chsk/recv
  [{:as ev-msg :keys [?data]}]
  (reset! +diag+ ev-msg)
  (->output! "Pushed event from server: %s" (first ?data))
  (let [msg-type (first ?data)]
    (cond 
      (= msg-type :sinet/new-pn) (reset! gov.nist.sinet.util.draw/+display-pn+ (:pn (second ?data)))
      (= msg-type :sinet/event)  (->output! "Event from Sinet: %s" (second ?data)))))

(defmethod -event-msg-handler :chsk/handshake
  [{:as ev-msg :keys [?data]}]
  (let [[?uid ?csrf-token ?handshake-data] ?data]
    (->output! "Handshake: %s" ?data)))

;; TODO Add your (defmethod -event-msg-handler <event-id> [ev-msg] <body>)s here...

;;; Sente event router (our `event-msg-handler` loop)
(defonce router_ (atom nil))
(defn  stop-router! [] (when-let [stop-f @router_] (stop-f)))
(defn start-router! []
  (stop-router!)
  (reset! router_
    (sente/start-client-chsk-router!
      ch-chsk event-msg-handler)))

;;; UI events
#_(when-let [target-el (.getElementById js/document "btn1")]
  (.addEventListener target-el "click"
    (fn [ev]
      (->output! "Button 1 was clicked (won't receive any reply from server)")
      (chsk-send! [:example/button1 {:had-a-callback? "nope"}]))))

(when-let [target-el (.getElementById js/document "btn1")]
  (.addEventListener target-el "click"
    (fn [ev]
      (->output! "Button 1 was clicked (will receive reply from server)")
      (chsk-send! [:example/button1 {:had-a-callback? "indeed"}] 5000
        (fn [cb-reply] (->output! "Callback reply: %s" cb-reply))))))

(def viewing-pn "What PN is displayed" (atom -1))

(when-let [target-el (.getElementById js/document "pop+")]
  (.addEventListener target-el "click"
    (fn [ev]
      ;(->output! "pop+ button was clicked (get-individual-plus)")
      (chsk-send! [:sinet/get-individual {:id (swap! viewing-pn inc)}] 5000
        (fn [cb-reply]
          (->output! "Received PN %s." @viewing-pn)
          (reset! +diag+ cb-reply)
          (reset! gov.nist.sinet.util.draw/+display-pn+ cb-reply))))))

(when-let [target-el (.getElementById js/document "pop-")]
    (.addEventListener target-el "click"
    (fn [ev]
      ;(->output! "pop- button was clicked (get-individual-minus)")
      (chsk-send! [:sinet/get-individual {:id (swap! viewing-pn dec)}] 5000
        (fn [cb-reply]
          (->output! "Received PN %s." @viewing-pn)                    
          (reset! gov.nist.sinet.util.draw/+display-pn+ cb-reply))))))

(when-let [target-el (.getElementById js/document "btn5")]
  (.addEventListener target-el "click"
                     (fn [ev]
                       (->output! "Disconnecting")
                       (sente/chsk-disconnect! chsk))))

(when-let [target-el (.getElementById js/document "btn6")]
  (.addEventListener target-el "click"
                     (fn [ev]
                       (->output! "Reconnecting")
                       (sente/chsk-reconnect! chsk))))

;;; Init stuff  ----------------
(defn start! [] (start-router!))

(defonce _start-once (start!))

(quil/defsketch best-pn ;cljs :features [:resizable :keep-on-top]
  :host "best-pn"
  :title "Best Individual"
  :settings #(fn [] (quil/smooth 2) #_(quil/scale 2)) ; Smooth=2 is typical. Can't use pixel-density with js.
  :setup draw/setup-pn
  :draw draw/draw-pn
  :mouse-wheel draw/pn-wheel-fn
  :size [900 500]) ; POD This is used in pnml/rescale. I need a solution for getting it here!

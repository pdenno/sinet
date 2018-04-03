(ns gov.nist.sinet.ws
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [clojure.core.async :as async]
            [taoensso.sente.server-adapters.http-kit :as sente-http]
            [taoensso.sente :as sente]
            [gov.nist.spntools.utils :as pnu :refer (ppprint ppp)]))

(def ping-counts (atom 0))

;;;  ~/Documents/clojure/sente/src/taoensso/sente.cljc:
;;;  NB performance note: since your `event-msg-handler` fn will be executed
;;;  within a simple go block, you'll want this fn to be ~non-blocking
;;;  (you'll especially want to avoid blocking IO) to avoid starving the
;;;  core.async thread pool under load. To avoid blocking, you can use futures,
;;;  agents, core.async, etc. as appropriate.

; Dispatch on event-id
(defn- event-msg-handler-dispatch [event]
  (when-not (= (:id event) :chsk/ws-ping)
    (log/debug (str "dispatch, event id =" (:id event))))
  (:id event))

;;; Sente event handlers
(defmulti event-msg-handler #'event-msg-handler-dispatch)

;;; "POD added because there is no clojure/add-method and NS problems with defining one elsewhere."
(defonce event-methods (atom {}))

(defn register-method
  "POD added to 'add methods'"
  [tag fn]
  (swap! event-methods #(assoc % tag fn)))

;; Wrap for logging, catching, etc.:
(defn  event-msg-handler* [{:as ev-msg :keys [id ?data event]}]
  (log/debug (str "dispatch, event id =" (:id event)))
  (if (contains? @event-methods id)
    ((get @event-methods id) ev-msg)
    (event-msg-handler ev-msg)))

(defmethod event-msg-handler :chsk/ws-ping
  [_]
  (swap! ping-counts inc)
  #_(when (= 0 (mod @ping-counts 100))
    (println "ping count: " @ping-counts)))

(defmethod event-msg-handler :rente/testevent
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (if ?reply-fn
    (?reply-fn [:rente/testevent {:message (str "Hello socket from server Callback, received: " ?data)}])
    (send-fn :sente/all-users-without-uid
             [:rente/testevent {:message (str "Hello socket from server Event (no callback), received: " ?data)}])))

(defmethod event-msg-handler :default ; Fallback (POD sort of)
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (println "Unhandled event: " event "id = " id)
    (when ?reply-fn
      (?reply-fn {:umatched-event-as-echoed-from-from-server event}))))

(defrecord WSRingHandlers [ajax-post-fn ajax-get-or-ws-handshake-fn])

(defn my-ws-error-handler
  "Errors only seem to occur when I'm trying to stop it with component/stop"
  [ch-recv]
  (fn [e event-message]
    (when ch-recv
      (repeatedly 10 #(async/take! ch-recv identity))
      (async/close! ch-recv))))

(defrecord WSConnection [ch-recv connected-uids send-fn ring-handlers stop-fn]
  component/Lifecycle
  (start [component]
    (if (and ch-recv connected-uids send-fn ring-handlers) ; this is what rente has
      component
      (let [component (component/stop component)
            {:keys [ch-recv send-fn connected-uids
                    ajax-post-fn ajax-get-or-ws-handshake-fn]}
            (sente/make-channel-socket! sente-http/http-kit-adapter {:packer :edn})]
        (log/debug "WebSocket connection started")
        (when-not ch-recv (log/debug "No ch-recv !"))
        (when-not event-msg-handler* (log/debug "No event-msg handler ?!?"))
        (assoc component
               :ch-recv ch-recv
               :connected-uids connected-uids
               :send-fn send-fn
               :ring-handlers
               (->WSRingHandlers ajax-post-fn ajax-get-or-ws-handshake-fn)
               :stop-fn (sente/start-server-chsk-router!
                         ch-recv
                         event-msg-handler*
                         :error-handler (my-ws-error-handler ch-recv))))))
  (stop [component]
    (when ch-recv
      (repeatedly 10 #(async/take! ch-recv identity))
      (async/close! ch-recv))
    (log/debug "WebSocket connection stopped")
    (if stop-fn (stop-fn) (log/debug "WS did not have a stop-fn!"))
    (assoc component
           :ch-recv nil :stop-fn nil :connected-uids nil :send-fn nil :ring-handlers nil)))

(defn send!  [ws-connection user-id event]
  ((:send-fn ws-connection) user-id event))

(defn broadcast! [ws-connection event]
  (let [uids (ws-connection :connected-uids )]
    (doseq [uid (:any @uids)] (send! ws-connection uid event))))

(defn ring-handlers [ws-connection]
  (:ring-handlers ws-connection))

;;; This is used in system.clj:
(defn new-ws-connection []
  (let [{:keys [ch-recv send-fn connected-uids
                ajax-post-fn ajax-get-or-ws-handshake-fn]}
        (sente/make-channel-socket! sente-http/http-kit-adapter {:packer :edn})]
    (log/debug "WebSocket connection started")
    (map->WSConnection {:ch-recv ch-recv
                        :connected-uids connected-uids
                        :send-fn send-fn
                        :ring-handlers
                        (->WSRingHandlers ajax-post-fn ajax-get-or-ws-handshake-fn)
                        :stop-fn (sente/start-chsk-router! ch-recv event-msg-handler*)})))


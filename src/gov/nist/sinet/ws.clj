(ns gov.nist.sinet.ws
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [clojure.core.async :as async]
            [taoensso.sente.server-adapters.http-kit :as sente-http]
            [taoensso.sente :as sente]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]))

(def ping-counts (atom 0))

; Dispatch on event-id
(defn- event-msg-handler-dispatch [event]
  (when-not (= (:id event) :chsk/ws-ping)
    (log/info (str "dispatch, event id =" (:id event))))
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
  ;(println "wrapper, id = " id)
  (if (contains? @event-methods id)
    (do ;(log/info (str "event-method " id))
        ((get @event-methods id) ev-msg))
  (event-msg-handler ev-msg)))

(defmethod event-msg-handler :chsk/ws-ping
  [_]
    (swap! ping-counts inc)
    (when (= 0 (mod @ping-counts 10))
      (println "ping counts: " @ping-counts)))

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

(defrecord WSConnection [ch-recv connected-uids send-fn ring-handlers]
  component/Lifecycle
  (start [component]
    (if (and ch-recv connected-uids send-fn ring-handlers)
      component
      (let [component (component/stop component)
            {:keys [ch-recv send-fn connected-uids
                    ajax-post-fn ajax-get-or-ws-handshake-fn]}
            (sente/make-channel-socket! sente-http/http-kit-adapter {:packer :edn})]
        (log/debug "WebSocket connection started")
        (assoc component
          :ch-recv ch-recv
          :connected-uids connected-uids
          :send-fn send-fn
          :stop-the-thing (sente/start-chsk-router! ch-recv event-msg-handler*)
          :ring-handlers
          (->WSRingHandlers ajax-post-fn ajax-get-or-ws-handshake-fn)))))
  (stop [component]
    (when ch-recv (async/close! ch-recv))
    (log/debug "WebSocket connection stopped")
    ;; stop is called from start; in that case, stop-fn won't be set.
    (when-let [stop-fn (:stop-the-thing component)] (stop-fn)) 
    (assoc component
      :ch-recv nil :connected-uids nil :send-fn nil :ring-handlers nil)))

(defn send!  [ws-connection user-id event]
  ((:send-fn ws-connection) user-id event))

(defn broadcast! [ws-connection event]
  (let [uids (ws-connection :connected-uids )]
    (doseq [uid (:any @uids)] (send! ws-connection uid event))))

(defn ring-handlers [ws-connection]
  (:ring-handlers ws-connection))

(def +ws+ (atom nil))

;;; POD The following is used in system.clj.
;;; I add the atom because I'm sort of lost as to how component works!
(defn new-ws-connection []
  (map->WSConnection {}))

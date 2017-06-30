(ns gov.nist.sinet.ws
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [clojure.core.async :as async]
            [taoensso.sente.server-adapters.http-kit :as sente-http]
            [taoensso.sente :as sente]
            [taoensso.sente.packers.transit :as sente-transit]
            [gov.nist.sinet.utils :as utils]))

(def ping-counts (atom 0))

(defmulti event-msg-handler :id) ; Dispatch on event-id
;; Wrap for logging, catching, etc.:
(defn     event-msg-handler* [{:as ev-msg :keys [id ?data event]}]
  (event-msg-handler ev-msg))

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

(defmethod event-msg-handler :default ; Fallback
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (let [session (:session ring-req)
        uid     (:uid     session)]
    (println "Unhandled event: %s" event)
    (when ?reply-fn
      (?reply-fn {:umatched-event-as-echoed-from-from-server event}))))

(defrecord WSRingHandlers [ajax-post-fn ajax-get-or-ws-handshake-fn])

(defrecord WSConnection [ch-recv connected-uids send-fn ring-handlers]
  component/Lifecycle
  (start [component]
    (if (and ch-recv connected-uids send-fn ring-handlers)
      component
      (let [component (component/stop component)
            packer :edn
            {:keys [ch-recv send-fn connected-uids
                    ajax-post-fn ajax-get-or-ws-handshake-fn]}
            (sente/make-channel-socket! sente-http/http-kit-adapter {:packer packer})]
        (log/info "WebSocket connection started") ; POD was log/debug
        (assoc component
          :ch-recv ch-recv
          :connected-uids connected-uids
          :send-fn send-fn
          :stop-the-thing (sente/start-chsk-router! ch-recv event-msg-handler*)
          :ring-handlers
          (->WSRingHandlers ajax-post-fn ajax-get-or-ws-handshake-fn)))))
  (stop [component]
    (when ch-recv (async/close! ch-recv))
    (log/info "WebSocket connection stopped") ; POD was log/debug
    (:stop-the-thing component)
    (assoc component
      :ch-recv nil :connected-uids nil :send-fn nil :ring-handlers nil)))

(defn send! [ws-connection user-id event]
  ((:send-fn ws-connection) user-id event))

(defn broadcast! [ws-connection event]
  (let [uids (ws-connection :connected-uids )]
    (doseq [uid (:any @uids)] (send! ws-connection uid event))))

(defn ring-handlers [ws-connection]
  (:ring-handlers ws-connection))

;;; The following is used in system.clj
(defn new-ws-connection []
  (map->WSConnection {}))

;;;=============== My stuff from server.clj -- some belongs in GP?
(defn clean-pn-for-transmit [pn]
  "Sente can't send functions, at least."
  (as-> pn ?pn
    (update ?pn :transitions (fn [t] (vec (map #(dissoc % :fn) t))))))

(defn get-individual 
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (if (empty? @utils/+pop+)
    (log/info "No population in get-individual!")
    (let [session (:session ring-req)
          uid     (:uid     session)
          pn-id   (:id ?data)]
      (log/info "get-individual: %s" pn-id)
      (when ?reply-fn
        (when (and (>= pn-id 0) (< pn-id (count @utils/+pop+)))
          (?reply-fn (-> (nth @utils/+pop+ (:id ?data)) utils/inv-geom :pn clean-pn-for-transmit)))))))

(defmethod event-msg-handler
  :sinet/get-individual
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (println "get-individual...")
  (get-individual ev-msg))

;;;(server>gui-push-inv (nth @+pop+ 1))
;;; POD So far, this one is just for debugging. 
#_(defn server>gui-notify-new-gen
  "Push Petri net (with its geometry) to the GUI."
  [report]
  (let [uids (ws-connection :connected-uids )] ; <===================================
    (if-let [uid (-> @uids :any first)]
      (send! uid [:sinet/new-generation report])
      (log/info "notify-new-gen failed -- BTW using log/debug"))))

(defn get-individual 
  [{:as ev-msg :keys [event id ?data ring-req ?reply-fn send-fn]}]
  (if (empty? @utils/+pop+)
    (log/info "No population in get-individual!")
    (let [session (:session ring-req)
          uid     (:uid     session)
          pn-id   (:id ?data)]
      (log/info "get-individual: %s" pn-id)
      (when ?reply-fn
        (when (and (>= pn-id 0) (< pn-id (count @utils/+pop+)))
          (?reply-fn (-> (nth @utils/+pop+ (:id ?data)) utils/inv-geom clean-pn-for-transmit)))))))


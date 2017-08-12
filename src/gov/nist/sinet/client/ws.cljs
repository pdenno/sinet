(ns gov.nist.sinet.client.ws
  (:require [clojure.string :as str]
            [taoensso.encore :as encore :refer-macros (have have?)] ; POD two logging facilities
            [taoensso.timbre :as timbre :refer-macros (tracef debugf infof warnf errorf)] ; POD two logging facilities
            [taoensso.sente :as sente]
            [reagent.core :as reagent]
            [re-frame.core :as rf]))


(timbre/set-level! :error) ; :trace :debug etc. for more logging

(defonce output-atom (reagent/atom "Intentionally blank"))

(def output-el (.getElementById js/document "output"))
(defn ->output! [fmt & args]
  (let [msg (apply encore/format fmt args)]
    (timbre/debug msg)
    (swap! output-atom #(str % "\n" msg))))

(->output! "ClojureScript appears to have loaded correctly.")

(defmulti push-msg-handler (fn [[id _]] id)) ; Dispatch on event key which is 1st elem in vector

(defmethod push-msg-handler :rente/testevent
  [[_ event]]
  (js/console.log "PUSHed :rente/testevent from server: %s " (pr-str event)))

(defmulti event-msg-handler :id) ; Dispatch on event-id
;; Wrap for logging, catching, etc.:

(defmethod event-msg-handler :default ; Fallback
    [{:as ev-msg :keys [event]}]
    (js/console.log "Unhandled event: %s" (pr-str event)))

(defmethod event-msg-handler :chsk/state
  [old-ev-msg new-ev-msg]
  (if (= (:?data new-ev-msg) {:first-open? true})
    (js/console.log "Channel socket successfully established!")
    (js/console.log "Channel socket state change: %s" (pr-str new-ev-msg))))

;;; This is for things pushed from server
(defmethod event-msg-handler :chsk/recv
  [{:as ev-msg :keys [?data]}]
  (->output! "Received event pushed from server: %s " (first ?data))
  (let [msg-type (first ?data)]
    (cond 
      (= msg-type :sinet/generation-report)
      (rf/dispatch [:sinet/recv-report (second ?data)]),
      (= msg-type :sinet/diag-push-pn)
      (rf/dispatch [:sinet/recv-pn (second ?data)]),
      (= msg-type :sinet/event)
      (->output! "Event from Sinet: %s" (second ?data)))))

(defmethod event-msg-handler :chsk/handshake
  [{:as ev-msg :keys [?data]}]
  (let [[?uid ?csrf-token ?handshake-data] ?data]
    (->output! "Handshake: %s" ?data)))

(defn event-msg-handler* [{:as ev-msg :keys [id ?data event]}]
  (event-msg-handler ev-msg))

(let [{:keys [chsk ch-recv send-fn state]}
      (sente/make-channel-socket! "/chsk" {:type :auto :packer :edn})]
  (def chsk       chsk)
  (def ch-chsk    ch-recv)
  (def chsk-send! send-fn)
  (def chsk-state state))

(sente/start-chsk-router! ch-chsk event-msg-handler*)

(defn test-socket-callback []
  (chsk-send!
    [:rente/testevent {:message "Hello socket Callback!"}]
    2000
    #(js/console.log "CALLBACK from server: " (pr-str %))))

(defn test-socket-event []
  (chsk-send! [:rente/testevent {:message "Hello socket Event!"}]))

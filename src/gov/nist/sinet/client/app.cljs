(ns gov.nist.sinet.client.app
    (:require-macros [cljs.core.async.macros :refer [go-loop]])
    (:require [reagent.core :as reagent]
              [gov.nist.sinet.client.views :as views]
              [gov.nist.sinet.client.ws :as ws]))

(defonce state (reagent/atom {:title "SINET"
                              :messages []
                              :re-render-flip false}))


(defmulti handle-event (fn [data [ev-id ev-data]] ev-id))

(defmethod handle-event :default
  [data [_ msg]]
  (swap! data update-in [:messages] #(conj % msg)))

(defn app [data]
  (:re-render-flip @data)
  [views/main data])

(defn ^:export main []
  (when-let [root (.getElementById js/document "app")]
    (reagent/render-component [app state] root)))

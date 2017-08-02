(ns gov.nist.sinet.client.app
    (:require-macros [cljs.core.async.macros :refer [go-loop]])
    (:require [reagent.core :as reagent]
              [re-frisk.core :refer [enable-frisk! #_enable-re-frisk!]]
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

;;; See ~/Documents/git/sinet/resources-index/dev/index.html for "app"
(defn ^:export main []
  #_(dispatch-sync [:initialize]) ; if/when I start using re-frame
  (enable-frisk!)                 ; if/when I start using re-frame this becomes enable-re-frisk
  (when-let [root (.getElementById js/document "app")]
    (reagent/render-component [app state] root)))

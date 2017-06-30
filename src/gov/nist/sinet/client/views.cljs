(ns gov.nist.sinet.client.views
  (:require [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn)]
            [reagent.core :as rea]))

(defn start-evolve
  [{:as args}]
  (ws/chsk-send! [:sinet/evolve {:status :best-wishes}]))

(defn buttons []
  [:div.buttons
   "Buttons"
   [:button {:on-click start-evolve} "Evolve"]
   [:br]
   [:button {:on-click start-evolve} "Evolve again"]])

;;; Util for logging output to on-screen console

(defn console-area []
  [:div#console
   [:h2 "Console"]
   [:textarea {:value @ws/output-atom :readOnly true
               :style {:width "100%" :height "200px"}}]])
(defn pn-area []
  [:div#pn
   [:canvas {:id "best-pn"}]])

#_(defn simple-example []
  [:div
   [greeting "SINET"]
   [clock]
   [color-input]
   [buttons]
   [output-area]])

(defn main [data]
  [:div
   [:h1 (:title @data)]
   [:div "Hello world! This is reagent speaking!"]
   [console-area]
   [:br]
   [:div "Look in your browsers developer console to see the web socket communication when clicking below buttons."]
   [:br]
   [:button {:on-click start-evolve} "Evolve"]
   [:br]
   [:button {:on-click ws/test-socket-event} "Send Message Event"]])


#_(quil/defsketch best-pn ;cljs :features [:resizable :keep-on-top]
  :host "best-pn"
  :title "Best Individual"
  :settings #(fn [] (quil/smooth 2) #_(quil/scale 2)) ; Smooth=2 is typical. Can't use pixel-density with js.
  :setup draw/setup-pn
  :draw draw/draw-pn
  :mouse-wheel draw/pn-wheel-fn
  :size [900 500]) ; POD This is used in pnml/rescale. I need a solution for getting it here!



#_(when-let [target-el (.getElementById js/document "pop+")]
  (.addEventListener target-el "click"
    (fn [ev]
      (->output! "pop+ button was clicked (get-individual-plus)")
      (chsk-send! [:sinet/get-individual {:id (swap! viewing-pn inc)}] 5000
        (fn [cb-reply]
          (->output! "Received PN %s." @viewing-pn)
          (reset! gov.nist.sinet.util.draw/+display-pn+ cb-reply))))))

#_(when-let [target-el (.getElementById js/document "pop-")]
    (.addEventListener target-el "click"
    (fn [ev]
      ;(->output! "pop- button was clicked (get-individual-minus)")
      (chsk-send! [:sinet/get-individual {:id (swap! viewing-pn dec)}] 5000
        (fn [cb-reply]
          (->output! "Received PN %s." @viewing-pn)                    
          (reset! gov.nist.sinet.util.draw/+display-pn+ cb-reply))))))

#_(when-let [target-el (.getElementById js/document "btn5")]
  (.addEventListener target-el "click"
                     (fn [ev]
                       (->output! "Disconnecting")
                       (sente/chsk-disconnect! chsk))))

#_(when-let [target-el (.getElementById js/document "btn6")]
  (.addEventListener target-el "click"
                     (fn [ev]
                       (->output! "Reconnecting")
                       (sente/chsk-reconnect! chsk))))


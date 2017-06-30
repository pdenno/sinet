(ns gov.nist.sinet.client.views
  (:require [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn)]
            [reagent.core :as rea]))

(def viewing-pn "What PN is displayed" (rea/atom {:index 0 :id nil}))

(defn view-pop
  "Display the next PN in the population"
  [{index :index}]
  (->output! "pop+/- button was clicked (get-individual-plus/minus)")
  (chsk-send! [:sinet/get-individual index] 5000
              (fn [cb-reply]
                (->output! "Received PN %s = %s." (:id cb-reply) cb-reply)
                (reset! gov.nist.sinet.draw/+display-pn+ cb-reply))))

(defn start-evolve
  [{:as args}]
  (ws/->output! "Starting evolution...")
  (ws/chsk-send! [:sinet/evolve {:status :best-wishes}]))

(defn buttons []
  [:div.buttons
   [:table
    [:tbody
     [:tr [:td [:strong "GP Control"]]] ; POD does nothing
     [:tr [:td "Viewing PN " (:index @viewing-pn)]]
     [:tr
      [:td [:button {:on-click (fn [] (view-pop (swap! viewing-pn #(update % :index inc))))}]]
      [:td [:button {:on-click (fn [] (view-pop (swap! viewing-pn #(update % :index dec))))}]]]
     [:tr
      [:td [:button {:on-click start-evolve} "Evolve"]]
      [:td [:button {:on-click start-evolve} "Evolve"]]]]]])

;;; Util for logging output to on-screen console
(defn console-area []
  [:div#console
   [:strong "Console"]
   [:textarea {:value @ws/output-atom :readOnly true
               :style {:width "100%" :height "200px"}}]])
(defn drawing-area []
  [:div#pn
   [:canvas {:id "best-pn"}]])

(quil/defsketch best-pn 
  :host "best-pn"
  :title "Best Individual"
  :settings #(fn [] (quil/smooth 2)) ; Smooth=2 is typical. Can't use pixel-density with js.
  :setup draw/setup-pn
  :draw draw/draw-pn
  :mouse-wheel draw/pn-wheel-fn
  :size [900 500]) ; POD This is used in pnml/rescale. I need a solution for getting it here! (component?)

(defn main [data]
  (view-pop 0)
  [:div
   [:h1 (:title @data)]
   ;;[:table [:tbody [:tr [:td [drawing-area]] [:td [buttons]]]]]
   #_[drawing-area]
   #_[buttons]
   [console-area]
   [:br]
   [:button {:on-click ws/test-socket-event} "Send Message Event"]])



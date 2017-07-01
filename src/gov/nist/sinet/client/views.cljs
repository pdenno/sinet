(ns gov.nist.sinet.client.views
  (:require [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn +display-pn+)]
            [reagent.core :as rea]))

(defonce viewing-pn (rea/atom {:index 0 :id nil}))
 
(defn view-pop
  "Display the next PN in the population"
  [{index :index}]
  (->output! "pop+/- button was clicked (get-individual-plus/minus)")
  (ws/chsk-send! [:sinet/get-individual index] 5000
              (fn [cb-reply]
                (->output! "Received PN  %s (it's Inv.id) " (:id cb-reply))
                (reset! +display-pn+ cb-reply))))

(defn start-evolve
  [{:as args}]
  (ws/->output! "Starting evolution...")
  (ws/chsk-send! [:sinet/evolve {:status :best-wishes}]))

(defn drawing-area []
  [:div#pn
   [:canvas {:id "best-pn"}]])

(defn buttons []
  [:div.buttons {:ref "buttons"} ; POD I'm not using this.
   [:table
    [:tbody
     [:tr [:td [:strong "GP Control"]]] ; POD does nothing
     [:tr [:td "Viewing PN " (:index @viewing-pn)]]
     [:tr
      [:td [:button {:on-click (fn [] (view-pop (swap! viewing-pn #(update % :index inc))))} "Pop+"]]
      [:td [:button {:on-click (fn [] (view-pop (swap! viewing-pn #(update % :index dec))))} "Pop-"]]]
     [:tr
      [:td [:button {:on-click start-evolve} "Evolve"]]
      [:td [:button {:on-click start-evolve} "Evolve"]]]]]])

;;; Util for logging output to on-screen console
(defn console-area []
  [:div#console
   [:strong "Console"]
   [:textarea {:value @ws/output-atom :readOnly true
               :on-change (fn [e] (aset e "scrollTop" (.-scrollHeight e))) ; POD does nothing
               :style {:width "100%" :height "200px"}}]])

(quil/defsketch best-pn 
  :host "best-pn"
  :title "Best Individual"
  :settings #(fn [] (quil/smooth 2)) ; Smooth=2 is typical. Can't use pixel-density with js.
  :setup draw/setup-pn
  :draw draw/draw-pn
  :mouse-wheel draw/pn-wheel-fn
  :size [900 500]) ; POD This is used in pnml/rescale. I need a solution for getting it here! (component?)

(defn main [data]
  (view-pop @viewing-pn)
  [:div
   [:div {:id "metaltop-teal"} [:li foo]]
   [:h1 (:title @data)]
   ;[:table [:tbody [:tr [:td [drawing-area]] [:td [buttons]]]]]
   [drawing-area]
   [buttons]
   [console-area]
   [:br]
   [:button {:on-click ws/test-socket-event} "Send Message Event"]
   [:br]
   [:button {:on-click ws/test-socket-callback} "Send Message Callback"]])



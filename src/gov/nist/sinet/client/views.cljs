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
  [:div#pn {:class "col-md-10"}
   [:canvas {:id "best-pn"}]])

(defn buttons []
  [:div#buttons {:class "col-md-2"}
   [:div {:class "container"}
    [:div {:class "row"} [:strong "GP Control"]]
    [:div {:class "row"} "Viewing PN " (:index @viewing-pn)]
    [:div {:class "row"}
     [:div {:class "btn-group btn-group-sm"}
      [:button {:class "btn btn-primary"
                :on-click (fn [] (view-pop (swap! viewing-pn #(update % :index inc))))} "Pop+"]
      [:button {:class "btn btn-primary"
                :on-click (fn [] (view-pop (swap! viewing-pn #(update % :index dec))))} "Pop-"]]]
    [:div {:class "row"}
     [:div {:class "btn-group btn-group-sm"}
      [:button {:class "btn btn-primary" :on-click start-evolve} "Evolve"]
      [:button {:class "btn btn-primary" :on-click start-evolve} "Pause Evolve"]]]]])

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
  [:body {:id "myPage" :data-spy "scroll" :data-target=".navbar" :data-offset="60"}
   [:nav {:class "navbar navbar-default navbar-fixed-top"}
    [:div {:class "container"}
     [:div {:class "navbar-header"}
      [:button {:type "button" :class "navbar-toggle" :data-toggle "collapse" :data-target "#myNavbar"}
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]]
      [:a {:class "navbar-brand" :href "#myPage"} "Logo" ]]
     [:div {:class "collapse navbar-collapse" :id "myNavbar"}
      [:ul {:class "nav navbar-nav navbar-right"}
       [:li [:a {:href "#gp"}GP]]
       [:li [:a {:href "#gpparams"}GP Parameters]]
       [:li [:a {:href "#patterns"}Message Patterns]]]]]]
  [:div {:class "container-fluid"}
   [:div {:class "jumbotron text-center"} 
    [:h1 "Sinet"]
    [:p "System Identification for Smart Manufacturing"]]
   [:div {:class "row"}
    [drawing-area]
    [buttons]]
   [:div {:class "row"}
    [console-area]]
   [:div {:class "row"}
    [:div {:class "btn-group btn-group-sm"}
     [:button {:class "btn btn-primary" :on-click ws/test-socket-event} "Send Message Event"]
     [:button {:class "btn btn-primary" :on-click ws/test-socket-callback} "Send Message Callback"]]]]])



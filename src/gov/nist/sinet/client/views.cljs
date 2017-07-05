(ns gov.nist.sinet.client.views
  (:require [clojure.string :as str]
            [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom report-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn +display-pn+)]
            [reagent.core :as reagent]))

(defn nav []
  [:nav {:class "navbar navbar-default navbar-fixed-top"
         :style {:margin-bottom "0" :background-color "#f4511e" :z-index "9999"
                 :border "0" :font-size "14px" :line-height "1.42857143" 
                 :letter-spacing "4px" :border-radius "0"}}
   [:div {:class "container"}
    [:div {:class "navbar-header"}
     [:button {:type "button" :class "navbar-toggle" :data-toggle "collapse" :data-target "#myNavbar" :style {:color "#ffffff"}} ; ditto
      [:span {:class "icon-bar"}]
      [:span {:class "icon-bar"}]
      [:span {:class "icon-bar"}]]
     [:a {:class "navbar-brand" :href "#myPage" :style {:color "#ffffff"}} "SINET" ]] 
    [:div {:class "collapse navbar-collapse" :id "myNavbar"} 
     [:ul {:class "nav navbar-nav navbar-right"} 
      [:li [:a {:href "#gp"}"GP"]]
      [:li [:a {:href "#gpparams"}"GP Parameters"]]
      [:li [:a {:href "#patterns"}"Message Patterns"]]]]]])

(defonce viewing-pn (reagent/atom {:index 0 :id nil}))
 
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
  [:div#pn {:class "col-md-8"}
   [:canvas {:id "best-pn"}]])

(defn buttons-report []
  [:div#buttons-report {:class "col-md-4"}
   [:div {:class "container-fluid"}
    [:div {:class "row"}
     [report]
     [buttons]]]])

(defn buttons []
  [:div {:class "col-md-2"}
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

(defn report []
  [:div {:class "col-md-10"}
   [:div {:class "container"}
    [:div {:class "row"}
     [:p [:strong "Report"]]]
    (let [rmap @ws/report-atom]
      (doall
       (for [key (keys rmap)]
         [:div {:class "row"}
          [:div {:key key}
           (str (->> (str/split (str/replace (str key) #"\-+" " ") " ")
                     (map str/capitalize)
                     (str/join))
                " "
                (get rmap key))]])))]])

;;; Util for logging output to on-screen console
(defn console-area []
  [:div {:class "col-md-12"}
   [:strong "Console"]
   [:textarea {:value @ws/output-atom :readOnly true
               :on-change (fn [e] (aset e "scrollTop" (.-scrollHeight e))) ; POD does nothing
               :style {:width "100%" :height "200px" :font-size "small"}}]])

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
  [:div {:id "myPage" :data-spy "scroll" :data-target ".navbar" :data-offset "60"} ; was :body. Could probably go back!
   [nav]
   [:div {:class "jumbotron text-center" :style {:background-color "#f4511e" :color "#ffffff"}}
    [:h1 "Sinet"]
    [:p "System Identification for Smart Manufacturing"]]
   [:div {:class "container-fluid"}
    [:div {:class "row"}
     [drawing-area]
     [buttons-report]]
    [:div {:class "row"}
     [console-area]]
    #_[:div {:class "row"}
     [:div {:class "btn-group btn-group-sm"}
      [:button {:class "btn btn-primary" :on-click ws/test-socket-event} "Send Message Event"]
      [:button {:class "btn btn-primary" :on-click ws/test-socket-callback} "Send Message Callback"]]]]])

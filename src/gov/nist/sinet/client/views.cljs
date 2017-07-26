(ns gov.nist.sinet.client.views
  (:require [clojure.string :as str]
            [clojure.pprint :refer (cl-format pprint)]
            [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom report-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn +display-pn+)]
            [reagent.core :as reagent]))

(defn pretty-val 
  "cljs: (cl-format nil '~5,3f' nil) --> 0.000."
  [val]
  (cond (number? val)
        (if (== 0 (rem val 1))
          (str val)
          (cl-format nil "~5,3f" val))
        (and (coll? val) (empty? val)) "nil"
        :else (str val)))

(defn nav []
  [:nav {:class "navbar navbar-default navbar-fixed-top"
         :style {:margin-bottom "0" :background-color "#330066" :z-index "9999"
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
      [:li [:a {:href "#params"}"Parameters"]]
      [:li [:a {:href "#patterns"}"Message Patterns"]]]]]])

(def viewing-pop-index (reagent/atom 0))
 
(defn view-pop
  "Display the next PN in the population"
  [index]
  (ws/chsk-send! [:sinet/get-individual index] 5000
              (fn [cb-reply]
                (->output! "Received PN  %s (it's Inv.id) " (:id cb-reply))
                (reset! +display-pn+ cb-reply))))

(def evolve-state (reagent/atom false))

(defn evolve-run
  [{:as args}]
  (ws/->output! "evolve-run...")
  (reset! evolve-state :running)
  (ws/chsk-send! [:sinet/evolve-run {:status :best-wishes}]))

(defn evolve-continue
  [{:as args}]
  (ws/->output! "evolve-continue...")
  (reset! evolve-state :running)
  (ws/chsk-send! [:sinet/evolve-continue {:status :best-wishes}]))

(defn evolve-pause
  [{:as args}]
  (ws/->output! "evolve-pause...")
  (reset! evolve-state :paused)
  (ws/chsk-send! [:sinet/evolve-pause {:status :best-wishes}]))

(declare draw-it)

(defn quil-pn
  "Form-3 component for quil Petri net"
  []  
  (let [a-closed-over-val nil]        ;; <-- closed over by lifecycle fns
     (reagent/create-class            ;; <-- expects a map of functions 
      {:component-did-mount           ;; the name of a lifecycle function
       #(do
          (println (cl-format nil "~%quil-pn requests PN ~S" @viewing-pop-index))
          (draw-it)
          (view-pop @viewing-pop-index))
         
       :component-will-mount            ;; the name of a lifecycle function
       #(println "quil-pn-will-mount")  ;; your implementation
       
       :display-name  "quil-pn"  ;; for more helpful warnings & errors
       
       :reagent-render  ;; Note:  is not :render
       (fn []           ;; remember to repeat parameters
         [:canvas {:id "best-pn"}])})))

(defn drawing-area []
  [:div#pn {:class "col-md-8"}
   [quil-pn]])

(defn buttons []
  [:div {:class "container"}
   [:div {:class "row"} [:strong "GP Control"]]
   [:div {:class "row"} "Viewing PN (order): " (pretty-val @viewing-pop-index)]
   [:div {:class "row"} "ID: " (pretty-val (:id @+display-pn+))]
   [:div {:class "row"} "Error: " (pretty-val (:error @+display-pn+))]
   [:div {:class "row"}
    [:div {:class "btn-group btn-group-sm"}
     [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
               :on-click (fn [] (view-pop (swap! viewing-pop-index inc)))} "Pop+"]
     [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
               :disabled (<= @viewing-pop-index 0)
               :on-click (fn [] (view-pop (swap! viewing-pop-index dec)))} "Pop-"]]]
   [:div {:class "row"}
    [:div {:class "btn-group btn-group-sm"}
     [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
               :disabled (= @evolve-state :running)
               :on-click evolve-run} "Run"]
     [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
               :disabled (not (= @evolve-state :running))
               :on-click evolve-pause} "Pause"]
     [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
               :disabled (not (= @evolve-state :paused))
               :on-click evolve-continue} "Continue"]]]])

(add-watch report-atom
           :watcher
           (fn [key atom old-state new-state]
             (reset! viewing-pop-index 0)
             (view-pop 0)))

(defn report []
  [:div {:class "container"}
   [:div {:class "row"}
    [:p [:strong "Report"]]]
   (let [rmap @ws/report-atom]
     (when (and (contains? rmap :generation) (contains? rmap :pop-size))
       (doall
        (for [key (keys rmap)]
          [:div {:class "row" :key key}
           [:div 
            (str (->> (str/split (str/replace (subs (str key) 1) #"\-+" " ") " ")
                      (map str/capitalize)
                      (interpose " ")
                      (str/join))
                 ": "
                 (pretty-val (get rmap key)))]]))))])

(defn buttons-report []
  [:div#buttons-report {:class "col-md-4"}
   [:div {:class "container-fluid"}
    [:div {:class "row"} [buttons]]
    [:div {:class "row"} [report]]]])

;;; Util for logging output to on-screen console
(defn console-area []
  [:div {:class "col-md-12"}
   [:strong "Console"]
   [:textarea {:value @ws/output-atom :readOnly true
               ;;:on-change (fn [e] (aset e "scrollTop" (.-scrollHeight e))) ; POD does nothing
               :on-change #(.-scrollHeight %) ; POD does nothing
               :style {:width "100%" :height "200px" :font-size "small"}}]])

(defn draw-it []
  (quil/defsketch best-pn 
    :host "best-pn"
    :title "Best Individual"
    :settings #(fn [] (quil/smooth 2)) ; Smooth=2 is typical. Can't use pixel-density with js.
    :setup draw/setup-pn
    :draw draw/draw-pn
    :mouse-wheel draw/pn-wheel-fn
    :size [900 500])) ; POD This is used in pnml/rescale. I need a solution for getting it here! (component?)

;;; Loughborough Purple:  Pantone 269 C #472267 (71,51,103), Websafe, #330066 
;;; Loughborough Magenta: Pantone 220 C #8F004F (143,0,79)   Websafe, #CC0066
;;; Orange "#f4511e" 
(defn main [data]
  ;(js/setTimeout #(view-pop @viewing-pop-index) 2000) ; POD I'm looking for a ":on-redisplay" sort of thing. 
  [:div {:id "myPage" :data-spy "scroll" :data-target ".navbar" :data-offset "60"} ; was :body. Could probably go back!
   [nav]
   [:div {:class "jumbotron text-center" :style {:background-color "#330066" :color "#ffffff"}} ; 
    [:h1 "Sinet"]
    [:p "System Identification for Smart Manufacturing"]]
   [:div {:class "container-fluid"}
    [:div {:class "row"}
     [drawing-area]
     [buttons-report]]
    [:div {:class "row"}
     [console-area]]]])

#_(ws/chsk-send!
 [:sinet/get-report {:gen 0}] 2000
 (fn [cb-reply]
   (->output! "Received GenerationReport ")
   (reset! ws/report-atom cb-reply)))

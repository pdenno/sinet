(ns gov.nist.sinet.client.views
  (:require [clojure.string :as str]
            [clojure.pprint :refer (cl-format pprint)]
            [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn +display-pn+)]
            [reagent.core :as reagent]
            [re-frame.core :as re]))

(declare request-individual)
;;; POD Should ask for GP params and check that it isn't over those. 
(defn handle-requested-pn
  [{:keys [db]} [_ dif]]
  (if (= :none (:requested-pn db))
    (do (request-individual 0)
        {:db (assoc db :requested-pn 0)})
    (when (>= (+ (:requested-pn db) dif) 0)
      (do (request-individual (+ (:requested-pn db) dif))
          {:db (update db :requested-pn #(+ % dif))}))))

(defn handle-evolve-state
  [{:keys [db]} [_ state]]
  {:db (assoc db :evolve-state state)})

;;; POD Still need to define re/dispatch for these two.
(defn handle-receive-pn
  [{:keys [db]} [_ pn]]
  {:db (assoc db :pn pn)})

(defn handle-receive-report
  [{:keys [db]} [_ report]]
  {:db (assoc db :report report)})

(re/reg-event-fx :sinet/requested-pn handle-requested-pn)
(re/reg-event-fx :sinet/evolve-state handle-evolve-state)
(re/reg-event-fx :sinet/recv-pn      handle-receive-pn)
(re/reg-event-fx :sinet/recv-report  handle-receive-report)

;;; Domino 4: a query (function) over this app state is automatically called.
;;; This query function "extracts" data from application state, and then computes "a materialised view"
;;; of the application state - producing data which is useful to the view functions of domino, 5.
(defn query-init
  [db v]
  (:initial? db))

(defn query-evolve-state
  [db v]
  (:evolve-state db))

(defn query-requested-pn
  [db v]
  (:requested-pn db))

(defn query-pn
  [db v]
  (:pn db))

(defn query-report
  [db v]
  (:report db))

;;; reg-sub says "if, in domino 5, you see a (subscribe [:pn]), then use query-pn to compute it".
(re/reg-sub :initial?     query-init)
(re/reg-sub :evolve-state query-evolve-state)
(re/reg-sub :pn           query-pn)
(re/reg-sub :requested-pn query-requested-pn)
(re/reg-sub :report       query-report)

(defn pretty-val 
  "cljs: (cl-format nil '~5,3f' nil) --> 0.000."
  [val]
  (cond (number? val)
        (if (== 0 (rem val 1))
          (str val)
          (cl-format nil "~5,3f" val))
        (and (coll? val) (empty? val)) "nil"
        :else (str val)))

;;; https://www.w3schools.com/bootstrap/bootstrap_theme_company.asp
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

(defn request-individual
  "Retrieve the argument PN (index from population)"
  [index]
  (ws/chsk-send! [:sinet/get-individual index] 5000
                 (fn [cb-reply]
                   (cond (= cb-reply :chsk/timeout)
                         (->output! "Timeout requesting individual")
                         (contains? cb-reply :places)
                         (do (->output! "Received PN with err= %s " (:err cb-reply))
                             (re/dispatch [:sinet/recv-pn cb-reply]))
                         :else
                         (->output! "Invalid individual returned from get-individual request.")))))

;;; reg-sub says "if, in domino 5, you see a (subscribe [:pn]), then use query-pn to compute it".
;;; Yeah, fine, that returns provide an :evolve-state value which I'd like to pick up here.
;;; This is where I'm stuck. These don't run. :evolve-state <===========
(defn request-server-change-evolve-state
  []
  (let [change-to (re/subscribe [:evolve-state])]
    (->output! "change-to-evolve-state: %s" change-to)
    (cond
      (= change-to :run)      (ws/chsk-send! [:sinet/evolve-run      {:status :best-wishes}]),
      (= change-to :pause)    (ws/chsk-send! [:sinet/evolve-pause    {:status :best-wishes}]),
      (= change-to :continue) (ws/chsk-send! [:sinet/evolve-continue {:status :best-wishes}]))))

(declare draw-it)

(defn quil-pn
  "Form-3 component for quil Petri net"
  []  
  (let [pn (re/subscribe [:pn])
        a-closed-over-val nil]        ;; <-- closed over by lifecycle fns
      (reagent/create-class            ;; <-- expects a map of functions 
       {:component-did-mount           ;; the name of a lifecycle function
        #(when (contains? pn :places)
           (reset! draw/+display-pn+ pn)
           (draw-it))
        
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
  (let [evolve-state (re/subscribe [:evolve-state])
        pn-id        (re/subscribe [:requested-pn])] ; Disabled ignores this. Did I read something about that?
    [:div {:class "container"}
     [:div {:class "row"} [:strong "GP Control"]]
     [:div {:class "row"} "Viewing PN (order): " pn-id]
     [:div {:class "row"} "Error: " (pretty-val (:err @+display-pn+))]
     [:div {:class "row"}
      [:div {:class "btn-group btn-group-sm"}
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :on-click #(re/dispatch [:sinet/requested-pn 1])} "Pop+"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (= pn-id 0)
                 :on-click #(re/dispatch [:sinet/requested-pn -1])} "Pop-"]]]
     [:div {:class "row"}
      [:div {:class "btn-group btn-group-sm"}
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 #_:disabled #_(= evolve-state :run)
                 :on-click #(re/dispatch [:sinet/evolve-state :run])} "Run"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 #_:disabled #_(not (= evolve-state :run))
                 :on-click #(re/dispatch [:sinet/evolve-state :pause])} "Pause"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 #_:disabled #_(not (= evolve-state :pause))
                 :on-click #(re/dispatch [:sinet/evolve-state :continue])} "Continue"]]]]))

(defn report []
  (let [rmap (re/subscribe [:report])]
    [:div {:class "container"}
     [:div {:class "row"}
      [:p [:strong "Report"]]]
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
                 (pretty-val (get rmap key)))]])))]))

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
  (let [_ (re/subscribe [:initial?])]
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
       [console-area]]]]))


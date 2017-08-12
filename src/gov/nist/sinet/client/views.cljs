(ns gov.nist.sinet.client.views
  (:require [clojure.string :as str]
            [clojure.pprint :refer (cl-format pprint)]
            [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [gov.nist.sinet.client.ws :as ws :refer (->output! output-atom chsk-send!)]
            [gov.nist.sinet.client.draw :as draw :refer (setup-pn draw-pn pn-wheel-fn +display-pn+)]
            [reagent.core :as reagent]
            [re-frame.core :as rf]))

(declare request-individual request-server-change-evolve-state)
;;; https://github.com/Day8/re-frame/blob/master/docs/EffectfulHandlers.md
;;; As suggested in above URL, if you want to do a dispatch in a hanlder use :dispatch
;;; just as you are using :db (as the thing returned). 
;;; POD Should ask for GP params and check that it isn't over those.

;;; reg-event-db just does one reduce-like step, -fx additionally allows:
;;;    * event handlers to hav effects effects (beyond state change)
;;;    * coeffects (arguments) beyond just db and v. POD I could probably use -db here.
(rf/reg-event-fx
 :sinet/requested-pn
 (fn [{:keys [db]} [_ dif]]
   (if (= :none (:requested-pn db))
     (do (request-individual 0)              ; POD Handlers are expected to be pure. Hmmm. 
         {:db (assoc db :requested-pn 0)})   ; The tutorial claims that. Then dismisses it. 
     (when (>= (+ (:requested-pn db) dif) 0) ; You can also call rf/dispatch here. 
       (do (request-individual (+ (:requested-pn db) dif))
           {:db (update db :requested-pn #(+ % dif))})))))

(rf/reg-event-fx
 :sinet/evolve-state
 (fn [{:keys [db]} [_ state]]
   (do (request-server-change-evolve-state state)
       {:db (assoc db :evolve-state state)})))
  
(rf/reg-event-fx
 :sinet/recv-pn
 (fn [{:keys [db]} [_ pn]]
   {:db (assoc db :pn pn)}))
 
(rf/reg-event-fx
 :sinet/recv-report
 (fn [{:keys [db]} [_ rpt]]
   (let [done? (or (= :failure (:state rpt))
                   (= :success (:state rpt)))]
     {:db (cond-> db
            true  (assoc :report rpt)
            done? (assoc :evolve-state :ready))})))

;;; Domino 4: a query (function) over this app state is automatically called.
;;; This query function "extracts" data from application state, and then computes "a materialised view"
;;; of the application state - producing data which is useful to the view functions of domino, 5.
;;; Check this out: https://www.youtube.com/watch?v=fU9hR3kiOK0
;;; reg-sub says "if, in domino 5, you see a @(subscribe [:pn]), then use query-pn to compute it".
(rf/reg-sub :initial?     (fn [db _] (:initial? db)))
(rf/reg-sub :evolve-state (fn [db _] (:evolve-state db)))
(rf/reg-sub :pn           (fn [db _] (:pn db)))           ; <--- This is "query-pn"
(rf/reg-sub :requested-pn (fn [db _] (:requested-pn db))) 
(rf/reg-sub :report       (fn [db _] (:report db)))

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
                             (rf/dispatch [:sinet/recv-pn cb-reply]))
                         :else
                         (->output! "Invalid individual returned from get-individual request.")))))

;;; reg-sub says "if, in domino 5, you see a @(subscribe [:pn]), then use query-pn to compute it".
;;; Yeah, fine, that returns provide an :evolve-state value which I'd like to pick up here.
;;; This is where I'm stuck. These don't run. :evolve-state <===========
(defn request-server-change-evolve-state
  [change-to]
  (->output! "change-to-evolve-state: %s" change-to)
  (cond
    (= change-to :run)      (ws/chsk-send! [:sinet/evolve-run      {:status :best-wishes}]),
    (= change-to :pause)    (ws/chsk-send! [:sinet/evolve-pause    {:status :best-wishes}]),
    (= change-to :continue) (ws/chsk-send! [:sinet/evolve-continue {:status :best-wishes}])))

(declare draw-it)

(defn quil-pn []
  (let [pn @(rf/subscribe [:pn])]
    (when (contains? pn :places)
      (reset! draw/+display-pn+ (draw/pn-geom pn))
      (draw-it))
    [:canvas {:id "best-pn"}]))

(defn drawing-area []
  [:div#pn {:class "col-md-8"}
   [quil-pn]])

(defn buttons []
  (let [evolve-state @(rf/subscribe [:evolve-state])
        pn-id        @(rf/subscribe [:requested-pn])
        report       @(rf/subscribe [:report])]
    [:div {:class "container"}
     [:div {:class "row"} [:strong "GP Control"]]
     [:div {:class "row"} "Viewing PN (order): " pn-id]
     [:div {:class "row"} "Error: " (pretty-val (:err @+display-pn+))]
     [:div {:class "row"}
      [:div {:class "btn-group btn-group-sm"}
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (not report)
                 :on-click #(rf/dispatch [:sinet/requested-pn 1])} "Pop+"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (or (= pn-id :none) (= pn-id 0) )
                 :on-click #(rf/dispatch [:sinet/requested-pn -1])} "Pop-"]]]
     [:div {:class "row"}
      [:div {:class "btn-group btn-group-sm"}
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (= evolve-state :run)
                 :on-click #(rf/dispatch [:sinet/evolve-state :run])} "Run"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (not (= evolve-state :run))
                 :on-click #(rf/dispatch [:sinet/evolve-state :pause])} "Pause"]
       [:button {:class "btn btn-primary" :style {:background-color "#CC0066"}
                 :disabled (not (= evolve-state :pause))
                 :on-click #(rf/dispatch [:sinet/evolve-state :continue])} "Continue"]]]]))

;;; To render the DOM representation of some part of the app state, view functions must query
;;; for that part of app-db, and that means using subscribe.
(defn report []
  (let [rmap @(rf/subscribe [:report])]
    [:div {:class "container"}
     [:div {:class "row"}
      [:p [:strong (cl-format  nil "Report")]]]
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
    ;; POD I need a solution for getting it here! 
    :size [(-> draw/graph-window-params :window-size :length)
           (-> draw/graph-window-params :window-size :height)]))

;;; Loughborough Purple:  Pantone 269 C #472267 (71,51,103), Websafe, #330066 
;;; Loughborough Magenta: Pantone 220 C #8F004F (143,0,79)   Websafe, #CC0066
;;; Orange "#f4511e" 
(defn main [data]
  (let [_ @(rf/subscribe [:initial?])]
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


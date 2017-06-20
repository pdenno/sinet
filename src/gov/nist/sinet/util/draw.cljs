(ns gov.nist.sinet.util.draw
  "SINET Petri net draw code"
  {:author "Peter Denno"}
  (:require [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]))
  
;;; ToDo: - Prevent coincident lines. (Example in m2-j2-bas.xml)
;;;       - Find a way that labels can get focus despite their proximity to objects.
  
;;;================== Stuff borrowed from pnu (not cljs)  ========================
(defn name2obj
  [pn name]
  (or 
   (some #(when (= name (:name %)) %) (:places pn))
   (some #(when (= name (:name %)) %) (:transitions pn))
   (some #(when (= name (:name %)) %) (:arcs pn))))

(defn arc? [obj] (:aid obj))
(defn place? [obj] (:pid obj))

(defn pn?
  "If the argument is a Petri net, return it; otherwise return false."
  [obj]
  (and (:places obj) (:transitions obj) (:arcs obj) obj))

(def +place-dia+ 30)
(def +trans-width+ 40)
(def +trans-height+ 8)
(def +token-dia+ 4)
(def +inhibit-dia+ 10)
(def +arrowhead-length+ 15)
(def +arrowhead-angle+ "zero is on the shaft" (/ Math/PI 8.0))
(def +lock-mouse-on+ (atom nil))

(defn setup-pn []
  (quil/frame-rate 10)    ; FPS. 10 is good
  (quil/text-font (quil/create-font "DejaVu Sans" 16 true))
  (quil/background 200)) ; light grey

(declare nearest-elem ref-points draw-elem draw-arc draw-tokens)
(declare arc-coords-trans-to-place arrowhead-coords pt-from-head)
(declare angle distance +display-pn+ highlight-elem! handle-move!)

(defn draw-pn []
  (let [pn @+display-pn+]
    (quil/background 230) ; POD not sure I want to keep this.
    (quil/stroke 0) ; black
    (quil/fill 255) ; white
    (quil/stroke-weight 2)
    (highlight-elem! pn)
    (if (quil/mouse-pressed?)
      (handle-move!)
      (reset! +lock-mouse-on+ nil))
    (doseq [place (:places pn)]
      (draw-elem pn place))
    (doseq [trans (:transitions pn)]
      (draw-elem pn trans))
    (doseq [arc (:arcs pn)]
      (draw-arc pn arc))))

(def +diag+ (atom nil))

(defn handle-move!
  "Mouse pressed: Update coordinates to move an element or its label."
  []
  (when-let [elem (or @+lock-mouse-on+ (nearest-elem @+display-pn+ [(quil/mouse-x) (quil/mouse-y)]))]
    (swap!
     +display-pn+
     #(let [n (:name elem)]
        (if (:label? elem)
          (as-> % ?pn
            (assoc-in ?pn [:pn-graph-positions n :label-x-off]
                      (- (quil/mouse-x) (-> ?pn :pn-graph-positions n :x)))
            (assoc-in ?pn [:pn-graph-positions n :label-y-off]
                      (- (quil/mouse-y) (-> ?pn :pn-graph-positions n :y))))
          (as-> % ?pn
            (assoc-in ?pn [:pn-graph-positions n :x] (quil/mouse-x))
            (assoc-in ?pn [:pn-graph-positions n :y] (quil/mouse-y))))))))

(def +highlight-elem+ (atom nil))
(defn highlight-elem!
  "Set +hilight-elem+ and maybe +lock-mouse-on+."
  [pn]
  (let [nearest (or @+lock-mouse-on+ (nearest-elem pn [(quil/mouse-x) (quil/mouse-y)]))]
    (when (and nearest (quil/mouse-pressed?)) (reset! +lock-mouse-on+ nearest))
    (if nearest
      (reset! +highlight-elem+ nearest)
      (reset! +highlight-elem+ nil))))

(defn nearest-elem
  "Return a element (place/trans) map indicating what was closest to the mouse.
  :label? in the map indicates it was the elem's label that was closest.
   Returns nil if nothing is close."
  [pn mxy]
  (let [[bkey min-d label?]
        (reduce
         (fn [[bkey min-d label?] [key val]]
           (let [delem  (Math/round (distance (into mxy (vector (:x val) (:y val)))))
                 dlabel (Math/round (distance (into mxy (vector (+ (:x val) (:label-x-off val))
                                                                (+ (:y val) (:label-y-off val))))))
                 min? (min delem dlabel min-d)]
             (if (= min? delem)
               [key min? false]
               (if (= min? dlabel)
                 [key min? true]
                 [bkey min-d label?]))))
         [:not-set 99999 true]
         (-> pn :pn-graph-positions))]
    (when (< min-d 30.0)
      (when-let [elem (or (some #(when (= bkey (:name %)) %) (:places pn))
                          (some #(when (= bkey (:name %)) %) (:transitions pn)))]
        (assoc elem :label? label?)))))

(defn draw-elem
  "Draws a element and its label. The element map might have :label? = true
   to indicate that it is the label that needs highlighting. The actual 
   updating of the net is taken care of in handle-mouse."
  [pn elem]
  (let [n (:name elem)
        x (-> pn :pn-graph-positions n :x)
        y (-> pn :pn-graph-positions n :y)
        hilite @+highlight-elem+]
    (quil/fill (if (and (= n (:name hilite)) (:label? hilite)) (quil/color 255 0 0) 0))
    (quil/text (name n)
            (+ x (-> pn :pn-graph-positions n :label-x-off))
            (+ y (-> pn :pn-graph-positions n :label-y-off)))
    (quil/fill 0)
    (quil/stroke (if (and (= (:name hilite) n) (not (:label? hilite))) (quil/color 255 0 0) 0))
    (if (place? elem)
      (do
        (quil/fill 255)
        (quil/ellipse x y +place-dia+ +place-dia+)
        (draw-tokens (:initial-tokens elem) x y))
      (do (quil/fill (if (= (:type elem) :immediate) 0 255))
          (quil/rect x y +trans-width+ +trans-height+)))
    (quil/stroke 0)
    (quil/fill 0)))

(declare draw-tkn rotate intersect-circle)
(defn draw-tokens
  [cnt x y]
  (let [d (+ +token-dia+ 1)]
    (case cnt
      0 :do-nothing
      1 (draw-tkn x y)
      2 (do (draw-tkn (- x d) (- y d))
            (draw-tkn (+ x d) (+ y d)))
      3 (do (draw-tkn (- x d) (- y d))
            (draw-tkn (+ x d) (+ y d))
            (draw-tkn x y))
      4 (do (draw-tkn (- x d) (- y d))
            (draw-tkn (+ x d) (+ y d))
            (draw-tkn (- x d) (+ y d))
            (draw-tkn (+ x d) (- y d)))
      5 (do (draw-tkn (- x d) (- y d))
            (draw-tkn (+ x d) (+ y d))
            (draw-tkn (- x d) (+ y d))
            (draw-tkn (+ x d) (- y d))
            (draw-tkn x y))
      (quil/text (str cnt) x y))))

(defn draw-tkn
  [x y]
  (quil/fill 0) ; black
  (quil/ellipse x y +token-dia+ +token-dia+))

(defn draw-arc
  [pn arc]
  (let [place-is-head? (place? (name2obj pn (:target arc))),
        inhibitor? (= :inhibitor (:type arc)),
        ln
        (if place-is-head? 
          (arc-coords-trans-to-place pn (:source arc) (:target arc))
          (arc-coords-trans-to-place pn (:target arc) (:source arc)))]
    (if inhibitor? ; head is always the transition
      (let [center (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- (/ +inhibit-dia+ 2)))
            end (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- +inhibit-dia+))]
        (quil/fill 255)
        (quil/stroke-weight 1)
        (quil/ellipse (:x center) (:y center) +inhibit-dia+ +inhibit-dia+)
        (quil/stroke-weight 2)
        (quil/line (:px ln) (:py ln) (:x end) (:y end)))
      (do (quil/line (:tx ln) (:ty ln) (:px ln) (:py ln))
          (if place-is-head?
            (let [ahc (arrowhead-coords (:tx ln) (:ty ln) (:px ln) (:py ln))]
              (quil/line (:px ln) (:py ln) (:xl ahc) (:yl ahc))
              (quil/line (:px ln) (:py ln) (:xr ahc) (:yr ahc)))
            (let [ahc (arrowhead-coords (:px ln) (:py ln) (:tx ln) (:ty ln))]
              (quil/line (:tx ln) (:ty ln) (:xl ahc) (:yl ahc))
              (quil/line (:tx ln) (:ty ln) (:xr ahc) (:yr ahc))))))))

(defn distance
  ([x1 y1 x2 y2] (Math/sqrt (+ (Math/pow (- x1 x2) 2) (Math/pow (- y1 y2) 2))))
  ([line] (let [[x1 y1 x2 y2] line] (distance x1 y1 x2 y2))))

(defn arrowhead-coords
  "Provide coordinates for the two points at the end of the edges of arrow at (x2,y2)"
  [x1 y1 x2 y2]
  (let [len (distance x1 y1 x2 y2)
        angle (angle x1 y1 x2 y2) 
        xl (+ len (* +arrowhead-length+ (Math/cos (- Math/PI +arrowhead-angle+))))
        xr (+ len (* +arrowhead-length+ (Math/cos (+ Math/PI +arrowhead-angle+))))
        yl (* +arrowhead-length+ (Math/sin (- Math/PI +arrowhead-angle+)))
        yr (* +arrowhead-length+ (Math/sin (+ Math/PI +arrowhead-angle+)))
        lrotate (rotate xl yl angle)
        rrotate (rotate xr yr angle)]
    {:xl (+ x1 (:x lrotate)) :yl (+ y1 (:y lrotate))
     :xr (+ x1 (:x rrotate)) :yr (+ y1 (:y rrotate))}))
  
(defn angle [x1 y1 x2 y2]
  "Calculate angle from horizontal."
  (let [scale (distance x1 y1 x2 y2)]
    (when (> scale 0)
      (let [xr (/ (- x2 x1) scale)
            yr (/ (- y2 y1) scale)]
        (cond (and (>= xr 0) (>= yr 0)) (Math/acos xr),
              (and (>= xr 0) (<= yr 0)) (- (* 2.0 Math/PI) (Math/acos xr)),
              (and (<= xr 0) (>= yr 0)) (Math/acos xr)
              :else  (- (* 2.0 Math/PI) (Math/acos xr)))))))

(defn rotate [x y theta]
  "Rotate (x,y) theta radians about origin."
  {:x (- (* (Math/cos theta) x) (* (Math/sin theta) y))
   :y (+ (* (Math/sin theta) x) (* (Math/cos theta) y))}) 

(defn pt-from-head
  "Return a point d units beyond (or within, if negative) the line segment."
  [x1 y1 x2 y2 d]
  (let [len (distance x1 y1 x2 y2)
        ratio (/ (+ len d) len)]
    {:x (+ x1 (* ratio (- x2 x1)))
     :y (+ y1 (* ratio (- y2 y1)))}))

(defn pn-graph-scale
  "Return a reasonable scale factor for displaying the graph,
   given that the PN might have originated with another tool."
  [pn]
  (let [range
        (reduce (fn [range xy]
                  (as-> range ?r
                    (assoc ?r :min-x (min (:min-x ?r) (:x xy)))
                    (assoc ?r :max-x (max (:max-x ?r) (:x xy)))
                    (assoc ?r :min-y (min (:min-y ?r) (:y xy)))
                    (assoc ?r :max-y (max (:max-y ?r) (:y xy)))))
                {:min-x 99999 :max-x -99999
                 :min-y 99999 :max-y -99999}
                (-> pn :pn-graph-positions vals))
        size (max (- (:max-x range) (:min-x range))
                  (- (:max-y range) (:min-y range)))]
    (double (/ (apply min (:pn-graph-window-size pn)) size))))

(def +display-pn+ (atom nil))

(reset! +display-pn+
        (as->
            {:places [{:name :buffer-j1, :pid 1, :initial-tokens 0} {:name :buffer-j2, :pid 2, :initial-tokens 0} {:name :buffer-occupancy, :pid 3, :initial-tokens 0} {:name :m1-blocked, :pid 4, :initial-tokens 0} {:name :m1-blocked-j1, :pid 5, :initial-tokens 0} {:name :m1-blocked-j2, :pid 6, :initial-tokens 0} {:name :m1-enter-job, :pid 7, :initial-tokens 1} {:name :m1-run-jt1, :pid 8, :initial-tokens 0} {:name :m1-run-jt2, :pid 9, :initial-tokens 0} {:name :m2-run-jt1, :pid 10, :initial-tokens 0} {:name :m2-run-jt2, :pid 11, :initial-tokens 0} {:name :m2-starved, :pid 12, :initial-tokens 1}], :transitions [{:name :choose-jt1, :tid 13, :type :immediate, :rate 0.6} {:name :choose-jt2, :tid 14, :type :immediate, :rate 0.4} {:name :m1-finish-j1, :tid 15, :type :exponential, :rate 0.9} {:name :m1-finish-j2, :tid 16, :type :exponential, :rate 1.0} {:name :m2-finish-jt1, :tid 17, :type :exponential, :rate 1.0} {:name :m2-finish-jt2, :tid 18, :type :exponential, :rate 1.0} {:name :m2-unstarved-j1, :tid 19, :type :immediate, :rate 1.0} {:name :m2-unstarved-j2, :tid 20, :type :immediate, :rate 1.0} {:name :unblock-j1, :tid 21, :type :immediate, :rate 1.0} {:name :unblock-j2, :tid 22, :type :immediate, :rate 1.0}], :arcs [{:aid 23, :source :buffer-j1, :target :m2-unstarved-j1, :name :aa-23, :type :normal, :multiplicity 1} {:aid 24, :source :buffer-j2, :target :m2-unstarved-j2, :name :aa-24, :type :normal, :multiplicity 1} {:aid 25, :source :buffer-occupancy, :target :m2-unstarved-j1, :name :aa-25, :type :normal, :multiplicity 1} {:aid 26, :source :buffer-occupancy, :target :m2-unstarved-j2, :name :aa-26, :type :normal, :multiplicity 1} {:aid 27, :source :buffer-occupancy, :target :unblock-j1, :name :aa-27, :type :inhibitor, :multiplicity 1} {:aid 28, :source :buffer-occupancy, :target :unblock-j2, :name :aa-28, :type :inhibitor, :multiplicity 1} {:aid 29, :source :choose-jt1, :target :m1-run-jt1, :name :aa-29, :type :normal, :multiplicity 1} {:aid 30, :source :choose-jt2, :target :m1-run-jt2, :name :aa-30, :type :normal, :multiplicity 1} {:aid 31, :source :m1-blocked-j2, :target :unblock-j2, :name :aa-31, :type :normal, :multiplicity 1} {:aid 32, :source :m1-blocked-j1, :target :unblock-j1, :name :aa-32, :type :normal, :multiplicity 1} {:aid 33, :source :m1-blocked, :target :unblock-j1, :name :aa-33, :type :normal, :multiplicity 1} {:aid 34, :source :m1-blocked, :target :unblock-j2, :name :aa-34, :type :normal, :multiplicity 1} {:aid 35, :source :m1-finish-j1, :target :m1-blocked-j1, :name :aa-35, :type :normal, :multiplicity 1} {:aid 36, :source :m1-enter-job, :target :choose-jt1, :name :aa-36, :type :normal, :multiplicity 1} {:aid 37, :source :m1-enter-job, :target :choose-jt2, :name :aa-37, :type :normal, :multiplicity 1} {:aid 38, :source :m1-finish-j1, :target :m1-blocked, :name :aa-38, :type :normal, :multiplicity 1} {:aid 39, :source :m1-finish-j2, :target :m1-blocked, :name :aa-39, :type :normal, :multiplicity 1} {:aid 40, :source :m1-finish-j2, :target :m1-blocked-j2, :name :aa-40, :type :normal, :multiplicity 1} {:aid 41, :source :m1-run-jt1, :target :m1-finish-j1, :name :aa-41, :type :normal, :multiplicity 1} {:aid 42, :source :m1-run-jt2, :target :m1-finish-j2, :name :aa-42, :type :normal, :multiplicity 1} {:aid 43, :source :unblock-j1, :target :buffer-j1, :name :aa-43, :type :normal, :multiplicity 1} {:aid 44, :source :m2-finish-jt1, :target :m2-starved, :name :aa-44, :type :normal, :multiplicity 1} {:aid 45, :source :m2-finish-jt2, :target :m2-starved, :name :aa-45, :type :normal, :multiplicity 1} {:aid 46, :source :m2-run-jt1, :target :m2-finish-jt1, :name :aa-46, :type :normal, :multiplicity 1} {:aid 47, :source :m2-run-jt2, :target :m2-finish-jt2, :name :aa-47, :type :normal, :multiplicity 1} {:aid 48, :source :m2-starved, :target :m2-unstarved-j1, :name :aa-48, :type :normal, :multiplicity 1} {:aid 49, :source :m2-starved, :target :m2-unstarved-j2, :name :aa-49, :type :normal, :multiplicity 1} {:aid 50, :source :m2-unstarved-j1, :target :m2-run-jt1, :name :aa-50, :type :normal, :multiplicity 1} {:aid 51, :source :m2-unstarved-j2, :target :m2-run-jt2, :name :aa-51, :type :normal, :multiplicity 1} {:aid 52, :source :unblock-j1, :target :buffer-occupancy, :name :aa-52, :type :normal, :multiplicity 1} {:aid 53, :source :unblock-j1, :target :m1-enter-job, :name :aa-53, :type :normal, :multiplicity 1} {:aid 54, :source :unblock-j2, :target :buffer-j2, :name :aa-54, :type :normal, :multiplicity 1} {:aid 55, :source :unblock-j2, :target :buffer-occupancy, :name :aa-55, :type :normal, :multiplicity 1} {:aid 56, :source :unblock-j2, :target :m1-enter-job, :name :aa-56, :type :normal, :multiplicity 1}]}
            ?pn
    (assoc ?pn :pn-graph-positions
           {:m2-run-jt2 {:y 181, :label-x-off -40, :label-y-off 38, :x 1086},
            :m1-finish-j1 {:y 38, :label-x-off 8, :label-y-off -11, :x 279},
            :m1-run-jt2 {:y 179, :label-x-off -42, :label-y-off 34, :x 203},
            :choose-jt1 {:y 35, :label-x-off -14, :label-y-off -11, :x 55},
            :m2-starved {:y 118, :label-x-off 38, :label-y-off 3, :x 1147},
            :buffer-j1 {:y 41, :label-x-off -11, :label-y-off -21, :x 732},
            :unblock-j2 {:y 173, :label-x-off 3, :label-y-off 35, :x 567},
            :m1-enter-job {:y 101, :label-x-off 31, :label-y-off -16, :x 19},
            :m1-blocked-j2 {:y 189, :label-x-off -31, :label-y-off 33, :x 449},
            :m1-run-jt1 {:y 42, :label-x-off -29, :label-y-off -22, :x 188},
            :m2-finish-jt1 {:y 41, :label-x-off -5, :label-y-off -12, :x 1212},
            :m1-blocked-j1 {:y 39, :label-x-off 15, :label-y-off -18, :x 433},
            :m1-finish-j2 {:y 179, :label-x-off -1, :label-y-off 38, :x 280},
            :m2-unstarved-j2 {:y 175, :label-x-off -55, :label-y-off 42, :x 920},
            :choose-jt2 {:y 169, :label-x-off -8, :label-y-off 27, :x 58},
            :m1-blocked {:y 111, :label-x-off 42, :label-y-off 4, :x 545},
            :buffer-j2 {:y 181, :label-x-off -14, :label-y-off 35, :x 719},
            :buffer-occupancy {:y 100, :label-x-off 21, :label-y-off 10, :x 821},
            :m2-unstarved-j1 {:y 36, :label-x-off -7, :label-y-off -17, :x 903},
            :m2-finish-jt2 {:y 178, :label-x-off -17, :label-y-off 39, :x 1232},
            :unblock-j1 {:y 39, :label-x-off 7, :label-y-off -11, :x 577},
            :m2-run-jt1 {:y 43, :label-x-off -22, :label-y-off -23, :x 1083}})
    (assoc ?pn :pn-graph-window-size [6000 1000]) ; was 1300 700 for mac
    (let [scale-factor (pn-graph-scale ?pn)]
       (assoc ?pn :pn-graph-positions
             (reduce (fn [mp [key val]]
                       (assoc mp key
                              (-> val
                                  (assoc :x (Math/round (* scale-factor (-> val :x))))
                                  (assoc :y (Math/round (* scale-factor (-> val :y))))
                                  (assoc :label-x-off (Math/round (* scale-factor (-> val :label-x-off))))
                                  (assoc :label-y-off (Math/round (* scale-factor (-> val :label-y-off)))))))
                     {}
                     (:pn-graph-positions ?pn))))))

(declare interesect-circle trans-point trans-connects)
;;; POD Of course I could have just backed off a parametric line by +place-dia+/2...
(defn arc-coords-trans-to-place
  [pn trans place]
  "Return arc coordinates for argument arc (has aid)."
  (let [[tx ty px py] (ref-points pn trans place) ; (tx,ty) is top left
        bc (intersect-circle ; base
            (double (- tx px))
            (double (- ty py))
            0.0
            0.0
            (/ +place-dia+ 2.0))
        tc {:x1 (+ (:x1 bc) px) ; translated
            :y1 (+ (:y1 bc) py)
            :x2 (+ (:x2 bc) px)
            :y2 (+ (:y2 bc) py)}
        ;; choose closest position on transition
        [txn tyn] (trans-point pn trans place)]
        ;; choose closest intersection on circle
    (if (< (distance (:x1 tc) (:y1 tc) tx ty)
           (distance (:x2 tc) (:y2 tc) tx ty))
      {:tx txn :ty tyn :px (:x1 tc) :py (:y1 tc)}
      {:tx txn :ty tyn :px (:x2 tc) :py (:y2 tc)})))

(defn trans-connects
  "Return a vector of [x, y] being the 10 connection points on a transition"
  [pn trans]
  (let [[rx ry] (ref-points pn trans)
        th +trans-height+
        tw +trans-width+]
    [[(+ rx 10) ry] [(+ rx 20) ry] [(+ rx 30) ry]
     [(+ rx 10) (+ ry th)] [(+ rx 20) (+ ry th)] [(+ rx 30) (+ ry th)]
     [rx (+ ry 4)] [(+ rx tw) (+ ry 4)]]))

(defn trans-point
  "Choose the connection point on trans closest to place."
  [pn trans place]
  (let [center (ref-points pn place)]
    (reduce (fn [best coords]
              (if (< (distance (into center coords))
                     (distance (into center best)))
                coords
                best))
            [99999 99999]
            (trans-connects pn trans))))
  
(defn ref-points
  "Return a vector of [x, y,...] for each named object."
  [pn & names]
  (reduce (fn [v name]
            (-> v
                (conj (-> pn :pn-graph-positions name :x))
                (conj (-> pn :pn-graph-positions name :y))))
          []
          names))

(defn intersect-circle
  "http://mathworld.wolfram.com/Circle-LineIntersection.html"
  [x1 y1 x2 y2 r]
  (let [dx (- x2 x1)
        dy (- y2 y1)
        dr (Math/sqrt (+ (* dx dx) (* dy dy)))
        D (- (* x1 y2) (* x2 y1))
        sgnDy (if (< dy 0) -1.0 1.0)
        rootTerm (Math/sqrt (- (* r r dr dr) (* D D)))
        denom (* dr dr)]
    {:x1 (/ (+ (* D dy) (* sgnDy dx rootTerm)) denom)
     :y1 (/ (+ (- (* D dx)) (* (abs dy) rootTerm)) denom)
     :x2 (/ (- (* D dy) (* sgnDy dx rootTerm)) denom)
     :y2 (/ (- (- (* D dx)) (* (abs dy) rootTerm)) denom)}))

(defn displayable? [pn]
  (and (pn? @+display-pn+)))

;;; The actual quil/defsketch is in client.cljs. (Otherwise it doesn't load.) 

(ns gov.nist.sinet.util.draw
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]
            [quil.core :as q]
            [quil.middleware :as qm]))

;;; Purpose: Draw a Petri net and related information. Allow some interaction with it.

(def +place-dia+ 30)
(def +trans-width+ 40)
(def +trans-height+ 8)
(def +token-dia+ 4)
(def +inhibit-dia+ 10)
(def +arrowhead-length+ 15)
(def +arrowhead-angle+ "zero is on the shaft" (/ Math/PI 8.0))

(defn setup-pn []
  (q/frame-rate 10)    ; FPS. 10 is good
  (q/text-font (q/create-font "DejaVu Sans" 16 true))
  (q/background 200)) ; light grey

(def +log+ (atom []))
(defn log [text]
  (swap! +log+ #(conj % text)))

(declare nearest-elem ref-points draw-elem draw-arc draw-tokens)
(declare arc-coords-trans-to-place arrowhead-coords pt-from-head)
(declare angle distance +display-pn+ highlight-elem handle-mouse)

(defn draw-pn []
  (let [pn @+display-pn+]
    (q/background 230) ; POD not sure I want to keep this.
    (q/stroke 0) ; black
    (q/fill 255) ; white
    (q/stroke-weight 2)
    (highlight-elem pn)
    (when (q/mouse-pressed?)
      (handle-mouse))
    (doseq [place (:places pn)]
      (draw-elem pn place))
    (doseq [trans (:transitions pn)]
      (draw-elem pn trans))
    (doseq [arc (:arcs pn)]
      (draw-arc pn arc))))

(def +diag+ (atom nil))

(defn handle-mouse
  "Mouse pressed: Update coordinates to move an element or its label."
  []
  (when-let [elem (nearest-elem @+display-pn+ [(q/mouse-x) (q/mouse-y)])]
    (reset! +diag+ elem)
    (swap!
     +display-pn+
     #(let [n (:name elem)]
        (if (:label? elem)
          (as-> % ?pn
            (assoc-in ?pn [:pn-graph-positions n :label-x-off]
                      (- (q/mouse-x) (-> ?pn :pn-graph-positions n :x)))
            (assoc-in ?pn [:pn-graph-positions n :label-y-off]
                      (- (q/mouse-y) (-> ?pn :pn-graph-positions n :y))))
          (as-> % ?pn
            (assoc-in ?pn [:pn-graph-positions n :x] (q/mouse-x))
            (assoc-in ?pn [:pn-graph-positions n :y] (q/mouse-y))))))))

(def +highlight-elem+ (atom nil))
(defn highlight-elem
  [pn]
  (if-let [elem (nearest-elem pn [(q/mouse-x) (q/mouse-y)])]
    (reset! +highlight-elem+ elem)
    (reset! +highlight-elem+ nil)))

(defn nearest-elem
  "Return a element (place/trans) map  indicating what was closest to the mouse.
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
    (q/fill (if (and (= n (:name hilite)) (:label? hilite)) (q/color 255 0 0) 0))
    (q/text (name n)
            (+ x (-> pn :pn-graph-positions n :label-x-off))
            (+ y (-> pn :pn-graph-positions n :label-y-off)))
    (q/fill 0)
    (q/stroke (if (and (= (:name hilite) n) (not (:label? hilite))) (q/color 255 0 0) 0))
    (if (pnu/place? elem)
      (do
        (q/fill 255)
        (q/ellipse x y +place-dia+ +place-dia+)
        (draw-tokens (:initial-tokens elem) x y))
      (do (q/fill (if (= (:type elem) :immediate) 0 255))
          (q/rect x y +trans-width+ +trans-height+)))
    (q/stroke 0)
    (q/fill 0)))

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
      (q/text (str cnt) x y))))

(defn draw-tkn
  [x y]
  (q/fill 0) ; black
  (q/ellipse x y +token-dia+ +token-dia+))

(defn draw-arc
  [pn arc]
  (let [place-is-head? (pnu/place? (pnu/name2obj pn (:target arc))),
        inhibitor? (= :inhibitor (:type arc)),
        ln
        (if place-is-head? 
          (arc-coords-trans-to-place pn (:source arc) (:target arc))
          (arc-coords-trans-to-place pn (:target arc) (:source arc)))]
    (if inhibitor? ; head is always the transition
      (let [center (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- (/ +inhibit-dia+ 2)))
            end (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- +inhibit-dia+))]
        (q/fill 255)
        (q/stroke-weight 1)
        (q/ellipse (:x center) (:y center) +inhibit-dia+ +inhibit-dia+)
        (q/stroke-weight 2)
        (q/line (:px ln) (:py ln) (:x end) (:y end)))
      (do (q/line (:tx ln) (:ty ln) (:px ln) (:py ln))
          (if place-is-head?
            (let [ahc (arrowhead-coords (:tx ln) (:ty ln) (:px ln) (:py ln))]
              (q/line (:px ln) (:py ln) (:xl ahc) (:yl ahc))
              (q/line (:px ln) (:py ln) (:xr ahc) (:yr ahc)))
            (let [ahc (arrowhead-coords (:px ln) (:py ln) (:tx ln) (:ty ln))]
              (q/line (:tx ln) (:ty ln) (:xl ahc) (:yl ahc))
              (q/line (:tx ln) (:ty ln) (:xr ahc) (:yr ahc))))))))

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
    (/ (apply min (:pn-graph-window-size pn)) size)))

(def +display-pn+ (atom nil))

(reset! +display-pn+
  (as-> "data/2017-05-06-three.xml" ?pn
    (read-pnml ?pn)
    (assoc ?pn :pn-graph-positions
           (pnml/positions-from-file "data/2017-05-06-three.xml"))
    ;; POD Consider q/width q/height
    (assoc ?pn :pn-graph-window-size [1300 700])
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
  (and (pnu/pn? @+display-pn+)))

(defn show-pn
  []
  (when (displayable? @+display-pn+)
    (q/defsketch best-pn :features [:resizable :keep-on-top]
      :title "Best Individual"
      :settings #(q/smooth 2) ; Turn on anti-aliasing
      :setup setup-pn
      :draw draw-pn
      :size [1300 900])))

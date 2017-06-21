(ns gov.nist.sinet.util.draw
  "SINET Petri net draw code"
  {:author "Peter Denno"}
  (:require [quil.core :as quil :include-macros true]
            [quil.middleware :as qm]
            [medley.core :refer (abs)]
            [cljs.pprint :refer (pprint)]
            #_[gov.nist.sinet.util.client :refer (->output!)]))
  
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

(def +place-dia+ 26)
(def +trans-width+ 35)
(def +trans-height+ 8)
(def +token-dia+ 4)
(def +inhibit-dia+ 10)
(def +arrowhead-length+ 15)
(def +arrowhead-angle+ "zero is on the shaft" (/ Math/PI 8.0))
(def +lock-mouse-on+ (atom nil))

(defn setup-pn []
  (quil/frame-rate 10)    ; FPS. 10 is good
  (quil/text-font (quil/create-font "DejaVu Sans" 12 true))
  (quil/background 200)) ; light grey

(declare nearest-elem ref-points draw-elem draw-arc draw-tokens)
(declare arc-coords-trans-to-place arrowhead-coords pt-from-head)
(declare angle distance +display-pn+ highlight-elem! handle-move!)

(defn draw-pn []
  (let [pn @+display-pn+]
    (quil/background 230) ; POD not sure I want to keep this.
    (quil/stroke 0) ; black
    (quil/fill 255) ; white
    (quil/stroke-weight 1)
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
  (gov.nist.sinet.util.client/->output! "mouse-move in draw")
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
        (quil/stroke-weight 1)
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

(def +display-pn+ (atom nil))
 
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

;;; The actual quil/defsketch is in client.cljs. (Otherwise it doesn't load.) 


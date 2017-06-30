(ns gov.nist.sinet.client.draw
  "SINET Petri net draw code"
  {:author "Peter Denno"}
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as qm]
            [medley.core :refer (abs)]
            [cljs.pprint :refer (pprint)]))
  
;;; ToDo: * Replace pn-trans-point: review everything on the trans and distribute
;;;         so that things are on the correct side, not overlapping, and spaced nicely. 
;;;       * Show :intro :elim acts (and their multiplicity).
;;;       * Integrate simulation stepping capability.  
  
;;;================== Stuff borrowed from pnu (not cljs)  ========================
(defn ppp []
  (binding [cljs.pprint/*print-right-margin* 140]
    (pprint *1)))

(defn ppprint [arg]
  (binding [cljs.pprint/*print-right-margin* 140]
    (pprint arg)))

(defn transition? [obj] (:tid obj))

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
(def +trans-width+ 36)
(def +trans-height+ 8)
(def +trans-prefer-center?+ true)
(def +token-dia+ 4)
(def +inhibit-dia+ 10)
(def +arrowhead-length+ 12)
(def +arrowhead-angle+ "zero is on the shaft" (/ Math/PI 8.0))
(def +lock-mouse-on+ (atom nil))
(def +hilite-elem+ (atom nil))
(defonce +display-pn+ (atom nil))

(defn rotate [x y theta]
  "Rotate (x,y) theta radians about origin."
  {:x (double (- (* (Math/cos theta) x) (* (Math/sin theta) y)))
   :y (double (+ (* (Math/sin theta) x) (* (Math/cos theta) y)))}) 

;;;   8----7----6----2----3----4----5
;;;   |                             |
;;;   1           (xc,yc)           0
;;;   |                             |
;;;   15---14---13---9---10---11---12
(def +rot-offsets+
  "Vector of vectors, one for each rotation. Each 16-place sub-vector is a set of 
   offsets from the center of the transition (xc,yc) with index as shown."
  (let [tw (/ +trans-width+  2.0)
        th (/ +trans-height+ 2.0)
        p3 (* 0.3333333 tw)
        p4 (* 0.6666666 tw)
        p5 (* 0.9500000 tw) 
        srotate (fn [x y theta] (vec (map #(Math/round %) (vals (rotate x y theta)))))
        ;; These are in window coordinates (0, 0 is upper left)
        base [[tw 0.0] [(- tw) 0.0]
              [0.0 (- th)] [p3 (- th)] [p4 (- th)] [p5 (- th)]
              [(- p3)(- th)] [(- p4) (- th)] [(- p5) (- th)]
              [0.0 th] [p3 th] [p4 th] [p5 th]
              [(- p3) th] [(- p4) th] [(- p5) th]]]
    [(vec (map (fn [[x y]] (srotate x y 0.0)) base))
     (vec (map (fn [[x y]] (srotate x y (* Math/PI 0.25))) base))
     (vec (map (fn [[x y]] (srotate x y (* Math/PI 0.50))) base))
     (vec (map (fn [[x y]] (srotate x y (* Math/PI 0.75))) base))]))

(defn setup-pn []
  (q/frame-rate 20)    ; FPS. 10 is good
  (q/text-font (q/create-font "DejaVu Sans" 12 true))
  (q/background 200)) ; light grey

(declare nearest-elem ref-points draw-elem draw-arc draw-tokens)
(declare arc-coords-trans-to-place! arrowhead-coords pt-from-head)
(declare angle distance hilite-elem! handle-move! rotate-trans!)

(defn draw-pn []
  (when-let [pn @+display-pn+]
    (q/background 230) ; POD not sure I want to keep this.
    (q/stroke 0) ; black
    (q/fill 255) ; white
    (q/stroke-weight 1)
    (hilite-elem! pn)
    (if (q/mouse-pressed?)
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
  (when-let [elem (or @+lock-mouse-on+ (nearest-elem @+display-pn+ [(q/mouse-x) (q/mouse-y)]))]
    (swap!
     +display-pn+
     #(let [n (:name elem)]
        (if (:label? elem)
          (as-> % ?pn
            (assoc-in ?pn [:geom n :label-x-off]
                      (- (q/mouse-x) (-> ?pn :geom n :x)))
            (assoc-in ?pn [:geom n :label-y-off]
                      (- (q/mouse-y) (-> ?pn :geom n :y))))
          (as-> % ?pn
            (assoc-in ?pn [:geom n :x] (q/mouse-x))
            (assoc-in ?pn [:geom n :y] (q/mouse-y))))))))

(defn hilite-elem!
  "Set +hilight-elem+ and maybe +lock-mouse-on+."
  [pn]
  (let [nearest (or @+lock-mouse-on+ (nearest-elem pn [(q/mouse-x) (q/mouse-y)]))]
    (when (and nearest (q/mouse-pressed?)) (reset! +lock-mouse-on+ nearest))
    (if nearest
      (reset! +hilite-elem+ nearest)
      (reset! +hilite-elem+ nil))))

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
         (-> pn :geom))]
    (when (< min-d 30.0)
      (when-let [elem (or (some #(when (= bkey (:name %)) %) (:places pn))
                          (some #(when (= bkey (:name %)) %) (:transitions pn)))]
        (assoc elem :label? label?)))))

(def half-tw (Math/round (/ +trans-width+ 2.0)))
(def half-th (Math/round (/ +trans-height+ 2.0)))
(def rots [0.0 (* Math/PI 0.25) (* Math/PI 0.50) (* Math/PI 0.75)])
(defn draw-trans
  "Draw a transition with rotation as indicated by :rotate."
  [name x y]
  (q/with-translation [x y] ;[(+ x half-tw) (+ y half-th)]
    (q/with-rotation [(if-let [n (-> @+display-pn+ :geom name :rotate)]
                        (nth rots n)
                        0.0)]
      (q/rect (- half-tw) (- half-th) +trans-width+ +trans-height+))))

(defn draw-elem
  "Draws a element and its label. The element map might have :label? = true
   to indicate that it is the label that needs highlighting. The actual 
   updating of the net is taken care of in handle-mouse."
  [pn elem]
  (let [n (:name elem)
        x (-> pn :geom n :x)
        y (-> pn :geom n :y)
        hilite @+hilite-elem+]
    (q/fill (if (and (= n (:name hilite)) (:label? hilite)) (q/color 255 0 0) 0))
    (q/text (name n)
            (+ x (-> pn :geom n :label-x-off))
            (+ y (-> pn :geom n :label-y-off)))
    (q/fill 0)
    (q/stroke (if (and (= (:name hilite) n) (not (:label? hilite))) (q/color 255 0 0) 0))
    (if (place? elem)
      (do
        (q/fill 255)
        (q/ellipse x y +place-dia+ +place-dia+)
        (draw-tokens (:initial-tokens elem) x y))
      ;; It's a transition
      (do (q/fill (if (= (:type elem) :immediate) 0 255))
          (draw-trans n x y)))
    (q/stroke 0)
    (q/fill 0)))

(declare draw-tkn intersect-circle)
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
  (q/fill 0) ; (q/fill 0 0 255) ; blue
  (q/ellipse x y +token-dia+ +token-dia+))

(defn draw-arc
  [pn arc]
  (let [place-is-head? (place? (name2obj pn (:target arc))),
        inhibitor? (= :inhibitor (:type arc)),
        ln
        (if place-is-head? 
          (arc-coords-trans-to-place! pn (:source arc) (:target arc) (:name arc))
          (arc-coords-trans-to-place! pn (:target arc) (:source arc) (:name arc)))]
    (if inhibitor? ; head is always the transition
      (let [center (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- (/ +inhibit-dia+ 2)))
            end (pt-from-head (:px ln) (:py ln) (:tx ln) (:ty ln) (- +inhibit-dia+))]
        (q/fill 255)
        (q/stroke-weight 1)
        (q/ellipse (:x center) (:y center) +inhibit-dia+ +inhibit-dia+)
        (q/stroke-weight 1)
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

(defn pt-from-head
  "Return a point d units beyond (or within, if negative) the line segment."
  [x1 y1 x2 y2 d]
  (let [len (distance x1 y1 x2 y2)
        ratio (/ (+ len d) len)]
    {:x (+ x1 (* ratio (- x2 x1)))
     :y (+ y1 (* ratio (- y2 y1)))}))

(declare interesect-circle pn-trans-point trans-connects)
;;; POD Of course I could have just backed off a parametric line by +place-dia+/2...
(defn arc-coords-trans-to-place!
  [pn trans place arc]
  "Return arc coordinates for argument arc (has aid)."
  (let [[tx ty px py] (ref-points pn trans place) ; both are center points
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
        ;; choose closest position on transition (with consideration of other occupancy)
        {:keys [pt take]} (pn-trans-point pn trans place arc)
        [txn tyn] pt]
    ;; Reserve the place on trans
    (swap! +display-pn+
           (fn [pn] (update-in pn [:geom trans :taken]
                               #(assoc % arc take))))
    ;; choose closest intersection on circle
    (if (< (distance (:x1 tc) (:y1 tc) tx ty)
           (distance (:x2 tc) (:y2 tc) tx ty))
      {:tx txn :ty tyn :px (:x1 tc) :py (:y1 tc)}
      {:tx txn :ty tyn :px (:x2 tc) :py (:y2 tc)})))

(defn trans-connects
  "Return a vector of [x, y] being the 16 connection points on a transition"
  [pn trans]
  (let [[rx ry] (ref-points pn trans)
        rotation (or (-> @+display-pn+ :geom trans :rotate) 0)
        offsets (nth +rot-offsets+ rotation)]
    (vec (map (fn [[xoff yoff]] (vector (+ rx xoff) (+ ry yoff))) offsets))))

;;;   8----7----6----2----3----4----5
;;;   |                             |
;;;   1           (xc,yc)           0
;;;   |                             |
;;;   15---14---13---9---10---11---12
(declare basic-candidates)
(defn pn-trans-point
  "Return {:pt [x y] :take <n>] of the best place for the argument arc to 
   connect to the trans. Considers rotation and other occupancy on the trans."
  [pn trans place arc]
  (let [me-now? (-> pn :geom trans :taken arc)
        t-connects (trans-connects pn trans)]
    (if (and me-now? (not @+lock-mouse-on+)) ; did it already assigned and elements are not being moved.
      {:pt (nth t-connects me-now?) :take me-now?}
      (let [[cx cy tx ty] (ref-points pn place trans) ; these are center points
            D (zipmap (range 16) (map (fn [txy] (distance (into [cx cy] txy))) t-connects))
            gfn (fn [n] [n (get D n)])
            top-showing? (< (get D 2) (get D 9))
            left-showing? (< (get D 1) (get D 0))
            closest (first (sort (fn [[_ d1] [_ d2]] (< d1 d2)) D))
            taken-map (-> @+display-pn+ :geom trans :taken)
            taken (vals taken-map)
            not-taken? (fn [n] (or (= n (arc taken-map)) ; take by me
                                   (not (some #(= n %) taken))))
            y-diff (Math/abs (double (- cy ty)))
            ;; at this point candidates is a MAP INDEX BY AN INTEGER position See also gfn.
            candidates (basic-candidates D top-showing? left-showing?)
            candidates (remove (fn [c] (some #(= (first c) %) taken)) candidates)
            candidates (sort (fn [[_ d1] [_ d2]] (< d1 d2)) candidates)
            #_zippy #_(when (and (= place :Place-22) (= trans :m1-start-job) (= arc :aa-76))
                    (reset! +diag+ {:place place :trans trans :arc arc
                                    :top-showing? top-showing?
                                    :me-now? me-now?
                                    :left-showing? left-showing?
                                    :first-candidate (first candidates)
                                    :taken-map taken-map
                                    :y-diff y-diff :cy cy :ty ty}))
            best (cond (empty? candidates) closest
                       (and (< y-diff 5) left-showing? (not-taken? 1)) (gfn 1) 
                       (and (< y-diff 5) (not-taken? 0)) (gfn 0)
                       (and +trans-prefer-center?+ top-showing? (not-taken? 2)) (gfn 2)
                       (and +trans-prefer-center?+ (not top-showing?) (not-taken? 9)) (gfn 9)
                       :else (first candidates))] ; POD 8 below for jitter is sensitive to trans size
        (if (and me-now? (< (Math/abs (- (get D me-now?) (get D (first best)))) 8)) 
          {:pt (nth t-connects me-now?) :take me-now?} ; Don't change. Prevent jitter.
          {:pt (nth t-connects (first best)) :take (first best)})))))

(defn basic-candidates
  "First set of considerations when pick candidate connection positions."
  [D top-showing? left-showing?]
  (let [gfn (fn [n] [n (get D n)])]
    (cond (and top-showing? left-showing?)
          (conj (map gfn '(8 7 6 2 3 4 5)) (gfn 1)),
          top-showing?
          (conj (map gfn '(8 7 6 2 3 4 5)) (gfn 0)),
          left-showing?
          (conj (map gfn '(15 14 13 9 10 11 12)) (gfn 1)),
          :else
          (conj (map gfn '(15 14 13 9 10 11 12)) (gfn 0)))))
  
(defn ref-points
  "Return a vector of [x, y,...] for each named object."
  [pn & names]
  (reduce (fn [v name]
            (-> v
                (conj (-> pn :geom name :x))
                (conj (-> pn :geom name :y))))
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

;;;(def last-rot (atom (System/currentTimeMillis)))
(def last-rot (atom (.getTime (js/Date.))))

(defn pn-wheel-fn
  [_]
  (when-let [hilite @+hilite-elem+]
    (when (contains? hilite :tid)
      (when (> (- (.getTime (js/Date.)) @last-rot) 250)
        (reset! last-rot (.getTime (js/Date.)))
        (swap! +display-pn+
               (fn [pn]
                 (update-in pn
                            [:geom (:name hilite)]
                            #(cond (not (contains? % :rotate)) (assoc % :rotate 1), 
                                   (= 1 (:rotate %)) (assoc % :rotate 2),
                                   (= 2 (:rotate %)) (assoc % :rotate 3),
                                   :else (dissoc % :rotate)))))))))



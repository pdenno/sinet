(ns gov.nist.sinet.gp
  "SINET demonstrate ideas in system identification/process mining using genetic programming."
  {:author "Peter Denno"}
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.simulate :as sim :refer (simulate)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)] ;  POD clean this up
            [gov.nist.sinet.fitness :as fit :refer (workflow-fitness)]
            [gov.nist.sinet.ws :as ws]))

;;; I started with Lee Spector's "gp" demonstration software.

;;; ToDo: - DONE: Get data for exponential jobs, BBS.
;;;       ===> I think it makes more sense to perform 5-10 mutations on edens THEN test them.
;;;       ===> Make sure I'm not promoting non-mutated individuals when they fail mutation.
;;;       ===> Normalize the error calculation.
;;;       ===> Create/save a zero population. Read it in to start.
;;;       - Keeping compute time on each individual might be useful.
;;;       - GSPN: Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - Implement a log for exceptional situations.
;;;       - DONE (enough): Probably need more than one Eden individual for diversity (backwards, multi-loops etc).
;;;       - GSPN: Maybe I shouldn't care about absorbing states?

;;; POD Two nasty functions...
(defn app-info []
  ((resolve 'gov.nist.sinet.run/app-info)))

(defn update-pop! [pop]
  (alter-var-root
   (resolve 'gov.nist.sinet.run/system)
   #(assoc-in % [:app :pop] pop)))

(defn gp-param [name]
  (-> (app-info) :gp-params name))

(defn pr-param [name]
  (-> (app-info) :problem name))

(defrecord Inv [pn id error history])
(def +diag+ (atom nil))
(def +log+ (atom []))
(defn log [msg] (swap! +log+ conj msg))

(def +edens+ "Vector of eden individuals"  (atom nil))

;;;  DOCUMENTATION REQUIREMENT: Determine what among the :gp-params matters.
;;; :pn-elements -- The PN elements that can appear in individuals.
;;; :initial-individuals -- percentage of each element type.
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")

;;; POD As currently conceived, the problem is to associate :scada-events with :visible-transitions
;;;     and then of course, get the wiring correct. 
;;;     Each transition in the initial population will be randomly given one of the four functions
;;;;    (from those that not already chosen). Mutations will move them around. etc.

(defn add-extra-nodes
  "Return a map {:t <> :p <> :t-adds, :p-adds} naming nodes (transitions or places) to be added.
   Used to make the ring-shaped Eden individual."
  [prob]
  (let [cnt-p (count (:visible-places prob))
        cnt-t (count (:visible-transitions prob))]
    (as-> {:p (:visible-places prob) :t (:visible-transitions prob)} ?p
      (cond (= cnt-p cnt-t) ?p
            (> cnt-p cnt-t)
            (update-in ?p [:t]
                       into (for [n (range (- cnt-p cnt-t))] (keyword (str "tadd-" (inc n)))))
            (> cnt-t cnt-p)
            (update-in ?p [:p]
                       into (for [n (range (- cnt-t cnt-p))] (keyword (str "padd-" (inc n))))))
      (if (> cnt-p cnt-t)
        (assoc ?p :t-adds (set (subvec (:t ?p) cnt-t)))
        (assoc ?p :p-adds (set (subvec (:p ?p) cnt-p)))))))

(declare eden-display-geometry)
(defn eden-individual
  "Return a minimal and prototypical individual for the problem.
   It is a loop made by using visible places and transitions with additional
   hidden places and transitions necessary to close the loop. It isn't
   random but rather it is constant for the problem definition."
  [problem]
  (let [prob (add-extra-nodes problem)]
    (as-> {:places [] :transitions [] :arcs []} ?pn
      (reduce (fn [pn pl] (pnu/add-pn pn (pnu/make-place pn :name pl))) ?pn (:p prob))
      (update-in ?pn [:places 0 :initial-tokens] inc) ; Add a token to make it alive
      (reduce (fn [pn tr] (pnu/add-pn pn (pnu/make-transition pn :name tr)))
              ?pn (:t prob))
      (reduce (fn [pn [from to]] (pnu/add-pn pn (pnu/make-arc pn from to)))
              ?pn
              (map vec (partition
                        2 (interleave
                           (vec (interleave (:p prob) (:t prob)))
                           (vec (interleave (:t prob)
                                            (conj (vec (rest (:p prob)))
                                                  (first (:p prob)))))))))
      ;; Initialize to :visible? true, then dissoc where added.
      (assoc ?pn :places (vec (map #(assoc % :visible? true) (:places ?pn))))
      (assoc ?pn :transitions (vec (map #(assoc % :visible? true) (:transitions ?pn))))
      (if (:p-adds prob)
        (assoc ?pn :places
               (vec (map #(if (contains? (:p-adds prob) (:name %)) (dissoc % :visible?) %)
                         (:places ?pn))))
        (assoc ?pn :transitions
               (vec (map (fn [trans]
                           (if (contains? (:t-adds prob) (:name trans))
                             (as-> trans ?t
                               (dissoc ?t :visible?)
                               (assoc ?t :type (if (= 0 (rand-int 2)) :exponential :immediate)))
                             trans))
                         (:transitions ?pn)))))
      (eden-display-geometry ?pn))))

(defn eden-display-geometry 
  "Assign positions to places and transitions of Eden individuals for display."
  [pn]
  (let [elems (interleave (map :name (:places pn)) (map :name (:transitions pn)))
        nelems (count elems)
        angle-inc (/ (* 2 Math/PI) nelems)
        angle (atom (- angle-inc))]
    (assoc pn :geom
           (reduce (fn [geom ename]
                     (swap! angle #(+ % angle-inc))
                     (assoc geom ename
                            {:x (Math/round (* 100 (Math/cos @angle)))
                             :y (Math/round (* 100 (Math/sin @angle)))
                             :label-x-off 10
                             :label-y-off 15}))
                   {}
                   elems))))

(defn eden-pns!
  [problem]
  (reset! +edens+
          (vector
           (map->Inv {:pn (eden-individual problem) :id "eden-fwd"})
           (map->Inv {:pn (eden-individual (update problem :visible-places reverse)) :id "eden-rev"}))))

(defn random-crossover [])

(defn rand-mute-key
  "Return a keyword designating a mutation function."
  ([] (rand-mute-key (gp-param :mutation-dist)))
  ([mdist]
   (let [r (rand (reduce (fn [sum p] (+ sum (second p))) 0 mdist))] ; 'normalized'
    (loop [dist mdist
           sum (second (first mdist))]
      (let [[mtype _] (first dist)]
        (if (> sum r)
          (first (first dist))
          (recur (rest dist)
                 (+ sum (second (second dist))))))))))

(defn random-trans [pn & {:keys [subset] :or {subset identity}}]
  (let [trans (subset (:transitions pn))]
    (when (not-empty trans)
      (nth trans (rand-int (count trans))))))

(defn random-place [pn  & {:keys [subset] :or {subset identity}}]
  (let [places (subset (:places pn))]
    (when (not-empty places)
      (nth places (rand-int (count places))))))

(defn random-arc [pn  & {:keys [subset] :or {subset identity}}]
  (let [arcs (subset (:arcs pn))]
    (when (not-empty arcs)
      (nth arcs (rand-int (count arcs))))))

(declare mutate-m reset-all! eval-pn)

;;; POD This could eliminate a good individual. Needs thought.
;;; Mutate now as the COMPLETE pn computation (through to steady-state) NEEDS THOUGHT!
(defn mutate
  "mutate the individual"
  ([inv] (mutate inv :pick-fn rand-mute-key)) ; no args to r-m defaults to :mutation-dist
  ([inv & {:keys [pick-fn force] :or {pick-fn rand-mute-key}}]
   (mutate-m inv :pick-fn pick-fn :force force)))

(defn- mutate-m-dispatch [inv & {:keys [pick-fn force]
                                :or {pick-fn rand-mute-key}}]
  (let [answer (or force (pick-fn))]
    (when-not (pnu/pn? (:pn inv))
      (pnu/break "last mutation failed."))
    ;(println "answer =" answer)
    answer))

(defmulti mutate-m #'mutate-m-dispatch)

(defn- crossover-m-dispatch [inv & {:keys [force pick-fn]
                                    :or {pick-fn random-crossover}}]
  (let [answer (or force (pick-fn))]
    answer))

(defmulti crossover-m #'crossover-m-dispatch)

(defn crossover [pn1 pn2]
  (let [[pnp1 pnp2] (crossover-m pn1 pn1)]
    (if (and (pnu/pn? pnp1) (pnu/pn? pnp2))
      [pnp1 pnp2]
      (crossover pn1 pn2))))

;;;=================== Add =======================================
(defmethod mutate-m :add-place [inv & args]
  (let [trans-in (:name (random-trans (:pn inv)))
        trans-out (:name (random-trans (:pn inv)))]
    (as-> inv ?i
      (assoc ?i :pn (pnu/add-pn (:pn ?i) (pnu/make-place (:pn ?i))))
      (assoc ?i :pn (pnu/add-pn (:pn ?i) (pnu/make-arc (:pn ?i) trans-in (-> ?i :pn :places last :name))))
      (assoc ?i :pn (pnu/add-pn (:pn ?i) (pnu/make-arc (:pn ?i) (-> ?i :pn :places last :name) trans-out)))
      (update ?i :history conj {:mutate :add-place :place (-> ?i :pn :places last :name)}))))

(defmethod mutate-m :add-token [inv & args]
  (let [pn (:pn inv)
        p-indx (rand-int (count (:places pn)))]
    (as-> inv ?i
        (update ?i :history conj {:mutate :add-token :place (as-> ?i ?j (:pn ?j) (:places ?j) (nth ?j p-indx) (:name ?j))})
        (update-in ?i [:pn :places p-indx :initial-tokens] inc))))

(defmethod mutate-m :add-trans [inv & args]
  (let [pn (:pn inv)]
    (if-let [p-in (:name (random-place pn))]
      (if-let [p-out (:name (random-place pn :subset #(remove (fn [pl] (= (:name pl) p-in)) %)))]
        (as-> inv ?i
          (assoc ?i :pn
                 (pnu/add-pn pn (pnu/make-transition
                                 pn ; POD choice of :exponential/:immediate here is temporary
                                 :type (if (= 0 (rand-int 2)) :exponential :immediate))))
          (let [t (-> ?i :pn :transitions last :name)]
            (-> ?i
                (update :history conj {:mutate :add-trans :trans t})
                (assoc :pn (as-> (:pn ?i) ?pn
                             (pnu/add-pn ?pn (pnu/make-arc ?pn p-in t))
                             (pnu/add-pn ?pn (pnu/make-arc ?pn t p-out)))))))
        {:skip :add-trans :msg "no p-out"})
      {:skip :add-trans :msg "no p-in"})))

(defmethod mutate-m :add-arc [inv & args]
  (if-let [tr (random-trans (:pn inv))]
    (if-let [pl (random-place (:pn inv))]
      (let [[from to] (case (rand-int 2) 0 (vector tr pl) 1 (vector tr pl))]
        (as-> inv ?i
          (update ?i :history conj {:mutate :add-arc :place pl})
          (assoc ?i :pn (pnu/add-pn (:pn ?i) (pnu/make-arc (:pn ?i) (:name from) (:name to))))))
      {:skip :add-arc :msg "No visible place"})
    {:skip :add-arc :msg "No trans"}))

(defmethod mutate-m :add-inhibitor [inv & args]
  (if-let [tr (random-trans (:pn inv))]
    (if-let [pl (random-place (:pn inv))]
      (as-> inv ?i
        (update ?i :history conj {:mutate :add-inhibitor :place pl})
        (assoc ?i :pn (pnu/add-pn (:pn ?i) (pnu/make-arc (:pn ?i) (:name pl) (:name tr) :type :inhibitor))))
      {:skip :add-inhibitor :msg "No visible place"})
    {:skip :add-inhibitor :msg "No trans"}))

;;;=================== Remove =======================================
(defmethod mutate-m :remove-place [inv & args]
  (let [pl (:name (random-place (:pn inv) :subset #(remove (fn [pl] (:visible? pl)) %)))]
    (as-> inv ?i
      (update ?i :history conj {:mutate :remove-place :place pl})
      (assoc-in ?i [:pn :places] (vec (remove #(= (:name %) pl) (-> ?i :pn :places))))
      (assoc-in ?i [:pn :arcs]   (vec (remove #(or (= (:source %) pl)
                                                   (= (:target %) pl)) (-> ?i :pn :arcs)))))))

(defmethod mutate-m :remove-token [inv & args]
  (if-let [pl (:name (random-place (:pn inv) :subset #(remove (fn [pl] (= 0 (:initial-tokens pl))) %)))]
    (as-> inv ?i
        (update ?i :history conj {:mutate :remove-token :place pl})
        (assoc-in ?i [:pn :places] (vec (map #(if (= (:name %) pl)
                                                (update % :initial-tokens dec)
                                                %)
                                             (-> ?i :pn :places)))))
    {:skip :remove-token :msg "No place with token"}))

(defmethod mutate-m :remove-trans [inv & args]
  (let [tr (:name (random-trans (:pn inv) :subset #(remove (fn [pl] (:visible? pl)) %)))]
    (as-> inv ?i
      (update ?i :history conj {:mutate :remove-trans :trans tr})
      (assoc-in ?i [:pn :transitions] (vec (remove #(= (:name %) tr) (-> ?i :pn :transitions))))
      (assoc-in ?i [:pn :arcs] (vec (remove #(or (= (:source %) tr) (= (:target %) tr))
                                            (-> ?i :pn :arcs)))))))

(defn arc-not-sole
  "Return true if removal of the argument arc wouldn't leave the net with a
   transition or place for which there isn't at least one arc in and one out."
  [pn ar]
  (and (> (count (remove #(= :inhibitor (:type %)) (pnu/arcs-into  pn (:source ar)))) 1)
       (> (count (remove #(= :inhibitor (:type %)) (pnu/arcs-outof pn (:target ar)))) 1)))


(defmethod mutate-m :remove-arc [inv & args]
  (if-let [aid (:aid (random-arc (:pn inv) :subset #(filter (fn [ar] (and (= :normal (:type ar))
                                                                             (arc-not-sole (:pn inv) ar))) %)))]
    (as-> inv ?i
      (update ?i :history conj {:mutate :remove-arc :aid aid})
      (assoc-in ?i [:pn :arcs] (vec (remove #(= (:aid %) aid) (-> ?i :pn :arcs)))))
    {:skip :remove-arc :msg "No arc"}))

(defmethod mutate-m :remove-inhibitor [inv & args]
  (if-let [aid (:aid (random-arc (:pn inv) :subset #(filter (fn [ar] (and (= :inhibitor (:type ar))
                                                                          (arc-not-sole (:pn inv) ar))) %)))]
    (as-> inv ?i
      (update ?i :history conj {:mutate :remove-inhibitor :aid aid})
      (assoc-in ?i [:pn :arcs] (vec (remove #(= (:aid %) aid) (-> ?i :pn :arcs)))))
    {:skip :remove-inhibitor :msg "No inhibitor arcs"}))

;;;================================================================================
(defn swap-arcs [pn pl1 pl2]
  "Swap use of places pl1 and pl2 in the arcs of the PN."
  (assoc pn :arcs
         (vec (map (fn [ar]
                     (as-> ar ?ar
                       (cond (= (:source ?ar) pl1) (assoc ar :source pl2)
                             (= (:source ?ar) pl2) (assoc ar :source pl1)
                             :else ?ar)
                       (cond (= (:target ?ar) pl1) (assoc ar :target pl2)
                             (= (:target ?ar) pl2) (assoc ar :target pl1)
                             :else ?ar)))
                   (:arcs pn)))))

(defmethod mutate-m :swap-places-vv [inv & args]
  (if-let [pl1 (:name (random-place (:pn inv) :subset #(filter (fn [pl] (:visible? pl)) %)))]
    (if-let [pl2 (:name (random-place (:pn inv):subset #(filter (fn [pl] (and (:visible? pl)
                                                                              (not= (:name pl) pl1)))
                                                                %)))]
      (as-> inv ?i
        (update ?i :history conj {:mutate :swap-places-vv :pl1 pl1 :pl2 pl2})
        (assoc ?i :pn (swap-arcs (:pn ?i) pl1 pl2)))
      {:skip :swap-places-vv :msg "no 2nd place"})
    {:skip :swap-places-vv :msg "no 1st place"}))

(def +old-pop+ "diagnostic" (atom []))

(defn flow-balance
  "Compute the difference tokens-out minus tokens in."
  [pn trans]
  (- (reduce (fn [sum arc] (+ sum (:multiplicity arc)))
             0
             (pnu/arcs-outof pn trans))
     (reduce (fn [sum arc] (+ sum (:multiplicity arc)))
             0
             (remove #(= (:type %) :inhibitor) (pnu/arcs-into pn trans)))))

;;; POD This will need to be more sophisticated when there is colour.
;;; NB It matters on what arc you add tokens, but it doesn't matter on which you :elim them.
(defn random-intro
  "Define a 'random plan' (a map) to :intro CNT tokens to the outbound arcs of the trans."
  [pn trans cnt]
  (let [arcs (map :name (pnu/arcs-outof pn trans))
        narcs (count arcs)]
    (reduce (fn [tally _] (update-in tally [(nth arcs (rand-int narcs))] inc))
            (zipmap arcs (repeat narcs 0))
            (range cnt))))

(defn pick-from-atom!
  [atom]
  (let [picked (nth @atom (rand-int (count @atom)))]
    (swap! atom (fn [a] (remove #(= picked %) a)))
    picked))

(defn add-scada-report-fns [inv]
  "Randomly add SCADA report functions to transitions."
  (let [report-fn (fn [name] (fn [tkns] {:act name :tkns tkns}))
        events-left (atom (pr-param :scada-events))
        trans-left (atom (range (count (-> inv :pn :transitions))))]
    (reduce (fn [inv _]
              (update-in inv [:pn :transitions (pick-from-atom! trans-left)]
                         #(assoc % :fn (report-fn (pick-from-atom! events-left)))))
              inv
              (range (count (pr-param :scada-events))))))

;;; POD This (and one for trans and place) belong in pnu/
(defn arc-index
  "Return the index of the named arc in pn. (For use with assoc-in, update-in, etc."
  [pn name]
  (loop [n 0
         arcs (:arcs pn)]
    (if (= name (:name (first arcs)))
      n
      (recur (inc n) (next arcs)))))

(defn trans-index
  "Return the index of the named index in pn. (For use with assoc-in, update-in, etc."
  [pn name]
  (loop [n 0
         trans (:transitions pn)]
    (if (= name (:name (first trans)))
      n
      (recur (inc n) (next trans)))))

(defn add-color-binding [inv]
  "Add color binding to arcs. To address imbalance, add :elim acts and (randomly) add :intro acts."
    (assoc-in
     inv [:pn :arcs]
     (:arcs
      (reduce
       (fn [pn trans]
         (let [arcs (map :name (into (pnu/arcs-into pn trans) (pnu/arcs-outof pn trans)))
               diff (flow-balance pn trans)]
           (as-> pn ?pn
             (reduce (fn [pn arc] (assoc-in pn [:arcs (arc-index pn arc) :bind] {:jtype :blue})) ?pn arcs)
             (cond (< diff 0) ; if < 0, arbitrary (first) removes tkns.
                   (update-in ?pn [:arcs 0 :bind]
                              #(-> % (assoc :act :remove) (assoc :cnt (Math/abs diff))))
                   (> diff 0) ; add diff tokens somewhere randomly.
                   (let [intro-plan (random-intro ?pn trans diff)]
                     (reduce (fn [pn arc]
                               (update-in pn [:arcs (arc-index pn arc) :bind]
                                          #(-> % (assoc :act :intro) (assoc :cnt (arc intro-plan)))))
                             ?pn
                             (map :name (pnu/arcs-outof ?pn trans))))
                   :else ?pn))))
       (:pn inv)
       (map :name (-> inv :pn :transitions))))))

(defn initial-pop [problem pop-size eden-dist eden-mutation-cnt]
  (let [edens (eden-pns! problem)
        pop-cnt (atom -1)]
    (vec (repeatedly
          pop-size
          #(as-> (nth edens (rand-int (count edens))) ?inv
             (reduce (fn [inv _]
                       (mutate inv :force (rand-mute-key eden-dist)))
                     (map->Inv {:pn (:pn ?inv)
                                :id (swap! pop-cnt inc)
                                :history [(:id ?inv)]})
                     (range eden-mutation-cnt))
             (assoc-in ?inv [:pn :id] (:id ?inv))
             (add-scada-report-fns ?inv)
             (add-color-binding ?inv))))))

(defn i-error [inv patterns penalty]
  "Compute the individual's score."
  (let [id (:id inv)
        result (assoc inv
                      :err
                      (fit/workflow-fitness (:pn inv) patterns penalty))]
    result))

(defn sort-by-error
  "Add value for :err to each PN and used it to sort the population; best first."
  [popu patterns penalty]
  (as-> popu ?i
    (pmap #(i-error % patterns penalty) ?i) ; POD pmap
    (vec (sort #(< (:err %1) (:err %2)) ?i))))

;;; Finally, we'll define a function to select an individual from a sorted
;;; population using tournaments of a given size.
(defn select
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))

(defn reset-all! []
  (reset! pnr/+k-bounded+ (gp-param :pn-k-bounded))
  (reset! pnr/+max-rs+ (gp-param :pn-max-rs))
  (reset! pn/+max-states+ (gp-param :pn-max-states))
  (pnu/reset-ids! {})
  (reset! +log+ []))

(declare evolve validate-gp-params report-gen make-next-gen write-gen)

(defn evolve
  "Toplevel: Starting with a random population (create one if given just one arg), 
   sort, select, check for a solution and produce a new population."
  [problem]
  (reset-all!)
  (validate-gp-params nil) ; needs integration with system. 
  (println "Starting evolution...")
  (let [start-time (System/currentTimeMillis)]
    (loop [gen 0
           pop (-> problem initial-pop)]
      (as-> pop ?pop
        (sort-by-error ?pop (pr-param :scada-patterns) (pr-param :no-new-jobs-penalty)) ; runs the fitness function
        (update-pop! ?pop)
        (report-gen ?pop gen start-time)
        (cond (< (:err (first ?pop)) 0.1) ; good enough to count as success (POD :gp-param+)
              (do (println "Success!") (first ?pop)),
              (= gen (gp-param :max-gens))
              (do (println "Stopped at max-gen.") false)
              :else
              (recur
               (inc gen)
               (as-> ?pop ?p
                 ;;(vec (map (fn [inv] (update inv :pn #(dissoc % :avg-tokens-on-place))) ?p))
                 (make-next-gen ?p :gen gen))))))))

;;; Lee Spector's original were:
;;;   Basic eqn    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   Weather n    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   even parity  - 1/10 mutate  8/10 cross over, 1/10 untouched,  selection pressure 5
(defn make-next-gen [sorted-pop & {:keys [gen] :or {gen -1}}]
  "Compute the next generation, a combination of tournament selection, mutations and crossover
   of tournament winners, and elite individuals."
  (let [e-cnt (gp-param :elite-individuals)
        pop-size (gp-param :pop-size)
        pressure (gp-param :select-pressure)]
    ;;(write-gen sorted-pop gen)
    (as-> sorted-pop ?spop
      (into (subvec ?spop 0 e-cnt)
            (repeatedly (* 7/8 pop-size) #(mutate (select ?spop pressure))))
       ;;(repeatedly (* 2/8 (gp-param :pop-size)) #(crossover (select ?spop 7) (select ?spop 7)))
       (loop [pop ?spop]
         (if (>= (count pop) pop-size)
           (subvec (vec pop) 0 pop-size)
           (recur (conj pop (select sorted-pop pressure))))))))

(def report-data "A map of things to report to the GUI" (atom nil))
(declare server>gui-notify-new-gen)

(defn report-gen
  "Set the report-data atom to new data and notify the server"
  [pop gen start-time]
  (println "Gen=" gen)
  (let [best (first pop)]
    (server>gui-notify-new-gen
     (reset! report-data
             {:generation gen
              :pop-size (count pop)
              :total-mutations (reduce + 0 (map #(count (:history %)) pop))
              :elapsed-time (int (/ (- (System/currentTimeMillis) start-time) 1000))
              :best-error (:err best)
              :id-of-best (:id best)
              :median-error (:err (nth pop (int (/ (gp-param :pop-size) 2))))
              :average-pn-size (pnu/avg (map #(-> % :pn pnu/pn-size) pop))})))
  pop)

(defn validate-gp-params [params]
  #_(when (not (< 0.9999 (reduce + 0 (map second (:mutation-types params))) 1.0001))
    (throw (ex-info {:error ":mutation-types does not sum to 1."}))))

(defn eval-inv
  "Evaluate the PN all the way through to :avg-tokens-on-place vals."
  [inv]
  (assoc inv :pn
         (pn-ok-> (:pn inv)
                  pnr/renumber-pids
                  pnr/possible-live?
                  pnu/enter-and-exit-places?
                  pnu/enter-and-exit-trans?
                  pnr/reachability
                  pnr/live?
                  pn/Q-matrix
                  pn/steady-state-props
                  (dissoc :M2Mp :initial-marking :Q :steady-state))))

;;;==================== Diagnostics ========================================
;;; POD Problem with this in that it doesn't save :visible?
#_(defn read-a-pop []
  (reset! +pop+
          (map (fn [ix]
                 (as-> (pnml/read-pnml (str "data/pops/initial-" ix ".xml")) ?i
                   (map->Inv {:pn ?i :id ix :history []})
                   (eval-inv ?i)))
               (range 100))))

#_(defn write-a-pop
  "Return a population of the argument problem sorted by error.
   The best individual in this population is data/initial-1.xml."
  [problem]
  (let [pnum (atom 0)]
    (map #(pnml/write-pnml
           (:pn %)
           :file (str "data/junk/initial-" (:id %) ".xml")
           :positions (:geom problem))
         (reset! +pop+ (-> problem initial-pop sort-by-error)))))

#_(defn write-gen
  "Write a population as 'data/gen-<gen>/individual-n.xml'"
  [popu gen]
  (dotimes [n (count popu)]
    (let [filename (str "data/pops/gen-" gen "/individual-" (inc n) ".xml")]
      (clojure.java.io/make-parents filename)
      (pnml/write-pnml
       (nth popu n)
       :file filename
       :positions (pr-param :geom)))))

#_(defn diag-eval-pop
  "Return score and compute times for each individual in the population, updating +pop+."
  []
  (let [initial-start-time (System/currentTimeMillis)]
    (doseq [inv @+pop+]
      (let [start-time (System/currentTimeMillis)]
        (cl-format *out* "~%Individual ~A err: ~A time: ~A"
                   (:id inv)
                   (do (swap! +pop+ #(assoc % (:id inv) (-> inv eval-inv i-error)))
                       (if (:err inv) (cl-format nil "~8,3F" (:err inv)) "NA"))
                   (/ (- (System/currentTimeMillis) start-time) 1000.0))))
    (cl-format *out* "~%Complete execution time: ~A"
               (/ (- (System/currentTimeMillis) initial-start-time) 1000.0))))

;;;===================================================================================
;;;============================= Two machine 1 buffer spot ===========================
;;;===================================================================================

;;; Rates :m1 1.0, :m2 1.0  data/m2-inhib-bbs-balanced.xml
(def +m2-11+
  {:buffer     0.33333
   :m1-blocked 0.33333
   :m1-busy    0.66667
   :m2-busy    0.66667
   :m2-starved 0.33333})

;;; Rates :m1 1.4, :m2 0.89  data/m2-inhib-bbs.xml
(def +m2-1489+
  {:buffer     0.49023
   :m1-blocked 0.49023
   :m1-busy    0.50977
   :m2-busy    0.80188
   :m2-starved 0.19812})

;;; POD these are starvation values for :m2 on MJPdes/data/submodel-1.clj.
;;; Unlike LS's model, I don't have pairs of (x, f(x)). These are just f(x)
;;; for x = (and (feed-buffer-empty? <machine>) (not (busy? <machine>))).
#_(def +target-data+ ; Here is one of the values from data/submodel-1-out.clj.
  {:TP 0.8616667,
   :number-of-jobs 15510,
   :jobmix {:jobType1 {:w {:m1 1.0, :m2 1.0}, :portion 1.0}},
   :avg-buffer-occupancy {:b1 1.5226589467929488},
   :status nil,
   :runtime 12.36,
   :starved {:m1 0.0, :m2 0.03542190667446635},
   :observed-residence-time 4.046157396269706,
   :blocked {:m1 0.0, :m2 0.0},
   :bottleneck-machine :m1,
   :process-id 0})

#_(map->Model
 {:line
  {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})
   :b1 (map->Buffer {:N 3})
   :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
  :number-of-simulations 20
  :topology [:m1 :b1 :m2]
  :entry-point :m1
  :params {:warm-up-time 2000 :run-to-time 20000}
  :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 1.0, :m2 1.0}})}})

#_(def submodel-1
  (mjp/map->Model
   {:line
    {:m1 (mjp/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})
     :b1 (mjp/map->Buffer {:N 3})
     :m2 (mjp/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
    :number-of-simulations 1
    :topology [:m1 :b1 :m2]
    :entry-point :m1
    :params {:warm-up-time 2000 :run-to-time 20000} ; Was 20000 on training.
    :jobmix {:jobType1 (mjp/map->JobType {:portion 1.0 :w {:m1 1.0, :m2 1.0}})}}))

(defn print-inv [p writer]
  (.write writer (cl-format nil "#Inv [id=~S, err=~A]"
                            (:id p)
                            (if (number? (:err p))
                              (cl-format nil "~6,2F" (:err p))
                              :NA))))

(defmethod print-method Inv [p writer]
  (print-inv p writer))

(.addMethod clojure.pprint/simple-dispatch Inv (fn [p] (print-inv p *out*)))

;;;===========================================================
;;; Communication with the client
;;;===========================================================
(defn clean-pn-for-transmit [pn]
  "Sente can't send functions, at least."
  (as-> pn ?pn
    (update ?pn :transitions (fn [t] (vec (map #(dissoc % :fn) t))))))

(defn inv-geom
  "Compute reasonable display placement (:geom) for the argument individual."
  [inv]
  (let [from (-> inv :history first)
        elems (into (set (map :name (-> inv :pn :places))) (map :name (-> inv :pn :transitions)))]
    (assoc inv :pn
           (as-> (:pn inv) ?pn
             (assoc ?pn :geom (-> (some #(when (= (:id %) from) %) @+edens+) :pn :geom))
             (reduce (fn [pn ename]
                       (assoc-in pn [:geom ename]
                                 {:x (+ 15 (rand-int 100))
                                  :y (+ 15 (rand-int 100))
                                  :label-x-off 10
                                  :label-y-off 15}))
                     ?pn
                     (clojure.set/difference elems (set (keys (:geom ?pn)))))
             (pnml/rescale ?pn)))))

(ws/register-method
  :sinet/get-individual     
  (fn [{:as ev-msg :keys [?data ?reply-fn]}]
    (let [pop (-> (app-info) :pop)]
      (if (empty? pop)
        (log/info "No population in get-individual!")
        (let [pn-index  ?data]
          (println "get-individual: " pn-index)
          (when ?reply-fn
            (when (and (>= pn-index 0) (< pn-index (count pop)))
              (?reply-fn (-> (nth pop pn-index) inv-geom :pn clean-pn-for-transmit)))))))))

(ws/register-method
 :sinet/evolve
 (fn [ev-msg]
   (evolve (-> (app-info) :problem))))

(defn server>gui-notify-new-gen [report])
;;;(server>gui-push-inv (nth @+pop+ 1))
;;; POD So far, this one is just for debugging. 

#_(defn server>gui-notify-new-gen
  "Push Petri net (with its geometry) to the GUI."
  [report]
  (let [uids (ws-connection :connected-uids )] ; <===================================
    (if-let [uid (-> @uids :any first)]
      (ws/send! uid [:sinet/new-generation report])
      (log/info "notify-new-gen failed -- BTW using log/debug"))))

;;; POD should be start of component start. Useful for GUI.
;;; Not defonce
;(when (empty? @+pop+)
;  (reset! +pop+ (-> (app-info) :problem initial-pop sort-by-error)))

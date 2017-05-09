(ns gov.nist.sinet.core
  (:require [gov.nist.sinet.util.draw :as d]
            [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

;;; Purpose: This is a program to demonstrate ideas in system identification of
;;; discrete event systems using genetic programming.

;;; I started with Lee Spector's "gp" demonstration software.

;;; ToDo: - DONE: Get data for exponential jobs, BBS.
;;;       ===> I think it makes more sense to perform 5-10 mutations on edens THEN test them.
;;;       ===> Make sure I'm not promoting non-mutated individuals when they fail mutation.
;;;       ===> Normalize the error calculation.
;;;       ===> Create/save a zero population. Read it in to start.
;;;       - Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - Implement a log for exceptional situations.
;;;       - DONE (enough): Probably need more than one Eden individual for diversity (backwards, multi-loops etc).
;;;       - Maybe I shouldn't care about absorbing states?

(defrecord Inv [pn id error history])
(def +diag+ (atom nil))
(def +log+ (atom []))
(defn log [msg] (swap! +log+ conj msg))
(declare +problem+)

;;;  DOCUMENTATION REQUIREMENT: Determine what among the +gp-params+ matters.
;;; :pn-elements -- The PN elements that can appear in individuals.
;;; :initial-individuals -- percentage of each element type.
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")
(def +gp-params+
  "Genetic programming algorithm parameters: they control important aspects of the solution."
  {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
   :pop-size 100
   :max-gens 40
   :debugging? true
   :pn-k-bounded  10      ; When to give up on computing the reachability graph.
   :pn-max-rs     1000
   :crossover-to-mutation-ratio 0.5
   :select-pressure 3 ; not normalized to pop-size
   :elite-individuals 0
   :crossover-keeps-parents? true ; NYI
   :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
   :mutation-dist ; The pdf for ordinary mutations (not eden mutations)
   [[:add-place        2/10]    ; Add place (mine can't be absorbing, thus Nobile 1&2).
    [:add-token        2/10]    ; Add token to some place (visible or hidden).
    [:add-trans        2/10]    ; Add transition, connecting to input and output places.
    [:add-arc          2/10]
    [:add-inhibitor    2/10]    ; Add inhibitor arc, connecting a place to a trans
    [:remove-place     1/10]
    [:remove-token     1/10]
    [:remove-trans     1/10]
    [:remove-arc       1/10]
    [:remove-inhibitor 1/10]
    [:swap-places-vv   2/10]]
   :eden-dist ; for creation of eden individual, which are already rather sparse
   [[:add-place        2/10]
    [:add-token        2/10]
    [:add-trans        2/10]
    [:add-arc          2/10]
    [:add-inhibitor    2/10]
    [:swap-places-vv   2/10]]})

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
                         (:transitions ?pn))))))))

(defn eden-pns
  [problem]
  (list
   (eden-individual problem)
   (eden-individual (update problem :visible-places reverse))))

(defn random-crossover [] )

(defn rand-mute-key
  "Return a keyword designating a mutation function."
  ([] (rand-mute-key (:mutation-dist +gp-params+)))
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

(def +zippy+ (atom nil))

(defn- mutate-m-dispatch [inv & {:keys [pick-fn force]
                                :or {pick-fn rand-mute-key}}]
  (let [answer (or force (pick-fn))]
    (when-not (pnu/pn? (:pn inv))
      (pnu/break "last mutation failed."))
    ;(println "answer =" answer)
    (reset! +zippy+ answer)
    answer))

(defmulti mutate-m #'mutate-m-dispatch)

(defn- crossover-m-dispatch [inv & {:keys [force pick-fn]
                                    :or {pick-fn random-crossover}}]
  (let [answer (or force (pick-fn))]
    (reset! +zippy+ answer)
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
   transition or place for which there isn't at least one "
  [pn ar]
  (let [pn (assoc pn :arcs (vec (remove #(= (:aid %) (:aid ar) (:arcs pn)))))]
    (and (pnu/enter-and-exit-trans? pn)
         (pnu/enter-and-exit-places? pn))))

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
(def +pop+ "diagnostic" (atom nil))

(defn initial-pop [problem]
  (let [edens (eden-pns problem)
        pop-cnt (atom -1)]
    (reset! +pop+
            (vec (repeatedly
                  (:pop-size +gp-params+)
                  #(reduce (fn [i _] (mutate i :force (rand-mute-key (:eden-dist +gp-params+))))
                           (map->Inv {:pn (nth edens (rand-int (count edens)))
                                      :id (swap! pop-cnt inc)
                                      :history []})
                           (range 5)))))))


;;; POD -- really should normalize values!
(defn i-error [inv]
  "Compute system error using PNs steady-state properties."
  (reset! +diag+ inv)
  (let [pn (:pn inv)]
    (cond-> inv
        true (assoc :err 9999999.9),
        (:avg-tokens-on-place pn)
        (assoc :err
               (reduce (fn [sum [pname pval]]
                         (+ sum (abs (- pval (-> pn :avg-tokens-on-place pname)))))
                       0.0
                       (:data-source +problem+))))))

(defn sort-by-error
  "Add value for :err to each PN and used it to sort the population; best first."
  [popu]
  (as-> popu ?p
    (map i-error ?p)
    (sort #(< (:err %1) (:err %2)) ?p)))

;;; Finally, we'll define a function to select an individual from a sorted
;;; population using tournaments of a given size.
(defn select
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))

(defn reset-all! []
  (reset! pnr/+k-bounded+ (:pn-k-bounded +gp-params+))
  (reset! pnr/+max-rs+ (:pn-max-rs +gp-params+))
  (reset! pn/+max-states+ (:pn-max-states +gp-params+))
  (pnu/reset-ids! {})
  (reset! +log+ []))

(declare validate-gp-params report-gen make-next-gen write-gen)

(defn evolve
  "Starting with a random population, sort, select, check for a solution and
   produce a new population."
  ([problem] (evolve problem (-> problem initial-pop)))
  ([problem popu]
   (reset-all!)
   (validate-gp-params +gp-params+)
   (println "Starting evolution...")
   (let [start-time (System/currentTimeMillis)]
     (loop [gen 0
            popu (sort-by-error popu)]
       (reset! +diag+ popu)
       (let [best (first popu)]
         (report-gen gen popu start-time)
         (cond (< (:err best) 0.1) ; good enough to count as success
               (do (println "Success!") best)
               (= gen (:max-gens +gp-params+))
               (do (println "Stopped at max-gen.") false)
               :else
               (recur
                (inc gen)
                (as-> popu ?p
                  (map (fn [inv] (update inv :pn #(dissoc % :avg-tokens-on-place))) ?p)
                  (make-next-gen ?p :gen gen)
                  (reset! +pop+ ?p)))))))))

(defn report-gen
  [gen popu start-time]
  (let [best (first popu)]
    (println "======================")
    (println "Generation:" gen)
    (println "Population size:" (count popu))
    (println "Total mutations:" (reduce + 0 (map #(count (:history %)) popu)))
    (println "Failed individuals:" (count (filter identity (map #(contains? % :failure) popu))))
    (println "Elapsed time (secs):" (int (/ (- (System/currentTimeMillis) start-time) 1000)))
    (println "Best error:" (:err best))
    (println "ID of best:" (:id best))
    (println "     Median error:" (:err (nth popu (int (/ (:pop-size +gp-params+) 2)))))
    (println "     Average PN size:" (pnu/avg (map #(-> % :pn pnu/pn-size) popu)))))

(defn make-next-gen [population & {:keys [gen] :or {gen -1}}]
  "Compute the next generation, a combination of tournament selection, mutations and crossover
   of tournament winners, and elite individuals."
  (let [popsize (count population)
        e-cnt (:elite-individuals +gp-params+)
        sorted-pop (sort-by-error population)]
    (write-gen sorted-pop gen)
    (as-> (vec sorted-pop) ?spop
      (concat
       (if e-cnt (subvec ?spop 0 (inc e-cnt)) [])
       (repeatedly (* 7/8 popsize) #(mutate (select ?spop (:select-pressure +gp-params+))))
       ;(repeatedly (* 2/8 popsize) #(crossover (select ?spop 7) (select ?spop 7)))
       (repeatedly (* 1/8 popsize) #(select sorted-pop (:select-pressure +gp-params+))))
      (if e-cnt
        (subvec (vec ?spop) 0 (- (:pop-size +gp-params+) e-cnt))
        ?spop))))

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
(defn debug-initial-pop []
  (reset-all!)
  (reset! +pop+ (initial-pop +problem+))
  true)

;;; POD Problem with this in that it doesn't save :visible?
(defn read-a-pop []
  (reset! +pop+
          (map (fn [ix]
                 (as-> (pnml/read-pnml (str "data/pops/initial-" ix ".xml")) ?i
                   (map->Inv {:pn ?i :id ix :history []})
                   (eval-inv ?i)))
               (range 100))))

(defn write-a-pop
  "Return a population of the argument problem sorted by error.
   The best individual in this population is data/initial-1.xml."
  [problem]
  (let [pnum (atom 0)]
    (map #(pnml/write-pnml
           (:pn %)
           :file (str "data/junk/initial-" (:id %) ".xml")
           :positions (:pn-graph-positions problem))
         (reset! +pop+ (-> problem initial-pop sort-by-error)))))

(defn write-gen
  "Write a population as 'data/gen-<gen>/individual-n.xml'"
  [popu gen]
  (dotimes [n (count popu)]
    (let [filename (str "data/pops/gen-" gen "/individual-" (inc n) ".xml")]
      (clojure.java.io/make-parents filename)
      (pnml/write-pnml
       (nth popu n)
       :file filename
       :positions (:pn-graph-positions +problem+)))))

(defn diag-eval-pop
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

(def +problem+
  {:visible-places [:m1-blocked :m1-busy :m2-busy :m2-starved :buffer]
   :pn-graph-positions (pnml/positions-from-file "data/pops/initial-positions.xml")
   :visible-transitions [:m1-finished :m2-finished]
   :data-source +m2-11+}) ; POD not yet dynamic, of course.


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
  (.write writer (cl-format nil "#Inv [id=~A, err=~A]"
                            (:id p)
                            (if (number? (:err p))
                              (cl-format nil "~6,2F" (:err p))
                              :NA))))

(defmethod print-method Inv [p writer]
  (print-inv p writer))

(.addMethod clojure.pprint/simple-dispatch Inv (fn [p] (print-inv p *out*)))

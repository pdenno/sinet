(ns gov.nist.sinet
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.matrix :as m :refer (zero-matrix)] ; POD temporary
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

;;; Purpose: This is a program to demonstrate ideas in system identification of 
;;; discrete event systems using genetic programming.

;;; I started with Lee Spector's "gp" demonstration software.

;;; ToDo: - DONE: Get data for exponential jobs, BBS.
;;;       ===> Make sure I'm not promoting non-mutated individuals when they fail mutation.
;;;       ===> Normalize the error calculation.
;;;       ===> Create/save a zero population. Read it in to start.
;;;       - Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - Implement a log for exceptional situations. 
;;;       - DONE (enough): Probably need more than one Eden individual for diversity (backwards, multi-loops etc).
;;;       - Maybe I shouldn't care about absorbing states?
(defrecord Inv [pn id error])

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
   :max-generations 40
   :debugging? true
   :pn-k-bounded  10      ; When to give up on computing the reachability graph.
   :pn-max-rs     2200
   :pn-max-states 1000
   :crossover-to-mutation-ratio 0.5
   :selection-pressure 3 ; not normalized to pop-size
   :elite-individuals 0
   :crossover-keeps-parents? true ; NYI
   :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
   :mutation-types       
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
      (assoc ?pn :history [])
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

(defn eden-individuals
  [problem]
  (list
   (eden-individual problem)
   (eden-individual (update problem :visible-places reverse))))

(defn random-crossover [] )

(defn random-mutation
  "Return a keyword designating a mutation function."
  []
  (let [mtypes (:mutation-types +gp-params+)
        r (rand (reduce (fn [sum p] (+ sum (second p))) 0 mtypes))]
    (loop [types mtypes
           sum (second (first (:mutation-types +gp-params+)))]
      (let [[mtype percent] (first types)]
        (if (> sum r)
          (first (first types))
          (recur (rest types)
                 (+ sum (second (second types)))))))))

(defn eden-mutation
  "Return a keyword designating a mutation function for 
   creating the eden individuals"
  []
  (let [add-pairs (remove #(re-matches #"^remove.*" (name (first %)))
                          (:mutation-types +gp-params+))
        r (rand (reduce (fn [sum p] (+ sum (second p))) 0 add-pairs))]
    (loop [types add-pairs
           sum (second (first add-pairs))]
      (let [[mtype percent] (first types)]
        (if (> sum r)
          (first (first types))
          (recur (rest types)
                 (+ sum (second (second types)))))))))

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

(declare mutate-m reset-all! reach-pn)

;;; POD This could eliminate a good individual. Needs thought. 
(defn mutate
  "Wrap the mutation process (mutate-m) through to reachability.
    Where no mutation is possible, log why and try again."
  ([pn] (mutate pn random-mutation 0))
  ([pn distrib cnt]
   (if (> cnt 5)
     (assoc pn :failure {:error :mutate :reason "exceed tries"})
     (let [pnp (mutate-m pn :distribution distrib)
           m-pn (if (pnu/pn? pnp) pnp (do (log pnp) (mutate pn distrib 0))) ; fails if mutation didn't work. 
           r-pn (reach-pn m-pn)]                                            
       (if (contains? r-pn :failure) ; fails if reachability not good. 
         (mutate pn distrib (inc cnt)) 
         r-pn)))))

(def +zippy+ (atom nil))

(defn- mutate-m-dispatch [pn & {:keys [force distribution]
                                :or {distribution random-mutation}}]
  (let [answer (or force (distribution))]
    (reset! +zippy+ answer)
    answer))

(defmulti mutate-m #'mutate-m-dispatch)

(defn- crossover-m-dispatch [pn & {:keys [force distribution]
                                   :or {distribution random-crossover}}]
  (let [answer (or force (distribution))]
    (reset! +zippy+ answer)
    answer))

(defmulti crossover-m #'crossover-m-dispatch)

(defn crossover [pn1 pn2]
  (let [[pnp1 pnp2] (crossover-m pn1 pn1)]
    (if (and (pnu/pn? pnp1) (pnu/pn? pnp2))
      [pnp1 pnp2]
      (crossover pn1 pn2))))

;;;=================== Add =======================================
(defmethod mutate-m :add-place [pn & args]
  (let [trans-in (:name (random-trans pn))
        trans-out (:name (random-trans pn))]
    (as-> pn ?pn
      (pnu/add-pn ?pn (pnu/make-place ?pn))
      (update ?pn :history conj {:mutate :add-place :place (:name (last (:places ?pn)))})
      (let [p (:name (last (:places ?pn)))]
        (as-> ?pn ?pnn
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn trans-in p))
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn p trans-out)))))))

(defmethod mutate-m :add-token [pn & args]
  (let [p-indx (rand-int (count (:places pn)))]
    (as-> pn ?pn
      (update ?pn :history conj {:mutate :add-token :place (:name (nth (:places ?pn) p-indx))})
      (update-in ?pn [:places p-indx :initial-tokens] inc))))
  
(defmethod mutate-m :add-trans [pn & args]
  (if-let [p-in (:name (random-place pn))]
    (if-let [p-out (:name (random-place pn :subset #(remove (fn [pl] (= (:name pl) p-in)) %)))]
      (as-> pn ?pn
        (pnu/add-pn ?pn (pnu/make-transition
                         pn ; POD choice of :exponential/:immediate here is temporary
                         :type (if (= 0 (rand-int 2)) :exponential :immediate)))
        (let [t (:name (last (:transitions ?pn)))]
          (as-> ?pn ?pnn
            (update ?pnn :history conj {:mutate :add-trans :trans t})
            (pnu/add-pn ?pnn (pnu/make-arc ?pnn p-in t))
            (pnu/add-pn ?pnn (pnu/make-arc ?pnn t p-out)))))
      {:skip :add-trans :msg "no p-out"})
    {:skip :add-trans :msg "no p-in"}))

(defmethod mutate-m :add-arc [pn & args]
  (if-let [trans (random-trans pn)]
    (if-let [place (random-place pn)]
      (let [[from to] (case (rand-int 2) 0 (vector trans place) 1 (vector trans place))]
        (as-> pn ?pn
          (update ?pn :history conj {:mutate :add-arc :place place})
          (pnu/add-pn pn (pnu/make-arc pn (:name from) (:name to)))))
        {:skip :add-arc :msg "No visible place"})
      {:skip :add-arc :msg "No trans"}))

(defmethod mutate-m :add-inhibitor [pn & args]
  (if-let [trans (random-trans pn)]
    (if-let [place (random-place pn)]
      (as-> pn ?pn
        (update ?pn :history conj {:mutate :add-inhibitor :place place})
        (pnu/add-pn pn (pnu/make-arc pn (:name place) (:name trans) :type :inhibitor)))
      {:skip :add-inhibitor :msg "No visible place"})
    {:skip :add-inhibitor :msg "No trans"}))

;;;=================== Remove =======================================
(defmethod mutate-m :remove-place [pn & args]
  (let [place (:name (random-place pn :subset #(remove (fn [pl] (:visible? pl)) %)))]
    (as-> pn ?pn
      (update ?pn :history conj {:mutate :remove-place :place place})
      (assoc ?pn :places (vec (remove #(= (:name %) place) (:places ?pn))))
      (assoc ?pn :arcs (vec (remove #(or (= (:source %) place) (= (:target %) place)) (:arcs ?pn)))))))

(defmethod mutate-m :remove-token [pn & args]
  (if-let [p (:name (random-place pn :subset #(remove (fn [pl] (= 0 (:initial-tokens pl))) %)))]
    (-> pn
        (update :history conj {:mutate :remove-token :place p})
        (assoc  :places (vec (map #(if (= (:name %) p)
                                     (update % :initial-tokens dec)
                                     %)
                                  (:places pn)))))
    {:skip :remove-token :msg "No place with token"}))

(defmethod mutate-m :remove-trans [pn & args]
  (let [trans (:name (random-trans pn :subset #(remove (fn [pl] (:visible? pl)) %)))]
    (as-> pn ?pn
      (update ?pn :history conj {:mutate :remove-trans :trans trans})
      (assoc ?pn :trans (vec (remove #(= (:name %) trans) (:transitions ?pn))))
      (assoc ?pn :arcs (vec (remove #(or (= (:source %) trans) (= (:target %) trans)) (:arcs ?pn)))))))

(defmethod mutate-m :remove-arc [pn & args]
  (if-let [arc-id (:aid (random-arc pn :subset #(remove (fn [ar] (= :normal (:type ar))) %)))]
    (as-> pn ?pn
      (update ?pn :history conj {:mutate :remove-arc :arc-id arc-id})
      (assoc ?pn :arcs (vec (remove #(= (:aid %) arc-id) (:arcs pn)))))
    {:skip :remove-arc :msg "No arc"}))

(defmethod mutate-m :remove-inhibitor [pn & args]
  (if-let [arc-id (:aid (random-arc pn :subset #(remove (fn [ar] (= :inhibitor (:type ar))) %)))]
    (as-> pn ?pn
      (update ?pn :history conj {:mutate :remove-inhibitor :arc-id arc-id})
      (assoc ?pn :arcs (vec (remove #(= (:aid %) arc-id) (:arcs ?pn)))))
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
  
(defmethod mutate-m :swap-places-vv [pn & args]
  (if-let [pl1 (:name (random-place pn :subset #(filter (fn [pl] (:visible? pl)) %)))]
    (if-let [pl2 (:name (random-place pn :subset #(filter (fn [pl] (and (:visible? pl)
                                                                        (not= (:name pl) pl1)))
                                                          %)))]
      (swap-arcs pn pl1 pl2)
      {:skip :swap-places-vv :msg "no 2nd place"})
    {:skip :swap-places-vv :msg "no 1st place"}))

(def +old-pop+ "diagnostic" (atom []))
(def +pop+ "diagnostic" (atom nil))

(defn initial-pop [problem]
  (let [edens (eden-individuals problem)
        fresh-eden (fn [] (nth edens (rand-int (count edens))))
        start-time (System/currentTimeMillis)]
    (reset! +old-pop+ [])
    (loop [pop [],
           indv (fresh-eden),
           mute-cnt 0,
           try 0]
      (when (and (:debugging? +gp-params+) (> (count pop) (count @+old-pop+)))
        (swap! +old-pop+ conj (last pop))
        (println "\nPopulation count:" (count pop))
        (println "Individual-size (M2Mp):" (count (:M2Mp (last pop))))
        (println "Time:" (int (/ (- (System/currentTimeMillis) start-time) 1000))))
      (cond (> try 2000) (throw (ex-info "initial-pop tries" {:individual-cnt (count pop)})),
            (>= (count pop) (:pop-size +gp-params+)) pop,
            :else (let [m-indv (-> indv #_crossover (mutate eden-mutation 0))]
                    (cond (:failure m-indv)
                          (do (log {:mutate-fails :initial-pop :method (last (:history m-indv))})
                              (if (< mute-cnt 2) ; POD 2 should be a +gp-params+
                                (recur pop (fresh-eden) 0 (inc try)) ; start over
                                (recur (conj pop indv) (fresh-eden) 0 (inc try)))) ; last one is good enough
                          (= (:initial-mutations +gp-params+) mute-cnt) ; complete success
                          (recur (conj pop m-indv) (fresh-eden) 0 (inc try))
                          :else ; continue mutating
                          (recur pop m-indv (inc mute-cnt) (inc try))))))))

(defn debug-initial-pop []
  (reset-all!)
  (reset! +pop+ (initial-pop +problem+))
  true)

;;; POD -- really should normalize values!
(defn i-error [ind]
  "Compute the steady-state properties of the individual and from those, compute its error."
  (let [pn (pn-ok->
            ind ; reachability analysis has already been performed. 
            pn/Q-matrix
            pn/steady-state-props
            (dissoc :steady-state))]
    (if (:failure pn)
      (assoc pn :error 999999999.9)
      (let [results (:avg-tokens-on-place pn)]
        (assoc pn :error
               (reduce (fn [sum [pname pval]] (+ sum (abs (- pval (pname results)))))
                       0.0
                       (:data-source +problem+)))))))
              
(defn sort-by-error
  "Add value for :error to each PN and used it to sort the population; best first." 
  [population]
  (as-> population ?p
    (map i-error ?p)
    (sort #(< (:error %1) (:error %2)) ?p)))

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

(declare validate-gp-params next-generation write-generation)

(defn evolve
  "Starting with a random population, sort, select, check for a solution and 
   produce a new population."
  ([problem] (evolve problem (-> problem initial-pop)))
  ([problem population]
   (reset-all!)
   (validate-gp-params +gp-params+)
   (println "Starting evolution...")
   (let [start-time (System/currentTimeMillis)]
     (loop [generation 0
            population (sort-by-error population)]
       (reset! +diag+ population)
       (let [best (first population)]
         (println "======================")
         (println "Generation:" generation)
         (println "Population size:" (count population))
         (println "Total mutations:" (reduce + 0 (map #(count (:history %)) population)))
         (println "Failed individuals:" (count (filter identity (map #(contains? % :failure) population))))
         (println "Elapsed time (secs):" (int (/ (- (System/currentTimeMillis) start-time) 1000)))
         (println "Best error:" (:error best))
         (println "ID of best:" (:pn-id best))
         (println "     Median error:" (:error (nth population (int (/ (:pop-size +gp-params+) 2)))))
         (println "     Average PN size:" (pnu/avg (map pnu/pn-size population)))
         (cond (< (:error best) 0.1) ; good enough to count as success
               (do (println "Success!") best)
               (= generation (:max-generations +gp-params+))
               (do (println "Stopped at max-generation.") false)
               :else
               (recur 
                (inc generation)
                (as-> population ?p
                  (map #(dissoc % :M2Mp :initial-marking :Q :steady-state :avg-tokens-on-place) ?p)
                  (next-generation ?p :gen generation)
                  (reset! +pop+ ?p)))))))))

(defn next-generation [population & {:keys [gen] :or {gen -1}}]
  "Compute the next generation, a combination of tournament selection, mutations and crossover
   of tournament winners, and elite individuals."
  (let [popsize (count population)
        e-cnt (:elite-individuals +gp-params+)
        sorted-pop (sort-by-error population)]
    (write-generation sorted-pop gen)
    (as-> (vec sorted-pop) ?spop
      (concat 
       (if e-cnt (subvec ?spop 0 (inc e-cnt)) [])
       (repeatedly (* 7/8 popsize) #(mutate (select ?spop (:selection-pressure +gp-params+))))
       ;(repeatedly (* 2/8 popsize) #(crossover (select ?spop 7) (select ?spop 7)))
       (repeatedly (* 1/8 popsize) #(select sorted-pop (:selection-pressure +gp-params+))))
      (if e-cnt
        (subvec (vec ?spop) 0 (- (:pop-size +gp-params+) e-cnt))
        ?spop))))

(defn validate-gp-params [params]
  #_(when (not (< 0.9999 (reduce + 0 (map second (:mutation-types params))) 1.0001))
    (throw (ex-info {:error ":mutation-types does not sum to 1."}))))

(defn reach-pn
  "Returns the argument pn with reachability calculated or false if that couldn't be done."
  ([pn]
   (pn-ok-> pn
            pnr/renumber-pids
            pnr/possible-live?
            pnu/enter-and-exit-places?
            pnu/enter-and-exit-trans?
            pnr/reachability
            pnr/live?)))

;;;==================== Diagnostics ========================================
(defn read-a-pop []
  (reset! +pop+
          (map (fn [ix]
                 (-> (pnml/read-pnml (str "data/pops/initial-" ix ".xml"))
                     (assoc :pn-id ix)))
               (range 1 101)))
  true)

(defn write-a-pop
  "Return a population of the argument problem sorted by error. 
   The best individual in this population is data/initial-1.xml."
  [problem]
  (let [pnum (atom 0)]
    (map #(pnml/write-pnml
           %
           :file (str "data/pops/initial-" (swap! pnum inc) ".xml")
           :positions (:pn-graph-positions problem))
         (reset! +pop+ (-> problem initial-pop sort-by-error)))))

(defn write-generation 
  "Write a population as 'data/gen-<gen>/individual-n.xml'"
  [popu gen]
  (dotimes [n (count popu)]
    (let [filename (str "data/pops/gen-" gen "/individual-" (inc n) ".xml")]
      (clojure.java.io/make-parents filename)
      (pnml/write-pnml
       (nth popu n)
       :file filename
       :positions (:pn-graph-positions +problem+)))))

;;; Diagnostic - Because in use of evolve, also check liveness, absorbing befoer
;;;              going into Q-matrix. 
(defn pn2error
  "Calculate the error for the given PN."
  [pn]
  (-> pn
      pnr/reachability
      i-error
      :error))

(defn diag-eval-pop
  "Return score and compute times for each individual in the population."
  []
  (for [pn @+pop+]
    (let [start-time (System/currentTimeMillis)]
      (cl-format *out* "~%Individual ~A error: ~8,3F time: ~A"
                 (:pn-id pn)
                 (pn2error pn)
                 (/ (- (System/currentTimeMillis) start-time) 1000.0)))))

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
  (.write writer (cl-format nil "#Inv [id= ~A, error=~A]"
                            (:id p)
                            (if (number? (:error p))
                              (cl-format nil "~6,2F" (:error p))
                              :not-set))))
                                    
(defmethod print-method Inv [p writer]
  (print-inv p writer))

(.addMethod clojure.pprint/simple-dispatch Inv (fn [p] (print-inv p *out*)))




   
  

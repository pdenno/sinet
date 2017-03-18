(ns gov.nist.sinet
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.memoize :as m]
            [gov.nist.spntools.core :as pn]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

;;; Purpose:This is a program to demonstrate ideas in system identification of 
;;; discrete event systems using genetic programming.

;;; I started with Lee Spector's "gp" demonstration software...

;;; ToDo: - DONE: Get data for exponential jobs, BBS.
;;;       - Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - Implement a log for exceptional situations. 
;;;       - Probably need more than one Eden individual for diversity (backwards, multi-loops etc). 

(def +diag+ (atom nil))
(def +log+ (atom []))
(defn log [msg] (swap! +log+ conj msg))

;;;  DOCUMENTATION REQUIREMENT: Determine what among the +gp-params+ matters.
;;; :pn-elements -- The PN elements that can appear in individuals.
;;; :initial-individuals -- percentage of each element type.
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")
(def +gp-params+
  "Genetic programming algorithm parameters: they control important aspects of the solution."
  {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans :immediate-trans :fixed-trans]
   :population-size 100
   :crossover-to-mutation-ratio 0.5
   :elite-individuals 0.02
   :crossover-keeps-parents? true
   :initial-mutations 10 ; number of times to mutate eden individuals to create first generation.
;;;  until it is ergodic (implies k-bounded and live, I think) and has no absorbing states.
   :mutation-types        ; These aren't much like Nobile because I need ergodic nets, they don't. Nobile doesn't do deletes either.
   [[:add-place     0.2]    ; Add place (mine can't be absorbing, thus 1&2).  
    [:add-trans-vv  0.1]    ; Add transition, connecting to visible input and output places. 
    [:add-trans-hh  0.1]    ; Add transition, connecting hidden input place to hidden output place.
    [:add-trans-vh  0.1]    ; Add transition, connecting visible input place to hidden output place.
    [:add-trans-hv  0.1]    ; Add transition, connecting hidden input place to visible output place.
    [:add-inhibit-v 0.1]    ; Add inhibitor arc, connecting a visible place to a trans
    [:add-inhibit-h 0.1]    ; Add inhibitor arc, connecting a visible place to a trans
    [:add-token     0.1]    ; Add token to some place (visible or hidden).
    [:remove-token  0.1]]}) ; Remove token from some place (visible or hidden).

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

(defn eden-individuals
  [problem]
  (list
   (eden-individual problem)
   (eden-individual (update problem :visible-places reverse))))

(defn eden-individual
  "Return the minimal and prototypical individual for the problem.
   It is a loop made by using visible places and transitions with additional 
   hidden places and transitions necessary to close the loop. It isn't
   random but rather it is constant for the problem definition."
  [problem]
  (let [prob (add-extra-nodes problem)]
    (as-> {:places [] :transitions [] :arcs []} ?pn
      (reduce (fn [pn pl] (pnu/add-pn pn (pnu/make-place pn :name pl))) ?pn (:p prob))
      (update-in ?pn [:places 0 :initial-marking] inc) ; Add a token to make it alive
      (reduce (fn [pn tr] (pnu/add-pn pn (pnu/make-transition pn :name tr))) ?pn (:t prob))
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
               (vec (map #(if (contains? (:t-adds prob) (:name %)) (dissoc % :visible?) %)
                         (:transitions ?pn))))))))

;;; POD why keywords? (does get you the :force)
(defn random-mutation
  "Return a keyword designating a mutation function."
  []
  (let [r (rand)]
    (loop [types (:mutation-types +gp-params+)
           sum (second (first (:mutation-types +gp-params+)))]
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
  (reset! +diag+ (list pn  subset))
  (let [places (subset (:places pn))]
    (when (not-empty places)
      (nth places (rand-int (count places))))))

(declare mutate-m)
(defn mutate
  "Wrap the mutation process (mutate-m). Where no mutation is possible, 
   log why and return the argument."
  [pn]
  (let [pnp (mutate-m pn)]
    (if (pnu/pn? pnp)
      pnp
      (do (println pnp)
          (log pnp)
          pn))))

(def +zippy+ (atom nil))

(defn- mutate-m-dispatch [pn & {:keys [force]}]
  (let [answer (or force (random-mutation))] ; return a keyword
    (reset! +zippy+ answer)
    answer))

(defmulti mutate-m #'mutate-m-dispatch)

;;; Add a (hidden) place to the Petri net."
(defmethod mutate-m :add-place [pn & args]
  (let [trans-in (:name (random-trans pn))
        trans-out (:name (random-trans pn))]
    (as-> pn ?pn
      (pnu/add-pn ?pn (pnu/make-place ?pn))
      (let [p (:name (last (:places ?pn)))]
        (as-> ?pn ?pnn
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn trans-in p))
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn p trans-out)))))))

;;; Add a (hidden) transition between two places according to visibility tests.
(defmacro various-trans-mutate
  [name test1 test2]
  `(defmethod mutate-m ~name [pn# & args#]
     (if-let [p-in#  (:name (random-place pn# :subset ~test1))]
       (if-let [p-out# (:name (random-place pn# :subset ~test2))]
         (as-> pn# ?pn#
           (pnu/add-pn ?pn# (pnu/make-transition pn#))
           (let [t# (:name (last (:transitions ?pn#)))]
             (as-> ?pn# ?pnn#
               (pnu/add-pn ?pnn# (pnu/make-arc ?pnn# p-in# t#))
               (pnu/add-pn ?pnn# (pnu/make-arc ?pnn# t# p-out#)))))
         {:error ~name :msg "no p-out"})
       {:error ~name :msg "no p-in"})))

;;; POD: This will remain a waste of time if the distribution of these remains equal.
(various-trans-mutate :add-trans-vv #(filter :visible? %) #(filter :visible? %))
(various-trans-mutate :add-trans-hh #(remove :visible? %) #(remove :visible? %))
(various-trans-mutate :add-trans-vh #(filter :visible? %) #(remove :visible? %))
(various-trans-mutate :add-trans-hv #(remove :visible? %) #(filter :visible? %))

;;; Doesn't care whether the transition is visible or hidden
(defmethod mutate-m :add-inhibit-v [pn & args]
  (if-let [trans (random-trans pn)]
    (if-let [place (random-place pn :subset #(filter :visible? %))]
      (pnu/add-pn pn (pnu/make-arc pn (:name trans) (:name place) :type :inhibitor))
      {:error :add-inhibit-v :msg "No visible place"})
    {:error :add-inhibit-v :msg "No trans"}))

(defmethod mutate-m :add-inhibit-h [pn & args]
  (if-let [trans (random-trans pn)]
    (if-let [place (random-place pn :subset #(remove :visible? %))]
      (pnu/add-pn pn (pnu/make-arc pn (:name trans) (:name place) :type :inhibitor))
      {:error :add-inhibit-h :msg "no hidden place"})
    {:error :add-inhibit-h :msg "no trans"}))
  
(defmethod mutate-m :add-token [pn & args]
  (update-in pn [:places (rand-int (count (:places pn))) :initial-marking] inc))
  
(defmethod mutate-m :remove-token [pn & args]
  (if-let [p (:name (random-place pn :subset #(remove (fn [pl] (= 0 (:initial-marking pl))) %)))]
    (assoc pn :places (vec (map #(if (= (:name %) p)
                                   (update % :initial-marking dec)
                                   %)
                                (:places pn))))
    {:error :remove-token :msg "No place with token"}))

(defn crossover
  [pn1 pn2]
  pn1) ; NYI

(defn initial-pop [problem]
  (let [edens (eden-individuals problem)]
    (repeatedly  (:population-size +gp-params+)
                 #(reduce (fn [pn _] (mutate pn))
                          (nth edens (rand-int (count edens)))
                          (range 10)))))

(defn i-error [ind]
  :nyi)

;; We'll also want a way to sort a population by i-error that doesn't require 
;; lots of i-error re-computation:
(defn sort-by-error
  [population]
  (vec (map second
            (sort (fn [[err1 ind1] [err2 ind2]] (< err1 err2))
                  (map #(vector (i-error %) %) population)))))

;; Finally, we'll define a function to select an individual from a sorted 
;; population using tournaments of a given size.
(defn select
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))

  
(defn reset-all! []
  (reset! +log+ [])
  (pnu/reset-ids! {}))

(declare validate-gp-params)
;; Now we can evolve a solution by starting with a random population and 
;; repeatedly sorting, checking for a solution, and producing a new population.
(defn evolve
  [problem]
  (reset-all!)
  (validate-gp-params)
  (let [popsize (:population-size +gp-params+)]
    (println "Starting evolution...")
    (loop [generation 0
           population (initial-pop problem)]
      (let [best (first population)
            best-error (i-error best)]
        (println "======================")
        (println "Generation:" generation)
        (println "Best error:" best-error)
        (println "Best program:" best)
        (println "     Median error:" (i-error (nth population (int (/ popsize 2)))))
        (println "     Average PN size:" 
                 (float (/ (reduce + (map
                                      #(+ (count (:places %)) (count (:transitions %)) (count (:arc %)))
                                      population))
                           popsize)))
        (if (< best-error 0.1) ;; good enough to count as success
          (println "Success:" best)
          (recur 
           (inc generation)
           (sort-by-error      
            (concat
             (repeatedly (* 1/2 popsize) #(mutate (select population 7)))
             (repeatedly (* 1/4 popsize) #(crossover (select population 7) (select population 7)))
             (repeatedly (* 1/4 popsize) #(select population 7))))))))))

(defn validate-gp-params [params]
  (when (not (< 0.9999 (reduce + 0 (map second (:mutation-types params))) 1.0001))
    (throw (ex-info {:error ":mutation-types does not sum to 1."}))))

;;; bbb
;;; (-> (pnml/read-pnml "data/m2-inhib-balanced.xml") (pn/gspn2spn) (pnr/reachability)) ; my gspn2spn can't do it.
;;; (-> (pnml/read-pnml "data/marsan69.xml") (pn/gspn2spn) (pnr/reachability))
;;; (def foo (initial-pop +problem+))
;;; (map #(if (reach-pn (reset! +diag+ %)) true false) foo)

(defn reach-pn
  "Returns the argument pn with reachability calculated or false if that couldn't be done."
  ([pn]
   (and
    (pnr/possible-live? pn)
    (pnu/enter-and-exit-places? pn)
    (pnu/enter-and-exit-trans? pn)
    (let [pn-reach (-> pn (pn/gspn2spn) (pnr/reachability))]
      (and (not (:failure pn-reach)) (pnr/live? pn-reach) pn-reach))))
  ([pn logging?]
   (if (not logging?)
     (reach-pn pn)
     (cond (not (pnr/possible-live? pn))
           (do (log {:error "fails possible live" :pn pn}) false),
           (not (pnu/enter-and-exit-places? pn))
           (do (log {:error "fails enter-and-exit-places" :pn pn}) false),
           (not (pnu/enter-and-exit-trans? pn))
           (do (log {:error "fails enter-and-exit-trans" :pn pn}) false),
           :else
           (let [pn-reach (-> pn (pn/gspn2spn) (pnr/reachability))]
             (cond (:failure pn-reach)
                   (do (log {:error "fails reachability calc" :pn pn-reach}) false),
                   (not (pnr/live? pn-reach))
                   (do (log {:error "fails live" :pn pn-reach}) false),
                   :else pn-reach))))))

;;; Run it with a population of 1000:
;;;(evolve 1000)

;;; Exercises:
;;; - Remove the numerical constants and see how this affects problem-solving performance.
;;; - Add the "inc" function (arity 1) and see how this affects problem-solving performance.
;;; - Run this on a different data set of your own choosing.
;;; - Replace various hard-coded parameters with variables or arguments to 
;;;   allow for easier experimentation with different parameter sets.
;;; - Add additional functions of various arities to the function set and see
;;;  how this affects problem-solving performance.

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
  {:visible-places [:m1-blocked :m1-busy :m2busy :m2-starved :buffer]
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



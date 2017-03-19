(ns gov.nist.sinet
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.memoize :as m]
            [gov.nist.spntools.core :as pn]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)]))

;;; Purpose:This is a program to demonstrate ideas in system identification of 
;;; discrete event systems using genetic programming.

;;; I started with Lee Spector's "gp" demonstration software...

;;; ToDo: - DONE: Get data for exponential jobs, BBS.
;;;       - Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - Implement a log for exceptional situations. 
;;;       - DONE (enough): Probably need more than one Eden individual for diversity (backwards, multi-loops etc).
;;;       - There are no mutate methods to remove elements; should there be?

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
  {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
   :pop-size 100
   :max-generations 10
   :k-bounded 10            ; When to give up on computing the reachability graph. 
   :crossover-to-mutation-ratio 0.5
   :elite-individuals 0.02 ; NYI
   :crossover-keeps-parents? true ; NYI
   :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
   :mutation-types       
   [[:add-place     1/5]    ; Add place (mine can't be absorbing, thus Nobile 1&2).
    #_[:remove-place     ]
    [:add-trans     1/5]    ; Add transition, connecting to input and output places.
    #_[:remove-tran      ]
    [:add-inhibit   1/5]    ; Add inhibitor arc, connecting a place to a trans
    #_[:remove-inhibit ]
    [:add-token     1/5]    ; Add token to some place (visible or hidden).
    [:remove-token  1/5]]}) ; Remove token from some place (visible or hidden).

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

(defn eden-individuals
  [problem]
  (list
   (eden-individual problem)
   (eden-individual (update problem :visible-places reverse))))

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
   log why and try again."
  [pn]
  (let [pnp (mutate-m pn)]
    (if (pnu/pn? pnp)
      pnp
      (do (log pnp)
          (mutate pn)))))

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
      (update ?pn :history conj {:mutate :add-place})
      (pnu/add-pn ?pn (pnu/make-place ?pn))
      (let [p (:name (last (:places ?pn)))]
        (as-> ?pn ?pnn
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn trans-in p))
          (pnu/add-pn ?pnn (pnu/make-arc ?pnn p trans-out)))))))

(defmethod mutate-m :add-trans [pn & args]
  (if-let [p-in (:name (random-place pn))]
    (if-let [p-out (:name (random-place pn :subset #(remove (fn [pl] (= (:name pl) p-in)) %)))]
      (as-> pn ?pn
        (pnu/add-pn ?pn (pnu/make-transition pn))
        (let [t (:name (last (:transitions ?pn)))]
          (as-> ?pn ?pnn
            (update ?pnn :history conj {:mutate :add-trans :trans t})
            (pnu/add-pn ?pnn (pnu/make-arc ?pnn p-in t))
            (pnu/add-pn ?pnn (pnu/make-arc ?pnn t p-out)))))
      {:skip :add-trans :msg "no p-out"})
    {:skip :add-trans :msg "no p-in"}))

(defmethod mutate-m :add-inhibit [pn & args]
  (if-let [trans (random-trans pn)]
    (if-let [place (random-place pn)]
      (as-> pn ?pn
        (update ?pn :history conj {:mutate :add-inhibit :place place})
        (pnu/add-pn pn (pnu/make-arc pn (:name place) (:name trans) :type :inhibitor)))
      {:skip :add-inhibit :msg "No visible place"})
    {:skip :add-inhibit :msg "No trans"}))

(defmethod mutate-m :add-token [pn & args]
  (-> pn
      (update :history conj {:mutate :add-token})
      (update-in [:places (rand-int (count (:places pn))) :initial-marking] inc)))
  
(defmethod mutate-m :remove-token [pn & args]
  (if-let [p (:name (random-place pn :subset #(remove (fn [pl] (= 0 (:initial-marking pl))) %)))]
    (-> pn
        (update :history conj {:mutate :remove-token :place p})
        (assoc  :places (vec (map #(if (= (:name %) p)
                                     (update % :initial-marking dec)
                                     %)
                                  (:places pn)))))
    {:skip :remove-token :msg "No place with token"}))

(defn crossover ; POD NYI
  [pn1 pn2]
  (case (rand-int 2)
    0 pn1
    1 pn2))

(declare reset-all! reach-pn)

(defn initial-pop [problem]
  (let [edens (eden-individuals problem)
        fresh-eden (fn [] (nth edens (rand-int (count edens))))]
    (loop [pop [], indv (fresh-eden), mute-cnt 0, try 0]
      (cond (> try 100000) (throw (ex-info {:error "couldn't find a population!"})),
            (>= (count pop) (:pop-size +gp-params+)) pop,
            :else (let [m-indv (pn-ok-> indv mutate reach-pn)]
                    (cond (:failure m-indv)
                          (do (log {:mutate-fails :initial-pop :method (last (:history m-indv))})
                              (if (< mute-cnt 2) ; POD 2 should be a +gp-params+
                                (recur pop (fresh-eden) 0 (inc try)) ; start over
                                (recur (conj pop indv) (fresh-eden) 0 (inc try)))) ; last one is good enough
                          (= (:initial-mutations +gp-params+) mute-cnt) ; complete success
                          (recur (conj pop m-indv) (fresh-eden) 0 (inc try))
                          :else ; continue mutating
                          (recur pop m-indv (inc mute-cnt) (inc try))))))))

(defn i-error [ind]
  "Compute the steady-state properties of the individual and from those, compute its error."
  (let [pn (pn-ok->
            ind
            pn/Q-matrix
            pn/steady-state-props)]
    (if (:failure pn)
      (assoc pn :error 999999999.9)
      (let [results (:avg-tokens-on-place pn)]
        (assoc pn :error
               (reduce (fn [sum [pname pval]] (+ sum (abs (- pval (pname results)))))
                       0
                       (:data-source +problem+)))))))
              
(defn sort-by-error
  "Add value for :error to each PN and used it to sort the population; best first." 
  [population]
  (as-> population p
    (map i-error p)
    (sort #(< (:error %1) (:error %2)) population)))

;; Finally, we'll define a function to select an individual from a sorted 
;; population using tournaments of a given size.
(defn select
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))
  
(defn reset-all! []
  (reset! pnr/+k-bounded+ (:k-bounded +gp-params+))
  (pnu/reset-ids! {})
  (reset! +log+ []))

(def +pop+ "diagnostic" (atom nil))
(declare validate-gp-params)

(defn evolve
  "Starting with a random population, sort, select, check for a soluition and 
   produce a new population."
  [problem]
  (reset-all!)
  (validate-gp-params +gp-params+)
  (println "Starting evolution...")
  (loop [generation 0
         population (-> +problem+ initial-pop sort-by-error)]
    (let [best (first population)
          best-error (:error best)]
      (println "======================")
      (println "Generation:" generation)
      (println "Population size:" (count population))
      (println "Total mutations:" (reduce + 0 (map #(count (:history %)) population)))
      (println "Failed individuals:" (count (filter identity (map #(contains? % :failure) population))))
      (println "Best error:" best-error)
      (println "     Median error:" (:error (nth population (int (/ (:pop-size +gp-params+) 2)))))
      (println "     Average PN size:" (pnu/avg (map pnu/pn-size population)))
      (cond (< best-error 0.1) ; good enough to count as success
            (do (println "Success!") best)
            (> generation (:max-generations +gp-params+))
            (do (println "Stopped at max-generation.") false)
            :else
            (recur 
             (inc generation)
             (as-> population ?p
               (reset! +pop+ ?p)
               (map #(dissoc % :M2Mp :initial-marking :Q :steady-state :avg-tokens-on-place) ?p)
               (next-generation ?p)))))))

(defn next-generation [population]
  (let [popsize (count population)]
    (sort-by-error      
     (concat
      (repeatedly (* 1/2 popsize) #(mutate (select population 7)))
      (repeatedly (* 1/4 popsize) #(crossover (select population 7) (select population 7)))
      (repeatedly (* 1/4 popsize) #(select population 7))))))

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
   (pn-ok-> pn 
            pnr/possible-live?
            pnu/enter-and-exit-places?
            pnu/enter-and-exit-trans?
            pn/gspn2spn
            pnr/reachability
            pnr/live?)))

;;; Run it with a population of 1000:
;;;(evolve 1000)

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



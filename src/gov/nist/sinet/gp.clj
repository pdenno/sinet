(ns gov.nist.sinet.gp
  "SINET demonstrate ideas in system identification/process mining using genetic programming."
  {:author "Peter Denno"}
  (:require ;[clojure.tools.trace :as tr] ; POD temporary, use tr/deftrace instead of defn
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan]]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)] ;  POD clean this up
            [gov.nist.sinet.util :as util :refer (app-info map->Inv gp-param pr-param *debugging*)]
            [gov.nist.sinet.simulate :as sim :refer (simulate)]
            [gov.nist.sinet.fitness :as fit :refer (workflow-fitness)]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.ws :as ws]
            [gov.nist.sinet.report :as rep]))

;;; Just for the record, I started with Lee Spector's "gp" demonstration software!

;;; ToDo: 
;;;       - Normalize the error calculation.
;;;       - Only do local mutations (No arcs to distance places, etc.)
;;;       - Implement the MJP crossover operator
;;;       - Keeping compute time on each individual might be useful.
;;;       - GSPN: Decide what to do about remove-token and other things that might fail or cause failure.
;;;       - GSPN: Maybe I shouldn't care about absorbing states?
;;;       - DONE: Need a mutation to move the :intro of new tokens to a different arc.
;;;         (:remove doesn't matter where you do it from )
;;;       - I made every transition timed. Probably not the best idea, generally speaking.

;;;  DOCUMENTATION REQUIREMENT: Determine what among the :gp-params matters.
;;; :pn-elements -- The PN elements that can appear in individuals.
;;; :initial-individuals -- percentage of each element type.
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")

(defn update-pop! [pop]
  (alter-var-root
   (resolve 'gov.nist.sinet.run/system)
   #(assoc-in % [:app :pop] pop))
  pop)

(def ^:private diag (atom nil))

;;;================================================================
;;; Generate initial population
;;;================================================================
(declare mjpdes2nice eden-pn)

;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m2-complete-job, :rep {:act :ej, :m :m2}}}
;;; (-> (scada/random-job-trace) mjpdes2nice make-plan)
;;; {:cnt 6,
;;;  :t
;;;  [{:name :m1-start-job, :act :aj, :m :m1}
;;;   {:name :m2-unstarved, :act :us, :m :m2}
;;;   {:name :m2-starved, :act :st, :m :m2}
;;;   {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}
;;;   {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}
;;;   {:name :m2-complete-job, :act :ej, :m :m2}],
;;;  :p [{:name :place-1} {:name :place-2} {:name :place-3} {:name :place-4} {:name :place-5} {:name :place-6}]}
(defn make-vertices
  "Return map with vectors containing skeleton transition and place definition maps."
  [e-assocs]
  (reduce (fn [plan e-assoc]
            (as-> plan ?p
              (update ?p :cnt inc)
              (update ?p :t conj e-assoc)
              (update ?p :p conj {:name (keyword (format "place-%d" (:cnt ?p)))})))
          {:cnt 0 :t [] :p []}
          e-assocs))

;;; POD Someday you might want to call this with multiple job traces.
;;; POD This interprets/translates the SCADA log. We'll need to generalize it someday.
(defn scada2pn-name
  "Return a transition name for a given SCADA msg (bl/ub/st/us probably wont' be used.)"
  [msg]
  (let [m (scada/implies-machine msg)]
    (cond (= :aj (:act msg)) (read-string (cl-format nil "~A-start-job"    m)),
          (= :ej (:act msg)) (read-string (cl-format nil "~A-complete-job" m)),
          (= :sm (:act msg)) (read-string (cl-format nil "~A-start-job"    m)),
          (= :bj (:act msg)) (read-string (cl-format nil "~A-complete-job" m)),
          (= :bl (:act msg)) (read-string (cl-format nil "~A-blocked"      m)),
          (= :ub (:act msg)) (read-string (cl-format nil "~A-unblocked"    m)),
          (= :st (:act msg)) (read-string (cl-format nil "~A-starved"      m)),
          (= :us (:act msg)) (read-string (cl-format nil "~A-unstarved"    m)))))

;;; POD Will need to generalize this idea of 'what a message means' I'm giving nice names to MJPdes output. 
;;; (mjpdes2nice (scada/random-job-trace)) ==>
;;; ({:name :m1-start-job, :act :aj, :m :m1}
;;;  {:name :m2-unstarved, :act :us, :m :m2}
;;;  {:name :m2-starved, :act :st, :m :m2}
;;;  {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}
;;;  {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}
;;;  {:name :m2-complete-job, :act :ej, :m :m2})
(defn mjpdes2nice
  "Interpret/translate the SCADA log. (Give nice names to MJPdes output.)" 
  [job-trace]
  (distinct
   (map (fn [msg]
          (let [m (scada/implies-machine msg)]
            (cond (= :aj (:act msg)) {:name (scada2pn-name msg) :act :aj :m m} 
                  (= :ej (:act msg)) {:name (scada2pn-name msg) :act :ej :m m} 
                  (= :sm (:act msg)) {:name (scada2pn-name msg) :act :sm :m m :bf (:bf msg)}
                  (= :bj (:act msg)) {:name (scada2pn-name msg) :act :bj :m m :bf (:bf msg)}
                  (= :bl (:act msg)) {:name (scada2pn-name msg) :act :bl :m m}
                  (= :ub (:act msg)) {:name (scada2pn-name msg) :act :ub :m m}
                  (= :st (:act msg)) {:name (scada2pn-name msg) :act :st :m m}
                  (= :us (:act msg)) {:name (scada2pn-name msg) :act :us :m m})))
        job-trace)))

;;; POD This still needs work. There needs to be higher level operations
;;; These include (1) recognizing subsystems and preserving them from further mucking.
;;; (2) adding feeder lines, (3) messing with buffer size. The setting of rates
;;; and distributions of timed transitions will be another process, one that also
;;; looks at the default causal knowledge. See Sankaran Mahadevan's paper with Sudarsan
;;; "Automated uncertainty quantification analysis using a system model and data"
;;; (4) The NN problem with blocking/starvation. 
(declare eden-places eden-trans eden-arcs eden-display-geometry)
(defn eden-pn
  "Return a PN expressing the places and transitions of the argument 'plan.'
   It is a loop made by using visible places and transitions with additional
   hidden places and transitions necessary to close the loop."
  [plan]
  (as-> {:places [] :transitions [] :arcs []} ?pn
    (eden-places ?pn (:p plan))
    (eden-trans  ?pn (:t plan))
    (eden-arcs   ?pn plan)))

(defn eden-places
  "Update the PN with :places according to the seq of plan-maps for places."
  [pn plans]
  (as-> pn ?pn
    (assoc ?pn :places
           (vec (map (fn [plan]
                       (as-> (pnu/make-place pn :name (:name plan)) ?pl
                         (assoc ?pl :visible? (if (= :silent (:act plan)) false true))))
                      plans)))
    (update-in ?pn [:places 0 :initial-tokens] inc))) ; Add a token to make it alive

(defn eden-trans
  "Update the PN with :transitions according to the seq of plan-maps for transitions."
  [pn plans]
  (assoc pn :transitions
         (vec (map (fn [plan]
                     (as-> (pnu/make-transition pn :name (:name plan)) ?tr
                       (assoc ?tr :type :exponential) ; (if (= 0 (rand-int 2)) :exponential :immediate))
                       (assoc ?tr :rep (dissoc plan :name))
                       (assoc ?tr :visible? (if (= :silent (:act plan)) false true))))
                   plans))))

(defn eden-arcs
  "Update the PN with :arc according to the plan."
  [pn plan]
  (assoc pn :arcs
         (reduce (fn [arcs [from to]] (conj arcs (pnu/make-arc pn from to)))
                 []
                 (map vec (partition
                           2 (interleave
                              (vec (interleave (map :name (:p plan)) (map :name (:t plan))))
                              ;; connect last first 
                              (vec (interleave (map :name (:t plan))
                                               (conj (vec (rest (map :name (:p plan))))
                                                     (first (map :name (:p plan))))))))))))

;;; POD Currently only one color. 
(defn add-color-binding
  "Add color binding information."
  [pn]
  (update-in pn [:arcs] (fn [arcs] (vec (map #(assoc % :bind {:jtype :blue}) arcs)))))

;;; A priority 1 to N is assigned to the N arcs out-going from a transition. Each
;;; out-going arc on the transition has a unique priority. Priority is therefore a
;;; total ordering on the out-going arcs.
;;; The priority assignments and the ids on token are used to determine what tokens
;;; will flow out of which arcs from a transition in simulation. The rules are as follows:
;;;
;;; (1) Negative balance: The oldest N tokens are removed to satisfy an imbalance of N tokens.
;;;     The remaining tokens are distributed so that the token requirements (multiplicity) of
;;;     the highest priority arc are satisfied first using the oldest remaining tokens,
;;;     then the second highest priority arc, and so on.
;;; (2) Positive balance: New tokens are created to satisfy the imbalance. Tokens are
;;;     distributed to the arcs as in (1).
;;;
;;; Mutation side-effects:
;;;    Added arc: If there were m arcs out-going prior to the addition, the new arc would
;;;               have priority m+1. (i.e. it has lowest priority).
;;;    Removed arcs: The total ordering on the remaining arcs is maintained.
;;;
;;; Mutation operator: A mutation search operator swaps the priority on two out-going arcs
;;;                    chosen randomly.
(defn add-flow-priority-trans
  "Update PN to assign flow priorities to arcs out of the transitions that do not yet have one."
  [pn trans]
  (let [aout (pnu/arcs-outof pn trans)
        priorities (map :priority aout) ; existing priorities (includes nils)
        have-priority (filter identity priorities) ; no nils.
        max-priority (if (empty? have-priority) 0 (apply max have-priority)) ; current max.
        num-needed (count (remove identity priorities)) ; number that need a priority
        pick-plan (map #(+ % max-priority 1) (util/random-index num-needed))
        pick-map (zipmap pick-plan (map :name (remove :priority aout)))]
    (update pn :arcs
            (fn [arcs]
              (vec
               (reduce (fn [arcs [priority aname]]
                         (assoc-in (vec arcs) [(pnu/arc-index pn aname) :priority] priority))
                       arcs
                       pick-map))))))

(defn add-flow-priorities
  "Assign flow priorities to all arcs outbound from a transition."
  [pn]
  (reduce (fn [pn trans]
            (add-flow-priority-trans pn trans))
          pn
          (->> pn :transitions (map :name))))

;;; (-> (scada/random-job-trace) initial-pn)
(defn initial-pn
  "Translate a SCADA job trace into a PN."
  [job-trace]
  (->> job-trace
       mjpdes2nice           ; returns maps to translate terse mjpdes log info to nice names.
       make-vertices         ; returns map of skeletons for place and transition definitions
       eden-pn               ; complete skeletons and add :arcs, making a bipartite graph. 
       add-color-binding     ; add e.g. :bind {:jtype :blue} to :arcs for multi-job paths.
       add-flow-priorities)) ; add info for deciding which tokens go where when multiple in/out on trans.

(defn initial-pop
  "Create an initial population of size pop-size."
  [pop-size]
  (vec (repeatedly
        pop-size 
        #(let [job-trace (scada/random-job-trace)]
           (map->Inv {:pn (initial-pn job-trace),
                      :id (util/uuid)
                      :history [{:trace job-trace}]})))))
          
;;;================================================================
;;; Genetic Operators (AKA search operators)
;;;================================================================
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

(defn random-inhib [pn  & {:keys [subset] :or {subset identity}}]
  (let [arcs (subset (filter #(= (:type %) :inhibitor) (:arcs pn)))]
    (when (not-empty arcs)
      (nth arcs (rand-int (count arcs))))))

(declare mutate-m eval-pn add-color-binding diag-record-inv)

(defn mutate
  "Mutate the individual. If impossible (after 5 tries) just return it."
  ([inv] (mutate inv :pick-fn rand-mute-key)) ; no args to r-m defaults to :mutation-dist
  ([inv & {:keys [pick-fn force] :or {pick-fn rand-mute-key}}]
   (let [save-inv inv]
     (as-> inv ?inv
       (loop [n 4] ; POD five...belongs in params.
         (let [i (mutate-m ?inv :pick-fn pick-fn :force force)]
           ;; Try 5 times to mutate; POD this skews things!
           (cond (pnu/pn? (:pn i)) (diag-record-inv i)
                 (= n 0) (do (util/log {:in "mutate" :inv-id (:id ?inv)}) save-inv)
                 :else (recur (dec n)))))
       (add-color-binding ?inv)
       (update ?inv :pn
               #(reduce (fn [pn trans] (add-flow-priority-trans pn trans))
                        %
                        (->> % :transitions (map :name))))))))

(defn- mutate-m-dispatch [inv & {:keys [pick-fn force]
                                 :or {pick-fn rand-mute-key}}]
  (or force (pick-fn)))

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

;;;------------------ Add -----------------------------
(defmethod mutate-m :add-place [inv & args]
  (let [trans-in  (:name (random-trans (:pn inv)))
        trans-out (:name (random-trans (:pn inv)))]
    (as-> inv ?i
      (update ?i :pn #(pnu/add-pn % (pnu/make-place %)))
      (update ?i :pn #(pnu/add-pn % (pnu/make-arc % trans-in (-> % :places last :name))))
      (update ?i :pn #(pnu/add-pn % (pnu/make-arc % (-> % :places last :name) trans-out)))
      (assoc-in ?i [:pn :marking-key] :invalid)
      (update ?i :pn pnr/renumber-pids)
      (update ?i :history conj [:add-place (-> ?i :pn :places last :name) :from (:id ?i)]))))

;;; POD this should probably go away! Replace by some sort of coping mechanism!
(defmethod mutate-m :add-token [inv & args]
  (if-let [places (-> inv :pn :places not-empty)]
    (let [p-indx (rand-int (count places))]
      (as-> inv ?i
          (update-in ?i [:pn :places p-indx :initial-tokens] inc)
          (update    ?i :history conj [:add-token (-> ?i :pn :places p-indx :name) :from (:id ?i)])))
    {:skip :add-token :msg "no place!"}))

(defmethod mutate-m :add-trans [inv & args]
  (if-let [p-in (:name (random-place (:pn inv)))]
    (if-let [p-out (:name (random-place (:pn inv) :subset #(remove (fn [pl] (= (:name pl) p-in)) %)))]
        (as-> inv ?i
          (update ?i :pn
                  #(pnu/add-pn % (pnu/make-transition
                                   % ; POD maybe the GP should assume everything is timed
                                   :type :exponential #_(if (== 0 (rand-int 2)) :exponential :immediate))))
          (update ?i :pn
                  #(let [tname (-> % :transitions last :name)]
                     (as-> % ?pn
                       (pnu/add-pn ?pn (pnu/make-arc ?pn p-in tname))
                       (pnu/add-pn ?pn (pnu/make-arc ?pn tname p-out)))))
          (update ?i :history conj [:add-trans (-> ?i :pn :transitions last :name) :from (:id ?i)]))
        {:skip :add-trans :msg "no p-out"})
    {:skip :add-trans :msg "no p-in"}))

(defmethod mutate-m :add-arc [inv & args]
  (if-let [tr (random-trans (:pn inv))]
    (if-let [pl (random-place (:pn inv))]
      (let [[from to] (case (rand-int 2) 0 (vector tr pl) 1 (vector pl tr))]
        (if-let [have-one (some #(when (and (= (:name from) (:source %))
                                            (= (:name to)   (:target %))) %)
                                (filter #(= (:type %) :normal) (-> inv :pn :arcs)))]
          (-> inv
              (update-in [:pn :arcs (pnu/arc-index (:pn inv) (:name have-one)) :multiplicity] inc)
              (update    :history conj [:add-arc :have-one (:name have-one) :from (:id inv)]))
          (as-> inv ?i
              (update ?i :pn #(pnu/add-pn % (pnu/make-arc % (:name from) (:name to))))
              (update ?i :history conj [:add-arc (-> ?i :pn :arcs last :name) :from (:id ?i)]))))
      {:skip :add-arc :msg "No place"})
    {:skip :add-arc :msg "No trans"}))

(defmethod mutate-m :add-inhibitor [inv & args]
  (if-let [tr (random-trans (:pn inv))]
    (if-let [pl (random-place (:pn inv))]
      (if-let [have-one (some #(when (and (= (:name pl) (:source %))
                                          (= (:name tr) (:target %))) %)
                              (filter #(= (:type %) :inhibitor) (-> inv :pn :arcs)))]
        (as-> inv ?i
          (update-in ?i [:pn :arcs (pnu/arc-index (:pn ?i) (:name have-one)) :multiplicity] inc)
          (update    ?i :history conj [:add-inhibitor :have-one (:name have-one) :from (:id ?i)]))
        (as-> inv ?i
          (update ?i :pn #(pnu/add-pn % (pnu/make-arc % (:name pl) (:name tr) :type :inhibitor)))
          (update ?i :history conj [:add-inhibitor (-> ?i :pn :arcs last :name) :from (:id ?i)])))
      {:skip :add-inhibitor :msg "No place"})
    {:skip :add-inhibitor :msg "No trans"}))

(defmethod mutate-m :bump-inhibitor-3 [inv & args]
  (if-let [inh (random-inhib (:pn inv))]
    (-> inv
        (update-in [:pn :arcs (pnu/arc-index (:pn inv) (:name inh)) :multiplicity] #(+ % 3))
        (update    :history conj [:bump-inhibitor-3 (:name inh) :from (:id inv)]))
    {:skip :bump-inhibitor-3 :msg "No inhib"}))

;;;------------------ Remove -----------------------------
(defn sole-arc?
  "Return true if removal of the argument arc would leave the net with a
   transition or place for which there isn't at least one arc in and one out."
  ([pn ar check-mult?]
   (if (> (:multiplicity ar) 1) false (sole-arc? pn ar)))
  ([pn ar]
   (let [narc (:name ar)]
     (some
      (fn [v]
        (let [into  (map :name (filter #(= (:type %) :normal) (pnu/arcs-into  pn v)))
              outof (map :name (filter #(= (:type %) :normal) (pnu/arcs-outof pn v)))]
          (when-let [sole (cond (and (== 1 (count into )) (= (first into ) narc)) (first into)
                                (and (== 1 (count outof)) (= (first outof) narc)) (first outof))]
            sole)))
      (into (map :name (:places pn)) (map :name (:transitions pn)))))))
               
(defmethod mutate-m :remove-place [inv & args]
  (let [pn (:pn inv)  ;; Removing a place means removing all the arcs into/outof. Therefore this subset:
        pl (:name (random-place
                   pn
                   :subset #(remove ;; Some vertex for which removing one of the arcs of place would be bad.
                             (fn [pl]
                               (or (:visible? pl)
                                   (some (fn [ar] (sole-arc? pn ar)) 
                                         (into (pnu/arcs-into pn (:name pl))
                                               (pnu/arcs-outof pn (:name pl))))))
                             %)))]
    (if pl
      (as-> inv ?i
          (update-in ?i [:pn :places] (fn [pls] (vec (remove #(= (:name %) pl) pls))))
          ;; In this case, remove arc regardless of multiplicity.
          (let [elims (map :name (into (pnu/arcs-into pn pl) (pnu/arcs-outof pn pl)))]
            (update-in ?i [:pn :arcs] (fn [arcs] (vec (remove (fn [ar] (some #(= (:name ar) %) elims)) arcs)))))
          (assoc-in ?i [:pn :marking-key] :invalid)
          (update ?i :pn pnr/renumber-pids)
          (update ?i :history conj [:remove-place pl :from (:id ?i)]))
      {:skip :remove-place :msg "no qualifying place"})))

(defmethod mutate-m :remove-trans [inv & args]
  (let [tr (:name (random-trans (:pn inv) :subset #(remove (fn [tr] (:visible? tr)) %)))]
    (if (> (-> inv :transitions count) 1)
      (-> inv 
        (update-in [:pn :transitions] (fn [ts] (vec (remove #(= % tr) ts))))
        (update-in [:pn :arcs] (fn [arcs] (vec (remove #(or (= (:source %) tr)
                                                               (= (:target %) tr)) arcs))))
        (update    :history conj [:remove-trans tr :from (:id inv)]))
      {:skip :remove-trans :msg "too few"})))

(defmethod mutate-m :remove-token [inv & args]
  (if (> (apply + (->> inv :pn :places (map :initial-tokens))) 1)
    (let [pl (:name (random-place (:pn inv) :subset #(remove (fn [pl] (= 0 (:initial-tokens pl))) %)))]
      (-> inv
          (update-in [:pn :places (pnu/place-index (:pn inv) pl) :initial-tokens] dec)
          (update    :history conj [:remove-token pl :from (:id inv)])))
    {:skip :remove-token :msg "Not enough tokens left"}))

(defn update-arc-removal
  "If arc has multiplicity 1, remove it. Otherwise, reduce its multiplicity."
  [inv ar]
  (if (== (:multiplicity ar) 1)
    (update-in inv [:pn :arcs] (fn [arcs] (vec (remove #(= % ar) arcs))))
    (update-in inv [:pn :arcs (pnu/arc-index (:pn inv) (:name ar)) :multiplicity] dec)))

(defmethod mutate-m :remove-arc [inv & args]
  (if-let [ar (random-arc (:pn inv) :subset #(filter (fn [ar] (and (= :normal (:type ar))
                                                                   (not (sole-arc? (:pn inv) ar true)))) %))]
    (-> inv
        (update-arc-removal ar)
        (update :history conj [:remove-or-dec-arc (:name ar) :from (:id inv)]))
    {:skip :remove-arc :msg "No arc"}))

(defmethod mutate-m :remove-inhibitor [inv & args]
  (if-let [ar (random-arc (:pn inv) :subset #(filter (fn [ar] (= :inhibitor (:type ar))) %))]
    (if (= 1 (:multiplicity ar))
      (-> inv
          (update-in [:pn :arcs] (fn [arcs] (vec (remove #(=  % ar) arcs))))
          (update    :history conj [:remove-inhib (:name ar) :from (:id inv)]))
      (-> inv
          (update-in [:pn :arcs (pnu/arc-index (:pn inv) (:name ar)) :multiplicity] dec)
          (update    :history conj [:remove-inhib :dec (:name ar) :from (:id inv)])))
    {:skip :remove-inhibitor :msg "No inhibitor arcs"}))

;;;------------------ Swap -----------------------------
(defn swap-arcs [pn pl1 pl2]
  "Swap use of places pl1 and pl2 in the arcs of the PN. Works on trans too!"
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

(defmethod mutate-m :swap-places [inv & args]
  (if-let [pl1 (:name (random-place (:pn inv)))]
    (if-let [pl2 (:name (random-place (:pn inv):subset #(filter (fn [pl] (not= (:name pl) pl1)) %)))]
      (-> inv
          (update :pn #(swap-arcs % pl1 pl2))
          (update :history conj [:swap-places pl1 pl2 :from (:id inv)]))
      {:skip :swap-places :msg "no 2nd place"})
    {:skip :swap-places :msg "no 1st place"}))

(defmethod mutate-m :swap-trans [inv & args]
  (if-let [tr1 (:name (random-trans (:pn inv)))]
    (if-let [tr2 (:name (random-trans (:pn inv):subset #(filter (fn [tr] (not= (:name tr) tr1)) %)))]
      (-> inv 
          (update :pn #(swap-arcs % tr1 tr2))
          (update :history conj [:swap-arcs tr1 tr2 :from (:id inv)]))
      {:skip :swap-trans :msg "no 2nd trans"})
    {:skip :swap-trans :msg "no 1st trans"}))

(defmethod mutate-m :swap-priority [inv & args]
  (let [pn (:pn inv)
        candidates (filter #(> (count (pnu/arcs-outof pn %)) 1)
                           (map :name (:transitions pn)))]
    (if (not-empty candidates)
      (let [trans (nth candidates (rand-int (count candidates)))
            patom (atom (pnu/arcs-outof pn trans))
            arc1 (util/pick-from-atom! patom)
            arc2 (util/pick-from-atom! patom)
            p1 (:priority arc1)
            p2 (:priority arc2)]
        (-> inv
            (assoc-in [:pn :arcs (pnu/arc-index pn (:name arc1)) :priority] p2)
            (assoc-in [:pn :arcs (pnu/arc-index pn (:name arc2)) :priority] p1)
            (update :history conj [:swap-priority  (:name arc1) (:name arc2) :from (:id inv)])))
      {:skip :swap-priority :msg "no candidates"})))

;;;=====================================================================================
;;;  Evolution Algorithm
;;;=====================================================================================
(defn i-error 
  "Compute the individual's score."
  [inv]
  (assoc inv :err (fit/workflow-fitness inv)))

(defn sort-by-error
  "Add value for :err to each PN and used it to sort the population; best first."
  [popu]
  (as-> popu ?i
    (pmap i-error ?i) ; POD pmap
    (vec (sort #(< (:err %1) (:err %2)) ?i))))

(defn select
  "Select an individual from a sorted population using a tournament of given size."
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))

(defn reset-spntools! []
  (reset! pnr/+k-bounded+ (gp-param :pn-k-bounded))
  (reset! pnr/+max-rs+    (gp-param :pn-max-rs))
  (reset! pn/+max-states+ (gp-param :pn-max-states))
  (pnu/reset-ids! {}))

(defn reset-all! []
  (reset-spntools!)
  (reset! util/+log+ []))

;;; Lee Spector's original were:
;;;   Basic eqn    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   Weather n    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   even parity  - 1/10 mutate  8/10 cross over, 1/10 untouched,  selection pressure 5
(defn make-next-gen [world]
  "Compute the next generation, a combination of tournament selection, mutations and crossover
   of tournament winners, and elite individuals. Argument has :state (e.g. :continue, :success)
   start-time and population Invs"
  (let [e-cnt    (gp-param :elite-individuals)
        pop-size (gp-param :pop-size)
        pressure (gp-param :select-pressure)] ; POD I'm running 4 right now. 
    (update world :pop
            (fn [?x] ; POD no # and % allowed here. Why? (CIDER says unmatched parentheses.)
              (as-> ?x ?spop
                (into (subvec ?spop 0 e-cnt)
                      (repeatedly (* 3/4 pop-size) #(mutate (select ?spop pressure)))) ; POD gp-param
                ;;(repeatedly (* 2/8 (gp-param :pop-size)) #(crossover (select ?spop 7) (select ?spop 7)))
                (loop [pop ?spop]
                  (if (>= (count pop) pop-size)
                    (subvec (vec pop) 0 pop-size)
                    (recur (conj pop (select ?x pressure))))))))))

(defn evolve-success? [world]
  (cond (< (-> world :pop first :err) 0.1) ; good enough to count as success (POD :gp-param+)
        (assoc world :state :success), 
        (>= (:gen world) (gp-param :max-gens))
        (assoc world :state :failure),         
        :else (assoc world :state :continue)))

(defn evolve-init
  "Set up world map and initial population."
  []
  (println "evolve-init...")
  (reset-all!)
  (let [world (as-> {} ?w
                (assoc ?w :gen 0)
                (assoc ?w :state :init)
                (assoc ?w :start-time (System/currentTimeMillis))
                (assoc ?w :pop (initial-pop (gp-param :pop-size))))]
    (update-pop! (:pop world))
    world))

(defn evolve-continue
  "Loop through generations until success, failure or paused."
  [world prom]
  (println "evolve-continue...")
  ;;(util/log {:defn evolve-continue :world world})
  (reset! (rep/pause-evolve?) false)
  (loop [w world]
    (rep/pop-stats w)
    (as-> w ?w
      (assoc ?w :state :running)
      (update ?w :pop #(sort-by-error %))
      (do (update-pop! (:pop ?w)) ?w)
      (update ?w :gen inc)
      (evolve-success? ?w)
      (rep/report-gen ?w)
      (cond @(rep/pause-evolve?) ?w, 
            (= (:state ?w) :failure) (do (rep/push-inv (-> ?w :pop first)) (deliver prom ?w)), 
            (= (:state ?w) :success) (do (rep/push-inv (-> ?w :pop first)) (deliver prom ?w)), 
            :else
            (recur (make-next-gen ?w))))))

;;; (>!! (rep/evolve-chan) "init")
;;; (>!! (rep/evolve-chan) "continue")
(defn start-evolve-loop!
  []
  (reset! util/+log+ [])
  (println "evolve-chan=" (rep/evolve-chan))
  (async/go-loop [world {}]
    (let [msg (<! (rep/evolve-chan))]
      ;(util/log (str "msg =" msg))
      (as-> world ?w
        (cond (= msg "init")
              (if (not= (:state ?w) :init) (evolve-init) ?w),
              (= msg "continue")
              (let [p (promise)]
                (evolve-continue ?w p)
                (deref p (* 1000 (gp-param :timeout-secs)) {:state :timeout})),
              (= msg "pause")
              (do (println "evolve-pause...")
                  (reset! (rep/pause-evolve?) true) ?w))
        (if (or (= :close (:state ?w)) (= :timeout (:state ?w)))
          (util/log ?w)
          (recur ?w))))))

;;; This is from the ICMR 2017 days!
#_(defn eval-inv
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

;;;=========================================================================
;;; Diagnostics
;;;=========================================================================
(def diag-all-inv (atom {}))
(defn diag-record-inv [inv]
  "Keep a map of EVERY Inv, check that it has a legit PN."
  (if *debugging*
    (let [inv (assoc inv :id (util/uuid))
          errors (pnu/validate-pn (:pn inv))]
      (swap! diag-all-inv #(assoc % (:id inv) inv))
      (when-not (empty? errors)
        (throw (ex-info "Bad PN" {:id (:id inv) :errors errors})))
      inv)
    inv))

(defn diag-run
  "Run the GP in diagnostic mode from the REPL. A very useful function!"
  []
  (binding [*debugging* true]
    (reset! diag-all-inv {})
    (let [p (promise)]
      (as-> (evolve-init) ?w
        (evolve-continue ?w p)))))

(defn diag-sim
  "Simulate some steps on the best Inv."
  ([] (diag-sim 20))
  ([nsteps]
   (-> (app-info)
       :pop
       first
       :pn
       (sim/simulate :max-steps nsteps)
       :sim
       :log
       ppprint)))

(defn diag-scada-patterns
  "pprint the scada-patterns."
  []
  (->> (app-info)
       :problem
       :scada-patterns
       (map :form)
       ppprint))

(defn diag-push-inv [inv]
  "Push an individual to the web client for viewing"
  (rep/push-inv inv))

(defn diag-write-inv
  "Write an Inv so that it is readable."
  [inv]
  (let [inv (update-in inv [:history 0 :trace] vec)]
    (println "(map->Inv ")
    (print "{  :id ")      (ppprint (:id inv))
    (print "   :pn ")      (ppprint (:pn inv))
    (print "   :err ")     (ppprint (:err inv))
    (print "   :history ") (ppprint (:history inv))
    (print "})")))

(defn diag-save-gen 
  "Save the current generation."
  []
  (with-open [writer (java.io.FileWriter. "data/generations/test.clj")]
    (binding [*out* writer]
      (println "(in-ns 'gov.nist.sinet.gp)")
      (println "(def foo [")
      (doseq [x (-> (app-info) :pop)] (diag-write-inv x))
      (println "])"))))



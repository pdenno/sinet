(ns gov.nist.sinet.gp
  "SINET demonstrate ideas in system identification/process mining using genetic programming."
  {:author "Peter Denno"}
  (:require ;[clojure.tools.trace :as tr] ; POD temporary, use tr/deftrace instead of defn
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan close!]]
            [clojure.spec.alpha :as s]
            [pdenno.utils4pmap :as u4pmap]
            [gov.nist.spntools.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.reach :as pnr]
            [gov.nist.sinet.util :as util :refer (log app-info map->Inv gp-param pr-param VARS *debugging* handling-evolve)]
            [gov.nist.sinet.fitness :as fit :refer (exceptional-fitness)]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.ws :as ws]
            [gov.nist.sinet.report :as rep]))

(alias 'gp 'gov.nist.sinet.gp)
(declare eden-places eden-trans eden-arcs add-machine-restart-bbs mutate-m eval-pn add-color-binding
         diag-record-inv remove-wrap-places bbs-bas-switch)

(s/check-asserts true)

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
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")

(s/def ::pop (s/coll-of #(identity %) :kind vector?))
(s/def ::state keyword?)
(s/def ::gen number?)
(s/def ::world (s/keys :req-un [::gen ::state ::pop]))

(defn update-pop! [pop]
  (s/assert ::pop pop)
  (alter-var-root
   (resolve 'gov.nist.sinet.run/system)
   #(assoc-in % [:app :pop] pop))
  pop)

(def ^:private diag (atom nil))

;;;================================================================
;;; Generate initial population
;;;================================================================

;;; {:tkns [{:jtype :blue, :id 1}], :rep {:act :m2-complete-job, :mjpact :ej, :m :m2}}}
;;; (-> (scada/rand-job-trace) mjpdes2pn make-plan)
;;; {:cnt 6,
;;;  :t
;;;  [{:act :m1-start-job, :mjpact :aj, :m :m1}
;;;   {:act :m2-unstarved, :mjpact :us, :m :m2}
;;;   {:act :m2-starved, :mjpact :st, :m :m2}
;;;   {:act :m1-complete-job, :mjpact :bj, :m :m1, :bf :b1}
;;;   {:act :m2-start-job, :mjpact :sm, :m :m2, :bf :b1}
;;;   {:act :m2-complete-job, :mjpact :ej, :m :m2}],
;;;  :p [{:name :place-1} {:name :place-2} {:name :place-3} {:name :place-4} {:name :place-5} {:name :place-6}]}
(defn make-vertices
  "Return map with vectors containing skeleton transition and place definition maps."
  [msg]
  (reduce (fn [plan msg]
            (as-> plan ?p
              (update ?p :cnt inc)
              (update ?p :t conj msg)
              (update ?p :p conj {:name (keyword (format "place-%d" (:cnt ?p)))})))
          {:cnt 0 :t [] :p []}
          msg))

;;; POD This still needs work. There needs to be higher level operations
;;; These include (1) recognizing subsystems and preserving them from further mucking.
;;; (2) adding feeder lines, (3) messing with buffer size. The setting of rates
;;; and distributions of timed transitions will be another process, one that also
;;; looks at the default causal knowledge. See Sankaran Mahadevan's paper with Sudarsan
;;; "Automated uncertainty quantification analysis using a system model and data"
;;; (4) The NN problem with blocking/starvation.
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
                         (assoc ?pl :visible? (if (= :silent (:mjpact plan)) false true))))
                      plans)))
    (update-in ?pn [:places 0 :initial-tokens] inc))) ; Add a token to make it alive

(defn eden-trans
  "Update the PN with :transitions according to the seq of plan-maps for transitions."
  [pn plans]
  (assoc pn :transitions
         (vec (map (fn [plan]
                     (as-> (pnu/make-transition pn :name (:act plan)) ?tr
                       (assoc ?tr :type :exponential) ; (if (= 0 (rand-int 2)) :exponential :immediate))
                       (assoc ?tr :rep (dissoc plan :name :dets :ends))
                       (assoc ?tr :visible? (if (= :silent (:mjpact plan)) false true))))
                   plans))))

(defn eden-arcs
  "Update the PN with :arc according to the plan."
  [pn plan]
  (assoc pn :arcs
         (reduce (fn [arcs [from to]] (conj arcs (pnu/make-arc pn from to)))
                 []
                 (map vec (partition
                           2 (interleave
                              (vec (interleave (map :name (:p plan)) (map :act (:t plan))))
                              ;; connect last first
                              (vec (interleave (map :act (:t plan))
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
;;;     the highest priority arc (lowest priority number) are satisfied first using the NEWEST
;;;     remaining tokens, then the second highest priority arc, and so on.
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
  (as-> pn ?pn
    (if (util/one-in-one-out? ?pn trans)
      pn
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
                           pick-map))))))))

(defn add-flow-priorities
  "Assign flow priorities to all arcs outbound from a transition."
  [pn]
  (reduce (fn [pn trans]
            (add-flow-priority-trans pn trans))
          pn
          (->> pn :transitions (map :name))))

(defn initial-pn
  "Translate a SCADA job trace into a PN."
  [job-trace]
  (->> job-trace
       make-vertices         ; returns map of skeletons for place and transition definitions
       eden-pn               ; complete skeletons and add :arcs, making a bipartite graph.
       add-color-binding     ; add e.g. :bind {:jtype :blue} to :arcs for multi-job paths.
       add-flow-priorities   ; add info for deciding which tokens go where when multiple in/out on trans.
       util/check-pn))

(defn initial-pop
  "Create an initial population of size pop-size."
  [pop-size]
  (vec (repeatedly
        pop-size
        #(let [job-trace (scada/rand-job-trace)]
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
      (rand-nth trans))))

(defn random-place [pn  & {:keys [subset] :or {subset identity}}]
  (let [places (subset (:places pn))]
    (when (not-empty places)
      (rand-nth places))))

(defn random-arc [pn  & {:keys [subset] :or {subset identity}}]
  (let [arcs (subset (:arcs pn))]
    (when (not-empty arcs)
      (rand-nth arcs))))

(defn random-inhib [pn  & {:keys [subset] :or {subset identity}}]
  (let [arcs (subset (filter #(= (:type %) :inhibitor) (:arcs pn)))]
    (when (not-empty arcs)
      (rand-nth arcs))))

(defn mutate
  "Mutate the individual. If impossible (after 5 tries) just return it."
  ([inv] (mutate inv :pick-fn rand-mute-key)) ; no args to r-m defaults to :mutation-dist
  ([inv & {:keys [pick-fn force] :or {pick-fn rand-mute-key}}]
   (handling-evolve [inv]
     (let [save-inv inv]
       (as-> inv ?inv
         (loop [n 4] ; POD five...belongs in params.
           (let [i (mutate-m ?inv :pick-fn pick-fn :force force)]
             ;; Try 5 times to mutate; POD this skews things!
             (cond (pnu/pn? (:pn i)) (diag-record-inv i)
                   (= n 0) (do (log {:in 'mutate :inv-id (:id ?inv)}) save-inv)
                   :else (recur (dec n)))))
         (add-color-binding ?inv) ;; POD meant to be temporary??? Same with next one.
         (update ?inv :pn add-flow-priorities))))))

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
      (update ?i :history conj {:op :add-place :place (-> ?i :pn :places last :name) :from (:id ?i)}))))

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
          (update ?i :history conj {:op :add-trans :trans (-> ?i :pn :transitions last :name) :from (:id ?i)}))
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
              (update    :history conj {:op :add-arc :have-one (:name have-one) :from (:id inv)}))
          (as-> inv ?i
              (update ?i :pn #(pnu/add-pn % (pnu/make-arc % (:name from) (:name to))))
              (update ?i :history conj {:op :add-arc :arc (-> ?i :pn :arcs last :name) :from (:id ?i)}))))
      {:skip :add-arc :msg "No place"})
    {:skip :add-arc :msg "No trans"}))

(defmethod mutate-m :add-machine-restart-bbs
  [inv & args]
  (let [pn (:pn inv)
        not-waiting (->> (util/related-places pn)
                         (reduce (fn [mp [key places]] ; key is a machine
                                   (if (or (empty? places)
                                           (some #(= :waiting (:purpose (pnu/name2obj pn %))) places))
                                     mp
                                     (assoc mp key places)))
                                 {})
                         keys)
        m1 (rand-nth not-waiting)
        m2 (when m1 (util/next-machine pn m1 :wrap-ok))]
    (if (and m1 m2)
      (-> inv
          (assoc :pn (add-machine-restart-bbs pn m1 m2))
          (update :history conj {:op :add-machine-restart-bbs :m1 m1 :m2 m2}))
      {:skip :add-machine-restart-bbs :msg "no qualifying machine"})))

(defn add-machine-restart-bbs
  "Mutate a buffering pattern to (potentially) 'buffering and returning to restart' pattern.
   The place added is the 'waiting' one, where 'waiting' can be interpreted as blocking or
   starving; interpretation decides which of these. The buffer is the existing interface
   place between the two machines."
  [pn m1 m2]
  (let [waiting (-> (pnu/make-place pn :name (pnu/name-with-prefix pn "wait"))
                    (assoc :purpose :waiting))
        m1-end  (some #(when (and (= m1 (-> % :rep :m))
                                  (#{:bj :ej} (-> % :rep :mjpact)))
                         (:name %))
                      (:transitions pn))
        m1-start (some #(when (and (= m1  (-> % :rep :m))
                                   (#{:aj :sm} (-> % :rep :mjpact)))
                          (:name %))
                       (:transitions pn))
        end-to-waiting   (assoc (pnu/make-arc pn m1-end (:name waiting)) :bind {:jtype :blue})
        waiting-to-start (assoc (pnu/make-arc pn (:name waiting) m1-start) :bind {:jtype :blue})]
    (if (and m1-end m1-start)
      (cond-> pn
          true (pnu/add-pn waiting)
          true (pnu/add-pn end-to-waiting)
          true (pnu/add-pn waiting-to-start)
          (not (util/next-machine pn m1)) (remove-wrap-places m1 m2)
          true add-flow-priorities
          true util/reasonably-marked-pn)
      (throw (ex-info "Couldn't find pieces for add-buffer" {:pn pn :m1 m1 :m2 m2})))))

(defn remove-wrap-places
  "Remove the ability to go from the last machine back to the first."
  [pn m1 m2]
  (let [places (get (util/iface-places pn) [m1 m2])]
    (reduce (fn [pn place]
              (-> pn
                  (update :places (fn [ps] (vec (remove #(= (:name %) place) ps))))
                  (update :arcs   (fn [as] (vec (remove #(or (= (:source %) place)
                                                                  (= (:target %) place))
                                                             as))))))
            pn
            places)))

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
          (update ?i :history conj {:op :remove-place :place pl :from (:id ?i)}))
      {:skip :remove-place :msg "no qualifying place"})))

(defmethod mutate-m :remove-trans [inv & args]
  (let [tr (:name (random-trans (:pn inv) :subset #(remove (fn [tr] (:visible? tr)) %)))]
    (if (> (-> inv :transitions count) 1)
      (-> inv
        (update-in [:pn :transitions] (fn [ts] (vec (remove #(= % tr) ts))))
        (update-in [:pn :arcs] (fn [arcs] (vec (remove #(or (= (:source %) tr)
                                                               (= (:target %) tr)) arcs))))
        (update    :history conj {:op :remove-trans :trans tr :from (:id inv)}))
      {:skip :remove-trans :msg "too few"})))

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
        (update :history conj {:op :remove-or-dec-arc :arc (:name ar) :from (:id inv)}))
    {:skip :remove-arc :msg "No arc"}))

;;;------------------ Swap -----------------------------
(defn swap-arcs
  "Swap use of places pl1 and pl2 in the arcs of the PN. Works on trans too!"
  [pn pl1 pl2]
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

(defmethod mutate-m :swap-priority [inv & args]
  (let [pn (:pn inv)
        candidates (filter #(> (count (pnu/arcs-outof pn %)) 1)
                           (map :name (:transitions pn)))]
    (if (not-empty candidates)
      (let [trans (rand-nth candidates)
            pref (ref (pnu/arcs-outof pn trans))
            arc1 (util/pick-from-ref! pref)
            arc2 (util/pick-from-ref! pref)
            p1 (:priority arc1)
            p2 (:priority arc2)]
        (-> inv
            (assoc-in [:pn :arcs (pnu/arc-index pn (:name arc1)) :priority] p2)
            (assoc-in [:pn :arcs (pnu/arc-index pn (:name arc2)) :priority] p1)
            (update :history conj {:op :swap-priority  :arc1 (:name arc1) :arc2 (:name arc2) :from (:id inv)})))
      {:skip :swap-priority :msg "no candidates"})))

(defmethod mutate-m :bbs-to-bas [inv & args]
  (let [pn (:pn inv)
        machines (util/machines-of pn)
        bbs-machines (filter #(util/bbs? pn %) machines)]
    (if (not-empty bbs-machines)
      (let [machine (rand-nth bbs-machines)
            muted (bbs-bas-switch pn machine :bbs2bas)]
        (if (pnu/pn? muted)
          (update muted :history conj {:op :bbs2bas :m machine})
          (update muted :history conj {:op :bbs2bas-failed! :m machine})))
      {:skip :bbs-to-bas :msg "no bbs machine"})))

(defmethod mutate-m :bas-to-bbs [inv & args]
  (let [pn (:pn inv)
        machines (util/machines-of pn)
        bas-machines (filter #(util/bas? pn %) machines)]
    (if (not-empty bas-machines)
      (let [machine (rand-nth bas-machines)
            muted (bbs-bas-switch pn machine :bas2bbs)]
        (if (pnu/pn? muted)
          (update muted :history conj {:op :bas2bbs :m machine})
          (update muted :history conj {:op :bas2bbs-failed! :m machine})))
      {:skip :bas-to-bbs :msg "no bas machine"})))

(defn bbs-bas-switch
  "Switch the argument machine from block-before-service to block-after-service."
  [pn m1 dir]
  (let [rtrans (get (util/related-trans pn) m1)]
    (when-let [m2 (util/next-machine pn m1)]
      (when-let [buffer (first (get (util/iface-places pn) [m1 m2]))]
        (when-let [done  (some #(when (= :bj (-> (pnu/name2obj pn %) :rep :mjpact)) %) rtrans)]
          (when-let [start (some #(when (#{:aj :sm} (-> (pnu/name2obj pn %) :rep :mjpact)) %) rtrans)]
            (when-let [arc (some #(when (and (= (:source %) (if (= dir :bbs2bas) done start))
                                             (= (:target %) buffer))
                                    (:name %))
                                 (:arcs pn))]
                (assoc-in pn [:arcs (pnu/arc-index pn arc) :source] (if (= dir :bbs2bas) start done)))))))))


;;;=====================================================================================
;;;  Evolution Algorithm
;;;=====================================================================================
(defn i-error
  "Compute the individual's score."
  [inv]
  (let [log (-> (app-info) :problem :scada-log)]
    (handling-evolve [inv]
      (as-> inv ?i
        (assoc ?i :disorder nil)
        (assoc ?i :except nil)
        (fit/exceptional-fitness ?i log)
        (fit/discipline-fitness ?i log)
        (assoc ?i :err (+ (:except ?i) (:discipline ?i)))))))

(def diag-timeouts (atom []))

(defn sort-by-error
  "Add value for :err to each PN and used it to sort the population by disorder.
   Where disorder is equal, prefer the one with less structure."
  [popu]
  (handling-evolve [popu]
   (let [favor-small? (-> (app-info) :gp-params :favor-smaller-pn?)]
     (as-> popu ?p
       (u4pmap/pmap-timeout1 i-error ?p 15000)
       ;(map i-error ?p)
       (map #(if (= (-> % keys set) #{:timeout})
                 (do (swap! diag-timeouts conj %)
                     (assoc (:timeout %) :err 123))
                 %)
              ?p)
       (vec (sort #(cond (< (:err %1) (:err %2)) true,
                         (and (== (:err %1) (:err %2)) favor-small?)
                         (< (pnu/pn-size (:pn %1)) (pnu/pn-size (:pn %2))),
                         :else false)
                  ?p))))))

(defn select
  "Select an individual from a sorted population using a tournament of given size."
  [population tournament-size]
  (let [size (count population)]
    (nth population
         (apply min (repeatedly tournament-size #(rand-int size))))))

(defn reset-spntools! []
;  (reset! pnr/+k-bounded+ (gp-param :pn-k-bounded))  ; these 
;  (reset! pnr/+max-rs+    (gp-param :pn-max-rs))     ; are 
;  (reset! pn/+max-states+ (gp-param :pn-max-states)) ; gspn
  (pnu/reset-ids! {}))

(defn reset-all! []
  (reset-spntools!)
  (reset! util/failed-evolve nil)
  (reset! util/+log+ []))

;;; Lee Spector's original were:
;;;   Basic eqn    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   Weather n    - 1/2  mutate, 1/4  cross over, 1/4 untouched,   selection pressure 7
;;;   even parity  - 1/10 mutate  8/10 cross over, 1/10 untouched,  selection pressure 5
(defn make-next-gen [world]
  "Compute the next generation, a combination of tournament selection, mutations and crossover
   of tournament winners, and elite individuals. Argument has :state (e.g. :continue, :success)
   start-time and population Invs"
  (handling-evolve [world]
     (let [e-cnt    (gp-param :elite-individuals)
           pop-size (gp-param :pop-size)
           pressure (gp-param :select-pressure)] ; POD I'm running 4 right now.
       (update world :pop
               (fn [?x]
                 (as-> ?x ?spop
                   (into (subvec ?spop 0 e-cnt)
                         (repeatedly (int (* 3/4 pop-size))
                                     #(mutate (select ?spop pressure)))) ; POD gp-param
                   ;;(repeatedly (* 2/8 (gp-param :pop-size)) #(crossover (select ?spop 7) (select ?spop 7)))
                   (loop [pop ?spop]
                     (if (>= (count pop) pop-size)
                       (subvec (vec pop) 0 pop-size)
                       (recur (conj pop (select ?x pressure)))))))))))

(defn evolve-success? [world]
  (cond (< (-> world :pop first :err)
           (gp-param :success-threshold))
        (assoc world :state :success),
        (>= (:gen world) (gp-param :max-gens))
        (-> world
            (assoc :state :failure)
            (assoc :reason :max-gens)),
        (> (- (System/currentTimeMillis)
              (:start-time world))
           (* 1000 (gp-param :timeout-secs)))
        (-> world
            (assoc :state :failure)
            (assoc :reason :timeout-secs)),
        :else world))

(def the-promise (ref nil))
(def the-future  (ref nil))

(defn evolve-init
  "Set up world map and initial population."
  [world]
  (println "evolve-init...")
  (if @the-future
    world ; already started.
    (do
      (reset-all!)
      (let [world (as-> {} ?w
                    (assoc ?w :gen 0)
                    (assoc ?w :state :init)
                    (assoc ?w :start-time (System/currentTimeMillis))
                    (assoc ?w :pop (initial-pop (gp-param :pop-size))))]
        (update-pop! (:pop world))
        world))))

(defn evolve-continue
  "Loop through generations until success, failure or paused
   On success or failure, put a message to that effect on the channel."
  [world prom]
  (println "evolve-continue...")
  (log {:in 'evolve-continue :world world})
  (reset! rep/pause-evolve? false)
  (loop [w world]
    (println "evolve-continue-loop, gen = " (:gen w) "...")
    (rep/pop-stats w)
    (as-> w ?w
      (assoc  ?w :state :running)
      (update ?w :pop #(sort-by-error %))
      (do (update-pop! (:pop ?w)) ?w)
      (update ?w :gen inc)
      (evolve-success? ?w)
      (rep/report-gen ?w)
      (cond @rep/pause-evolve?
            (do (rep/push-inv (-> ?w :pop first))
                (deliver prom ?w)
                (>!! (util/evolve-chan) "pause"))

            (= (:state ?w) :failure)
            (do (rep/push-inv (-> ?w :pop first))
                (deliver prom ?w)
                (>!! (util/evolve-chan) "abort")),

            (= (:state ?w) :success)
            (do (rep/push-inv (-> ?w :pop first))
                (deliver prom ?w)
                (>!! (util/evolve-chan) "success")),
            :else
            (recur (make-next-gen ?w))))))

;;; POD currently not doing anything with the world.
(defn evolve-continue-start
  "Setup for running the evolve loop, setting the-promise, the-future and a reaper process."
  [world]
  (if @the-future
    (do (println "Ignoring second continue.") world)
    (do (println "Starting future for evolve-continue")
        (dosync (ref-set the-promise (promise)))
        (dosync (ref-set the-future
                         (future (evolve-continue world @the-promise))))
        (future ; This is a last resort timeout method; see also evolve-success?
          (let [result (deref @the-promise ; yes, 'double deref'
                              (* 1000 (-> (app-info) :gp-params :timeout-secs))
                              :too-late)]
            (when (= result :too-late)
              (log "evolve-continue the-future expired.")
              (println "evolve-continue the-future expired.")
              (>!! (util/evolve-chan) "abort"))))
        world)))

;;; Both of the following get pushed when the client sends :sinet/evolve-run (see report.clj)
;;; (>!! (util/evolve-chan) "init")
;;; (>!! (util/evolve-chan) "continue")
;;; =====>>> In order to see changes in this function, you need to do a util/big-reset. <<<=======
(defn start-evolve-loop!
  "Called from app.clj when starting the app. Waits for messages. Never stops."
  [evolve-chan]  ; Can't use util/evolve-chan here. It is not set yet!
  (async/go-loop [world nil]
    (let [msg (<! evolve-chan)] ; parks thread, doesn't block.
      (println (str "in loop, msg = " msg))
      (log {:in "evolve-loop" :msg msg})
      (if (= msg "ABORT")
        (println "Leaving go; will need to run start-evolve-loop!.")
        (let [world (cond (= msg "init")
                          (evolve-init world), ; returns world map with population, etc.

                          (= msg "continue")   ; new future & promise and returns world
                          (evolve-continue-start world)

                          (= msg "pause")      ; continue-evolve will have delivered it.
                          (dosync (ref-set the-future nil)
                                  (deref @the-promise))

                          (= msg "report now!")
                          (do (println "world = " world)
                              ;(reset! diag {:world world})
                              world)

                          (= msg "success")
                          (dosync (println "success!")
                                  (ref-set the-future nil)
                                  (deref @the-promise))

                          (= msg "abort")
                          (dosync (println "aborting...")
                                  (when (future? @the-future)
                                    (future-cancel @the-future)) ; 2017-12-07 uncommented
                                  (ref-set the-future nil)
                                        ;(reset! diag {:world world})
                                  (ref-set the-promise nil)
                                  world))]
          (s/assert ::world world)
          (recur world))))))

(defn diag-simple-evolve
  "Run the program without async and GUI"
  []
  (reset-all!)
  (binding [*debugging* {}] ; basic debugging
    (let [world (as-> {} ?w
                  (assoc ?w :gen 0)
                  (assoc ?w :state :init)
                  (assoc ?w :start-time (System/currentTimeMillis))
                  (assoc ?w :pop (initial-pop (gp-param :pop-size))))]
      (update-pop! (:pop world))
      (loop [w world]
        (println "evolve-continue-loop, gen = " (:gen w) "...")
        (rep/pop-stats w)
        (as-> w ?w
          (assoc  ?w :state :running)
          (update ?w :pop #(sort-by-error %))
          (do (update-pop! (:pop ?w)) ?w)
          (update ?w :gen inc)
          (evolve-success? ?w)
          (rep/report-gen ?w)
          (cond (= (:state ?w) :failure) ?w
                (= (:state ?w) :success) ?w
                :else (recur (make-next-gen ?w))))))))

(defn diag-i-error
  []
  (reset-all!)
  (let [popu (-> (app-info) :pop)]
    (for [i (range (count popu))]
      (do (println "Inv " i)
          (i-error (nth popu i))))))

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
(def diag-all-inv (ref {}))
(defn diag-record-inv [inv]
  "Keep a map of EVERY Inv, check that it has a legit PN."
  (if (:save-invs? *debugging*)
    (let [inv (assoc inv :id (util/uuid))
          ;; pnu/validate-pn requires arcs-into/out-of trans >= 1. 
          errors [] #_(pnu/validate-pn (:pn inv))] 
      (dosync (alter diag-all-inv #(assoc % (:id inv) inv)))
      (when-not (empty? errors)
        (throw (ex-info "Bad PN" {:id (:id inv) :errors errors})))
      inv)
    inv))

;;; To stop it: (>!! (util/evolve-chan) "abort")
;;; Alternative is (diag-simple-evolve)
(defn diag-run
  "Run the GP in diagnostic mode from the REPL. A very useful function!"
  []
  (binding [*debugging* nil] ;<===== {:save-invs? true} to save every individual
    (dosync (ref-set diag-all-inv {}))
    (>!! (util/evolve-chan) "init")
    (>!! (util/evolve-chan) "continue")))

(defn diag-scada-patterns
  "pprint the scada-patterns."
  []
  (->> (app-info)
       :problem
       :patterns
       (map :form)
       ppprint))

(defn diag-push-inv [inv]
  "Push an individual to the web client for viewing"
  (-> inv
      (update :pn util/reasonably-marked-pn)
      rep/push-inv))

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

(defn diag-force-priority
  "Set PN priority as indicated by the argument. Anything not specified has priority=1."
  [pn priority-maps]
  (as-> pn ?pn
    (update ?pn :arcs (fn [arcs] (vec (map #(assoc % :priority 1) arcs))))
    (update ?pn :arcs
            (fn [arcs] (reduce (fn [arcs pr]
                                 (if-let [ar (some #(when (and (= (:source %) (:source pr))
                                                               (= (:target %) (:target pr)))
                                                      %)
                                                   arcs)]
                                   (assoc-in arcs [(pnu/arc-index pn (:name ar)) :priority] (:priority pr))
                                   arcs))
                               arcs priority-maps)))))

;;; [{:act :m1-start-job, :mjpact :aj, :m :m1}
;;;  {:act :m1-complete-job, :mjpact :bj, :m :m1, :bf :b1}
;;;  {:act :m2-start-job, :mjpact :sm, :m :m2, :bf :b1}
;;;  {:act :m2-complete-job, :mjpact :ej, :m :m2}]
;;; 2017-10-07 I don't think this is needed. Worked on :rep, and I switched to using pretty-fied.
#_(defn diag-force-rep
  "Set the :rep of each transition according to the argument map."
  [pn rep-vec]
  (update pn :transitions
          (fn [t]
            (reduce (fn [tvec cmd]
                      (update-in tvec [(pnu/trans-index pn (:act cmd)) :rep]
                                 #(merge % (dissoc cmd :act))))
                    t rep-vec))))

;;; (diag-inject-pn "data/PNs/m2-inhib-bas.xml" 10 [{:source :m1-start-job, :target :buffer :priority 2}])
;;; Highest priority (lowest priority number) gets the newest tokens.
;;; Thus here we want:
;;;    - m1-start-job to buffer be a low priority, sending the old part to the buffer.
;;;    - m2-start-job doesn't matter; it is a "fan in", will take the newest.
(defn diag-inject-pn2
  "Read the PN and insert it in the population, replacing the individual specified."
  [fname ix priorities]
  (let [pn (-> (load-file fname)
               add-color-binding
               (diag-force-priority priorities))]
    (update-pop!
     (assoc (-> (app-info) :pop) ix
            (map->Inv {:pn pn})))))

(defn diag-inject-pn1
  "Read the PN and insert it in the population, replacing the individual specified."
  [pn ix]
    (update-pop!
     (assoc (-> (app-info) :pop) ix
            (map->Inv {:pn pn}))))

;(def pnpn (-> (initial-pop 1) first :pn))
;(def iii  (-> (initial-pop 1) first))

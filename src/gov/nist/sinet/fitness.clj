(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.sinet.simulate :as sim :refer-only (simulate)]
            [gov.nist.sinet.util :as util :refer (app-info reset)]))

;;; ToDo: Currently fitness only concerns violation of partial orders it should
;;;       additionally include:
;;;         0) Checking for work flows that are not reflected in the log. 
;;;         1) Dynamic response (from Q matrix or simulation)
;;;         2) Association to being blocked/unblocked starved/unstarved.
;;;            This is some sort of function relating tokens in places to messages.
;;;            Maybe this is a place for a NN classifier. The idea here being that
;;;            you develop a classifier (for a given individual) and then employ it
;;;            to inject predictions of message types in the execution of the individual.
;;;            (If the individual scores better without the NN, then just consider that
;;;            its best score. (The question then becomes, how would you use this in
;;;            the downstream analytical process? A: Maybe you don't really, but it
;;;            nonetheless helps the fitness of the individual.) 

(def ^:private diag (atom nil))
;;;===========================================
;;; QPN
;;;===========================================
;;; POD only collects from :act messages currently (no :on-act)
;;;  {:act :ej, :m :m2, :j [46], :fire :m2-complete-job}
(defn qpn-gather-tkn
  "Return every mention of token id in chronological order."
  [log tkn-id]
  (filter (fn [msg]
            (and (contains? msg :act)
                 #_(some #(= % tkn-id) (:j msg))
                 ;; POD not too sure about just using the newest token here. 
                 (when (not-empty (:j msg))
                   (== tkn-id (apply max (:j msg))))))
          log))

(declare act2trans)
;;; POD Because I'm focusing on jobs here (qpn-gather-job), at some point I'm going to have to account for
;;; lines in the log that were not addressed by qpn-gather-job (and the things in-between it).
(defn qpn-act-is-intro? [pn act]
  "Return true if the named transition has an arc exiting it that 
   introduces a token."
  (let [trans (act2trans pn act)]
    (some #(= :intro (-> % :bind :act))
          (filter #(= (:source %) trans) (:arcs pn)))))

;;; If qpn-act-is-intro? and this is not first mention of the token, then it is recycling.
;;; An example is {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]} above.
;;; Here I remove those. 
(defn qpn-log-about
  "Return in chronological order log entries about the argument tkn-id.
   This removes messages concerning the introduction of a token that is not the argument token."
  [pn tkn-id]
  (remove (fn [msg]
            (and (qpn-act-is-intro? pn (:act msg))
                 (some #(> (:id %) tkn-id) (:tkns msg))))
          (qpn-gather-tkn (-> pn :sim :log) tkn-id)))

;;; POD not used yet, but useful. 
(defn qpn-characterize-tkn-trace
  "Return a map describing the relative frequency that each event occurs in a token trace."
  [log tkn-id]
  (let [acts (distinct (map :act (qpn-gather-tkn log tkn-id)))]
    (reduce (fn [distrib msg]
              (update-in distrib [(:act msg)] inc))
            (zipmap acts (repeat (count acts) 0))
            (filter #(contains? % :act) log))))

;;; This is only called when there aren't many jobs. Typically, just one. 
#_(defn qpn-typical-job-id
  "Return log entry from (statistically) most typical jobs (a statistical analysis)."
  [pn]
  ;; Check variance across qpn-c-t-t; use it (and process pattern) to determine job types.
  ;(NYI)
  ;; Of the types, choose one (a safe one).
  (let [tkn-id (max (Math/round (/ (-> pn :sim :max-tkn) 2.0)) 1)]
    (vector ; POD current assume just one job type. 
     (loop [log (qpn-gather-tkn (-> pn :sim :log) tkn-id) ; this collects just :acts
            trace []]
       (let [msg (first log)]
         (cond (empty? log) trace, 
               (some #(= (:act %) (:act msg)) trace) trace,
               :else (recur (next log) (conj trace msg))))))))
            
;;;===========================================
;;; Fitness measure
;;;===========================================
(defn act2trans
  "Return the transition (its name) responsible for the argument act."
  [pn act]
  (some #(when (= act (-> % :rep :act)) (:name %))
        (:transitions pn)))

#_(defn diag-describe-pn-transition-binding
  [pn]
  (zipmap (map :name (:transitions pn))
          (map #((:fn %) :job-x) (:transitions pn))))

(defn violates?
  "Return true if the qpn-job violates the argument relation."
  [qpn-job relation]
  (not (relation qpn-job)))

(defn avg-scada-process-steps
  "Calculate the weighted average number of steps in a SCADA pattern."
  [patterns]
  (let [npat (count patterns)]
    (when (zero? npat)
      (throw (ex-info "Insufficient data to find a pattern" {})))
    (let [njobs (apply + (map #(:njobs %) patterns))]
      (/ (apply + (map #(* (/ (:njobs %) njobs) (count (:form %))) patterns))
         npat))))

;;; Example scada pattern:
;;;({:id 3,
;;;    :form [{:act :aj, :jt :*} {:act :bj, :bf :b1, :n :*} {:act :sm, :bf :b1, :n :*} {:act :ej, :m :m2}],
;;;    :relations
;;;    [#function[gov.nist.sinet.scada/ordering-fn/fn--19018]...]
;;;    :njobs 244})

;;; +1 for every precedence constraint violated. +1 for each act not manifest in the QPN log. 
;;; Will need something more for loops, but we'll get to that later.
(defn calc-process-disorder
  "For a single QPN job-trace, return a map {:score <> :pattern-id <>} indicating the 
   score and pattern-id from the best matching SCADA patterns. Note that in assembly lines,
   there is only one SCADA pattern."
  [job-trace patterns]
  (loop [pats patterns
         best {:score 99999 :pattern-id -1}]
    (let [pat (first pats)
          ;; How many of the pattern actions are represented in this QPN trace?
          ;; POD Should this also consider acts in the qpn job trace but not in the pattern?
          nact-diff (Math/abs (- (count job-trace)
                                 (count (set/intersection (set (map :act (:form pat)))
                                                          (set (map :act job-trace))))))
          nviolates (reduce (fn [score rel] (if (violates? job-trace rel) (inc score) score))
                            0
                            (:relations pat))
          this-score (+ nact-diff nviolates)
          best  (if (< this-score (:score best))
                  {:score this-score :pattern-id (:id pat)}
                  best)]
      (cond (== this-score 0) {:score 0 :pattern-id (:id pat)}
            (empty? (next pats)) best
            :else (recur (next pats) best)))))

(defn trunc-qpn-log-at-cycle
  "Return a log that stops when it sees the same message a second time on the same job."
  [qpn-log]
  (loop [log qpn-log
         short-log []]
    (let [msg (first log)]
      (if (or (empty? log) (some #(= msg %) short-log))
        short-log
        (recur (next log) (conj short-log msg))))))

;;; SCADA log processes produces multiple patterns. There is one pattern per colour for
;;; a transfer/flow or assembly line. Associated with each colour-tagged
;;; pattern are sojourn times and breakdown/repair rates. (POD, that is a ToDo!)
;;; workflow-fitness looks at a range (tkn-range) of qpn jobs, finding the error in each relative
;;; to the (typically one) SCADA log pattern, producing the average error relative to this pattern.

;;; What is the GP doing?
;;;   1) It is finding a PN that best matches the log. That PN has colour. SCADA logs
;;;      also have colour. The PNs could have multiple paths for different job types or
;;;      could combine paths where that makes more sense. 

;;; The individuals have to cope with all job types. I will keep scores on how well
;;; the PN does against each SCADA job type (colour). Then I can use crossover to combine
;;; the best of multiple colour paths. (One Inv does well on blue, another does well on red...)
;;; Maybe the GP is two-phase, where the first phase optimises for individual colours (no crossover)
;;; and the second phase predominantly does crossover on these individuals. Maybe they aren't
;;; so much phases as a function that increases the portion of crossovers as the colour-wise
;;; scores increase. Early on, perhaps scoring is about being good at one color, and later about
;;; being good at all of them. Maybe in addition to increasing cross-over, I penalize more for
;;; not handling multiple types (and do this by weighting, according to the proportion of each job
;;; type seen).

;;; So that's all good, but what do I mean by "does well on blue" etc.? With the SCADA log
;;; I'll have information about workstation reliability, colour of jobs, and time spent on
;;; at each workstation. I can keep patterns for each color. Indeed, it is not even necessary
;;; that something is reported at each workstation -- some workstations in the line could
;;; "disappear" and there would be a different section of path for some color where this occurs.
;;; I don't think there is a challenge here except in finding buffer sizes. Maybe that is a good
;;; thing. Do the ANN on the buffer size and be done with it. (BTW, maybe there are similar
;;; problems such as not having sufficient carriers, etc.)

;;; A problem here is that I don't have anything in the GP fitness measurement currently that
;;; would encourage the introduction of inhibitor arcs (and their multiplicity) as means of
;;; specifying buffer capacity. Should I just explicitly edit the PN according to the results
;;; of the ANN classification? (And how exactly do you I get the ANN to tell me that it is
;;; focusing on the quantity of tokens in place x?)

;;; The steady-state and dynamic analyses are looking more and more like validation activities.
;;; Maybe I translate to DES to do these. (Do I feed back the results? How? What?)

;;; A potentially negative aspect of the above is that it may completely separates jobs of
;;; different types. Can this be fixed with flexible cross-over? For example, I could 
;;; make some part of the red/blue, another part of the path separate red and blue. 


;;; (workflow-fitness (:pn i1) (:scada-patterns +problem+)) ; i1 is in the file data/test-m2-bas.clj
;;; Problem here is to run enough steps to get enough jobs to be able to trim some.
;;; POD Note that this treats jobs that return to workstation as damaged. 
(defn workflow-fitness
  "Generate a QPN log for the PN and return the score WRT SCADA patterns. The disorder score is the
   average (across a range of complete QPN jobs) of the process disorder of the best matched process.
   If there are very few jobs (perhaps because :elim :intro weirdness), then just score them.
   The total score is (currently) disorder score + weighted number of vertices in the individual.
   That latter term is intended to discourage individuals that add pointless structure. "
  [inv]
  (let [patterns (-> (util/app-info) :problem :scada-patterns)
        pn (sim/simulate (:pn inv) :max-steps (* 50 (avg-scada-process-steps patterns)))
        max-tkn (-> pn :sim :max-tkn) ; max-tkn is number of tokens generated by sim.
        warm-up (-> (util/app-info) :gp-params :aqpn-warm-up)
        disorder (if (> max-tkn 20)
                   (let [tkn-range (range warm-up (- (-> pn :sim :max-tkn) warm-up))
                         sum-error (reduce (fn [sum tkn-id] ; sum disorder on simulation job.
                                             ;; POD I am not using :pattern-id yet. Needs thought. 
                                             (+ sum (:score (calc-process-disorder (qpn-log-about pn tkn-id) patterns))))
                                           0
                                           tkn-range)]
                     ;; Average over all the jobs. 
                     (double (/ sum-error (count tkn-range))))
                   ;; Otherwise at most just a few jobs. It is either not eliminating jobs-ids, or 
                   ;; not even creating a log. 
                   (let [tkn-id (max (Math/round (/ (-> pn :sim :max-tkn) 2.0)) 1)
                         qpn-log (qpn-log-about pn tkn-id)]
                     (+ (-> (util/app-info) :gp-params :no-new-jobs-penalty)
                        (if (empty? qpn-log)
                          (-> (util/app-info) :gp-params :no-qpn-log-penalty)
                          (:score (calc-process-disorder
                                   (trunc-qpn-log-at-cycle qpn-log)
                                   patterns))))))]
    (-> inv
        (assoc :disorder disorder)
        (assoc :err      disorder))))

;;; These are useful to understanding how things work. 
;;; This one for an Eden INV:
#_(def eee
    (let [pn (->> (gov.nist.sinet.scada/random-job-trace)
                  (gov.nist.sinet.gp/initial-individual-pn))]
      (-> (gov.nist.sinet.gp/map->Inv {:pn pn})
          gov.nist.sinet.gp/add-scada-report-fns
          gov.nist.sinet.gp/add-color-binding
          (update :pn
                  (fn [pn]
                    (reduce (fn [pn trans] (gov.nist.sinet.gp/assign-flow-priorities pn trans))
                            pn
                            (->> pn :transitions (map :name))))))))

;;; This one to show it on the client: (not working; I don't know why.)
#_(-> eee
      gov.nist.sinet.gp/inv-geom
      gov.nist.sinet.gp/clean-inv-for-transmit
      gov.nist.sinet.gp/diag-push-pn)

;;; This one for a typical-job:
;;;(def jjj (-> eee :pn (sim/simulate :max-steps 50) (qpn-log-about 1) trunc-qpn-log-at-cycle))
;;; ==> 
;;;[{:tkns [{:jtype :blue, :id 1}], :rep {:name :m1-start-job, :act :aj, :m :m1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m2-complete-job, :act :ej, :m :m2}}]

;;; This one (finally!) to calculate job disorder:
;;; (calc-process-disorder jjj (-> (util/app-info) :problem :scada-patterns))
;;; ==> 0 (but of course it is going to get hit for not introducing a new token.

(defn diag-one-that-runs
  "Return the first PN that can generate at least modest amount of log!"
  []
  (some #(let [pn (sim/simulate (:pn %) :max-steps 100)]
           (when (> (-> pn :sim :log count) 20) %))
        (-> (util/app-info) :pop)))

;;; POD NYI    
#_(defn diag-process-disorder
  "Report how messed up this PN is." 
  [inv]
  (let [patterns (-> (util/app-info) :problem :scada-patterns)
        sim (-> inv :pn (sim/simulate :max-steps (* 50 (avg-scada-process-steps patterns))))]))

;;; This needs to be commented out. (load order)
#_(defn m2-inhib-bas
  "Setup the m2-inhib-bas PN for a fitness test"
  [steps]       ;     Change...
  (let [pn (-> "/Users/peterdenno/Documents/git/spntools/data/m2-inhib-bas.xml" 
               gov.nist.spntools.core/run-ready
               gov.nist.sinet.gp/add-color-binding
               (gov.nist.sinet.gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
               (gov.nist.sinet.gp/diag-force-rep
                [{:name :m1-start-job, :act :aj, :m :m1}
                 {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}
                 {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}
                 {:name :m2-complete-job, :act :ej, :m :m2}])
               (sim/simulate :max-steps steps))]
    (workflow-fitness (util/map->Inv {:pn pn}))))

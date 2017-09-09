(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.sinet.simulate :as sim :refer-only (simulate)]
            [gov.nist.sinet.util :as util :refer (app-info)]))

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

(def diag (atom nil))
;;;===========================================
;;; QPN
;;;===========================================
;;; POD only collects from :act messages currently (no :on-act)
(defn qpn-gather-tkn
  "Return every mention of token id in chronological order."
  [log tkn-id]
  (filter (fn [msg]
            (and (contains? msg :rep)
                 (some #(= (:id %) tkn-id) (:tkns msg))))
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
  "Return in chronologicl order log entries about the argument tkn-id.
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

;;; +1 for every precedence constraint violated. +1 for each act not manifest in the QPN log. 
;;; Will need something more for loops, but we'll get to that later.
(defn calc-process-disorder
  "Return the best score from matching the argument job against every SCADA pattern."
  [job patterns]
  (loop [pats patterns
         start-score 99999]
    (let [nact-diff (Math/abs (- (count job) (count (:form (first pats)))))
          nviolates (reduce (fn [score rel] (if (violates? job rel) (inc score) score))
                            0
                            (:relations (first pats)))
          this-score (+ nact-diff nviolates)]
      (cond (= this-score 0) 0
            (empty? (next pats)) this-score
            :else (recur (next pats) (min this-score start-score))))))

(defn trunc-qpn-log-at-cycle
  "Return a log that stops when it sees the same message a second time on the same job."
  [qpn-log]
  (loop [log qpn-log
         short-log []]
    (let [msg (first log)]
      (if (or (empty? log) (some #(= msg %) short-log))
        short-log
        (recur (next log) (conj short-log msg))))))

;;; (workflow-fitness (:pn i1) (:scada-patterns +problem+)) ; i1 is in the file data/test-m2-bas.clj
;;; Problem here is to run enough steps to get enough jobs to be able to trim some.
;;; POD Note that this treats jobs that return to workstation as damaged. 
(defn workflow-fitness
  "Generate a QPN log for the PN and return the score WRT SCADA patterns. The score is the
   average (across all complete jobs) of the process disorder of the best matched process.
   If there are very few jobs (perhaps because :elim :intro weirdness), then just score them."
  [inv]
  (let [pn (:pn inv)
        patterns (-> (util/app-info) :problem :scada-patterns)
        no-new-jobs-penalty (-> (util/app-info) :gp-params :no-new-jobs-penalty)]
    (if-let [errs (not-empty (pnu/validate-pn pn))] ; POD TEMPORARY!
      (do
        #_(reset! diag {:errors errs :inv inv})
        (util/log {:errors errs :id (:id inv)})
        #_(throw (ex-info "Invalid PN" {:errors errs :inv inv}))
        (double (count errs)))
      (let [pn (sim/simulate pn :max-steps (* 50 (avg-scada-process-steps patterns)))
            max-tkn (-> pn :sim :max-tkn) ; max-tkn is number of tokens generated by sim.
            warm-up (-> (util/app-info) :gp-params :aqpn-warm-up)]
        (if (> max-tkn 20)
          (let [tkn-range (range warm-up (- (-> pn :sim :max-tkn) warm-up))
                total-error (reduce (fn [sum tkn-id] ; sum disorder on simulation job. 
                                      (+ sum (calc-process-disorder (qpn-log-about pn tkn-id) patterns)))
                                    0
                                    tkn-range)]
            (double (/ total-error (count tkn-range))))
          ;; Otherwise just a few jobs. It is likely to be not eliminating jobs-ids, so
          ;; we'll truncated it at the first cycle. 
          (let [tkn-id (max (Math/round (/ (-> pn :sim :max-tkn) 2.0)) 1)]
            (+ no-new-jobs-penalty
               (calc-process-disorder
                (-> pn (qpn-log-about tkn-id) trunc-qpn-log-at-cycle)
                patterns))))))))

;;; These are useful to understanding how things work. 
;;; This one for an Eden INV:
#_(def eee
    (let [pn (->> (gov.nist.sinet.scada/random-job-trace)
                  (filter (fn [msg] (contains? msg :j)))
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
  (some #(let [sim (sim/simulate (:pn %) :max-steps 100)]
           (when (> (-> sim :log count) 20) %))
        (-> (util/app-info) :pop)))

(defn diag-simulate
  "Run the individual a bit an print its log."
  [inv]
  (let [pn (sim/simulate (:pn inv) :max-steps 50)]
;    (doall (map println (-> pn :sim :log)))
    pn))

;;; POD NYI    
(defn diag-process-disorder
  "Report how messed up this PN is." 
  [inv]
  (let [patterns (-> (util/app-info) :problem :scada-patterns)
        sim (-> inv :pn (sim/simulate :max-steps (* 50 (avg-scada-process-steps patterns))))]))

#_(defn m2-inhib-bas
  "Does 'the' correct answer score 0?"
  []
  (as-> "/Users/pdenno/Documents/git/spntools/data/m2-inhib-bas.xml" ?inv
    (gov.nist.sinet.gp/map->Inv {:pn (pn/run-ready ?inv)})
    (gov.nist.sinet.gp/add-scada-report-fns ?inv)
    (gov.nist.sinet.gp/add-color-binding ?inv)
    (update ?inv :pn
            (fn [pn]
              (reduce (fn [pn trans] (gov.nist.sinet.gp/assign-flow-priorities pn trans))
                      pn
                      (->> pn :transitions (map :name)))))
    #_(workflow-fitness ?inv)))

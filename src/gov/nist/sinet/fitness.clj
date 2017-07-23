(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.simulate :as sim :refer (simulate)]))

;;; ToDo: Currently fitness only concerns violation of partial orders it should
;;;       additionally include:
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

(def +diag+ (atom nil))
;;;===========================================
;;; QPN
;;;===========================================
;;; POD only collects from :act messages currently (no :on-act)
(defn qpn-gather-tkn
  "Return every mention of token id in chronological order."
  [log tkn-id]
  (filter (fn [msg]
            (and (contains? msg :act)
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

;;; POD this will have to updated for colour, currently I assume just one job type.
(defn qpn-typical-jobs
  "Return isolated log entry from typical jobs (a statistical analysis)."
  [pn]
  ;; Check variance across qpn-c-t-t; use it (and process pattern) to determine job types.
  ;(NYI)
  ;; Of the types, choose one (a safe one).
  (let [tkn-id (Math/round (/ (-> pn :sim :max-tkn) 2.0))]
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
  (some #(when (= act (:act ((:fn %) :arg-do-not-matter))) (:name %))
        (filter #(contains? % :fn) (:transitions pn))))

(defn diag-describe-pn-transition-binding
  [pn]
  (zipmap (map :name (:transitions pn))
          (map #((:fn %) :job-x) (:transitions pn))))

(defn violates?
  "Return true if the qpn-job violates the argument relation."
  [qpn-job relation]
  (not (relation qpn-job)))

(def +qpn-warm-up+ "Ignore this number of tokens on both ends of the log." 5)

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

;;; (workflow-fitness (:pn i1) (:scada-patterns +problem+)) ; i1 is in the file data/test-m2-bas.clj
;;; Problem here is to run enough steps to get enough jobs to be able to trim some. 
(defn workflow-fitness
  "Generate a QPN log for the PN and return the score WRT SCADA patterns. The score is the
   average (across all complete jobs) of the process disorder of the best matched process.
   If there are very few jobs (perhaps because :elim :intro weirdness), then just score them."
  [pn patterns no-new-jobs-penalty]
  (let [pn (sim/simulate pn :max-steps (* 50 (avg-scada-process-steps patterns)))
        max-tkn (-> pn :sim :max-tkn)]
    ;(println "max-tkn =" max-tkn)
    (if (> max-tkn 20)
      (let [tkn-range (range +qpn-warm-up+ (- (-> pn :sim :max-tkn) +qpn-warm-up+))
            total-error (reduce (fn [sum tkn-id]
                                  (+ sum (calc-process-disorder (qpn-log-about pn tkn-id) patterns)))
                                0
                                tkn-range)]
        (double (/ total-error (count tkn-range))))
      ;; Otherwise just a few jobs
      (let [typical-job (first (qpn-typical-jobs pn))]
        (+ no-new-jobs-penalty
           (calc-process-disorder typical-job patterns))))))
          




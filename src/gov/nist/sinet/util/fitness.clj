(ns gov.nist.sinet.util.fitness
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :refer (union difference intersection)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]
            [gov.nist.spntools.util.simulate :as sim :refer (simulate)]))

;;; Purpose: Fitness test

(defn preprocess-log
  "Add line numbers. This is used by hand on the datafile."
  [data]
  (reduce (fn [data n] (assoc-in data [:log n :line] n))
          data (range (count (:log data)))))

(defn scada-gather-job
  "Return every mention of of job-id in chronological order."
  [data job-id]
  (filter  #(= (:j %) job-id) data))
  
(defn scada-all-job-ids
  "Return a vector of all job-ids found in the data"
  [data]
  (sort (distinct (map :j (filter #(contains? % :j) data)))))

 (def +pattern-reserves+ "keys that are preserved in patterns" #{:act :jt :bf :m :n})
 
(defn make-pattern
  [msgs pattern-id]
  {:id pattern-id
   :form
   (as-> msgs ?msgs
     (map #(reduce (fn [msg key] (dissoc msg key)) ; remove unnecessary keys
                   %
                   (difference (set (keys %)) +pattern-reserves+))
          ?msgs)
     (map #(reduce (fn [msg key] (if (contains? msg key) (assoc msg key \*) msg))
                   % ; wildcard certain msg vals
                   [:jt :bf :n :m])
          ?msgs)
     (vec ?msgs))})

(defn match-msg?
  "Return true if msg matches form"
  [msg form]
  (every? (fn [key]
           (or (and (= (key form) \*) (contains? msg key))
               (= (key form) (key msg))))
          (keys form)))

(defn match-pattern?
  "Return true if msgs matches pattern"
  [msgs pattern]
  (let [form (:form pattern)]
    (and (= (count msgs) (count form))
         (every? (fn [n] (match-msg? (nth msgs n) (nth form n)))
                 (range (count form))))))

(declare all-scada-patterns trim-patterns scada-ordering-relations act2trans)
(defn scada-patterns
  "Compute SCADA patterns."
  [log]
  (as-> (:log log) ?pats ; POD fix this! All this preprocessing
    (all-scada-patterns ?pats)
    (trim-patterns ?pats 5 5)
    (map #(assoc % :relations (scada-ordering-relations %)) ?pats)))
       
;;; POD Probably want start and stop point for every occurrence. 
(defn all-scada-patterns
  "Return a vector of all the job patterns found in the SCADA log."
  [data]
  (let [pattern-id (atom -1)]
    (reduce (fn [patterns job-id]
              (let [job (scada-gather-job data job-id)
                    matches (filter #(match-pattern? job %) patterns)]
                (if (empty? matches)
                  (conj patterns (assoc (make-pattern job (swap! pattern-id inc)) :jobs [job-id]))
                  (reduce (fn [patterns id]
                            (update-in patterns [id :jobs] #(conj % job-id)))
                          patterns (map :id matches)))))
            [] (scada-all-job-ids data))))

(defn trim-patterns
  "Trim up to ntrim patterns from the ends of the pattern vector if they account for only a few (njobs) jobs.
   These are quite likely to be fragments of the complete log for these jobs."
  [patterns ntrim njobs]
  (let [size (count patterns)]
    (reduce (fn [patterns id]
              (let [p (some #(when (= (:id %) id) %) patterns)]
                (if (< (count (:jobs p)) njobs)
                  (remove #(= % p) patterns)
                  patterns)))
            patterns
            (into (range (- size ntrim) size) (range ntrim)))))

(defn pos-in-trace
  "Return the position of the argument action in the argument QPN process trace."
  [trace act]
  (let [^clojure.lang.PersistentVector acts (vec (map :act trace))
        idx (.indexOf acts act)]
    (if (< idx 0) nil idx)))

(defn ordering-fn
  "Return a function : trace -> boolean indicating whether 
   the ordering relationship is violated by the argument QPN process trace."
  [x y]
  (fn [trace] (<= (pos-in-trace trace x) (pos-in-trace trace y))))

(defn scada-ordering-relations
  "Calculate ordering functions for a SCADA pattern."
  [p]
  (loop [events (:form p)
         ordering []]
    (if (empty? (rest events))
      ordering
      (recur
       (next events)
       (into ordering
             (reduce (fn [m s] (conj m (ordering-fn (:act (first events)) (:act s))))
                     []
                     (rest events)))))))

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

;;;===========================================
;;; Fitness measure
;;;===========================================
(defn act2trans
  "Return the transition (its name) responsible for the argument act."
  [pn act]
  (some #(when (= act (:act ((:fn %) :foobar))) (:name %))
        (:transitions pn)))

(defn violates?
  "Return true if the qpn-job violates the argument relation."
  [qpn-job relation]
  (not (relation qpn-job)))

(def qpn-warm-up "Ignore this number of tokens on both ends of the log." 20)

;;; +1 for every precedence constraint violated. 
;;; Will need something more for loops, but we'll get to that later.
(defn calc-process-disorder
  "Return the best score from matching the argument job against every SCADA pattern."
  [job patterns]
  (loop [pats patterns
         score 99999]
    (let [this-score (reduce (fn [score rel]
                               (if (violates? job rel) (inc score) score))
                             0
                             (:relations (first pats)))]
      (cond (= this-score 0) 0
            (empty? (next pats)) score
            :else (recur (next pats) (min this-score score))))))

(load-file "data/test-individuals/test-m2-bas.clj") ; defines test-m2-bas

;(workflow-fitness test-m2-bas (:scada-patterns +problem+))
(defn workflow-fitness
  "Generate the QPN log and score it WRT SCADA patterns (calculate activity disorder)."
  [pn patterns]
  (let [pn (sim/simulate pn 300)
        tkn-range (range qpn-warm-up (- (-> pn :sim :max-tkn) qpn-warm-up))
        total-error (reduce (fn [sum tkn-id]
                              (calc-process-disorder
                               (qpn-log-about pn tkn-id)
                               patterns))
                            0
                            tkn-range)]
    (double (/ total-error (count tkn-range)))))


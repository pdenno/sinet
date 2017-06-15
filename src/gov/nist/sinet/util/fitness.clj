(ns gov.nist.sinet.util.fitness
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :refer (union difference intersection)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]))

;;; Purpose: Fitness test

(defn preprocess-log
  "Add line numbers. Called from data file."
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
       
;;; POD Probably want start and stop point for every occurrence. 
(defn scada-patterns
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
              (if-let [p (some #(when (= (:id %) id) %) patterns)]
                (if (< (count (:jobs p)) njobs)
                  (remove #(= (:id %) id) patterns)
                  patterns)
                patterns))
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

(defn scada-pattern-ordering
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
(defn qpn-all-job-ids
  "Return a vector of all job-ids found in the data"
  [data]
  (-> (mapcat (fn [msg] (map :id (:tkns msg)))
              (filter #(contains? % :act) data))
      distinct
      sort))
 
;;; POD only collects :act currently
(defn qpn-gather-job
  "Return every mention of job-id in chronological order."
  [data job-id]
  (filter  (fn [msg]
             (and (contains? msg :act)
                  (some #(= (:id %) job-id) (:tkns msg))))
           data))

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
(defn clean-qpn-job
  "Remove messages concerning the introduction of a token that is not the argument token."
  [pn tkn-id qpn-job]
  (remove (fn [msg]
            (and (qpn-act-is-intro? pn (:act msg))
                 (some #(> (:id %) tkn-id) (:tkns msg))))
          qpn-job))

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

;;; +1 for every precedence constraint violated. 
;;; Will need something more for loops, but we'll get to that later. 
(defn calc-activity-disorder
  "Compute how well a QPN job follows a given SCADA pattern."
  [pn scada-pattern tkn-id qpn-job]
  (let [cqpn-job (clean-qpn-job pn tkn-id qpn-job)
        ordering-rels (scada-pattern-ordering scada-pattern)]
    (reduce (fn [score rel] (if (violates? cqpn-job rel) (inc score) score))
            0
            ordering-rels)))
    
#_(defn workflow-fitness
  "Score the QPN-generated log with respect to the SCADA log."
  []
  (qpn-patterns 
  ))



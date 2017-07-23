(ns gov.nist.sinet.scada
  "Read and process SCADA data."
  (:require [clojure.set :refer (union difference intersection)]
            [clojure.edn :as edn]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info)]))

;;; ToDo: preprocess log ought to remove redundant stuff in log like this:
;;;    {:act :bl, :m :m1, :clk 2077.1059568493292, :line 278}
;;;    {:act :ub, :m :m1, :clk 2077.1059568493292, :line 280}
;;;    {:act :bl, :m :m1, :clk 2078.205956849329,  :line 284}
;;;    {:act :ub, :m :m1, :clk 2078.205956849329,  :line 286}
;;; (Even better, MJPdes should not generate this stuff!)

(defn preprocess-log
  "Add line numbers. This is used by hand on the datafile."
  [data]
  (reduce (fn [data n] (assoc-in data [n :line] n))
          data
          (range (count data))))

;;; POD Better than this would be transit. 
(defn load-scada [filename]
  (let [in (java.io.PushbackReader. (clojure.java.io/reader filename))
        edn-seq (repeatedly (partial edn/read {:eof :eof :readers {'function (fn [x])}} in))
        data (first (take-while #(not= :eof %) edn-seq))]
    (preprocess-log data)))

;;;====== These are used to generate Eden individuals  ======

;;; POD as my notes in fit/ suggest, this ought to be done on a per-individual basis.

  
(defn infer-visible-transitions
  []
  [:m1-complete-job :m1-start-job :m2-complete-job :m2-start-job])

;;; POD as my notes in fit/ suggest, this ought to be done on a per-individual basis.
(defn infer-visible-places
  "Read the SCADA log to infer what ought to be treated state."
  []
  [:buffer :m1-blocked :m1-busy :m2-busy :m2-starved])

(defn job-id-near
  "Return a job ID near the argument line. Look forward then reverse for one."
  [data line-num]
  (let [look-to (- (count data) 10)
        look-fn (fn [dir-fn]
                  (loop [line line-num]
                    (let [msg (nth data line)]
                      (cond (contains? msg :j) (:j msg)
                            (>= line look-to) nil
                            :else (recur (dir-fn line))))))]
    (or (look-fn inc) (look-fn dec))))

(defn random-job-trace
  "Return the trace of a random job. This includes every message starting 
   with where it is first mentioned to where it is last mentioned MINUS
   the messages that are about a different job."
  []
  (let [data (-> (util/app-info) :problem :scada-data-file load-scada)
        line-num (-> data count rand-int)
        job-id (job-id-near data line-num)
        job-trace (scada-gather-job data job-id)
        start-job (-> job-trace first :line)
        end-job (-> job-trace last :line)]
    (remove #(and (contains? % :j) (not (== job-id (:j %))))
            (subvec data start-job (inc end-job)))))


(defn max-machine [job-trace]
  "Return an integer representing the last machine mentioned in the argument job trace
   by reference to the last buffer mentioned. Note that the first machine is 1 and 
  (e.g):b3 is the buffer AFTER machine 3"
  (->> job-trace
       (filter #(contains? % :bf))
       (map :bf)
       (map #(second (re-matches #"\:b(\d+)" (str %))))
       (map read-string)
       (apply max)
       inc))

;;; {:act :sm, :bf :b1, :j 1660, :n 3, :clk 2083.1285760500264, :line 301}
(defn implies-machine
  [msg]
  (map #(second (re-matches #"\:b(\d+)" (str (:bf msg))))))
  

;;;====== These are used to generate scada patterns ======
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
  "Compute the problem's SCADA patterns. It is a vector of maps with keys
   (:id :form :njobs :relations). Run once per problem."
  [log]
  (as-> log ?pats 
    (all-scada-patterns ?pats)
    (trim-patterns ?pats 5 5)
    (map #(as-> % ?pat
            (assoc ?pat :relations (scada-ordering-relations %))
            (assoc ?pat :njobs (count (:jobs ?pat)))
            (dissoc ?pat :jobs)) ; POD don't think the actual job will be useful.
         ?pats)))
       
;;; POD Probably want start and stop point for every occurrence. 
(defn all-scada-patterns
  "Return a vector of all the job patterns found in the SCADA log.
   Run once per problem."
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
   These are quite likely to be fragments of the complete log for these jobs. Run once per problem."
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
    (if (< idx 0) false idx)))

(defn ordering-fn
  "Return a function : trace -> boolean indicating whether the ordering relationship 
   is violated by the argument QPN process trace. If one or both of the arguments 
   does not even appear in the trace, it is considered violated."
  [x y]
  (fn [trace]
    (let [pos-x (pos-in-trace trace x)
          pos-y (pos-in-trace trace y)]
      (if (and pos-x pos-y)
        (<= (pos-in-trace trace x) (pos-in-trace trace y))
        true))))

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


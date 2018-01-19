(ns gov.nist.sinet.scada
  "Read and process SCADA data."
  (:require [clojure.set :refer (union difference intersection)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.edn :as edn]
            [clojure.spec.alpha :as s]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info)]))

(def ^:private diag (atom nil))

;;; Get error "Method code too large!" If I just do load-file here.
(defn load-scada [filename] 
  "Read a SCADA log."
  (let [in (java.io.PushbackReader. (clojure.java.io/reader filename))]
    (edn/read in)))

(s/def ::act keyword?)
(s/def ::mjpact keyword?)
(s/def ::clk number?)
(s/def ::line number?)

(s/def ::bf keyword?)
(s/def ::m keyword?)
(s/def ::n number?)
(s/def ::ent number?)
(s/def ::scada-msg
  (s/keys :req-un [::act ::mjpact ::clk ::line]
          :opt-un [::m ::bf ::n ::ent ::ends]))
(s/def ::scada-log (s/coll-of ::scada-msg :kind vector?))

;;; POD I expected this to check the return value; it doesn't.  
(s/fdef load-scada
        :args (s/cat :filename string?)
        :ret  ::scada-log)

;;;====== These are used to generate Eden individuals  ======
(defn job-id-near
  "Return a job ID near the argument line. Look forward then reverse for one."
  [data line-num]
  (let [look-to (- (count data) 10)
        look-fn (fn [dir-fn stop-fn]
                  (loop [line line-num]
                    (let [msg (nth data line)]
                      (cond (contains? msg :j) (:j msg)
                            (stop-fn line) nil
                            :else (recur (dir-fn line))))))]
    (or (look-fn inc #(>= % look-to))
        (look-fn dec #(<= % 0)))))

(defn scada-log
  "Return the entire SCADA log vector."
  []
  (-> (util/app-info) :problem :scada-log))

(declare scada-gather-job)

(defn random-job-trace
  "Return the trace of a random job. This includes every message starting 
   with where it is first mentioned to where it is last mentioned MINUS
   the messages that are about a different job."
  ([] (random-job-trace (scada-log)))
  ([log]
  (let [line-num (-> log count rand-int)
        job-id (job-id-near log line-num)
        job-trace (scada-gather-job log job-id)
        start-job (-> job-trace first :line)
        end-job (-> job-trace last :line)]
    (->> (subvec log start-job (inc end-job))
         (remove #(and (contains? % :j) (not (== job-id (:j %)))))
         (filter (fn [msg] (contains? msg :j)))
         vec))))

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

;;;====== These are used to generate scada patterns ======
(defn scada-gather-job
  "Return a 'job trace', every mention of of job-id in chronological order."
  [data job-id]
  (filter  #(= (:j %) job-id) data)) ; POD this is not a very efficient implementation!
  
(defn scada-all-job-ids
  "Return a vector of all job-ids found in the data"
  [data]
  (sort (distinct (map :j (filter #(contains? % :j) data)))))
 
(defn make-pattern
  "Create a SCADA pattern; they look like this: {:act :m2-start-job, :bf :b1, :n :*}, 
   {:act :ej, :m m1}..."
  [msgs pattern-id]
  {:id pattern-id
   :form
   (as-> msgs ?msgs
     (map #(reduce (fn [msg key] (dissoc msg key)) ; remove unnecessary keys
                   %
                   (difference (set (keys %))
                               #{:act :jt :bf :m :n}))  ; POD Long-term okay?
          ?msgs)
     (map #(reduce (fn [msg key] (if (contains? msg key) (assoc msg key :*) msg))
                   % ; wildcard certain msg vals
                   [:jt :n]) ; POD I ONLY WANT :jt and :n here
          ?msgs)
     (vec ?msgs))})

(defn match-msg?
  "Return true if msg matches form"
  [msg form]
  (every? (fn [key]
           (or (and (= (key form) :*) (contains? msg key))
               (= (key form) (key msg))))
          (keys form)))

(defn match-pattern?
  "Return true if msgs matches pattern"
  [msgs pattern]
  (let [form (:form pattern)]
    (and (= (count msgs) (count form))
         (every? (fn [n] (match-msg? (nth msgs n) (nth form n)))
                 (range (count form))))))

(declare all-scada-patterns trim-patterns act2trans)
(defn scada-patterns ; called from app.clj
  "Compute the problem's SCADA patterns. It is a vector of maps with keys
   (:id :form :njobs :relations). Run once per problem."
  [log]
  (as-> log ?pats 
    (all-scada-patterns ?pats)
    (trim-patterns ?pats 5 5)
    (map #(as-> % ?pat
            (assoc ?pat :njobs (count (:jobs ?pat)))
            (dissoc ?pat :jobs)) ; POD don't think the actual job will be useful.
         ?pats)))
       
;;; POD Probably want start and stop point for every occurrence. 
(defn all-scada-patterns
  "Return a vector of all the job-trace patterns  found in the SCADA log.
   A 'job-trace-pattern' only includes msgs that have a :j. Run once per problem at init."
  [data]
  (let [pattern-id (atom -1)]
    (reduce (fn [patterns job-id]
              (let [job (scada-gather-job data job-id) ; get a job trace
                    matches (filter #(match-pattern? job %) patterns)] ; matches one already collected?
                (if (empty? matches)  ; no, make a new pattern.
                  (conj patterns (assoc (make-pattern job (swap! pattern-id inc)) :jobs [job-id]))
                  (reduce (fn [patterns id] ; yes, just update the job count.
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

(defn exceptional-msgs
  "Return the set of the exceptional messages found in the scada log."
  [scada-patterns scada-log]
  (let [ordinary (set (mapcat (fn [pat]
                                (map :act (:form pat)))
                              scada-patterns))]
    (->> (reduce (fn [excepts msg]
                   (if (contains? ordinary (:act msg))
                     excepts
                     (conj excepts (-> msg ; so can use distinct below
                                       (dissoc :j)
                                       (dissoc :clk)
                                       (dissoc :ent)
                                       (dissoc :line)))))
                 []
                 scada-log)
         (map :act)
         distinct
         set)))

(defn active-jobs
  "Return the set of active jobs in the system"
  [log]
  (let [all-jobs (set (reduce (fn [accum msg]
                                (if-let [job (:j msg)]
                                  (conj accum job)
                                  accum))
                              []
                              log))
        add-jobs (set (reduce (fn [accum msg]
                                (if (= (:mjpact msg) :aj)
                                  (conj accum (:j msg))
                                  accum))
                              []
                              log))]
    (difference all-jobs add-jobs)))

(defn msg-matching
  "Return a message matching the predicate."
  [pred]
  (let [log (-> (app-info) :problem :scada-log)]
    (some #(when (pred %) %) log)))

;;; POD the 'whole-job requirement currently just for neatness. 
(defn job-map 
  "Return a map indexed by job-id and containing maps of where 
   mention of that job starts and stops. The job must be whole."
  [log]
  (as-> {} ?jmap
    (reduce (fn [jmap msg]
              (if-let [job-id (:j msg)]
                (if (contains? jmap job-id)
                  (assoc-in jmap [job-id :ends] (:line msg))
                  (if (= (:mjpact msg) :aj) ; whole job started.
                    (assoc jmap job-id {:starts (:line msg)})
                    jmap))
                jmap))
            ?jmap
            log)
    (reduce (fn [jmap job-id] ; whole job ended.
              (if-let [end-line (-> (get jmap job-id) :ends)]
                (if (= :ej (:mjpact (nth log end-line)))
                  jmap
                  (dissoc jmap job-id))
                (dissoc jmap job-id)))
            ?jmap
            (keys ?jmap))))

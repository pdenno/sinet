(ns gov.nist.sinet.scada
  "Read and process SCADA data."
  (:require [clojure.spec.alpha :as s]
            [clojure.set :refer (union difference intersection)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.edn :as edn]
            [net.cgrand.xforms :as x]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info)]))

(def ^:private diag (atom nil))
(declare scada-gather-job job-map scada-patterns exceptional-msgs rand-job-trace)

(defn load-scada [filename] 
  (with-open [in (java.io.PushbackReader. (clojure.java.io/reader filename))]
    (let [raw (loop [msg (edn/read {:eof :eof} in)
                     lines (transient [])]
                (if (not= :eof msg)
                  (recur (edn/read {:eof :eof} in) (conj! lines msg)) 
                  (persistent! lines)))]
      (as-> {:raw raw} ?log
        (job-map ?log)
        (scada-patterns ?log)
        (exceptional-msgs ?log)
        (assoc ?log :job-ids (-> ?log :job-map keys sort vec))
        (assoc ?log :machines (->> ?log
                                   rand-job-trace 
                                   (map :m)
                                   (filter identity)
                                   set))
        (buffer-discipline ?log)))))

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
(s/def ::raw (s/coll-of ::scada-msg :kind vector?))
(s/def ::scada-log (s/keys :req-un [::raw]))

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
  (-> (util/app-info) :problem :scada-log :raw))

(defn job-trace 
  "Return all mentions of the job."
  [log job-id]
  (when-let [jcover (get (:job-map log) job-id)]
    (->> (subvec (:raw log) (:starts jcover) (-> jcover :ends inc))
         (remove #(and (contains? % :j)
                       (not= (:j %) job-id)))
         vec)))

(defn rand-job-trace
  "Return the trace of a random job. This includes every message starting 
   with where it is first mentioned to where it is last mentioned MINUS
   the messages that are about a different job."
  ([] (rand-job-trace (scada-log)))
  ([log]
   (job-trace log (rand-nth (:job-ids log)))))

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
  (let [raw (:raw log)]
    (assoc log
           :patterns
           (as-> raw ?pats 
             (all-scada-patterns ?pats)
             (trim-patterns ?pats 5 5)
             (map #(as-> % ?pat
                     (assoc ?pat :njobs (count (:jobs ?pat)))
                     (dissoc ?pat :jobs)) ; POD don't think the actual job will be useful.
                  ?pats)))))
       
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
  [log]
  (let [patterns (:patterns log)
        ordinary (set (mapcat (fn [pat] (map :act (:form pat))) patterns))]
    (-> log
        (assoc :ordinary ordinary)
        (assoc :exceptional
               (->> (reduce (fn [excepts msg]
                              (if (ordinary (:act msg))
                                excepts ; dissoc for distinct members
                                (conj excepts (:act msg))))
                            []
                            (:raw log))
                    set)))))

(defn active-jobs
  "Return the set of active jobs in the system"
  [log]
  (let [raw (:raw log)
        all-jobs (set (reduce (fn [accum msg]
                                (if-let [job (:j msg)]
                                  (conj accum job)
                                  accum))
                              []
                              raw))
        add-jobs (set (reduce (fn [accum msg]
                                (if (= (:mjpact msg) :aj)
                                  (conj accum (:j msg))
                                  accum))
                              []
                              raw))]
    (difference all-jobs add-jobs)))

(defn msg-matching
  "Return a message matching the predicate."
  [pred]
  (let [raw (-> (app-info) :problem :scada-log :raw)]
    (some #(when (pred %) %) raw)))

;;; POD the 'whole-job requirement currently just for neatness. 
(defn job-map 
  "Return a map indexed by job-id and containing maps of where 
   mention of that job starts and stops. The job must be whole."
  [log]
  (let [raw (:raw log)
        job-map (as-> {} ?jmap
                  (reduce (fn [jmap msg]
                            (if-let [job-id (:j msg)]
                              (if (contains? jmap job-id)
                                (assoc-in jmap [job-id :ends] (:line msg))
                                (if (= (:mjpact msg) :aj) ; whole job started.
                                  (assoc jmap job-id {:starts (:line msg)})
                                  jmap))
                              jmap))
                          ?jmap
                          raw)
                  (reduce (fn [jmap job-id] ; whole job ended.
                            (if-let [end-line (-> (get jmap job-id) :ends)]
                              (if (= :ej (:mjpact (nth raw end-line)))
                                jmap
                                (dissoc jmap job-id))
                              (dissoc jmap job-id)))
                          ?jmap
                          (keys ?jmap)))]
    (assoc log :job-map job-map)))

;;;==============================
;;; log-only BAS/BBS analysis 
;;; POD More filtering would be necessary were the machine to generate messages while working.
;;;==============================
;;; Once warmed-up, a reliable machine BAS follows this cycle:
;;; {:clk    5.6000 :act :m1-blocked        :m :m1 :mjpact :bl :line 5}
;;; {:clk    6.8000 :act :m2-complete-job   :m :m2 :mjpact :ej :ent 1.6 :j 3 :line 6}
;;; {:clk    6.8000 :act :m2-start-job      :m :m2 :mjpact :sm :bf :b1 :n 1 :j 4 :line 7}
;;; {:clk    6.8000 :act :m1-unblocked      :m :m1 :mjpact :ub :line 8}
;;; {:clk    6.8000 :act :m1-complete-job   :m :m1 :mjpact :bj :bf :b1 :n 0 :j 5 :line 9}
;;; {:clk    6.8000 :act :m1-start-job      :m :m1 :mjpact :aj :jt :jobType1 :ends 7.6 :j 6 :line 10}

;;; Key here is (..., m1-start-job, m1-block, m1-unblock, m1-complete-job, ...)
(defn count-bas-pattern 
  "Counts the number of machine process cycles of log that 
   reflect a block-after-service discipline."
  [raw m]
  (transduce
   (comp (filter #(= m (:m %)))
         (map :mjpact) 
         (remove #(#{:st :us} %))
         (partition-by #(#{:aj :sm} %))     ; stateful
         (remove #(#{'(:sm) '(:aj)} %))
         (filter #(and (= :bl (nth % 0))
                       (= :ub (nth % 1))
                       (= :bj (nth % 2))))
         x/count)
   +
   raw))

;;; Once warmed-up, a reliable machine BBS follows this cycle:
;;; {:clk    4.8000 :act :m2-complete-job   :m :m2 :mjpact :ej :ent 0.8 :j 2 :line 14}
;;; {:clk    4.8000 :act :m2-start-job      :m :m2 :mjpact :sm :bf :b1 :n 1 :j 3 :line 15}
;;; {:clk    4.8000 :act :m1-unblocked      :m :m1 :mjpact :ub :line 16}
;;; {:clk    4.8000 :act :m1-start-job      :m :m1 :mjpact :aj :jt :jobType1 :ends 5.6 :j 4 :line 17}
;;; {:clk    5.6000 :act :m1-complete-job   :m :m1 :mjpact :bj :bf :b1 :n 0 :j 4 :line 18}
;;; {:clk    5.6000 :act :m1-blocked        :m :m1 :mjpact :bl :line 19}

;;; Key here is (..., m1-unblock, m1-start-job, m1-complete-job, ...)

(defn count-bbs-pattern 
  "Counts the number of machine process cycles of log 
   that reflect a block-before-service discipline."
  [raw m]
  (transduce
   (comp (filter #(= m (:m %)))
         (map :mjpact) 
         (remove #(#{:st :us} %))
         (partition-by #(= % :ub))  ; stateful
         (remove #(= % '(:ub)))
         (filter #(and (#{:aj :sm} (first  %))
                       (= :bj      (second %))))
         x/count)
   +
   raw))

(defn buffer-discipline
  "Add a :discpline map to the log, describing the evidence for 
   BBS and BAS of each machine in the system. e.g. {:m1 {:bbs 220 :bas 0}...}"
  [log]
  (let [raw (:raw log)]
    (assoc log :discipline
           (reduce (fn [res m]
                     (-> res
                         (assoc m {:bas (count-bas-pattern raw m)
                                   :bbs (count-bbs-pattern raw m)})))
                   {}
                   (:machines log)))))

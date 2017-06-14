(ns gov.nist.sinet.util.fitness
  (:require [medley.core :refer (abs)]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :refer (union difference intersection)]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability)]))

;;; Purpose: Fitness test

(defrecord Pair [id error scada-ptr qpn-ptr scada-job qpn-job scada qpn])

(defn preprocess-log
  "Add line numbers."
  [data]
  (reduce (fn [data n] (assoc-in data [:log n :line] n))
          data (range (count (:log data)))))

(declare #_scroll-to msg-at)
(defn sync-event
  "Find corresponding places in SCADA and QPN"
  [pair event])

#_(defn scroll-to
  "Return index of argument or nil."
  [data event]
  (let [size (count data)]
    (loop [ptr 0]
      (cond (> ptr size) nilm
            (= (:act (nth data ptr)) event) ptr,
            :else (recur (inc ptr))))))

(defn msg-at
  [data ptr]
  (nth data ptr))

(defn scada-gather-job
  "Return every mention of of job-id in chronological order."
  [data job-id]
  (filter  #(= (:j %) job-id) data))
  
(defn scada-all-job-ids
  "Return a vector of all job-ids found in the data"
  [data]
  (sort (distinct (map :j (filter #(contains? % :j) data)))))

[{:act :aj, :j 1602, :jt :jobType1, :ends 2001.5882553364702, :clk 2000.5882553364702}
 {:act :bj, :bf :b1, :j 1602, :n 2, :clk 2001.68825533647}
 {:act :sm, :bf :b1, :j 1602, :n 3, :clk 2004.9882553364698}
 {:act :ej, :m :m2, :j 1602, :ent 2000.5882553364702, :clk 2006.0882553364697}]

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
       
;;; Probably want start and stop point for every occurrence. 
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
  "Trim up to ntrim patterns from the ends of the pattern vector if they account of few (njobs) jobs.
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

;;; {:id 3, :form [{:act :aj, :jt \*} {:act :bj, :bf \*, :n \*} {:act :sm, :bf \*, :n \*} {:act :ej, :m \*}],
;;;  :jobs [1602 1603 ...]
(def +scada-patterns+
  (as-> (:log scada-log) ?log
    (scada-patterns ?log)
    (trim-patterns ?log 5 5)))

;;;===========================================
;;; QPN

;;; POD only collects on :act currently
(defn qpn-all-job-ids
  "Return a vector of all job-ids found in the data"
  [data]
  (sort (distinct (mapcat (fn [msg] (map :id (:tkns msg)))
                          (filter #(contains? % :act) data)))))
 
;;; POD only collects :act currently
(defn qpn-gather-job
  "Return every mention of job-id in chronological order."
  [data job-id]
  (filter  (fn [msg]
             (and (contains? msg :act)
                  (some #(= (:id %) job-id) (:tkns msg))))
           data))

 
#_(defn qpn-patterns
  "Return a vector of all the job patterns found in the QPN log."
  [data]
  (let [pattern-id (atom -1)]
    (reduce (fn [patterns job-id]
              (let [job (qpn-gather-job data job-id)
                    matches (filter #(match-pattern? job %) patterns)]
                (if (empty? matches)
                  (conj patterns (assoc (make-pattern job (swap! pattern-id inc)) :jobs [job-id]))
                  (reduce (fn [patterns id]
                            (update-in patterns [id :jobs] #(conj % job-id)))
                          patterns (map :id matches)))))
            [] (all-job-ids data))))
  
  


(def +test-qpn-patterns+
  (as-> +qpn-m2-bas ?log
    (qpn-patterns ?log)
    (trim-patterns ?log 5 5)))
      

;;;===========================================
;;; Fitness measure

(defn act2trans
  "Return the transition (its name) responsible for the argument act."
  [pn act]
  (some #(when (= act (:act ((:fn %) :foobar))) (:name %))
        (:transitions pn)))

;;; Because I'm focusing on jobs here (qpn-gather-job), at some point I'm going to have to account for
;;; lines in the log that were not addressed by qpn-gather-job (and the things in-between it).
(defn act-is-intro? [pn act]
  "Return true if the named transition has an arc exiting it that 
   introduces a token."
  (let [trans (act2trans pn act)]
    (some #(= :intro (-> % :bind :act))
          (filter #(= (:source %) trans) (:arcs pn)))))

;;; If pn-act-is-intro? and this is not first mention of the token, then it is recycling.
;;; An example is {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]} above.
;;; Here I remove those. 
(defn clean-job-log
  [pn tkn-id job-log]
  (remove (fn [msg]
            (and (act-is-intro? pn (:act msg))
                 (some #(> (:id %) tkn-id) (:tkns msg))))
          job-log))

(defn pos-in-trace
  "Return the position of the argument action in the argument process trace."
  [trace act]
  (let [^clojure.lang.PersistentVector acts (vec (map :act trace))
        idx (.indexOf acts act)]
    (if (< idx 0) nil idx)))

(defn poset-fn
  "Return a function : trace -> boolean indicating whether 
   the ordering relationship is violated by the arguments."
  [x y]
  (fn [trace] (<= (pos-in-trace trace x) (pos-in-trace trace y))))

;;; POD memoize. This should be a property of the SCADA pattern. 
(defn scada-pattern-poset
  "Calculate the poset of a SCADA pattern"
  [p]
  (loop [events p
         poset []]
    (if (empty? (rest events))
      poset
      (recur
       (next events)
       (into poset (reduce (fn [m s] (conj m (poset-fn (:act (first events)) (:act s))))
                           []
                           (rest events)))))))
(defn violates?
  "Return true if the job-log violates the argument relation."
  [job-log relation]
  (not (relation job-log)))

(def test-scada-pattern
  [{:act :aj, :jt \*}
   {:act :bj, :bf \*, :n \*}
   {:act :sm, :bf \*, :n \*}
   {:act :ej, :m  \*}])

(def test-job-log-1
  [{:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
   {:act :bj, :tkns [{:type :a, :id 22}]}
   {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
   {:act :sm, :tkns [{:type :a, :id 22}]}
   {:act :ej, :tkns [{:type :a, :id 22}]}])

(def test-job-log-2
  [{:act :bj, :tkns [{:type :a, :id 22}]}
   {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
   {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
   {:act :sm, :tkns [{:type :a, :id 22}]}
   {:act :ej, :tkns [{:type :a, :id 22}]}])


(def test-job-log-3
  [{:act :ej, :tkns [{:type :a, :id 22}]}
   {:act :bj, :tkns [{:type :a, :id 22}]}
   {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
   {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
   {:act :sm, :tkns [{:type :a, :id 22}]}])



;(calc-activity-disorder talking-m2-bas test-scada-pattern 22 test-job-log)

;;; +1 for every precedence constraint violated. 
;;; Will need something more for loops, but we'll get to that later. 
(defn calc-activity-disorder
  "Compute how well a QPN job follows a given SCADA pattern."
  [pn scada-pattern tkn-id job-log]
  (let [cjob-log (clean-job-log pn tkn-id job-log)
        poset-rels (scada-pattern-poset scada-pattern)]
    (reduce (fn [score rel] (if (violates? cjob-log rel) (inc score) score))
            0
            poset-rels)))
    

(defn workflow-fitness
  "Score the QPN-generated log with respect to the SCADA log."
  []
  (qpn-patterns 
  ))


  [{:act :bj, :tkns [{:type :a, :id 17}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 17}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 11}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 11}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 12}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 11}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 17}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 17}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 18}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 12}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 12}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 13}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 19}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 19}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 19}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 19}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 13}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 13}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 14}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 14}, :motion :move, :from :buffer, :to :m2-busy}]

  
(defn print-pair [p writer]
  (.write writer (cl-format nil "#Pair [err=~A scada-ptr=~A, qpn-ptr=~A, scada-job=~A, qpr-job=~A]"
                            (if (number? (:err p)) (cl-format nil "~6,2F" (:err p)) :NA)
                            (:scada-ptr p)
                            (:qpr-ptr p)
                            (:scada-job p)
                            (:qpr-job p))))

(defmethod print-method Pair [p writer]
  (print-pair p writer))

(.addMethod clojure.pprint/simple-dispatch Pair (fn [p] (print-pair p *out*)))

(def test-pair
  (map->Pair
   {:id 1
    :err 0.0
    :scada-ptr nil
    :qpn-ptr nil
    :scada-job nil
    :qpn-job nil
    :log
    [{:act :sm, :tkns [{:type :a, :id 12}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 11}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 17}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 17}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 18}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 12}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 12}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 13}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 19}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 19}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 19}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 19}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 13}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 13}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 14}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 14}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 20} {:type :a, :id 19}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 20}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 19}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 20}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 20}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 14}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 14}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 15}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 14}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 15}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 20}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 21}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 20}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 21}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 21}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 15}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 15}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 16}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 15}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 16}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 22}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 21}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :ej, :tkns [{:type :a, :id 16}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 16}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 17}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 16}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 17}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :bj, :tkns [{:type :a, :id 22}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 22}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 23}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 22}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 23}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 23}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 17}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 17}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 18}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 17}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 18}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 24} {:type :a, :id 23}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 24}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 23}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 24}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 24}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 18}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 18}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 19}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 18}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 19}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 24} {:type :a, :id 25}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 25}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 24}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :ej, :tkns [{:type :a, :id 19}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 19}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 20}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 19}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 20}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :bj, :tkns [{:type :a, :id 25}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 25}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :aj, :tkns [{:type :a, :id 26} {:type :a, :id 25}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 26}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 25}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 26}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 26}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 20}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 20}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 21}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 20}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 21}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 26} {:type :a, :id 27}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 27}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 26}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 27}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 27}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 21}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 21}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 22}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 21}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 22}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 28} {:type :a, :id 27}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 28}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 27}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 28}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 28}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 22}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 22}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 23}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 22}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 23}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 29} {:type :a, :id 28}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 29}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 28}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 29}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 29}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 23}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 23}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 24}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 23}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 24}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 29} {:type :a, :id 30}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 30}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 29}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 30}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 30}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 24}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 24}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 25}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 24}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 25}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 31} {:type :a, :id 30}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 31}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 30}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 31}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 31}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 25}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 25}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 26}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 25}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 26}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 32} {:type :a, :id 31}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 32}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 31}, :motion :move, :from :m1-blocked, :to :buffer}
     {:act :bj, :tkns [{:type :a, :id 32}]}
     {:on-act :m1-complete-job, :tkn {:type :a, :id 32}, :motion :move, :from :m1-busy, :to :m1-blocked}
     {:act :ej, :tkns [{:type :a, :id 26}]}
     {:on-act :m2-complete-job, :tkn {:type :a, :id 26}, :motion :move, :from :m2-busy, :to :m2-starved}
     {:act :sm, :tkns [{:type :a, :id 27}]}
     {:on-act :m2-start-job, :tkn {:type :a, :id 26}, :motion :remove}
     {:on-act :m2-start-job, :tkn {:type :a, :id 27}, :motion :move, :from :buffer, :to :m2-busy}
     {:act :aj, :tkns [{:type :a, :id 33} {:type :a, :id 32}]}
     {:on-act :m1-start-job, :tkn {:type :a, :id 33}, :motion :add}
     {:on-act :m1-start-job, :tkn {:type :a, :id 32}, :motion :move, :from :m1-blocked, :to :buffer}]}))
     
(def talking-m2-bas
  (pnr/renumber-pids 
   {:places                                         
    [{:name :buffer, :pid 1, :initial-tokens 1    }
     {:name :m1-blocked, :pid 2, :initial-tokens 0}
     {:name :m1-busy, :pid 3, :initial-tokens 1   }
     {:name :m2-busy, :pid 4, :initial-tokens 1   }
     {:name :m2-starved, :pid 5, :initial-tokens 0}],
    :transitions  ; :fn here would be added by GP, associating SCADA acts with transitions.
    [{:name :m1-complete-job, :tid 6, :type :exponential, :rate 3.9 :fn (fn [tkns] {:act :bj :tkns tkns})}
     {:name :m1-start-job, :tid 7, :type :immediate, :rate 1.0      :fn (fn [tkns] {:act :aj :tkns tkns})}
     {:name :m2-complete-job, :tid 8, :type :exponential, :rate 1.0 :fn (fn [tkns] {:act :ej :tkns tkns})}
     {:name :m2-start-job, :tid 9, :type :immediate, :rate 1.0      :fn (fn [tkns] {:act :sm :tkns tkns})}],
    :arcs ; :bind here would be added by GP, selecting where to make intro and elim, split jobtypes, etc. 
    [{:aid 10, :source :buffer, :target :m1-start-job, :name :aa-10, :type :inhibitor, :multiplicity 5 :bind {:type :a}}
     {:aid 11, :source :buffer, :target :m2-start-job, :name :aa-11, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 12, :source :m1-blocked, :target :m1-start-job, :name :aa-12, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 13, :source :m1-busy, :target :m1-complete-job, :name :aa-13, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 14, :source :m1-complete-job, :target :m1-blocked, :name :aa-14, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 15, :source :m1-start-job, :target :buffer, :name :aa-15, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 16, :source :m1-start-job, :target :m1-busy, :name :aa-16, :type :normal, :multiplicity 1
      :bind {:type :a :act :intro}}
     {:aid 17, :source :m2-busy, :target :m2-complete-job, :name :aa-17, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 18, :source :m2-complete-job, :target :m2-starved, :name :aa-18, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 19, :source :m2-start-job, :target :m2-busy, :name :aa-19, :type :normal, :multiplicity 1 :bind {:type :a}}
     {:aid 20, :source :m2-starved, :target :m2-start-job, :name :aa-20, :type :normal, :multiplicity 1
      :bind {:type :a :act :elim}}]}))


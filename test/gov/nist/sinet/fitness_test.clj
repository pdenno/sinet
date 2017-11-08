(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint)]
            [loom.alg :as alg]
            [loom.graph :as graph]
            [gov.nist.spntools.core :as spn]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.pnml :as pnml]
            [gov.nist.spntools.core :as pn]
            [gov.nist.sinet.util :as util :refer (map->Inv app-info reset big-reset)]
            [gov.nist.sinet.app :as app]
            [gov.nist.sinet.run :as run]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.sinet.simulate :as sim]
            [gov.nist.sinet.pnn :as pnn]
            [gov.nist.sinet.fitness :as fit]))

(def ^:private diag (atom nil))

(defn =*
  "Check that v1 == v2 +/i tolerance."
  [v1 v2 tol]
  (< (- v1 tol) v2 (+ v1 tol)))

#_(load-file "data/SCADA-logs/scada-f0.clj") ; defines fit/scada-log-f0
#_(load-file "data/test-individuals/test-m2-bas.clj") ; defines (in .gp) test-m2-bas individual (a perfect individual for scada-log-f0)
#_(load-file "data/QPN-logs/qpn-m2-bas.clj") ; defines fit/qpn-m2-bas (a log for the perfect individual above)

#_(deftest scada-pattern-disorder
  (testing "scada-pattern-generation-and-qpn-disorder"
    (let [pats (as-> (:log fit/scada-log-f0) ?pats
                 (fit/scada-patterns ?pats)
                 (map #(dissoc % :jobs) ?pats))]
      (is (= (count pats) 1))
      (is (= (dissoc (first pats) :relations)
             {:id 3, :form
              [{:act :aj, :jt \*}
               {:act :bj, :bf \*, :n \*}
               {:act :sm, :bf \*, :n \*}
             {:act :ej, :m \*}]}))
      (is (= 0
             (fit/calc-process-disorder (fit/qpn-log-about gp/test-m2-bas 22) 22)
             gp/test-m2-bas ; pod I'm guessing
              (first pats)
              22
              (fit/qpn-gather-tkn fit/qpn-m2-bas 22)))
      (is (= 1
             (fit/calc-process-disorder
              gp/test-m2-bas
              (first pats)
              22
              [{:act :bj, :tkns [{:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
               {:act :sm, :tkns [{:type :a, :id 22}]}
               {:act :ej, :tkns [{:type :a, :id 22}]}])))
      (is (= 4
             (fit/calc-process-disorder
              gp/test-m2-bas
              (first pats)
              22
              [{:act :ej, :tkns [{:type :a, :id 22}]}
               {:act :bj, :tkns [{:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
               {:act :sm, :tkns [{:type :a, :id 22}]}]))))))

(def hopeful-pn
  {:initial-marking [1 0 0 0 0], ; I changed this too! How do I fix this? GP operator? Try different ones in simple-reach? 
   :transitions
   [{:name :m1-start-job,
     :tid 38,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m1-start-job, :j 1991, :jt :jobType1, :ends 2356.5705647971827, :clk 2355.3103128463604, :line 1233, :mjpact :aj, :m :m1},
     :visible? true}
    {:name :m1-complete-job,
     :tid 39,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m1-complete-job, :bf :b1, :j 1991, :n 1, :clk 2356.5705647971827, :line 1238, :mjpact :bj, :m :m1},
     :visible? true}
    {:name :m2-start-job,
     :tid 40,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m2-start-job, :bf :b1, :j 1991, :n 3, :clk 2358.9070474961236, :line 1247, :mjpact :sm, :m :m2},
     :visible? true}
    {:name :m2-complete-job,
     :tid 41,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m2-complete-job, :m :m2, :j 1991, :ent 2355.3103128463604, :clk 2360.0770474961237, :line 1248, :mjpact :ej},
     :visible? true}],
   :arcs
   [{:aid 74, :source :place-1, :target :m2-start-job, :EDITED true :name :aa-74, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 75, :source :m1-start-job, :target :place-2, :name :aa-75, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 76, :source :place-2, :target :m1-complete-job, :name :aa-76, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 77, :source :m1-complete-job, :target :place-3, :name :aa-77, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 78, :source :place-3, :target :m1-start-job, :EDITED true :name :aa-78, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 79, :source :m2-start-job, :target :place-4, :name :aa-79, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 80, :source :place-4, :target :m2-complete-job, :name :aa-80, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 81, :source :m2-complete-job, :target :place-1, :name :aa-81, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 205, :source :m1-start-job, :target :Place-103, :name :aa-205, :type :normal, :multiplicity 1, :bind {:jtype :blue} :priority 2}
    {:aid 206, :source :Place-103, :target :m2-start-job, :name :aa-206, :type :normal, :multiplicity 1 :bind {:jtype :blue}, :priority 1}],
   :marking-key [:place-1 :place-2 :place-3 :place-4 :Place-103],
   :places
   [{:name :place-1, :pid 0, :initial-tokens 1, :visible? true}
    {:name :place-2, :pid 1, :initial-tokens 0, :visible? true}
    {:name :place-3, :pid 2, :initial-tokens 0, :visible? true}
    {:name :place-4, :pid 3, :initial-tokens 0, :visible? true}
    {:name :Place-103, :pid 4, :initial-tokens 0}]})

(defn m2-inhib-bas-workflow-fit
  "Setup the m2-inhib-bas PN for a fitness test"
  [steps]    
  (let [pn (-> "data/PNs/m2-inhib-bas.xml" 
               spn/run-ready
               gp/add-color-binding
               (gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
               (sim/simulate :max-steps steps))]
    (fit/workflow-fitness (map->Inv {:pn pn}))))

(deftest perfect-fitness-scores-zero
  (testing "That a PN matching the log scores zero."
    (is true (=* 0.0 (:disorder (m2-inhib-bas-workflow-fit 200)) 0.01))))

;;; POD Better than this would be to use the new MJPdes output directly. (Don't mess with app-info.)
#_(defn problem-setting-fixture
  "Set the 'problem' (the log we look at) to the m2-inhib-bas problem."
  [f]
  (let [orig-scada (-> (app-info) :problem :scada-data-file)]
    (swap! app/problem #(assoc % :scada-data-file "data/SCADA-logs/scada-m2-inhib-bas.clj"))
    (util/big-reset) ;; POD need something less extreme than this! stop and start app!
    (f) ; The canonical fixture function, in this case called using the 'once' procedure
    (swap! app/problem #(assoc % :scada-data-file orig-scada))
    (util/big-reset)))

#_(use-fixtures :once problem-setting-fixture)
(deftest starving-is-ok
  (testing "that the starved? predicate works."
    (is (not (fit/starved?
              {:M [0 1 0 1 1], :fire :m2-complete-job, :Mp [1 1 0 0 1], :m :m2, :indx 224}
              {:act :m2-starved, :prev-act :m2-complete-job, :Mp [1 1 0 0 1], :state [1 1 0 0 1], :indx 225}
              hopeful-pn)))
    (is (fit/starved? 
         {:M [0 1 0 1 0], :fire :m2-complete-job, :Mp [1 1 0 0 0] :m :m2, :indx 224}
         {:act :m2-starved, :m :m2, :line 225, :mjpact :st}
         hopeful-pn))))

(defn winners-ok?
  "Returns true if calculated are as expected."
  [calculated expected]
  (every? (fn [[mark [msg value]]]
            (and (= msg    (-> (get expected mark) first))
                 (=* value (-> (get expected mark) second) 0.00001)))
          calculated))

(def rgraph
  [{:M [1 1 0 0 2], :fire :m2-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [0 0 1 1 3], :fire :m2-complete-job, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m2-complete-job, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m2-start-job, :Mp [0 1 0 1 0], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m1-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m2-complete-job, :Mp [1 1 0 0 3], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m1-start-job, :Mp [1 1 0 0 2], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m1-complete-job, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m1-start-job, :Mp [1 1 0 0 3], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m2-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [1 1 0 0 0], :fire :m1-complete-job, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m1-start-job, :Mp [0 1 0 1 3], :rate 1.0}
   {:M [1 0 1 0 3], :fire :m2-start-job, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m1-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m1-complete-job, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m1-complete-job, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m2-start-job, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m1-complete-job, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m2-complete-job, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m1-complete-job, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m2-start-job, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m1-complete-job, :Mp [0 0 1 1 3], :rate 1.0}
   {:M [1 0 1 0 0], :fire :m1-start-job, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m2-complete-job, :Mp [1 1 0 0 0], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m2-complete-job, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [1 1 0 0 2], :fire :m1-complete-job, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m2-complete-job, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m2-complete-job, :Mp [1 1 0 0 2], :rate 1.0}])

(def msg-table
  {:m2-starved   {[1 1 0 0 0] 14},
   :m2-unstarved {[0 1 0 1 0] 14},
   :m1-blocked   {[0 1 0 1 3] 30},
   :m1-unblocked {[0 0 1 1 2] 30},
   :ordinary     {[0 0 1 1 1] 263,
                  [0 1 0 1 0] 217,
                  [1 1 0 0 2] 263,
                  [0 1 0 1 3] 248,
                  [1 1 0 0 3] 248,
                  [0 1 0 1 1] 466,
                  [1 1 0 0 0] 14,
                  [0 0 1 1 0] 203,
                  [0 0 1 1 2] 248,
                  [1 1 0 0 1] 217,
                  [0 1 0 1 2] 511,
                  [1 0 1 0 0] 14}})
                                        ;
(deftest msg-table-test
  (testing "that the message table looks good"
    (is (= msg-table
           (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")]
             (as-> (fit/find-interpretation hopeful-pn log) ?pn
               (fit/compute-msg-table ?pn)))))))

(deftest full-winner-process 
  (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
        pn (as-> (fit/find-interpretation hopeful-pn log) ?pn
             (assoc  ?pn :msg-table (fit/compute-msg-table ?pn)) 
             (assoc  ?pn :trans-counts (fit/trans-counts (:interp ?pn)))
             (dissoc ?pn :interp)
             (assoc  ?pn :sigma 0.40)
             (assoc  ?pn :loom-prob (fit/rgraph2loom-probability (:rgraph ?pn) (:trans-counts ?pn)))
             (assoc  ?pn :distance-fn #(second (alg/dijkstra-path-dist (:loom-prob ?pn) %1 %2)))
             (assoc  ?pn :pdf-fns
                     (zipmap (-> ?pn :msg-table keys)
                             (map #(fit/parzen-pdf-msg ?pn %)
                                  (-> ?pn :msg-table keys)))))]
    (is (= (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.0903244614282773],
            [0 1 0 1 0] [:m2-unstarved 1.0],
            [1 1 0 0 2] [:ordinary 0.09031954835912448],
            [0 1 0 1 3] [:m1-blocked 1.0],
            [1 1 0 0 3] [:ordinary 0.08549534846163118],
            [0 1 0 1 1] [:ordinary 0.1606469021025419],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.06990869038942338],
            [0 0 1 1 2] [:m1-unblocked 1.0],
            [1 1 0 0 1] [:ordinary 0.07453835356002238],
            [0 1 0 1 2] [:ordinary 0.17616047457462952],
            [1 0 1 0 0] [:ordinary 0.0048262784622090035]}))))

;;; There are more state that this in the PN, but not all occurred in the 3000 msgs logged. That's okay. 
(deftest pnn-for-msgs-1 
  (testing "PNN-based classification using Euclidean/sigma=0.2"
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.2)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :distance-fn pnn/euclid-dist2)
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :pdf-fns
                      (zipmap (keys msg-table) 
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Good values, but the sigma is so tight that it won't generalize well. 
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 1 0 1 0] [:ordinary 0.06971187503880233],
            [2 0 1 1 0] [:ordinary 0.17548168297989752],
            [1 1 0 1 0] [:ordinary 0.09031651123868557],
            [3 0 1 0 1] [:ordinary 0.0851651717421801],
            [1 0 1 1 0] [:ordinary 0.16002840419305475],
            [0 1 0 0 1] [:ordinary 0.0048076923087272344],
            [2 1 0 1 0] [:m1-unblocked 1.0],
            [3 0 1 1 0] [:m1-blocked 1.0],
            [1 0 1 0 1] [:ordinary 0.07451958526421719],
            [0 0 1 1 0] [:m2-unstarved 1.0],
            [0 0 1 0 1] [:m2-starved 1.0],
            [2 0 1 0 1] [:ordinary 0.09031652915550199]})))))

(deftest pnn-for-msgs-2
  (testing "PNN-based classification using Euclidean/sigma=0.75"
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.75)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :distance-fn pnn/euclid-dist2)
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Much larger sigma, but bad performance.
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 1 0 1 0] [:m2-unstarved 0.1690133154060661],
            [2 0 1 1 0] [:m1-blocked 0.41111229050718745],
            [1 1 0 1 0] [:m1-unblocked 0.41111229050718745],
            [3 0 1 0 1] [:m1-blocked 0.1690133154060661],
            [1 0 1 1 0] [:m2-unstarved 0.41111229050718745],
            [0 1 0 0 1] [:m2-starved 0.1690133154060661],
            [2 1 0 1 0] [:m1-unblocked 1.0],
            [3 0 1 1 0] [:m1-blocked 1.0],
            [1 0 1 0 1] [:m2-starved 0.41111229050718745],
            [0 0 1 1 0] [:m2-unstarved 1.0],
            [0 0 1 0 1] [:m2-starved 1.0],
            [2 0 1 0 1] [:ordinary 0.20673002778168464]})))))

(deftest pnn-for-msgs-3
  (testing "PNN-based classification using graph-distance/sigma=0.75"
    (let [pn (as-> (test-pn) ?pn
               (assoc ?pn :sigma 0.75)
               (assoc ?pn :distance-fn #(second (alg/dijkstra-path-dist (:loom-prob ?pn) %1 %2)))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; graph-distance scaling gives good results at wide sigma. 
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 1 0 1 0] [:ordinary 0.07812345592321546],
            [2 0 1 1 0] [:ordinary 0.19350798937548197],
            [1 1 0 1 0] [:ordinary 0.10565451941946981],
            [3 0 1 0 1] [:ordinary 0.09387730377891051],
            [1 0 1 1 0] [:ordinary 0.1783054552497219],
            [0 1 0 0 1] [:m2-starved 0.028565500784550373],
            [2 1 0 1 0] [:m1-unblocked 1.0],
            [3 0 1 1 0] [:m1-blocked 1.0],
            [1 0 1 0 1] [:ordinary 0.08572916833008677],
            [0 0 1 1 0] [:m2-unstarved 1.0],
            [0 0 1 0 1] [:m2-starved 1.0],
            [2 0 1 0 1] [:ordinary 0.10642989332503937]})))))


;;;(alias 'gp 'gov.nist.sinet.gp)
;;;;(alias 'scada 'gov.nist.sinet.scada)
;;; These are useful to understanding how things work. 
;;; This one for an Eden INV:
#_(def eee
    (let [pn (->> (scada/random-job-trace)
                  (gp/initial-individual-pn))]
      (-> (gp/map->Inv {:pn pn})
           gp/add-scada-report-fns
           gp/add-color-binding
          (update :pn
                  (fn [pn]
                    (reduce (fn [pn trans] (gp/assign-flow-priorities pn trans))
                            pn
                            (->> pn :transitions (map :name))))))))

;;; This one to show it on the client: (not working; I don't know why.)
#_(-> eee
      gp/clean-inv-for-transmit
      gp/diag-push-pn)

;;; This one for a typical-job:
;;;(def jjj (-> eee :pn (sim/simulate :max-steps 50) (fit/qpn-log-about 1) trunc-qpn-log-at-cycle))
;;; ==> 
;;;[{:tkns [{:jtype :blue, :id 1}], :rep {:name :m1-start-job, :act :aj, :m :m1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}}
;;; {:tkns [{:jtype :blue, :id 1}], :rep {:name :m2-complete-job, :act :ej, :m :m2}}]

;;; This one (finally!) to calculate job disorder:
;;; (calc-process-disorder jjj (-> (util/app-info) :problem :scada-patterns))
;;; ==> 0 (but of course it is going to get hit for not introducing a new token.

#_(defn diag-one-that-runs
  "Return the first PN that can generate at least modest amount of log!"
  []
  (some #(let [pn (sim/simulate (:pn %) :max-steps 100)]
           (when (> (-> pn :sim :log count) 20) %))
        (-> (util/app-info) :pop)))

;;; POD NYI    
#_(defn diag-process-disorder
  "Report how messed up this PN is." 
  [inv]
  (let [patterns (-> (app-info) :problem :scada-patterns)
        sim (-> inv :pn (sim/simulate :max-steps (* 50 (avg-scada-process-steps patterns))))]))

;;; This needs to be commented out. (load order)
#_(defn m2-inhib-bas
  "Setup the m2-inhib-bas PN for a fitness test"
  [steps]
  (let [pn (-> "data/PNs/m2-inhib-bas.xml" 
               gov.nist.spntools.core/run-ready
               gp/add-color-binding
               (gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
               #_(sim/simulate :max-steps steps))]
    #_(workflow-fitness (util/map->Inv {:pn pn}))
    pn))

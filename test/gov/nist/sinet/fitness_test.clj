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

(def hopeful-pn (load-file "data/PNs/hopeful-pn.clj"))

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

;;; POD This one is worth lots more tests!!!
(deftest logs-interpret
  (testing "that interpretations can be found when they should be found."
    (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
          pn  (fit/find-interpretation hopeful-pn log)]
      (is (= 3002 (count (:interp pn)))))))

(def rgraph
  [{:M [1 1 0 0 2], :fire :m2-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m1-move-off, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m1-move-off, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m2-start-job, :Mp [0 1 0 1 0], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m1-move-off, :Mp [0 0 1 1 3], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m1-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m2-move-off, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m1-start-job, :Mp [1 1 0 0 2], :rate 1.0}
   {:M [1 1 0 0 2], :fire :m1-move-off, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 0 1 1 3], :fire :m2-move-off, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m1-start-job, :Mp [1 1 0 0 3], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m2-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m1-start-job, :Mp [0 1 0 1 3], :rate 1.0}
   {:M [1 0 1 0 3], :fire :m2-start-job, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m1-move-off, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m1-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m2-start-job, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m2-move-off, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m2-move-off, :Mp [1 1 0 0 0], :rate 1.0}
   {:M [1 1 0 0 0], :fire :m1-move-off, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m2-move-off, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m1-move-off, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m1-move-off, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m2-start-job, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [1 0 1 0 0], :fire :m1-start-job, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m2-move-off, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m2-move-off, :Mp [1 1 0 0 2], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m2-move-off, :Mp [1 1 0 0 3], :rate 1.0}])

(def msg-table
  {:m2-starved   {[1 1 0 0 0] 32},
   :m2-unstarved {[1 1 0 0 1] 32},
   :m1-blocked   {[0 1 0 1 3] 60},
   :m1-unblocked {[0 1 0 1 2] 60},
   :ordinary     {[0 0 1 1 1] 195,
                  [0 1 0 1 0] 235,
                  [1 1 0 0 2] 194,
                  [0 1 0 1 3] 275,
                  [1 1 0 0 3] 274,
                  [0 1 0 1 1] 398,
                  [1 1 0 0 0] 32,
                  [0 0 1 1 0] 203,
                  [0 0 1 1 2] 276,
                  [1 1 0 0 1] 235,
                  [0 1 0 1 2] 469,
                  [1 0 1 0 0] 32}})

(def trans-counts
  {[0 0 1 1 1] {[0 1 0 1 2] 195},
   [0 1 0 1 0] {[0 0 1 1 0] 203, [1 1 0 0 0] 32},
   [1 1 0 0 2] {[0 1 0 1 1] 194},
   [0 1 0 1 3] {[1 1 0 0 3] 274, [0 0 1 1 3] 1},
   [1 1 0 0 3] {[0 1 0 1 2] 274},
   [0 1 0 1 1] {[0 0 1 1 1] 195, [1 1 0 0 1] 203},
   [1 1 0 0 0] {[1 0 1 0 0] 32},
   [0 0 1 1 0] {[0 1 0 1 1] 203},
   [0 0 1 1 2] {[0 1 0 1 3] 276},
   [1 1 0 0 1] {[0 1 0 1 0] 235},
   [0 1 0 1 2] {[1 1 0 0 2] 194, [0 0 1 1 2] 275},
   [1 0 1 0 0] {[1 1 0 0 1] 32}})

(def loom-prob  (fit/rgraph2loom-probability rgraph trans-counts))
(def loom-steps (fit/rgraph2loom-steps rgraph))
(def norm-factors (fit/normalize-marking-factors rgraph))

(deftest trans-counts-test
  (testing "that trans-counts works"
      (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
            pn (as-> (fit/find-interpretation hopeful-pn log) ?pn
                 (assoc ?pn :msg-table (fit/compute-msg-table ?pn)))] 
        (is (= trans-counts (fit/trans-counts (:interp pn)))))))
                                        
(deftest msg-table-test
  (testing "that the message table looks good"
    (is (= msg-table
           (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")]
             (as-> (fit/find-interpretation hopeful-pn log) ?pn
               (fit/compute-msg-table ?pn)))))))

(deftest full-winner-process
  (testing "that the process works to winners and that intermediate test data is in sync."
    (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
          pn (as-> (fit/find-interpretation hopeful-pn log) ?pn
               (assoc  ?pn :msg-table (fit/compute-msg-table ?pn))
               (assoc  ?pn :norm-factors (fit/normalize-marking-factors (:rgraph ?pn)))
               (assoc  ?pn :trans-counts (fit/trans-counts (:interp ?pn)))
               (dissoc ?pn :interp)
               (assoc  ?pn :sigma 0.35)
               (assoc  ?pn :loom-prob (fit/rgraph2loom-probability (:rgraph ?pn) (:trans-counts ?pn)))
               (assoc  ?pn :distance-fn (fit/dist-fn-6 (:loom-prob ?pn) (:norm-factors ?pn)))
               (assoc  ?pn :pdf-fns
                       (zipmap (-> ?pn :msg-table keys)
                               (map #(fit/parzen-pdf-msg ?pn %)
                                    (-> ?pn :msg-table keys)))))]
      (is (= (:norm-factors pn) norm-factors))
      (is (= (:rgraph pn) rgraph))
      (is (= (:msg-table pn) msg-table))
      (is (= (:trans-counts pn) trans-counts))
      (is (= (fit/choose-winners pn)
             {[0 0 1 1 1] [:ordinary 0.07035003350586438],
              [0 1 0 1 0] [:ordinary 0.08612941888443124],
              [1 1 0 0 2] [:ordinary 0.06977395019946811],
              [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
              [1 1 0 0 3] [:ordinary 0.09753131509940632],
              [0 1 0 1 1] [:ordinary 0.14762935943771455],
              [1 1 0 0 0] [:m2-starved 1.0],
              [0 0 1 1 0] [:ordinary 0.0721420233904942],
              [0 0 1 1 2] [:ordinary 0.0996944685574537],
              [1 1 0 0 1] [:m2-unstarved 1.0],
              [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
              [1 0 1 0 0] [:ordinary 0.01139091655954467]})))))

(deftest pnn-for-msgs-1 
  (testing "PNN-based classification based on 'traditional' euclid-dist2"
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :distance-fn (fit/dist-fn-1 norm-factors))
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :pdf-fns
                      (zipmap (keys msg-table) 
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Not so good values, even with medium sigma.
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.1772930229756261],
            [0 1 0 1 0] [:ordinary 0.2019653717274339],
            [1 1 0 0 2] [:m2-unstarved 0.6353909887688034],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:m2-unstarved 0.16299121800184535],
            [0 1 0 1 1] [:m1-unblocked 0.6353909887688035],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.1320291240060683],
            [0 0 1 1 2] [:ordinary 0.15374605256549206],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:ordinary 0.011415187440842868]})))))

(deftest pnn-for-msgs-2
  (testing "PNN-based classification based on Distance = steps * normalized euclid-dist2." 
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :distance-fn (fit/dist-fn-2 loom-steps norm-factors))
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :pdf-fns
                      (zipmap (keys msg-table) 
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Good values, but the sigma is so tight that it won't generalize well. 
      (is (winners-ok?
           (fit/choose-winners pn) ; results not very good with normalized!
           {[0 0 1 1 1] [:ordinary 0.11280115552657274],
            [0 1 0 1 0] [:ordinary 0.11964136621006477],
            [1 1 0 0 2] [:m2-unstarved 0.25652113562024753],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:ordinary 0.11490140358513679],
            [0 1 0 1 1] [:m1-unblocked 0.2565211356202476],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.08979893169932006],
            [0 0 1 1 2] [:ordinary 0.11570085562261395],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:ordinary 0.011355578097432782]})))))
           
(deftest pnn-for-msgs-3
  (testing "PNN-based classification where Distance = product of probability along the 1/p cost path."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :norm-factors (fit/normalize-marking-factors (:rgraph ?pn)))
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :distance-fn (fit/dist-fn-3 rgraph trans-counts loom-prob))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Much larger sigma, but bad performance.
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:m1-blocked 0.438586052885812],
            [0 1 0 1 0] [:m1-blocked 0.4240039342366138],
            [1 1 0 0 2] [:m2-starved 0.4894043305758072],
            [0 1 0 1 3] [:m2-starved 0.3631584213323572],
            [1 1 0 0 3] [:m2-starved 0.3644985206255141],
            [0 1 0 1 1] [:m1-blocked 0.18596221192489185],
            [1 1 0 0 0] [:m1-blocked 0.8897313188204132],
            [0 0 1 1 0] [:m1-blocked 0.47655278089878783],
            [0 0 1 1 2] [:m2-starved 0.3631584213323572],
            [1 1 0 0 1] [:m1-blocked 0.4240039342366138],
            [0 1 0 1 2] [:m2-starved 0.17773130408512924],
            [1 0 1 0 0] [:m1-blocked 0.8897313188204132]})))))

(deftest pnn-for-msgs-4
  (testing "Distance = product of probability along a '1 per step' cost path."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :norm-factors (fit/normalize-marking-factors rgraph))
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :trans-counts trans-counts)
               (assoc ?pn :loom-prob loom-prob)
               (assoc ?pn :distance-fn (fit/dist-fn-4 loom-steps trans-counts))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; graph-distance scaling gives good results at wide sigma. 
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:m2-starved 0.9999999998000205],
            [0 1 0 1 0] [:m1-blocked 0.4240039342366138],
            [1 1 0 0 2] [:m2-starved 0.9999999995918367],
            [0 1 0 1 3] [:m2-starved 0.9999999998827412],
            [1 1 0 0 3] [:m2-starved 1.0],
            [0 1 0 1 1] [:m2-starved 0.9999999995918367],
            [1 1 0 0 0] [:m1-blocked 0.8897313188204132],
            [0 0 1 1 0] [:m1-blocked 0.47655278089878783],
            [0 0 1 1 2] [:m2-starved 0.9999999998827412],
            [1 1 0 0 1] [:m1-blocked 0.4240039342366138],
            [0 1 0 1 2] [:m2-starved 0.9999999998000205],
            [1 0 1 0 0] [:m1-blocked 0.8897313188204132]})))))

(deftest pnn-for-msgs-5
  (testing "Measure distance as the sum of 1/p steps along shortest path times 
            normalized euclid-dist2, sigma=0.25, sqrt distance in the parzen-pdf-msg" 
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :trans-counts trans-counts)
               (assoc ?pn :distance-fn (fit/dist-fn-5 loom-prob))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.06977147041215553],
            [0 1 0 1 0] [:ordinary 0.08502197400428994],
            [1 1 0 0 2] [:ordinary 0.06926258672468386],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:ordinary 0.09925020351353822],
            [0 1 0 1 1] [:ordinary 0.14401317115106646],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.07333414873688693],
            [0 0 1 1 2] [:ordinary 0.09901759234253096],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:m2-starved 0.016879884148789895]})))))

(deftest pnn-for-msgs-6
  (testing "Measure distance as the sum of 1/p steps along shortest path times 
            normalized euclid-dist2, sigma=0.25, sqrt distance in the parzen-pdf-msg" 
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :msg-table msg-table)
               (assoc ?pn :trans-counts trans-counts)
               (assoc ?pn :distance-fn (fit/dist-fn-6 loom-prob norm-factors))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.07035003350586438],
            [0 1 0 1 0] [:ordinary 0.08612941888443124],
            [1 1 0 0 2] [:ordinary 0.06977395019946811],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:ordinary 0.09753131509940632],
            [0 1 0 1 1] [:ordinary 0.14762935943771455],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.0721420233904942],
            [0 0 1 1 2] [:ordinary 0.0996944685574537],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:ordinary 0.01139091655954467]})))))

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

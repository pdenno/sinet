(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint)]
            [gov.nist.spntools.core :as spn]
            [gov.nist.spntools.util.reach :as pnr]
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

(def example-msgs
  {:m2-unstarved {[0 0 1 1 0] 14},
   :m1-unblocked {[2 1 0 1 0] 30},
   :m2-starved   {[0 0 1 0 1] 14},
   :m1-blocked   {[3 0 1 1 0] 30},
   :ordinary
   {[0 1 0 1 0] 203,
    [2 0 1 1 0] 511,
    [1 1 0 1 0] 263,
    [3 0 1 0 1] 248,
    [1 0 1 1 0] 466,
    [0 1 0 0 1] 14,
    [2 1 0 1 0] 248,
    [3 0 1 1 0] 248,
    [1 0 1 0 1] 217,
    [0 0 1 1 0] 217,
    [0 0 1 0 1] 14,
    [2 0 1 0 1] 263}})

(defn pnn-all-ok?
  "Returns true if calculated are as expected."
  [calculated expected]
  (every? (fn [[mark [msg value]]]
            (and (= msg    (-> (get expected mark) first))
                 (=* value (-> (get expected mark) second) 0.00001)))
          calculated))

;;; POD *THIS* (and not problem-setting-feature if you can help it) is how to code these.
;;;     Here I am loading scada directly, not counting on app.clj
;;; defn rather than def so that I don't get dragged into fixing a bug every time I load this. 
(defn test-pn
  "Partiallly complete PN for PNN testing."
  []
  (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")]
    (as-> "data/PNs/m2-inhib-n3.xml" ?pn
      (pnml/read-pnml ?pn)
      (pnr/renumber-pids ?pn)
      (assoc ?pn :log log)
      (assoc ?pn :last-line (-> log last :line))
      (assoc ?pn :rgraph (vec (pnr/simple-reach ?pn)))
      (assoc ?pn :k-limited? (-> ?pn :rgraph :k-limited?))
      (assoc ?pn :rgraph (-> ?pn :rgraph :rgraph vec))
      (assoc ?pn :starting-links (fit/starting-links ?pn 0))
      (assoc ?pn :msg-table (fit/compute-msg-table ?pn))
      (assoc ?pn :distance-fn pnn/euclid-dist2))))

;;; There are more state that this in the PN, but not all occurred in the 3000 msgs logged. That's okay. 
(deftest pnn-for-msgs-1 
  (testing "PNN-based classification using Euclidean/sigma=0.2"
    (let [pn (as-> (test-pn) ?pn
               (assoc ?pn :sigma 0.2)  ; sigma = 0.2
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Good values, but the sigma is so tight that it won't generalize well. 
      (is (pnn-all-ok?
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
    (let [pn (as-> (test-pn) ?pn
                 (assoc ?pn :sigma 0.75)
                 (assoc ?pn :pdf-fns
                        (zipmap (-> ?pn :msg-table keys)
                                (map #(fit/parzen-pdf-msg ?pn %)
                                     (-> ?pn :msg-table keys)))))]
      ;; Much larger sigma, but bad performance.
      (is (pnn-all-ok?
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
               (assoc ?pn :distance-fn (fit/graph-distance-fn ?pn))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; graph-distance scaling gives good results at wide sigma. 
      (is (pnn-all-ok?
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











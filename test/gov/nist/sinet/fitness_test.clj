(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [gov.nist.spntools.core :as spn]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.core :as pn]
            [gov.nist.sinet.util :as util :refer (map->Inv app-info reset big-reset)]
            [gov.nist.sinet.app :as app]
            [gov.nist.sinet.run :as run]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.sinet.simulate :as sim]
            [gov.nist.sinet.fitness :as fit]))

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
  (let [pn (-> "/data/PNs/m2-inhib-bas.xml" 
               spn/run-ready
               gp/add-color-binding
               (gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
               (sim/simulate :max-steps steps))]
    (fit/workflow-fitness (map->Inv {:pn pn}))))

(deftest perfect-fitness-scores-zero
  (testing "That a PN matching the log scores zero."
    (is (=* 0.0 (m2-inhib-bas-workflow-fit 200) 0.01))))

(defn problem-setting-fixture
  "Set the 'problem' (the log we look at) to the m2-inhib-bas problem."
  [f]
  (let [orig-scada (-> (app-info) :problem :scada-data-file)]
    (swap! app/problem #(assoc % :scada-data-file "data/SCADA-logs/scada-m2-inhib-bas.clj"))
    (util/big-reset) ;; POD need something less extreme than this! stop and start app!
    (f) ; The canonical fixture function, in this case called using the 'once' procedure
    (swap! app/problem #(assoc % :scada-data-file orig-scada))
    (util/big-reset)))

(use-fixtures :once problem-setting-fixture)

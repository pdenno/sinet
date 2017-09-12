(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.core :as pn]
            [gov.nist.sinet.util :refer (map->Inv)]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.sinet.fitness :as fit]))

(defn =*
  "Check that v1 is = v2 +/i tolerance."
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

;;; POD This needs work. The flow-priorities could be wrong.
;;; Could use a force-flow-priorities. Define it in this file.
(defn m2-inhib-bas-fit
  "Setup the m2-inhib-bas PN for a fitness test"
 [steps]       ;     Change...
  (-> "/Users/peterdenno/Documents/git/spntools/data/m2-inhib-bas.xml" 
      gov.nist.spntools.core/run-ready
      gov.nist.sinet.gp/add-color-binding
      (gov.nist.sinet.gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
      (gov.nist.sinet.gp/diag-force-rep
       [{:name :m1-start-job, :act :aj, :m :m1}
        {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}
        {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}
        {:name :m2-complete-job, :act :ej, :m :m2}])
      (sim/simulate :max-steps steps)))

;;; POD NYI
(deftest perfect-fitness-scores-zero
  (testing "That a PN matching the log scores zero."
    (is (=* 0.0 (m2-inhib-bas-fit) 0.01))))


     




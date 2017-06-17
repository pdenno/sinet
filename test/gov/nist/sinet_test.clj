(ns gov.nist.sinet-test
  (:require [clojure.test :refer :all]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.sinet.core :refer :all]
            [gov.nist.sinet.util.fitness :as fit :refer :all]))

(load-file "data/SCADA-logs/scada-f0.clj") ; defines fit/scada-log-f0
(load-file "data/test-individuals/test-m2-bas.clj") ; defines (in .core) test-m2-bas individual (a perfect individual for scada-log-f0)
(load-file "data/QPN-logs/qpn-m2-bas.clj") ; defines fit/qpn-m2-bas (a log for the perfect individual above)

(deftest scada-pattern-disorder
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
             (fit/calc-process-disorder (fit/qpn-log-about test-m2-bas 22) 22)
              
              (first pats)
              22
              (qpn-gather-job qpn-m2-bas 22))))
      (is (= 1
             (fit/calc-activity-disorder
              test-m2-bas
              (first pats)
              22
              [{:act :bj, :tkns [{:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
               {:act :sm, :tkns [{:type :a, :id 22}]}
               {:act :ej, :tkns [{:type :a, :id 22}]}])))
      (is (= 4
             (fit/calc-activity-disorder
              test-m2-bas
              (first pats)
              22
              [{:act :ej, :tkns [{:type :a, :id 22}]}
               {:act :bj, :tkns [{:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
               {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
               {:act :sm, :tkns [{:type :a, :id 22}]}]))))))
     




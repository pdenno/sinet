(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.sinet.gp :as gp :refer :all]
            [gov.nist.sinet.fitness :as fit #_:refer #_(scada-log-f0 scada-patterns calc-process-disorder qpn-m2-bas)]))


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



(defn m2-inhib-bas-test
  "Does 'the' correct answer score 0?"
 []       ;     cartier...
  (as-> "/Users/peterdenno/Documents/git/spntools/data/m2-inhib-bas.xml" ?inv
    (gov.nist.sinet.gp/map->Inv {:pn (pn/run-ready ?inv)})
    (gov.nist.sinet.gp/add-color-binding ?inv)
    (update ?inv :pn
            (fn [pn]
              (reduce (fn [pn trans] (gov.nist.sinet.gp/assign-flow-priorities pn trans))
                      pn
                      (->> pn :transitions (map :name)))))
    (workflow-fitness ?inv)))

(deftest perfect-fitness-scores-zero
  (testing "That a PN matching the log scores zero."
    (is (=* 0.0 (m2-inhib-bas-test) 0.01))))


     




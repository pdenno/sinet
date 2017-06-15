(ns gov.nist.sinet-test
  (:require [clojure.test :refer :all]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.sinet.core :refer :all]
            [gov.nist.sinet.util.fitness :as fit :refer :all]))

(load-file "data/SCADA-logs/scada-f0.clj") ; defines fit/scada-log-f0
(load-file "data/QPN-logs/qpn-m2-bas.clj") ; defines fit/qpn-m2-bas (a perfect individual for scada-log-f0)

(def test-m2-bas
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

(deftest scada-pattern-disorder
  (testing "scada-pattern-generation-and-qpn-disorder"
    (let [pats (as-> (:log fit/scada-log-f0) ?pats
                 (fit/scada-patterns ?pats)
                 (fit/trim-patterns ?pats 5 5)
                 (map #(assoc % :relations (fit/scada-pattern-ordering %)) ?pats)
                 (map #(dissoc % :jobs) ?pats))]
      (is (= (count pats) 1))
      (is (= (dissoc (first pats) :relations)
             {:id 3, :form
              [{:act :aj, :jt \*}
               {:act :bj, :bf \*, :n \*}
               {:act :sm, :bf \*, :n \*}
             {:act :ej, :m \*}]}))
      (is (= 0
             (fit/calc-activity-disorder
              test-m2-bas
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
     




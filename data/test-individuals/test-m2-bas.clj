
(ns gov.nist.sinet.gp)

;;; m2-bas
(def test-m2-bas
  (map->Inv
   {:pn
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
     [{:aid 10, :source :buffer, :target :m1-start-job, :name :aa-10, :type :inhibitor, :multiplicity 3 :bind {:type :a}}
      {:aid 11, :source :buffer, :target :m2-start-job, :name :aa-11, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 12, :source :m1-blocked, :target :m1-start-job, :name :aa-12, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 13, :source :m1-busy, :target :m1-complete-job, :name :aa-13, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 14, :source :m1-complete-job, :target :m1-blocked, :name :aa-14, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 15, :source :m1-start-job, :target :buffer, :name :aa-15, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 16, :source :m1-start-job, :target :m1-busy, :name :aa-16, :type :normal, :multiplicity 1
       :bind {:type :a :act :intro :cnt 1}}
      {:aid 17, :source :m2-busy, :target :m2-complete-job, :name :aa-17, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 18, :source :m2-complete-job, :target :m2-starved, :name :aa-18, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 19, :source :m2-start-job, :target :m2-busy, :name :aa-19, :type :normal, :multiplicity 1 :bind {:type :a}}
      {:aid 20, :source :m2-starved, :target :m2-start-job, :name :aa-20, :type :normal, :multiplicity 1
       :bind {:type :a :act :elim :cnt 1}}]}}))


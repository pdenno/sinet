
;;; A three-machine system with two buffers (mutate :add-buffer)-ed in. 

{:places
 [{:name :place-1, :pid 7, :initial-tokens 1, :visible? true}
  {:name :place-2, :pid 8, :initial-tokens 0, :visible? true}
  {:name :place-3, :pid 9, :initial-tokens 0, :visible? true}
  {:name :place-4, :pid 10, :initial-tokens 0, :visible? true}
  {:name :place-5, :pid 11, :initial-tokens 0, :visible? true}
  {:name :place-6, :pid 12, :initial-tokens 0, :visible? true}
  {:name :Place-13, :pid 13, :initial-tokens 0}
  {:name :Place-14, :pid 14, :initial-tokens 0}],
 :transitions
 [{:name :m1-start-job,
   :tid 7,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2447.3391, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 2448.3391, :j 1667, :line 2060},
   :visible? true}
  {:name :m1-complete-job,
   :tid 8,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2448.3391, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 1667, :line 2063},
   :visible? true}
  {:name :m2-start-job,
   :tid 9,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2449.4604, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 1667, :line 2072},
   :visible? true}
  {:name :m2-complete-job,
   :tid 10,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2450.4604, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 1667, :line 2077},
   :visible? true}
  {:name :m3-start-job,
   :tid 11,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2452.4604, :act :m3-start-job, :m :m3, :mjpact :sm, :bf :b2, :n 2, :j 1667, :line 2088},
   :visible? true}
  {:name :m3-complete-job,
   :tid 12,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 2453.5276, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2447.3391, :j 1667, :line 2092},
   :visible? true}],
 :arcs
 [{:aid 13, :source :place-1, :target :m3-start-job, :name :aa-13, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 14, :source :m1-start-job, :target :place-2, :name :aa-14, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 15, :source :place-2, :target :m1-complete-job, :name :aa-15, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 16, :source :m1-complete-job, :target :place-3, :name :aa-16, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 17, :source :place-3, :target :m1-start-job, :name :aa-17, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 18, :source :m2-start-job, :target :place-4, :name :aa-18, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 19, :source :place-4, :target :m2-complete-job, :name :aa-19, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 20, :source :m2-complete-job, :target :place-5, :name :aa-20, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 21, :source :place-5, :target :m2-start-job, :name :aa-21, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 22, :source :m3-start-job, :target :place-6, :name :aa-22, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 23, :source :place-6, :target :m3-complete-job, :name :aa-23, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 24, :source :m3-complete-job, :target :place-1, :name :aa-24, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 25, :source :m1-start-job, :target :Place-13, :name :aa-25, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 26, :source :Place-13, :target :m2-start-job, :name :aa-26, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 27, :source :m2-complete-job, :target :Place-14, :name :aa-27, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 28, :source :Place-14, :target :m3-start-job, :name :aa-28, :type :normal, :multiplicity 1, :bind {:jtype :blue}}]}

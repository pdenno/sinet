{:places
 [{:name :place-2, :pid 1, :initial-tokens 1, :visible? true}
  {:name :place-3, :pid 2, :initial-tokens 0, :visible? true}
  {:name :place-4, :pid 3, :initial-tokens 1, :visible? true}
  {:name :place-5, :pid 4, :initial-tokens 0, :visible? true}
  {:name :place-6, :pid 5, :initial-tokens 1, :visible? true}
  {:name :place-7, :pid 6, :initial-tokens 0, :visible? true}
  {:name :place-8, :pid 7, :initial-tokens 1, :visible? true}
  {:name :wait-1, :pid 8, :initial-tokens 0, :purpose :waiting}
  {:name :wait-2, :pid 9, :initial-tokens 0, :purpose :waiting}
  {:name :wait-3, :pid 10, :initial-tokens 0, :purpose :waiting}
  {:name :place-p-1, :pid 12, :initial-tokens 1, :visible? true}
  {:name :place-p-2, :pid 13, :initial-tokens 0, :purpose :waiting}],
 :transitions
 [{:name :m1-start-job,
   :tid 9,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 593.1681, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :j 447, :line 672},
   :visible? true}
  {:name :m1-complete-job,
   :tid 10,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 594.1681, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 447, :line 676},
   :visible? true}
  {:name :m2-start-job,
   :tid 11,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 594.4003, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 447, :line 685},
   :visible? true}
  {:name :m2-complete-job,
   :tid 12,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 595.4003, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 447, :line 690},
   :visible? true}
  {:name :m3-2-start-job,
   :tid 13,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 600.371, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 447, :line 716},
   :visible? true}
  {:name :m3-2-complete-job,
   :tid 14,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 603.971, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 447, :line 742},
   :visible? true}
  {:name :m4-start-job,
   :tid 15,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 604.771, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 447, :line 747},
   :visible? true}
  {:name :m4-complete-job,
   :tid 16,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 605.971, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 593.1681, :j 447, :line 751},
   :visible? true}
  {:name :m3-1-start-job,
   :tid 13,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 600.371, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 447, :line 716},
   :visible? true}
  {:name :m3-1-complete-job,
   :tid 14,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 603.971, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 447, :line 742},
   :visible? true}],
 :arcs
 [{:aid 18, :source :m1-start-job, :target :place-2, :name :aa-18, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 19, :source :place-2, :target :m1-complete-job, :name :aa-19, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 20, :source :m1-start-job, :target :place-3, :name :aa-20, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 21, :source :place-3, :target :m2-start-job, :name :aa-21, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 22, :source :m2-start-job, :target :place-4, :name :aa-22, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 23, :source :place-4, :target :m2-complete-job, :name :aa-23, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 24, :source :m2-complete-job, :target :place-5, :name :aa-24, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 25, :source :place-5, :target :m3-2-start-job, :name :aa-25, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 26, :source :m3-2-start-job, :target :place-6, :name :aa-26, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 27, :source :place-6, :target :m3-2-complete-job, :name :aa-27, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 28, :source :m3-2-complete-job, :target :place-7, :name :aa-28, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 29, :source :place-7, :target :m4-start-job, :name :aa-29, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 30, :source :m4-start-job, :target :place-8, :name :aa-30, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 31, :source :place-8, :target :m4-complete-job, :name :aa-31, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 51, :source :m1-complete-job, :target :wait-1, :name :aa-51, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 52, :source :wait-1, :target :m1-start-job, :name :aa-52, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 53, :source :m2-complete-job, :target :wait-2, :name :aa-53, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 54, :source :wait-2, :target :m2-start-job, :name :aa-54, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 55, :source :m3-2-complete-job, :target :wait-3, :name :aa-55, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 56, :source :wait-3, :target :m3-2-start-job, :name :aa-56, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 58, :source :place-p-1, :target :m3-1-complete-job, :name :arc-p-1, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 59, :source :m3-1-complete-job, :target :place-p-2, :name :arc-p-2, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 60, :source :m3-1-start-job, :target :place-p-1, :name :arc-p-3, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 61, :source :place-p-2, :target :m3-1-start-job, :name :arc-p-4, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 155, :source :place-5, :target :m3-1-start-job, :name :aa-155, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 156, :source :m3-1-complete-job, :target :place-7, :name :aa-156, :type :normal, :multiplicity 1, :bind {:jtype :blue}}]}

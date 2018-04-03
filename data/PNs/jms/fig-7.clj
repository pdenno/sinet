{:places
 [{:name :wc1-busy, :pid 1, :initial-tokens 1, :visible? true}
  {:name :buffer-1, :pid 2, :initial-tokens 0, :visible? true}
  {:name :wc2-busy, :pid 3, :initial-tokens 1, :visible? true}
  {:name :buffer-2, :pid 4, :initial-tokens 0, :visible? true}
  {:name :wc1-blocked, :pid 8, :initial-tokens 0, :purpose :waiting}
  {:name :wc2-blocked, :pid 9, :initial-tokens 0, :purpose :waiting}
  {:name :wc3-starved, :pid 10, :initial-tokens 0, :purpose :waiting}
  {:name :m3-busy, :pid 13, :initial-tokens 0, :purpose :waiting}
  {:name :wc2-starved, :pid 14, :initial-tokens 0, :purpose :waiting}],
 :transitions
 [{:name :wc1-start-job,
   :tid 9,
   :type :immediate,
   :rate 1.0,
   :rep {:clk 593.1681, :act :wc1-start-job, :m :wc1, :mjpact :aj, :jt :jobType2, :j 447, :line 672},
   :visible? true}
  {:name :wc1-complete-job,
   :tid 10,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 594.1681, :act :wc1-complete-job, :m :wc1, :mjpact :bj, :bf :b1, :n 0, :j 447, :line 676},
   :visible? true}
  {:name :wc2-start-job,
   :tid 11,
   :type :immediate,
   :rate 1.0,
   :rep {:clk 594.4003, :act :wc2-start-job, :m :wc2, :mjpact :sm, :bf :b1, :n 1, :j 447, :line 685},
   :visible? true}
  {:name :wc2-complete-job,
   :tid 12,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 595.4003, :act :wc2-complete-job, :m :wc2, :mjpact :bj, :bf :b2, :n 1, :j 447, :line 690},
   :visible? true}
  {:name :wc3-start-job,
   :tid 13,
   :type :immediate,
   :rate 1.0,
   :rep {:clk 600.371, :act :wc3-start-job, :m :wc3, :mjpact :sm, :bf :b2, :n 2, :j 447, :line 716},
   :visible? true}
  {:name :wc3-complete-job,
   :tid 14,
   :type :exponential,
   :rate 1.0,
   :rep {:clk 603.971, :act :wc3-complete-job, :m :wc3, :mjpact :bj, :bf :b3, :n 0, :j 447, :line 742},
   :visible? true}
  
  {:name :wc2-unstarve,
   :tid 14,
   :type :immediate,
   :rate 1.0,
   :rep {:clk 603.971, :act :w2-unstarve, :m :wc3, :mjpact :bj, :bf :b3, :n 0, :j 447, :line 742},
   :visible? true}
  {:name :wc2-unblock,
   :tid 14,
   :type :immediate,
   :rate 1.0,
   :rep {:clk 603.971, :act :wc2-unblock, :m :wc3, :mjpact :bj, :bf :b3, :n 0, :j 447, :line 742},
   :visible? true}
  ],
 :arcs
 [{:aid 18, :source :wc1-start-job, :target :wc1-busy, :name :aa-18, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 19, :source :wc1-busy, :target :wc1-complete-job, :name :aa-19, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 20, :source :wc1-start-job, :target :buffer-1, :name :aa-20, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 21, :source :buffer-1, :target :wc2-start-job, :name :aa-21, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 22, :source :wc2-start-job, :target :wc2-busy, :name :aa-22, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
  {:aid 23, :source :wc2-busy, :target :wc2-complete-job, :name :aa-23, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 25, :source :buffer-2, :target :wc3-start-job, :name :aa-25, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 51,
   :source :wc1-complete-job,
   :target :wc1-blocked,
   :name :aa-51,
   :type :normal,
   :multiplicity 1,
   :bind {:jtype :blue},
   :priority 2}
  {:aid 52,
   :source :wc1-blocked,
   :target :wc1-start-job,
   :name :aa-52,
   :type :normal,
   :multiplicity 1,
   :bind {:jtype :blue}}
  {:aid 53, :source :wc2-complete-job, :target :wc2-blocked, :name :aa-53, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 2}
  {:aid 55,
   :source :wc3-complete-job,
   :target :wc3-starved,
   :name :aa-55,
   :type :normal,
   :multiplicity 1,
   :bind {:jtype :blue},
   :priority 1}
  {:aid 56, :source :wc3-starved, :target :wc3-start-job, :name :aa-56, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 59,
   :source :wc3-complete-job,
   :target :m3-busy,
   :name :arc-p-2,
   :type :normal,
   :multiplicity 1,
   :bind {:jtype :blue},
   :priority 1}
  {:aid 61, :source :m3-busy, :target :wc3-start-job, :name :arc-p-4, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  
  {:aid 156, :source :wc2-unstarve, :target :wc2-busy, :name :aa-156, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 157, :source :wc2-busy,     :target :wc2-unstarve, :name :aa-157, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 158, :source :wc2-complete-job, :target :wc2-starved, :name :aa-158, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 54,  :source :wc2-blocked, :target :wc2-start-job, :name :aa-54, :type :inhibitor, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 160, :source :wc2-busy,     :target :wc2-start-job, :name :aa-160, :type :inhibitor, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 161, :source :wc2-starved,  :target :wc2-unstarve, :name :aa-161, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 162, :source :wc2-blocked,  :target :wc2-unblock, :name :aa-162, :type :normal, :multiplicity 1, :bind {:jtype :blue}}

  {:aid 163, :source :wc2-unblock, :target :buffer-2, :name :aa-163, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 164, :source :buffer-2,    :target :wc2-unblock, :name :aa-164, :type :inhibitor, :multiplicity 1, :bind {:jtype :blue}}
  {:aid 165, :source :buffer-1,    :target :wc1-start-job, :name :aa-165, :type :inhibitor, :multiplicity 1, :bind {:jtype :blue}}
  ],
  :geom
 {:wc3-starved {:x 651, :y 316, :label-x-off 12, :label-y-off 18},
  :wc3-start-job {:x 582, :y 465, :label-x-off 12, :label-y-off 18},
  :wc2-starved {:x 319, :y 312, :label-x-off -34, :label-y-off 34},
  :wc1-busy {:x 36, :y 318, :label-x-off 12, :label-y-off 18},
  :wc1-complete-job {:x 86, :y 205, :label-x-off 12, :label-y-off 18},
  :wc2-unstarve {:x 269, :y 303, :label-x-off -19, :label-y-off -14},
  :wc2-busy {:x 204, :y 306, :label-x-off -39, :label-y-off -19},
  :m3-busy {:x 505, :y 319, :label-x-off 12, :label-y-off 18},
  :wc1-blocked {:x 139, :y 329, :label-x-off 12, :label-y-off 18},
  :wc1-start-job {:x 77, :y 451, :label-x-off -45, :label-y-off 21},
  :wc2-complete-job {:x 311, :y 202, :label-x-off 12, :label-y-off 18},
  :wc2-blocked {:x 422, :y 315, :label-x-off 12, :label-y-off 18},
  :wc2-unblock {:x 418, :y 415, :label-x-off 12, :label-y-off 18},
  :wc2-start-job {:x 302, :y 457, :label-x-off 12, :label-y-off 18},
  :buffer-1 {:x 173, :y 457, :label-x-off 12, :label-y-off 18},
  :buffer-2 {:x 459, :y 459, :label-x-off 12, :label-y-off 18},
  :wc3-complete-job {:x 576, :y 213, :label-x-off 12, :label-y-off 18}}}

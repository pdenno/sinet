
;;; Just like the original f0, but with buffer of size 2 and work at m1 taking much longer than
;;; work at m2.
;;; Steady-state:
#_{:TP 0.45325,
 :number-of-jobs 3626,
 :jobmix {:jobType1 {:w {:m1 2.0, :m2 0.8}, :portion 1.0}},
 :avg-buffer-occupancy {:b1 0.07359382536183143},
 :status nil,
 :runtime 1.203,
 :starved {:m1 0.0, :m2 0.5601215859893464},
 :observed-residence-time 3.258176494622952,
 :blocked {:m1 0.0, :m2 0.0},
 :bottleneck-machine :m1,
 :process-id 0}
;;;  ./MJPdes -i ../../sinet/data/SCADA-logs/scada-f0-imbalanced-input.clj -o ../../sinet/data/SCADA-logs/scada-f0-imbalanced.clj
 (map->Model
  {:line 
   {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0}) 
    :b1 (map->Buffer {:N 2})
    :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
   :number-of-simulations 1
   :report {:log? true :max-lines 1000}
   :topology [:m1 :b1 :m2]
   :entry-point :m1
   :params {:warm-up-time 2000 :run-to-time 10000}
   :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 2.0, :m2 0.8}})}})

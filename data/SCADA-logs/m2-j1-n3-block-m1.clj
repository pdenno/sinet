;;; Imbalanced line of 2 machines with 3 buffer spots -- Lots of blocking of m1. 
;;; ./MJPdes -i ~/Documents/git/sinet/data/SCADA-logs/m2-j1-n3-block-m1.clj -o ~/Documents/git/sinet/data/SCADA-logs/m2-j1-n3-block-raw.clj
(map->Model
 {:line 
  {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0}) 
   :b1 (map->Buffer {:N 3})
   :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
  :number-of-simulations 1
  :report {:log? true :max-lines 3000}
  :topology [:m1 :b1 :m2]
  :entry-point :m1
  :params {:warm-up-time 2000 :run-to-time 10000}
  :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 1.0, :m2 3.1}})}})

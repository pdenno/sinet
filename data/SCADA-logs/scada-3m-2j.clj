;;; ./MJPdes -i ~/Documents/git/sinet/data/SCADA-logs/scada-3m-2j.clj -o ~/Documents/git/sinet/data/SCADA-logs/scada-3m-2j-out.clj
(map->Model
 {:line 
  {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0}) 
   :b1 (map->Buffer {:N 2})
   :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})
   :b2 (map->Buffer {:N 2})
   :m3 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
  :number-of-simulations 1
  :report {:log? true :max-lines 3000}
  :topology [:m1 :b1 :m2 :b2 :m3]
  :entry-point :m1
  :params {:warm-up-time 2000 :run-to-time 10000}
  :jobmix {:jobType1 (map->JobType {:portion 0.5 :w {:m1 1.0, :m2 1.0, :m3 1.0}})
           :jobType2 (map->JobType {:portion 0.5 :w {:m1 1.5, :m2 1.5, :m3 1.5}})}})

;;; Good balance less than 1% :bl :st
;;; ./MJPdes -i ~/Documents/git/sinet/data/SCADA-logs/m2-j1-n3-block-mild.clj -o ~/Documents/git/sinet/data/SCADA-logs/m2-j1-n3-block-mild-out-2.clj
(map->Model
 {:line 
  {:m1 (map->ExpoMachine {:lambda 0.6 :mu 3.5 :W 1.0}) 
   :b1 (map->Buffer {:N 3})
   :m2 (map->ExpoMachine {:lambda 0.001 :mu 0.99 :W 1.0})}
  :number-of-simulations 1
  :report {:log? true :max-lines 3000}
  :topology [:m1 :b1 :m2]
  :entry-point :m1
  :params {:warm-up-time 2000 :run-to-time 10000}
  :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 1.0, :m2 1.17}})}})

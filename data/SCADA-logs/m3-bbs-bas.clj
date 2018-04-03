;;; 2018-02-03 For testing log-only BBS/BAS detection.
;;; ./MJPdes -i ~/Documents/git/sinet/data/SCADA-logs/m3-bbs-bas.clj -o ~/Documents/git/sinet/data/SCADA-logs/m3-bbs-bas-out.clj
;;; ./MJPdes -i ~/Documents/git/sinet/data/SCADA-logs/m3-bbs-bas.clj -o ~/Documents/git/sinet/data/SCADA-logs/fitness-test2-m3-bbs-bas-out.clj
(map->Model
   {:line 
    {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BBS}) 
     :b1 (map->Buffer {:N 1})
     :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BAS})
     :b2 (map->Buffer {:N 1})
     :m3 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BAS})}
    :number-of-simulations 1
    :report {:log? true :max-lines 3000 :up&down? false}
    :topology [:m1 :b1 :m2 :b2 :m3]
    :entry-point :m1
    :params {:warm-up-time 500 :run-to-time 1000}
    :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 0.9, :m2 1.0 :m3 1.2}})}})

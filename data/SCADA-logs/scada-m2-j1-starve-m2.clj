;;; Imbalanced line of 2 machines with 1 buffer spot -- simplest test of exceptional messages. Lots of starvation of m2. 
(map->Model
 {:line 
  {:m1 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0}) 
   :b1 (map->Buffer {:N 1})
   :m2 (map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0})}
  :number-of-simulations 1
  :report {:log? true :max-lines 3000}
  :topology [:m1 :b1 :m2]
  :entry-point :m1
  :params {:warm-up-time 2000 :run-to-time 10000}
  :jobmix {:jobType1 (map->JobType {:portion 1.0 :w {:m1 1.0, :m2 0.9}})}})

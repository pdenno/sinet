(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (pprint)]
            [clojure.spec.alpha :as s]
            [clojure.core.async :as async :refer [>! <! >!! <!! chan]]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.MJPdes.core :as des]))

#_(def des-model
  (des/map->Model
   {:line 
    {:m1 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BBS}) 
     :b1 (des/map->Buffer {:N 1})
     :m2 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BAS})
     :b2 (des/map->Buffer {:N 1})
     :m3 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BAS})}
    :report {:continuous? true :up&down? false}
    :topology [:m1 :b1 :m2 :b2 :m3]
    :entry-point :m1
    :params {:warm-up-time 500}
    :jobmix {:jobType1 (des/map->JobType {:portion 1.0 :w {:m1 0.9, :m2 1.0 :m3 1.2}})}}))

(def des-model
   (des/map->Model 
    {:line     
     {:wc1 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 })  
      :b1 (des/map->Buffer {:N 2}) ; originally 3                              
      :wc2 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 :discipline :BBS})
      :b2 (des/map->Buffer {:N 2}) ; originally 5
      :wc3-1 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 })
      :wc3-2 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 })
      :wc3-3 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 }) 
      :b3 (des/map->Buffer {:N 1})                              
      :wc4 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 }) 
      :b4 (des/map->Buffer {:N 1})
      :wc5 (des/map->ExpoMachine {:lambda 0.1 :mu 0.9 :W 1.0 })
      }
     :topology [:wc1 :b1 :wc2 :b2
                {:type :parallel-or :name :wc3 :machines [:wc3-1 :wc3-2]}
                :b3 :wc4 :b4 :wc5]
     :entry-point :wc1
     :report {:continuous? true :up&down? false :job-detail? true}
     :params {:warm-up-time 500}
     :jobmix {:jobType1 (des/map->JobType {:portion 0.8
                                       :w {:wc1 1.0, :wc2 1.0, :wc3 3.0, :wc4 1.0, :wc5 1.0}})
              :jobType2 (des/map->JobType {:portion 0.2
                                           :w {:wc1 1.0, :wc2 1.0, :wc3 3.6, :wc4 1.2, :wc5 1.0}})}}))

(def mutation-dist "The pdf for ordinary mutations (not eden mutations)"
  [[:add-place                  0] ; Add place (mine can't be absorbing, thus Nobile 1&2).
   [:add-trans                  0]
   [:add-machine-restart-bbs 2/10] ; New for November 27. (Yeah right, finishend Dec 17th!)
   [:bas-to-bbs              1/10]
   [:bbs-to-bas              1/10]   
   [:add-arc                    0] ; 1/20 pre-except, 1/10 pre bbs-to-bas
   [:remove-place               0] ; 1/10 pre-except
   [:remove-trans               0] ; 1/10 pre-November 27
   [:remove-arc                 0] ; 1/10 pre bbs-to-bas
   [:swap-priority           1/10]])

(def gp-params
  (ref
   {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
    :pop-size 25          ; 100 pre-except
    :aqpn-warm-up 5       ; Ignore this number of tokens on both ends of the log.
    
    :max-gens 30           ; These three control how long gp runs.  
    :success-threshold 0.15
    :timeout-secs 1200 ; 20 minutes
    
    :favor-smaller-pn? false
    :debugging? true
    :pn-k-bounded 10 ; When to give up on computing the reachability graph.
    :min-max-k  2 ; POD 1    ; Minimum token count for max-k used in computing lax rgraph
    :max-max-k  2 ; POD 3    ; Maximum token count for max-k used in computing lax rgraph 
    :pn-max-rs 1000
    :crossover-to-mutation-ratio 0.5
    :select-pressure 4 ; POD not normalized to pop-size! Spector: 7/1000
    :elite-individuals 1
    :no-new-jobs-penalty 1.00001
    :no-qpn-log-penalty  3.000003 ; This if, for example, one transition, one place and two arcs back and forth. 
    :crossover-keeps-parents? true ; NYI
    :exceptional-sigma 0.40 ; sigma squared is variance of PDF around training point (exceptional message). Was 0.75!
    :mutation-dist mutation-dist}))

(def problem
  (ref ; :scada-log will be computed in app-start-body
   {:keep-vs-ignore 0.8
    :des-model (des/main-loop des-model)
    :log-bite-size 1000
    ;:scada-data-file "data/SCADA-logs/m3-bbs-bas-out.clj"
    #_"data/SCADA-logs/scada-3m-2j-third-out.clj"
    #_"data/SCADA-logs/m2-j1-n3-block-mild-out.clj"      
    #_"data/SCADA-logs/m2-j1-n3-block-out.clj"
    #_"data/SCADA-logs/scada-m2-j1-starve-m2-out.clj" ;"scada-f0-imbalanced.clj"
    :pattern-reserves #{:act :jt :bf :m :n}}))

(defn gp-system
  "Create an async channel for communcation about evolution."
  []
  (let [chan (async/chan)]
    {:evolve-chan chan
     :use-cpus (.availableProcessors (Runtime/getRuntime)) ; Counts hyperthreading, apparently. 
     :check-asserts? true}))

(defn app-start-body
  "Compose the parts of component and optionally s/check-assert."
  [component ws-connection]
  (let [comp (as-> component ?c
               (assoc ?c
                      :gp-params @gp-params
                      :problem   @problem
                      :gp-system (gp-system))
               (assoc-in ?c [:problem :scada-log]
                         (scada/load-scada-raw
                          (des/pull-data! (:des-model @problem) 1000))))]
    (s/check-asserts (-> comp :gp-system :check-asserts?))
    (s/assert ::app comp)
    (gp/start-evolve-loop! (-> comp :gp-system :evolve-chan))
    comp))

(s/def ::evolve-chan (s/and #(= (type %) clojure.core.async.impl.channels.ManyToManyChannel))) 
(s/def ::gp-system (s/keys :req-un [::evolve-chan]))
(s/def ::app (s/keys :req-un [::gp-system]))

;;; Start and stop will reset the component to what is returned here. Thus I use refs
;;; for things that I want to change and I do not reload this file on reset.
;;; See use of (nsp/disable-reload! (find-ns 'gov.nist.sinet.app)) in util.clj.
(defrecord App [ws-connection]
  component/Lifecycle
  (start [component]
    ;; Things here should not reference app-info; it won't be set. Instead, pass args in.
    (app-start-body component ws-connection))
  (stop [component]
    (>!! (-> component :gp-system :evolve-chan) "ABORT")
    ;(async/close! (-> component :gp-system :evolve-chan))
    component))

(defn new-app [ws-connection]
  (if ws-connection
    (map->App {:ws-connection ws-connection})
    (log/debug "No ws-connection on new-app!")))


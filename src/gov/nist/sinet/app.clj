(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (pprint)]
            [clojure.spec.alpha :as s]
            [clojure.core.async :as async :refer [>! <! >!! <!! chan]]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]))

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
  (atom
   {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
    :pop-size 25          ; 100 pre-except
    :aqpn-warm-up 5       ; Ignore this number of tokens on both ends of the log.
    
    :max-gens 30           ; These three control how long gp runs.  
    :success-threshold 0.15
    :timeout-secs 15
    
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
  (atom ; :scada-log will be computed in app-start-body
   {:keep-vs-ignore 0.8 
    :scada-data-file "data/SCADA-logs/scada-3m-2j-bufs-out.clj"
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
               (assoc-in ?c [:problem :scada-log] (-> ?c :problem :scada-data-file scada/load-scada))
               (assoc-in ?c [:problem :scada-patterns] ; Needs :pattern-reserves defined.
                         (-> ?c :problem :scada-log scada/scada-patterns))
               (assoc-in ?c [:problem :exceptional-msgs]
                         (scada/exceptional-msgs (-> ?c :problem :scada-patterns)
                                                 (-> ?c :problem :scada-log))))]
    (s/check-asserts (-> comp :gp-system :check-asserts?))
    (s/assert ::app comp)
    (gp/start-evolve-loop! (-> comp :gp-system :evolve-chan))
    comp))

(s/def ::evolve-chan (s/and #(= (type %) clojure.core.async.impl.channels.ManyToManyChannel))) 
(s/def ::gp-system (s/keys :req-un [::evolve-chan]))
(s/def ::app (s/keys :req-un [::gp-system]))

;;; Start and stop will reset the component to what is returned here. Thus I use atoms
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


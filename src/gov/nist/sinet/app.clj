(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan]]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]))

(def mutation-dist "The pdf for ordinary mutations (not eden mutations)"
  [[:add-place        1/10]    ; Add place (mine can't be absorbing, thus Nobile 1&2).
   [:add-token           0]    ; Add token to some place (visible or hidden).
   [:add-trans        1/10]    ; Add transition, connecting to input and output places.
   [:add-arc          1/20]
   [:add-inhibitor    1/10]    ; Add inhibitor arc, connecting a place to a trans
;  [:bump-inhibitor-3 1/20]    ; N.B. Makes it hard to remove, (but that might be good).
   [:remove-place     1/10]
   [:remove-token        0]
   [:remove-trans     1/10]
   [:remove-arc       1/10]
   [:remove-inhibitor 1/10]
   [:swap-places      2/10]
   [:swap-trans       2/10]
   [:swap-priority    1/10]])

(def gp-params
  (atom
   {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
    :pop-size 100
    :aqpn-warm-up 5 ; "Ignore this number of tokens on both ends of the log."
    :max-gens 30
    :debugging? true
    :pn-k-bounded 10 ; When to give up on computing the reachability graph.
    :pn-max-rs 1000
    :crossover-to-mutation-ratio 0.5
    :select-pressure 4 ; POD not normalized to pop-size! Spector: 7/1000
    :elite-individuals 1
    :timeout-secs 60
    :no-new-jobs-penalty 1.00001
    :no-qpn-log-penalty  3.000003 ; This if, for example, one transition, one place and two arcs back and forth. 
    :crossover-keeps-parents? true ; NYI
    :mutation-dist mutation-dist}))

(def problem
  (atom 
   {:use-cpus (.availableProcessors (Runtime/getRuntime)) ; Counts hyperthreading, apparently. 
    :keep-vs-ignore 0.8
    :scada-data-file  "data/SCADA-logs/scada-m2-j1-starve-m2-out.clj" ;"scada-f0-imbalanced.clj"
    :pattern-reserves #{:act :jt :bf :m :n}}))

(defn gp-system []
  {:evolve-chan (async/chan)
   :pause-evolve? (atom false)})

;;; Start and stop will reset the component to what is returned here. Thus I use atoms
;;; for things that I want to change and I do not reload this file on reset.
;;; See use of (nsp/disable-reload! (find-ns 'gov.nist.sinet.app)) in util.clj.
(defrecord App [ws-connection]
  component/Lifecycle
  (start [component]
    ;; Things here should not reference app-info; it won't be set. Instead, pass args in.
    (let [component
          (as-> component ?c
            (assoc ?c :gp-params @gp-params :problem @problem :gp-system (gp-system))
            (assoc-in ?c [:problem :scada-log] (-> ?c :problem :scada-data-file scada/load-scada))
            (assoc-in ?c [:problem :scada-patterns] ; Needs :pattern-reserves defined.
                      (-> ?c :problem :scada-log scada/scada-patterns))
            #_(assoc-in ?c [:problem :exceptional-msgs]
                      (scada/exceptional-msgs (-> ?c :problem :scada-patterns)
                                              (-> ?c :problem :scada-log))))]
          (gp/start-evolve-loop! (-> component :gp-system :evolve-chan))
          component))
  (stop [component]
    (async/close! (-> component :gp-system :evolve-chan))
    component))

(defn new-app [ws-connection]
  (if ws-connection
    (map->App {:ws-connection ws-connection})
    (log/debug "No ws-connection on new-app!")))


(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan]]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]))


(def mutation-dist "The pdf for ordinary mutations (not eden mutations)"
  [[:add-place        1/10]    ; Add place (mine can't be absorbing, thus Nobile 1&2).
   [:add-token        1/10]    ; Add token to some place (visible or hidden).
   [:add-trans        1/10]    ; Add transition, connecting to input and output places.
   [:add-arc          1/10]
   [:add-inhibitor    1/10]    ; Add inhibitor arc, connecting a place to a trans
   [:remove-place     1/10]
   [:remove-token     1/10]
   [:remove-trans     1/10]
   [:remove-arc       1/10]
   [:remove-inhibitor 1/10]
   [:swap-places-vv   2/10]])

(def eden-dist "for creation of eden individual, which are already rather sparse"
  [[:add-place        2/10]
   [:add-token        2/10]
   [:add-trans        2/10]
   [:add-arc          2/10]
   [:add-inhibitor    2/10]
   [:swap-places-vv   2/10]])

(def gp-params
  {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
   :pop-size 100
   :eden-mutation-cnt 4
   :max-gens 3
   :debugging? true
   :pn-k-bounded  10      ; When to give up on computing the reachability graph.
   :pn-max-rs     1000
   :crossover-to-mutation-ratio 0.5
   :select-pressure 70 ; POD not normalized to pop-size
   :elite-individuals 3
   :timeout-secs 60
   :no-new-jobs-penalty 1.00001
   :crossover-keeps-parents? true ; NYI
   :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
   :mutation-dist mutation-dist
   :eden-dist eden-dist})

(def problem
  {:use-cpus (.availableProcessors (Runtime/getRuntime)) ; counts hyperthreading apparently
   :scada-events [:bj :aj :ej :sm] ; POD this will go away. 
   :scada-data-file    "data/SCADA-logs/scada-f0-vec.clj"
   :scada-patterns (-> "data/SCADA-logs/scada-f0-vec.clj" scada/load-scada scada/scada-patterns)
   :data-source :ignore #_+m2-11+}) ; POD not yet dynamic, of course.

(defn gp-system []
  {:evolve-chan (async/chan)
   :pause-evolve? (atom false)})

;;; I *think* that start and stop will reset the component to what is returned here. 
(defrecord App [ws-connection]
  component/Lifecycle
  (start [component]
    (assoc component :gp-params gp-params :problem problem :gp-system (gp-system)))
  (stop [component]
    (async/close! (-> component :gp-system :evolve-chan))
    component))

(defn new-app [ws-connection]
  (if ws-connection
    (map->App {:ws-connection ws-connection})
    (log/debug "No ws-connection on new-app!")))


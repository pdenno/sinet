(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [clojure.edn :as edn]
            [clojure.pprint :refer (pprint)]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.fitness :as fit]
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

(defn preprocess-log
  "Add line numbers. This is used by hand on the datafile."
  [data]
  (reduce (fn [data n] (assoc-in data [n :line] n))
          data
          (range (count data))))

;;; POD Better than this would be transit. 
(defn load-scada [filename]
  (let [in (java.io.PushbackReader. (clojure.java.io/reader filename))
        edn-seq (repeatedly (partial edn/read {:eof :eof :readers {'function (fn [x])}} in))
        data (first (take-while #(not= :eof %) edn-seq))]
    (preprocess-log data)))

(defrecord App [ws-connection problem gp-params]
  component/Lifecycle
  (start [component]
    (as-> component ?c
      (assoc ?c
             :gp-params {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
                         :pop-size 100
                         :eden-mutations 4
                         :max-gens 3
                         :debugging? true
                         :pn-k-bounded  10      ; When to give up on computing the reachability graph.
                         :pn-max-rs     1000
                         :crossover-to-mutation-ratio 0.5
                         :select-pressure 70 ; POD not normalized to pop-size
                         :elite-individuals 3
                         :no-new-jobs-penalty 1.00001
                         :crossover-keeps-parents? true ; NYI
                         :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
                         :mutation-dist mutation-dist
                         :eden-dist eden-dist}
             :problem {:visible-places [:buffer :m1-blocked :m1-busy :m2-busy :m2-starved]
                       :use-cpus (.availableProcessors (Runtime/getRuntime)) ; counts hyperthreading apparently
                       :scada-events [:bj :aj :ej :sm] 
                       :visible-transitions [:m1-complete-job :m1-start-job :m2-complete-job :m2-start-job]
                       ;:scada-patterns (-> "data/SCADA-logs/scada-f0-vec.clj" load-scada fit/scada-patterns)
                       :data-source :ignore #_+m2-11+}) ; POD not yet dynamic, of course.
      (assoc ?c :pop nil #_(-> ?c :problem gp/initial-pop gp/sort-by-error))
      ?c))
  (stop [component]
    component))

(defn new-app []
  (map->App {})) 

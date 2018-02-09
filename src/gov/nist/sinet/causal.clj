(ns gov.nist.sinet.causal
  "Perform causal analysis using PN's parametric infinitesimal generator"
  (:require [clojure.pprint :refer (cl-format pprint print-table)]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [clojure.core.matrix :as m :refer :all]
            [clojure.core.matrix.linear :as ml :refer (svd)]
            [gov.nist.spntools.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.reach :as pnr]
            [gov.nist.gspn.core :as gspn] 
            [gov.nist.sinet.util :as util :refer (app-info)]))

(alias 'cause 'gov.nist.sinet.causal)

;;; POD NYI
(defn starving? [m] false)
(defn self [arg] arg)

;;; POD The model doesn't describe *where* (e.g. upstream ?) and *what elements*
;;; (e.g. next buffer?) are affected. When a machine blocks, eventually every machine
;;; upstream blocks. When a machine starves, eventually every machine downstream starves.
;;; Effects would be different on feeder lines -- they tend to block when either the
;;; main line starves or blocks. 
(def model
  "The causal model for asynchronous lines. Nodes are phenomena; arcs are influences."
  {:nodes [{:name :starvation          :types #{:response}}
           {:name :blocking            :types #{:response}}
           {:name :machine-utilization :types #{:response}}
           {:name :buffer-occupancy    :types #{:response}}
           {:name :residence-time      :types #{:response}}
           {:name :system-cost         :types #{:response :performance}}
           {:name :wip                 :types #{:response :performance}}
           {:name :throughput          :types #{:response :performance}}
           
           {:name :buffer-size           :types #{:design-var}}
           {:name :machine-work-capacity :types #{:design-var}}
           
           {:name :machine-efficiency :types #{:machine-char :system-char}}
           {:name :breakdown-rate     :types #{:machine-char :system-char}}
           {:name :repair-rate        :types #{:machine-char :system-char}}
           
           {:name :work-req           :types #{:job-req :task-req}}
           {:name :cycle-time         :types #{:job-req}}]
   ;; More to be done here, of course. 
   :arcs  [{:name :W-to-block
            :explanation "As the work capacity of a machine in a balanced line increases,
                          the machine tends to block if it does not starve."
            :source :machine-work-capacity
            :target :blocking
            :direction :increases
            :preconditions [#(not (starving? (self %)))]
            :location :self}
           {:name :W-to-block
            :explanation "As the work capacity of a machine in a balanced line increases,
                          buffer-occupancy directly downstream increases if it does not starve."
            :source :machine-work-capacity
            :target :buffer-occupancy
            :direction :increases
            :preconditions #(not (starving? (self %)))
            :location [:downstream :buffer]}]})

(defn zero-pos
  "Return the position of the value closest to zero."
  [v]
  (let [size (count v)]
    (loop [i 1
           mini (abs (first v))
           min-pos 0]
      (cond (= i size) min-pos,
            (< (abs (nth v i)) mini)
            (recur (inc i) (abs (nth v i)) i),
            :else
            (recur (inc i) mini min-pos)))))

(defn parametric-steady-state [pn rate-table]
  "Return a table of steady-state occupancy for the PN using given transition rates."
  (let [pn (pn/Q-matrix pn :rates rate-table)
        sol (ml/svd (:Q pn)) 
        svec (vec (m/get-column (:U sol) (zero-pos (vec (:S sol)))))
        scale (apply + svec)
        pn (assoc pn :steady-state (zipmap (:states pn) (map #(/ % scale) svec)))]
    (gspn/avg-tokens-on-place pn)))

#_(defn simple
  "Example of causation: Increase production rate of M2 in a 3-machine serial line."
  []
  (let [pn (-> (pnml/read-pnml "data/PNs/m3.xml")
               (gspn/reachability)) 
        rate-table-1 (reduce (fn [t e] (assoc t (:name e) (:rate e))) {} (:transitions pn))
        steady-state-1 (parametric-steady-state pn rate-table-1)
        rate-table-2 (update rate-table-1 :m2-complete-job #(* % 1.2)) ; 20% increase
        steady-state-2 (parametric-steady-state pn rate-table-2)]
    (vector steady-state-1
            steady-state-2)))

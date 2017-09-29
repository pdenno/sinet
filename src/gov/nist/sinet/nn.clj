(ns gov.nist.sinet.nn
  "Playing around with simple NNs"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info reset)]
            [gov.nist.sinet.scada :as scada]))

;;; https://mattmazur.com/2015/03/17/a-step-by-step-backpropagation-example/
;;; http://www.ai-junkie.com/ann/evolved/nnt6.html

;;; note that :weights are on arcs INTO the neuron.
;;; Layers
(defrecord Neuron [weights])

(defn make-neuron
  [n-inputs] ; create one extra for bias.
  (Neuron. (vec (into '(1.0) (repeatedly n-inputs rand)))))

(defrecord NeuralNet [input hlayers olayer output])

;;; For the time being, and probably a long time to come, I assume 1 hidden layer. 
(defn make-net
  [n-inputs n-outputs n-neurons-per-hl]
  "Create a neural net structure"
  (map->NeuralNet {:input   (vec (repeat n-inputs nil))
                   :hlayers (vec (repeatedly 1 #(vec (repeatedly n-inputs (fn [](make-neuron n-inputs))))))
                   :olayer  (vec (repeatedly n-outputs #(make-neuron n-neurons-per-hl)))
                   :output  (vec (repeat n-outputs nil))}))

;;; Mazur -- 
;;; (make-net 2 2 2)
(defn set-weight [net layer n-index w-index val]
  "Set a weight. layer=1 is first hidden layer. Layer=2 is (typically) output. 
   n-index index, of neuron, is [0..<number of neurons in layer>].
   w-index, index of arc, is [0..<number of neurons in previous layer>]"
  (let [nlayers (count (:hlayers net))]
    (assert (== 1 nlayers)) ; POD deeper nets NYI.
    (if (== layer 1)
      (assoc-in net [:hlayers 0 n-index :weights w-index] val)
      (assoc-in net [:olayer    n-index :weights w-index] val))))

;;; Make-nn is pretty-much pointless. 
(defn mazur-set-weights []
  (-> (make-net 2 2 2)
      (set-weight 1 0 0 0.15)))
  
  
  



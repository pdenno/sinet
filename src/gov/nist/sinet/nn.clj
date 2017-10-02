(ns gov.nist.sinet.nn
  "Simple backpropagation neural nets"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info reset)]
            [gov.nist.sinet.scada :as scada]))

;;; note that :weights are on arcs INTO the neuron.

(defrecord Neuron [name weights])

(defn make-neuron
  "Create an neuron with n-inputs+1 (+1 for bias) weights. 
   Name can be anything; make it useful for indexing. See make-net."
  [name n-inputs] 
  (map->Neuron {:name name
                :weights (vec (into '(1.0) (repeatedly n-inputs rand)))
                :net-output nil ; value before application of activation function
                :output nil}))  ; value after application of activation function   

(defn sigmoid 
  "Return the value of sigmoid (simplified logistic) function at the argument."
  [x]
  (/ 1.0 (+ 1.0 (Math/exp (- (double x))))))

(defrecord NeuralNet [input hlayers olayer total-error activation])

;;; POD For the time being, and probably a long time to come, I assume 1 hidden layer.
;;; POD inc for Mazur numbering (starts at 1). 
(defn make-net
  "Create a neural net structure. Assume 1 hidden layer, and thus names like this: [:h 3]."
  ([n-inputs n-outputs n-neurons-per-hl] (make-net n-inputs n-outputs n-neurons-per-hl 0.5))
  ([n-inputs n-outputs n-neurons-per-hl eta]
  (map->NeuralNet {:input   (vec (repeat n-inputs nil))
                   :hlayers (vec (repeatedly 1 (fn [] (vec (map #(make-neuron [:h %] n-inputs) (range n-inputs))))))
                   :olayer  (vec (map #(make-neuron [:o %] n-outputs) (range n-neurons-per-hl)))
                   :eta  eta ; "learning rate" (multiplier on gradient). 
                   :total-error nil
                   :activation sigmoid
                   :doutdnet (fn [out] (* out (- 1.0 out)))})))

(defn set-weight [net layer n-index w-index val]
  "Set a weight. layer=1 is first hidden layer. Layer=2 is (typically) output. 
   n-index index, of neuron, is [0..<number of neurons in layer>].
   w-index, index of arc, is [0..<number of neurons in previous layer>]"
  (let [nlayers (count (:hlayers net))]
    (assert (== 1 nlayers)) ; POD deeper nets NYI.
    (if (= layer :hlayers)
      (assoc-in net [:hlayers 0 n-index :weights w-index] val)
      (assoc-in net [:olayer    n-index :weights w-index] val))))

#_(defn diag-node
  "Get the hidden neuron with the given name."
  [net name]
  (or (some #(when (= name (:name %)) %) (:olayer net))
      (loop [layers (:hlayers net)]
        (if (empty? layers)
          nil
          (if-let [found (some #(when (= name (:name %)) %) (first layers))]
            found
            (recur (rest layers)))))))

(defn hnode
  "Get the hidden-layer neuron at the index."
  ([net ix] (hnode net 0 ix))
  ([net ilayer ix]
   (nth (nth (:hlayers net) ilayer) ix)))

(defn onode
  "Get the output-layer neuron at the index."
  [net ix]
  (nth (:olayer net) ix))

(defn weight
  "Get the weight indexed from the argument node. Indexing starts at 1."
  [node ix]
  (nth (:weights node) ix))

(defn input
  "Get the input indexed from the argument net. Indexing starts at 1."
  [net ix]
  (nth (:input net) ix))

(defn mazur-set-weights [net]
  (-> net
      (set-weight :hlayers 0 0 0.15)
      (set-weight :hlayers 0 1 0.20)
      (set-weight :hlayers 0 2 0.35)
      (set-weight :hlayers 1 0 0.25)
      (set-weight :hlayers 1 1 0.30)
      (set-weight :hlayers 1 2 0.35)
      (set-weight :olayer 0 0 0.40)
      (set-weight :olayer 0 1 0.45)
      (set-weight :olayer 0 2 0.60)
      (set-weight :olayer 1 0 0.50)
      (set-weight :olayer 1 1 0.55)
      (set-weight :olayer 1 2 0.60)))

(defn forward-pass-hidden-layer
  "Calculate hidden layer neuron values."
  [net]
  (let [ninputs (count (:input net))
        nhidden (-> net :hlayers first count)]
    (reduce (fn [net ix]
              (let [net-out
                    (reduce (fn [sum [input weight]]
                              (+ sum (* input weight)))
                            0.0
                            (map #(vector %1 %2)
                                 (conj (vec (map #(input net %) (range nhidden))) 1.0) ; last is for bias
                                 (map #(weight (hnode net ix) %) (range (inc nhidden)))))]
                (-> net
                    (assoc-in [:hlayers 0 ix :net-output] net-out)
                    (assoc-in [:hlayers 0 ix :output] ((:activation net) net-out)))))
            net
            (range ninputs))))

(defn forward-pass-output-layer
  "Calculate output layer neuron values."
  [net]
  (let [noutput (count (:olayer net))
        nhidden (-> net :hlayers first count)]
    (reduce (fn [net ix]
              (let [net-out
                    (reduce (fn [sum [output weight]]
                              (+ sum (* output weight)))
                            0.0
                            (map #(vector %1 %2)
                                 (conj (vec (map :output (-> net :hlayers first))) 1.0) ; last is for bias
                                 (map #(weight (onode net ix) %) (range (inc nhidden)))))]
                (-> net
                    (assoc-in [:olayer ix :net-output] net-out)
                    (assoc-in [:olayer ix :output] ((:activation net) net-out)))))
            net
            (range noutput))))

(defn total-error
  "Calculate (and set) the total error in the net."
  [net targets]
  (let [outputs (map :output (:olayer net))]
    (assoc net
           :total-error
           (* 0.5
              (reduce (fn [sum ix]
                        (+ sum
                           (Math/pow
                            (- (nth targets ix)
                               (nth outputs ix))
                            2)))
                      0.0
                      (range (count outputs)))))))

;;; Could do this easier with the "delta rule" assuming that the activation is sigmoid.
;;; Delta rule: -(target - out) * out*(1-out) *out_{hidden}
(defn backprop-output-layer
  "Calculate error gradient on output layer."
  [net targets]
  (let [eta (:eta net)]
    (reduce (fn [net io]
              (let [nth-io #(nth % io)]
                (reduce (fn [net iw]
                          (let [nth-iw #(nth % iw)
                                out (-> net :olayer nth-io :output)
                                dtotaldout (- out (nth targets io))
                                doutdnet ((:doutdnet net) out)
                                dnetdweight (-> net :hlayers first nth-iw :output) ; dNet_out / dW_k = Out_{hidden_k}
                                dtotaldweight (* dtotaldout doutdnet dnetdweight)
                                oldweight (-> net :olayer nth-io :weights nth-iw)]
                            (update-in net [:olayer io :new-weights]
                                       #(conj % (- oldweight (* eta dtotaldweight))))))
                        (assoc-in net [:olayer io :new-weights] [])
                        (range (-> net :olayer first :weights count dec)))))
            net
            (range (-> net :olayer count)))))


(defn backprop-hidden-layer
  [net targets]
  (let [eta (:eta net)]
    (reduce (fn [net io]
              (let [nth-io #(nth % io)] ; "o" is really "neuron"
                (reduce (fn [net iw]
                          (let [nth-iw #(nth % iw)
                                dtotaldout (reduce (fn [sum io]
                                                     (let [out       (-> net :olayer nth-io :output)
                                                           dedouto   (- out (nth targets io))
                                                           doutdnet  ((:doutdnet net) out)
                                                           dedneto   (* dedouto doutdnet)                    ; Eqn 3
                                                           dnetdouth (-> net :olayer nth-io :weights nth-iw) ; Eqn 4
                                                           dedouth   (* dedneto dnetdouth)]                  ; Eqn 2
                                                       (+ sum dedouth)))                                     ; Eqn 1
                                                   0.0
                                                   (range (count (-> net :olayer))))
                                douthdneth ((:doutdnet net) (-> net :hlayers first first :output)) ; suspect
                                dnethdw (-> net :input first)
                                detotaldw (* dtotaldout douthdneth dnethdw)                                  ; Eqn 5
                                oldweight (-> net :hlayers first nth-io :weights nth-iw)]
                            (update-in net [:hlayers 0 io :new-weights]
                                       #(conj % (- oldweight (* eta detotaldw))))))
                        (assoc-in net [:hlayers 0 io :new-weights] [])
                        (range (-> net :hlayers first first :weights count dec)))))
            net
            (range (-> net :hlayers first count)))))

(defn tryme []
  (let [targets [0.01 0.99]]
    (-> (make-net 2 2 2)
        (assoc :input [0.05 0.10]) 
        (mazur-set-weights)
        (forward-pass-hidden-layer)
        (forward-pass-output-layer)
        (total-error targets)
        (backprop-output-layer targets)
        (backprop-hidden-layer targets))))

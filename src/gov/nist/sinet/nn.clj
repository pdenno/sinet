(ns gov.nist.sinet.nn
  "Simple backpropagation neural nets"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info reset)]
            [gov.nist.sinet.scada :as scada]))

;;; Note that :weights are on arcs INTO the neuron.

(defrecord Neuron [name weights])

(def ^:private diag (atom nil))

(defn make-neuron
  "Create an neuron with n-inputs+1 (+1 for bias) weights. 
   Name can be anything; make it useful for indexing. See make-net."
  [name n-inputs] 
  (map->Neuron {:name name
                :weights (vec (into '(1.0) (repeatedly n-inputs rand)))
                :net-output nil ; value before application of activation function
                :output nil}))  ; value after application of activation function

(s/def ::weights (s/and vector? #(every? number? %)))
(s/def ::neuron (s/keys :req-un [::net-output ::output ::weights] :opt-un [::name]))

(defn sigmoid 
  "Return the value of sigmoid (simplified logistic) function at the argument."
  [x]
  (/ 1.0 (+ 1.0 (Math/exp (- (double x))))))

(defrecord NeuralNet [input hlayers olayer total-error activation])

;;; POD For the time being, and probably a long time to come, I assume 1 hidden layer.
;;; POD inc for Mazur numbering (starts at 1). 
(defn make-net
  "Create a neural net structure. Assume 1 hidden layer, and thus names like this: [:h 3]."
  ([n-inputs n-outputs n-neurons-per-hl] (make-net n-inputs n-outputs n-neurons-per-hl 1.0))
  ([n-inputs n-outputs n-neurons-per-hl eta]
  (map->NeuralNet {:input   (vec (repeat n-inputs nil))
                   :hlayers (vec (repeatedly 1 (fn [] (vec (map #(make-neuron [:h %] n-inputs)
                                                                (range n-neurons-per-hl))))))
                   :olayer  (vec (map #(make-neuron [:o %] n-neurons-per-hl)
                                      (range n-outputs)))
                   :eta  eta ; "learning rate" (multiplier on gradient). 
                   :total-error nil
                   :activation sigmoid
                   :doutdnet (fn [out] (* out (- 1.0 out)))})))

;;; POD the count requirements are just for testing. 
(s/def ::activation fn?)
(s/def ::doutdnet fn?)
(s/def ::olayer (s/and (s/coll-of ::neuron) vector? #(>= (count %) 2)))
(s/def ::hlayers (s/and (s/coll-of vector?) vector? #(>= (-> % first count) 2)))
(s/def ::net (s/keys :req-un [::total-error ::input ::hlayers ::olayer ::activation ::doutdnet]
                     :opt-un [::name]))

(defn set-weight [net layer n-index w-index val]
  "Set a weight. layer=1 is first hidden layer. Layer=2 is (typically) output. 
   n-index index, of neuron, is [0..<number of neurons in layer>].
   w-index, index of arc, is [0..<number of neurons in previous layer>]"
  (let [nlayers (count (:hlayers net))]
    (assert (== 1 nlayers)) ; POD deeper nets NYI.
    (if (= layer :hlayers)
      (assoc-in net [:hlayers 0 n-index :weights w-index] val)
      (assoc-in net [:olayer    n-index :weights w-index] val))))

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

;;; Mazur notation - It is weird because there is this overloading of "output":
;;; "net" means raw value (e.g. net_{h1} = w_1*i_1 + w_2*i2 + b_1*1.0 in Mazur.)
;;; "out" mean output measured through the activation function. (e.g. out_{h1} = 1 \ (1+ e^{-net_h1})).
;;; yet in any NN there are "output" nodes. These are indexed with just "o" (e.g. o1, o2...)

(defn forward-eqn
  "Update the argument neuron's net-output output given argument inputs."
  [net neuron inputs]
  (let [weights (:weights neuron)]
    (as-> neuron ?n
      (assoc ?n :net-output (apply + (map * inputs weights)))
      (assoc ?n :output ((:activation net) (:net-output ?n))))))

(defn forward-pass-hidden-layer
  "Feed the inputs forward to calculate outputs of hidden neurons."
  [net]
  (let [inputs (conj (:input net) 1.0)] ; 1.0 is multiplier of bias. 
    (assoc net
           :hlayers
           (vector (vec (map #(forward-eqn net % inputs)
                             (-> net :hlayers first)))))))

(defn forward-pass-output-layer
  "Calculate output layer neuron values."
  [net]
  (let [inputs (conj (vec (map :output (-> net :hlayers first))) 1.0)] ; 1.0 is multiplier of bias. 
    (assoc net
           :olayer
           (vec (map #(forward-eqn net % inputs) (:olayer net))))))

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
    (reduce (fn [net neur]
              (let [nth-neur #(nth % neur)]
                (reduce (fn [net iw]
                          (let [nth-iw #(nth % iw)
                                out (-> net :olayer nth-neur :output)
                                dtotaldout (- out (nth targets neur))
                                doutdnet ((:doutdnet net) out)
                                dnetdweight (-> net :hlayers first nth-iw :output) ; dNet_out / dW_k = Out_{hidden_k}
                                dtotaldweight (* dtotaldout doutdnet dnetdweight)
                                oldweight (-> net :olayer nth-neur :weights nth-iw)]
                            (update-in net [:olayer neur :new-weights]
                                       #(conj % (- oldweight (* eta dtotaldweight))))))
                        (assoc-in net [:olayer neur :new-weights] [])
                        (range (-> net :olayer first :weights count dec)))))
            net
            (range (-> net :olayer count)))))

;;; \frac{\partial{E_total}}{\partial out_h1} = sum \frac{\partial E_outi}{\partial out_h1}
;;; The meaning of the above is that we sum over (multiple) output error values for the
;;; the effect with respect to a given (single) hidden neuron.
(defn dEtotaldouth
  "Return the value of the derivative frac{partial{E_total}}{partial out_h1} 
   for argument hidden neuron (its index, i-neuron)."
  [net targets i-neuron]
  (let [nth-neur #(nth % i-neuron)]
    (reduce (fn [sum out-node] ; Sum over \frac{\partial E_outi}{\partial out_h_{i-neuron}}
              (let [nth-out  #(nth % out-node)
                    out       (-> net :olayer nth-out :output)
                    dedouto   (- out (nth targets out-node))
                    doutdnet  ((:doutdnet net) out)
                    dedneto   (* dedouto doutdnet)                       ; Eqn 3
                    dnetdouth (-> net :olayer nth-out :weights nth-neur) ; Eqn 4
                    dedouth   (* dedneto dnetdouth)]                     ; Eqn 2
                (+ sum dedouth)))                                        ; Eqn 1
            0.0
            (range (count (-> net :olayer))))))

(defn dEtotaldw
  "Calculate the derivative of Etotal with respect to a weight on a hidden neuron.
   Uses the chain rule producing a product of 3 factors."
  [net targets ineuron iinput]
  (reset! diag {:net net :targets targets :ineuron ineuron :iinput iinput})
  (let [nth-neuron #(nth % ineuron)
        nth-input #(nth % iinput)
        dtotaldout (dEtotaldouth net targets ineuron)
        douthdneth ((:doutdnet net) (-> net :hlayers first nth-neuron :output)) ; 0.241300709?
        dnethdw    (-> net :input nth-input)]
    (* dtotaldout douthdneth dnethdw))) ; Eqn 5                                 

(defn backprop-hidden-layer
  [net targets]
  (let [eta (:eta net)]
    (reduce (fn [net ihneur]
              (let [nth-hneur #(nth % ihneur)] 
                (reduce (fn [net iinput]
                          (let [nth-input #(nth % iinput)
                                detotaldw  (dEtotaldw net targets ihneur iinput)
                                oldweight  (-> net :hlayers first nth-hneur :weights nth-input)] ; OK
                            (update-in net [:hlayers 0 ihneur :new-weights]
                                       #(conj % (- oldweight (* eta detotaldw)))))) ; oldweight or detotaldw is wrong.
                        (assoc-in net [:hlayers 0 ihneur :new-weights] [])
                        (range (-> net :input count)))))
            net
            (range (-> net :hlayers first count)))))

(defn update-weights
  [net]
  "Bookkeeping operations to update weights after backpropagation."
  (as-> net ?n
    (reduce (fn [net ineuron]
              (let [nth-neur #(nth % ineuron)]
                (let [bias (-> net :olayer nth-neur :weights last)]
                  (-> net
                      (assoc-in [:olayer ineuron :weights]
                                (conj (-> net :olayer nth-neur :new-weights) bias))
                      (update-in [:olayer ineuron] #(dissoc % :new-weights))))))
            ?n
            (range (-> ?n :olayer count)))
    (reduce (fn [net ineuron]
              (let [nth-neur #(nth % ineuron)]
                (-> net
                    (assoc-in [:hlayers 0 ineuron :weights]
                              (-> net :hlayers first nth-neur :new-weights))
                    (update-in [:hlayers 0 ineuron] #(dissoc % :new-weights)))))
            ?n
            (range (-> ?n :hlayers first count)))))

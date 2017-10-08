(ns gov.nist.sinet.nn-test
  "Unit test for simple backpropagation neural nets"
  (:require [clojure.test :refer :all]
            [clojure.spec.test.alpha :as stest]
            [clojure.set :as set]
            [gov.nist.sinet.nn :as nn :refer :all]))

;;; POD If you recompile nn.clj after evaluating this, it won't happen. 
(stest/instrument) ; Instrument everything

;;;(require '[clojure.spec.test.alpha :as stest])

;;; https://mattmazur.com/2015/03/17/a-step-by-step-backpropagation-example/
(defn mazur-set-weights-test [net]
  (cond (== 2 (-> net :hlayers first count))
        (-> net
            (nn/set-weight :hlayers 0 0 0.15)
            (nn/set-weight :hlayers 0 1 0.20)
            (nn/set-weight :hlayers 0 2 0.35)
            (nn/set-weight :hlayers 1 0 0.25)
            (nn/set-weight :hlayers 1 1 0.30)
            (nn/set-weight :hlayers 1 2 0.35)
            (nn/set-weight :olayer 0 0 0.40)
            (nn/set-weight :olayer 0 1 0.45)
            (nn/set-weight :olayer 0 2 0.60)
            (nn/set-weight :olayer 1 0 0.50)
            (nn/set-weight :olayer 1 1 0.55)
            (nn/set-weight :olayer 1 2 0.60)),
        (== 3 (-> net :hlayers first count))
        (-> net
            (nn/set-weight :hlayers 0 0 0.15)
            (nn/set-weight :hlayers 0 1 0.20)
            (nn/set-weight :hlayers 0 2 0.20)
            (nn/set-weight :hlayers 0 3 0.35)
            (nn/set-weight :hlayers 1 0 0.25)
            (nn/set-weight :hlayers 1 1 0.30)
            (nn/set-weight :hlayers 1 2 0.30)
            (nn/set-weight :hlayers 1 3 0.35)
            (nn/set-weight :olayer 0 0 0.40)
            (nn/set-weight :olayer 0 1 0.45)
            (nn/set-weight :olayer 0 2 0.60)
            (nn/set-weight :olayer 1 0 0.50)
            (nn/set-weight :olayer 1 1 0.55)
            (nn/set-weight :olayer 1 2 0.60))
        :otherwise (/ 3 0)))

(defn mazur-test []
  (let [targets [0.01 0.99]]
    (-> (nn/make-net 2 2 2 0.5)
        (assoc :input [0.05 0.10]) 
        (mazur-set-weights-test)
        (nn/forward-pass-hidden-layer)
        (nn/forward-pass-output-layer)
        (nn/total-error targets)
        (nn/backprop-output-layer targets)
        (nn/backprop-hidden-layer targets)
        (forward-pass-hidden-layer)
        (forward-pass-output-layer))))

(deftest total-error-tests
  (testing "whether total-error calculation is correct"
    (is (< 0.2983711
           (:total-error (mazur-test))
           0.29837111))))

(defn =* [calculated given tol]
  (< (- given tol) calculated (+ given tol)))

(deftest backprop-output-layer-tests
  (testing "whether calculation of updated output layer weights is correct"
    (let [net (mazur-test)]
      (is (=* (-> net :olayer (nth 0) :new-weights (nth 0)) 0.35891647971788465 0.0000001))
      (is (=* (-> net :olayer (nth 0) :new-weights (nth 1)) 0.40866618607623345 0.0000001))
      (is (=* (-> net :olayer (nth 1) :new-weights (nth 0)) 0.51130127023873750 0.0000001))
      (is (=* (-> net :olayer (nth 1) :new-weights (nth 1)) 0.56137012110798910 0.0000001)))))

(deftest backprop-hidden-layer-output-layer-tests
  (testing "derivative of total error in an output with respect to an output neuron."
    (let [net (mazur-test)]
      (is (=* (dEtotaldouth net [0.01 0.99] 0) 0.03635030639314468 0.0000001))
      (is (=* (dEtotaldouth net [0.01 0.99] 1) 0.04137032264874471 0.0000001)))))

(deftest backprop-hidden-layer-tests
  (testing "whether calculation of updated hidden layer weights is correct"
    (let [net (mazur-test)]
      (is (=* (-> net :hlayers (nth 0) (nth 0) :new-weights (nth 0)) 0.14978071613276280 0.0000001))
      (is (=* (-> net :hlayers (nth 0) (nth 0) :new-weights (nth 1)) 0.19956143226552567 0.0000001))
      (is (=* (-> net :hlayers (nth 0) (nth 1) :new-weights (nth 0)) 0.24975114363236958 0.0000001))
      (is (=* (-> net :hlayers (nth 0) (nth 1) :new-weights (nth 1)) 0.29950228726473915 0.0000001)))))

(defn mazur-3-hidden [iterations]
  (let [targets [0.01 0.99]]
    (loop [net (-> (make-net 2 2 3) ; three hidden nodes on this one (works better, BTW). 
                   (assoc :input [0.05 0.10]) 
                   (mazur-set-weights-test))
           cnt iterations]
      (if (< cnt 0)
        net
        (recur
         (-> net
             (forward-pass-hidden-layer)
             (forward-pass-output-layer)
             (total-error targets)
             (backprop-output-layer targets)
             (backprop-hidden-layer targets)
             (update-weights))
         (dec cnt))))))

(deftest convergence-more-hidden-nodes
  (testing "whether calculation of updated hidden layer weights is correct"
    (let [net (mazur-3-hidden 10000)]
      (is (=* (:total-error net) 6.249163999127777E-6 0.00001)))))

(ns gov.nist.sinet.nn-test
  "Unit test for simple backpropagation neural nets"
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [gov.nist.sinet.nn :as nn :refer :all]))

;;; https://mattmazur.com/2015/03/17/a-step-by-step-backpropagation-example/
(defn mazur-set-weights-test [net]
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
      (nn/set-weight :olayer 1 2 0.60)))

(defn mazur-test []
  (let [targets [0.01 0.99]]
    (-> (nn/make-net 2 2 2)
        (assoc :input [0.05 0.10]) 
        (mazur-set-weights-test)
        (nn/forward-pass-hidden-layer)
        (nn/forward-pass-output-layer)
        (nn/total-error targets))))

(deftest total-error-tests
  (testing "whether total-error calculation is correct"
    (is (< 0.2983711
           (:total-error (mazur-test))
           0.29837111))))

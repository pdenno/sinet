(ns gov.nist.sinet.pnn-test
  "Probabilistic neural nets (Bayesian nets)"
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest] 
            [gov.nist.sinet.pnn :as pnn]))

(stest/instrument)

(defn =* [calculated given tol]
  (< (- given tol) calculated (+ given tol)))

(def data1
  {:class1 [[1.0 0.0], [0.0 1.0], [1.0 ,1.0]]
   :class2 [[-1.0 0.0], [0.0, -1.0]]})

(def parzen-fns1
  (zipmap
   (keys data1)
   (map #(pnn/parzen-pdf % data1) (keys data1))))

;;; http://www.personal.reading.ac.uk/~sis01xh/teaching/CY2D2/Pattern3.pdf ...but that has a mistake!
(deftest simple-pnn
  (is (=* ((:class1 parzen-fns1) [0.5 0.5]) 0.7788007830714048 0.0000001)
      (=* ((:class2 parzen-fns1) [0.5 0.5]) 0.2865047968601901 0.0000001)))

;;;=======================================================
(def data2
  {:class1 [[1.0 0.0], [1.0 0.0], [0.0 1.0],  [1.0 ,1.0]]
   :class2 [[1.0 0.0]]})

(def parzen-fns2
  (zipmap
   (keys data1)
   (map #(pnn/parzen-pdf % data2) (keys data2))))

;;; If a class only has one data point, it wins when you hit it. 
(deftest simple-pnn
  (is (=* ((:class1 parzen-fns2) [1.0 0.0]) 0.743602525221019 0.0000001)
      (=* ((:class2 parzen-fns2) [1.0 0.0]) 1.0 0.0000001)))

;;; There are more state that this in the PN, but not all occurred in the 3000 msgs logged. That's okay. 
(def example-msgs
  {:m2-unstarved {[0 0 1 1 0] 14},
   :m1-unblocked {[2 1 0 1 0] 30},
   :m2-starved   {[0 0 1 0 1] 14},
   :m1-blocked   {[3 0 1 1 0] 30},
   :ordinary
   {[0 1 0 1 0] 203,
    [2 0 1 1 0] 511,
    [1 1 0 1 0] 263,
    [3 0 1 0 1] 248,
    [1 0 1 1 0] 466,
    [0 1 0 0 1] 14,
    [2 1 0 1 0] 248,
    [3 0 1 1 0] 248,
    [1 0 1 0 1] 217,
    [0 0 1 1 0] 217,
    [0 0 1 0 1] 14,
    [2 0 1 0 1] 263}})

(defn pnn-all-ok?
  "Returns true if calculated are as expected."
  [calculated expected]
  (every? (fn [[mark [msg value]]]
            (and (= msg    (-> (get expected mark) first))
                 (=* value (-> (get expected mark) second) 0.00001)))
          calculated))

(deftest pnn-for-msgs
  (testing "that we get good values processing real messages."
    ;; Results with sigma = 1.0
    (is (pnn-all-ok?
         (pnn/choose-winners example-msgs 1.0)
         {[0 1 0 1 0] [:m2-unstarved 0.36787944117144233],
          [2 0 1 1 0] [:m1-blocked 0.6065306597126334],
          [1 1 0 1 0] [:m1-unblocked 0.6065306597126334],
          [3 0 1 0 1] [:m1-blocked 0.3678794411714423],
          [1 0 1 1 0] [:m2-unstarved 0.6065306597126334],
          [0 1 0 0 1] [:m2-starved 0.36787944117144233],
          [2 1 0 1 0] [:m1-unblocked 1.0],
          [3 0 1 1 0] [:m1-blocked 1.0],
          [1 0 1 0 1] [:m2-starved 0.6065306597126334],
          [0 0 1 1 0] [:m2-unstarved 1.0],
          [0 0 1 0 1] [:m2-starved 1.0],
          [2 0 1 0 1] [:ordinary 0.3312510892460261]}))
    ;; Results with sigma = 0.2
    (is (pnn-all-ok?
         (pnn/choose-winners example-msgs 0.2)
         {[0 1 0 1 0] [:ordinary 0.06971187503880233],
          [2 0 1 1 0] [:ordinary 0.17548168297989752],
          [1 1 0 1 0] [:ordinary 0.09031651123868557],
          [3 0 1 0 1] [:ordinary 0.0851651717421801],
          [1 0 1 1 0] [:ordinary 0.16002840419305475],
          [0 1 0 0 1] [:ordinary 0.0048076923087272344],
          [2 1 0 1 0] [:m1-unblocked 1.0],
          [3 0 1 1 0] [:m1-blocked 1.0],
          [1 0 1 0 1] [:ordinary 0.07451958526421719],
          [0 0 1 1 0] [:m2-unstarved 1.0],
          [0 0 1 0 1] [:m2-starved 1.0],
          [2 0 1 0 1] [:ordinary 0.09031652915550199]}))))

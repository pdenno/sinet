(ns gov.nist.sinet.pnn-test
  "Testing of probabilistic neural nets (Specht, 1990)"
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [gov.nist.spntools.util.utils :as pnu]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.util.pnml :as pnml]
            [gov.nist.sinet.pnn :as pnn]))

(stest/instrument 'pnn/euclid-dist2)

(defn =* [calculated given tol]
  (< (- given tol) calculated (+ given tol)))

;;; http://www.personal.reading.ac.uk/~sis01xh/teaching/CY2D2/Pattern3.pdf ...but that has a mistake!
(deftest simple-pnn
  (let [data {:class1 [[ 1.0 0.0], [0.0   1.0], [1.0 ,1.0]]
              :class2 [[-1.0 0.0], [0.0, -1.0]]}
        parzen-fns (zipmap
                    (keys data)
                    (map #(pnn/parzen-pdf % data) (keys data)))]
  (is (=* ((:class1 parzen-fns) [0.5 0.5]) 0.7788007830714048 0.0000001)
      (=* ((:class2 parzen-fns) [0.5 0.5]) 0.2865047968601901 0.0000001))))

;;;=======================================================
;;; If a class only has one data point, it wins when you hit it. 
(deftest simple-pnn
  (let [data {:class1 [[1.0 0.0], [1.0 0.0], [0.0 1.0],  [1.0 ,1.0]]
              :class2 [[1.0 0.0]]}
        parzen-fns (zipmap
                    (keys data)
                    (map #(pnn/parzen-pdf % data) (keys data)))]
  (is (=* ((:class1 parzen-fns) [1.0 0.0]) 0.743602525221019 0.0000001)
      (=* ((:class2 parzen-fns) [1.0 0.0]) 1.0 0.0000001))))

(ns gov.nist.sinet.pnn
  "Probabilistic neural nets (Specht, 1990)"
  (:require [clojure.spec.alpha :as s]))

;;; A PNN consists of several sub-networks, each of which is
;;; a Parzen window PDF estimator for each of the classes.
(defn euclid-dist2
  "Square of Euclidean distance; typical for Gaussian kernels."
  [x y]
  (reduce (fn [sum ix] (+ sum (Math/pow (- (nth x ix) (nth y ix)) 2)))
          0.0
          (range (count x))))

(s/def ::vec (s/and (s/coll-of number? :kind vector?) #(>= (count %) 1)))
(s/fdef euclid-dist2
        :args (s/cat :x ::vec :y ::vec)
        :ret double?
        :fn #(== (-> % :args :x count)
                 (-> % :args :y count)))
  
(defn parzen-pdf
  "Return the parzen-pdf function for the argument class."
  ([class data] (parzen-pdf class data 1.0 euclid-dist2))
  ([class data sigma dist-fn]
  (let [xdata (class data)
        size (count xdata)
        sig2 (* 2 sigma sigma)] ; sig^2 is variance. 
    (fn [x]
      (* (/ 1 size)
         (reduce (fn [sum ix] ; Specht is exp of sum, not sum of exps! (exponential activation)
                   (+ sum (Math/exp (- (/ (dist-fn (nth xdata ix) x) sig2)))))
                 0.0
                 (range size)))))))


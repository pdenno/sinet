(ns gov.nist.sinet.pnn
  "Probabilistic neural nets (Bayesian nets)"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest] ; POD temporary
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.sinet.util :as util :refer (app-info reset)]))

;;; A PNN consists of several sub-networks, each of which is a Parzen window PDF estimator for each of the classes.

(def sigma "standard deviation of Gaussian, used to sharpen/broaden the distributions" 0.2)

(defn euclid-dist2
  "Square of Euclidean distance; typical for Gaussian kernel."
  [x y]
  (reduce (fn [sum ix] (+ sum (Math/pow (- (nth x ix) (nth y ix)) 2)))
          0.0
          (range (count x))))

(s/def ::vec (s/and (s/coll-of number? :kind vector?) #(>= (count %) 1)))
(s/fdef euclid-dist2
        :args (s/cat :x ::vec :y ::vec)
        :ret double?
        :fn #(= (count %1) (count %2))) ; POD this isn't working. See example in youtube video.
  
(defn parzen-pdf
  "Return the parzen-pdf function for the argument class."
  ([class data] (parzen-pdf class data 1.0))
  ([class data sigma]
  (let [xdata (class data)
        size (count xdata)
        sig2 (* 2 sigma sigma)]
    (fn [x]
      (* (/ 1 size)
         (reduce (fn [sum ix]
                   (+ sum (Math/exp (- (/ (euclid-dist2 (nth xdata ix) x) sig2)))))
                 0.0
                 (range size)))))))

;;; (parzen-pdf-msg (:m2-starved example-interp))
;;; (parzen-pdf-msg (:ordinary example-interp))
(defn parzen-pdf-msg
  "Return the parzen-pdf function for the argument class using message counts."
  ([msg-table] (parzen-pdf-msg msg-table 1.0))
  ([msg-table sigma]
   (let [size (apply + (vals msg-table)) ; the total number of messages
         sig2 (* 2 sigma sigma)]
     (fn [x]
       (* (/ 1 size)
          (reduce (fn [sum [mark cnt]] ; cnt the number of messages with this marking
                    (+ sum (* cnt (Math/exp (- (/ (euclid-dist2 mark x) sig2))))))
                  0.0
                  msg-table))))))

;;; (choose-winners example-interp)
(defn choose-winners
  "Map of the winners for each marking."
  ([msg-table] (choose-winners msg-table 1.0))
  ([msg-table sigma]
   (let [classes (keys msg-table)
         parzen-fns (zipmap classes
                            (map #(parzen-pdf-msg (% msg-table) sigma) classes))
         marks (distinct
                (mapcat keys (map #(get msg-table %) classes)))]
     (reduce (fn [results mark]
               (let [result (reduce (fn [[best-class best-score] class]
                                      (let [my-score ((class parzen-fns) mark)]
                                        (if (> my-score best-score)
                                          [class  my-score]
                                          [best-class best-score])))
                                    [nil 0]
                                    classes)]
                 (assoc results mark result)))
             {}
             marks))))

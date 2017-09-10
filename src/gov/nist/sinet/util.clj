(ns gov.nist.sinet.util
  "General sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint)]))

(defn app-info []
  ((resolve 'gov.nist.sinet.run/app-info)))

(defn gp-param [name]
  (-> (app-info) :gp-params name))

(defn pr-param [name]
  (-> (app-info) :problem name))

(defn reset
  "Reset the systems, reloading changed code."
  []
  ((resolve 'gov.nist.sinet.run/reset)))

(def +log+ (atom []))
(defn log [msg] (swap! +log+ conj msg))

(defn uuid [] (.toString (java.util.UUID/randomUUID)))

(def ^:dynamic *debugging* false)

(defn pick-from-atom!
  "Randomly remove one element from the atom and return it."
  [atom]
  (let [picked (nth @atom (rand-int (count @atom)))]
    (swap! atom (fn [a] (remove #(= picked %) a)))
    picked))

(defn random-index
  "Create a vector of size n using each of the numbers 0 to n-1 once."
  [n]
  (let [patom (atom (range n))]
    (reduce (fn [v _] (conj v (pick-from-atom! patom)))
            []
            (range n))))

(defrecord Inv [pn id error history])

(defn print-inv [p writer]
  (.write writer (cl-format nil "#Inv [err=~A]"
                            (if (number? (:err p))
                              (cl-format nil "~6,2F" (:err p))
                              :NA))))

(defmethod print-method Inv [p writer]
  (print-inv p writer))

(.addMethod clojure.pprint/simple-dispatch Inv (fn [p] (print-inv p *out*)))

(defn mean
  [v]
  (/ (apply + v) (count v)))

(defn variance
  "Var(X) = E[(X - mu)^2]"
  [v]
  (let [avg (mean v)]
    (mean (vec (map (fn [x]
                      (let [dif (- x avg)]
                        (* dif dif)))
                    v)))))




 






(ns gov.nist.sinet.util.utils
  (:require [gov.nist.spntools.util.pnml :as pnml]))

(def +pop+ (atom nil))
(def +edens+ (atom nil))

(defn inv-geom
  "Compute reasonable display placement (:geom) for the argument individual."
  [inv]
  (let [from (-> inv :history first)
        elems (into (set (map :name (-> inv :pn :places))) (map :name (-> inv :pn :transitions)))]
    (assoc inv :pn
           (as-> (:pn inv) ?pn
             (assoc ?pn :geom (-> (some #(when (= (:id %) from) %) @+edens+) :pn :geom))
             (reduce (fn [pn ename]
                       (assoc-in pn [:geom ename]
                                 {:x (+ 15 (rand-int 100))
                                  :y (+ 15 (rand-int 100))
                                  :label-x-off 10
                                  :label-y-off 15}))
                     ?pn
                     (clojure.set/difference elems (set (keys (:geom ?pn)))))
             (pnml/rescale ?pn)))))

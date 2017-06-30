(ns gov.nist.sinet.utils
  "Parts of sinet used in multiple places. SINET demonstrate ideas in system identification/process mining using genetic programming."
  {:author "Peter Denno"}
  (:require [gov.nist.spntools.util.pnml :as pnml]))

(def +pop+ "Diagnostic set to population vector" (atom nil))
(def +edens+ "Vector of eden individuals"  (atom nil))

;;;  DOCUMENTATION REQUIREMENT: Determine what among the +gp-params+ matters.
;;; :pn-elements -- The PN elements that can appear in individuals.
;;; :initial-individuals -- percentage of each element type.
;;; :elite-individuals -- carry over this amount of the best without revision.
;;; :max-initial-mutations -- apply 1 to this number of mutations (uniform distribution to the "Eden individual")
(def +gp-params+
  "Genetic programming algorithm parameters: they control important aspects of the solution."
  {:pn-elements [:place :token :normal-arc :inhibitor-arc :expo-trans #_:immediate-trans #_:fixed-trans]
   :pop-size 100
   :eden-mutations 4
   :max-gens 3
   :debugging? true
   :pn-k-bounded  10      ; When to give up on computing the reachability graph.
   :pn-max-rs     1000
   :crossover-to-mutation-ratio 0.5
   :select-pressure 70 ; POD not normalized to pop-size
   :elite-individuals 3
   :no-new-jobs-penalty 1.00001
   :crossover-keeps-parents? true ; NYI
   :initial-mutations 10  ; max number of times to mutate eden individuals to create first generation.
   :mutation-dist ; The pdf for ordinary mutations (not eden mutations)
   [[:add-place        1/10]    ; Add place (mine can't be absorbing, thus Nobile 1&2).
    [:add-token        1/10]    ; Add token to some place (visible or hidden).
    [:add-trans        1/10]    ; Add transition, connecting to input and output places.
    [:add-arc          1/10]
    [:add-inhibitor    1/10]    ; Add inhibitor arc, connecting a place to a trans
    [:remove-place     1/10]
    [:remove-token     1/10]
    [:remove-trans     1/10]
    [:remove-arc       1/10]
    [:remove-inhibitor 1/10]
    [:swap-places-vv   2/10]]
   :eden-dist ; for creation of eden individual, which are already rather sparse
   [[:add-place        2/10]
    [:add-token        2/10]
    [:add-trans        2/10]
    [:add-arc          2/10]
    [:add-inhibitor    2/10]
    [:swap-places-vv   2/10]]})

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

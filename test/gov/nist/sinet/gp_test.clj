(ns gov.nist.sinet.gp-test
  "testing genetic programming code"
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.spec.alpha :as s]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.sinet.util :as util :refer (log app-info map->Inv gp-param pr-param VARS *debugging* handling-evolve)]
            [gov.nist.sinet.gp :as gp]))

(defn skimpy-test-pn
  "Return a pn containing only things essential for the tests in this file."
  [pn]
  (-> pn
      (update :places      #(mapv (fn [p] (dissoc p :visible? :initial-tokens :pid)) %))
      (update :arcs        #(mapv (fn [a] (dissoc a :type :multiplicity :bind :priority)) %))
      (update :transitions #(mapv
                             (fn [t]
                               (as-> t ?t
                                 (dissoc ?t :type :multiplicity :bind :visible? :rate :tid)
                                 (update ?t :rep
                                         (fn [t] (dissoc t :jt :j :line :clk :n :bf :visible? :ent))))) %))))

(def simple-3-machine-pn
  {:places [{:name :place-1} {:name :place-2} {:name :place-3} {:name :place-4} {:name :place-5} {:name :place-6}],
   :transitions
   [{:name :m1-start-job, :rep {:m :m1, :act :m1-start-job, :mjpact :aj}}
    {:name :m1-complete-job, :rep {:m :m1, :act :m1-complete-job, :mjpact :bj}}
    {:name :m2-start-job, :rep {:m :m2, :act :m2-start-job, :mjpact :sm}}
    {:name :m2-complete-job, :rep {:m :m2, :act :m2-complete-job, :mjpact :bj}}
    {:name :m3-start-job, :rep {:m :m3, :act :m3-start-job, :mjpact :sm}}
    {:name :m3-complete-job, :rep {:act :m3-complete-job, :m :m3, :mjpact :ej}}],
   :arcs
   [{:source :place-1, :target :m1-start-job, :name :aa-832}
    {:source :m1-start-job, :target :place-2, :name :aa-833}
    {:source :place-2, :target :m1-complete-job, :name :aa-834}
    {:source :m1-complete-job, :target :place-3, :name :aa-835}
    {:source :place-3, :target :m2-start-job, :name :aa-836}
    {:source :m2-start-job, :target :place-4, :name :aa-837}
    {:source :place-4, :target :m2-complete-job, :name :aa-838}
    {:source :m2-complete-job, :target :place-5, :name :aa-839}
    {:source :place-5, :target :m3-start-job, :name :aa-840}
    {:source :m3-start-job, :target :place-6, :name :aa-841}
    {:source :place-6, :target :m3-complete-job, :name :aa-842}
    {:source :m3-complete-job, :target :place-1, :name :aa-843}]})

(def bbs-3-machine
  "A test PN that has 3-machines, all doing BBS."
  (let [save-check (s/check-asserts?)]
    (s/check-asserts false)
    (let [pn (as-> simple-3-machine-pn ?pn
               (skimpy-test-pn ?pn)
               (gp/add-machine-restart-bbs ?pn :m1 :m2)
               (gp/add-machine-restart-bbs ?pn :m2 :m3)
               (gp/add-machine-restart-bbs ?pn :m3 :m1)
               (skimpy-test-pn ?pn)
               (update ?pn :places #(mapv (fn [p] (dissoc p :pid)) %))
               (update ?pn :arcs   #(mapv (fn [a] (dissoc a :name :aid)) %)))]
      (s/check-asserts save-check)
      pn)))

(defn add-inhibitor-3
  [pn]
  (update pn :arcs conj
          {:aid 55, :source :place-3, :target :m1-start-job, :name :aa-55, 
           :type :inhibitor, :multiplicity 3, :bind {:jtype :blue}}))

(defn make-inv [pn] (map->Inv {:pn pn}))
(defn restart-bbs-3 [pn]
  (-> pn
      (gp/add-machine-restart-bbs :m1 :m2)
      (gp/add-machine-restart-bbs :m2 :m3)
      (gp/add-machine-restart-bbs :m3 :m1)
      (gp/bbs-bas-switch :m1 :bbs2bas)
      add-inhibitor-3))
  
;;; (-> (initial-pop 1) first :pn gpt/restart-bbs-3 gpt/make-inv diag-push-inv)
(deftest add-machine-restart-bbs-test
  (testing "that add-machine-restart-bbs works.")
      (is (= bbs-3-machine
             {:places
              [{:name :place-2} {:name :place-4} {:name :place-6}
               {:name :wait-1, :purpose :waiting}
               {:name :wait-2, :purpose :waiting}
               {:name :wait-3, :purpose :waiting}],
              :transitions
              [{:name :m1-start-job, :rep {:m :m1, :act :m1-start-job, :mjpact :aj}}
               {:name :m1-complete-job, :rep {:m :m1, :act :m1-complete-job, :mjpact :bj}}
               {:name :m2-start-job, :rep {:m :m2, :act :m2-start-job, :mjpact :sm}}
               {:name :m2-complete-job, :rep {:m :m2, :act :m2-complete-job, :mjpact :bj}}
               {:name :m3-start-job, :rep {:m :m3, :act :m3-start-job, :mjpact :sm}}
               {:name :m3-complete-job, :rep {:act :m3-complete-job, :m :m3, :mjpact :ej}}],
              :arcs
              [{:source :m1-start-job, :target :place-2}
               {:source :place-2, :target :m1-complete-job}
               {:source :m2-start-job, :target :place-4}
               {:source :place-4, :target :m2-complete-job}
               {:source :m3-start-job, :target :place-6}
               {:source :place-6, :target :m3-complete-job}
               {:source :m1-complete-job, :target :wait-1}
               {:source :wait-1, :target :m1-start-job}
               {:source :m2-complete-job, :target :wait-2}
               {:source :wait-2, :target :m2-start-job}
               {:source :m3-complete-job, :target :wait-3}
               {:source :wait-3, :target :m3-start-job}]})))

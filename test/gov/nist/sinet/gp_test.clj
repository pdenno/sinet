(ns gov.nist.sinet.gp-test
  "testing genetic programming code"
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.spec.alpha :as s]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.sinet.util :as util :refer (log app-info map->Inv gp-param pr-param VARS *debugging* handling-evolve)]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.sinet.fitness :as fit]))

(def random-job-trace
  [{:clk 866.0014, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 866.9014, :j 596, :line 2413}
   {:clk 866.9014, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 596, :line 2416}
   {:clk 867.0014, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 596, :line 2419}
   {:clk 868.0014, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 596, :line 2426}
   {:clk 870.4562, :act :m3-start-job, :m :m3, :mjpact :sm, :bf :b2, :n 1, :j 596, :line 2434}
   {:clk 871.6562, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 866.0014, :j 596, :line 2443}])

(def eden-3-machine
  (-> random-job-trace
      gp/initial-pn))

(def bbs-3-machine
  "A 3-machine PB with BBS everywhere."
  (-> eden-3-machine
      (gp/add-machine-restart-bbs :m1 :m2)
      (gp/add-machine-restart-bbs :m2 :m3)
      (gp/add-machine-restart-bbs :m3 :m1)))

(deftest bas-bbs-mutations-and-checking
  (testing "that GP mutations for BBS work and that fit/bbs? fit/bas? work."
    (let [save-check (s/check-asserts?)
          pn bbs-3-machine]
      (is (fit/bbs? pn :m1))
      (is (fit/bbs? pn :m2))
      (is (fit/bas? (gp/bbs-bas-switch pn :m1 :bbs2bas) :m1))
      (is (fit/bas? (gp/bbs-bas-switch pn :m2 :bbs2bas) :m2)))))




(ns gov.nist.sinet.simulate-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint pp)]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp as-pn-ok-> name2obj)]
            [gov.nist.spntools.util.pnml  :as pnml]
            [gov.nist.sinet.util :as util :refer (*debugging*)]
            [gov.nist.sinet.simulate :as sim]))

(defn m2-inhib-bas-sim
  "Setup the m2-inhib-bas PN for a simulation."
 [steps]       ;     Change...
  (-> "/Users/peterdenno/Documents/git/spntools/data/m2-inhib-bas.xml" 
      gov.nist.spntools.core/run-ready
      gov.nist.sinet.gp/add-color-binding
      (gov.nist.sinet.gp/diag-force-priority [{:source :m1-start-job, :target :buffer :priority 2}])
      (gov.nist.sinet.gp/diag-force-rep
       [{:name :m1-start-job, :act :aj, :m :m1}
        {:name :m1-complete-job, :act :bj, :m :m1, :bf :b1}
        {:name :m2-start-job, :act :sm, :m :m2, :bf :b1}
        {:name :m2-complete-job, :act :ej, :m :m2}])
      (sim/simulate :max-steps steps)))

(defn sequential? [seq]
  "Returns true if SEQ is a sequence of integers in order [n, n+1, n+2,...,n+m]"
  (first
   (reduce (fn [[answer prev] nxt]
             (if answer
               [(== (inc prev) nxt) nxt]
               [false nil]))
           [true (first seq)]
           (rest seq))))

(deftest m2-inhib-bas-processes-serially
  (testing "serial processing of a simple PN"
    (is true (->> (m2-inhib-bas-sim 200)
                  :sim 
                  :log
                  (filter #(= :remove (:motion %)))
                  (map :tkn)
                  (map :id)
                  sequential?))))

      
    




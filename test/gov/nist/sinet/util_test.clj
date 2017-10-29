(ns gov.nist.sinet.util-test
  "Test of general sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.test :refer :all]
            [gov.nist.sinet.util :as util]))

(deftest pmap-timeout-test
  (testing "That this eventually finishes."
    (is (= 100
           (count (repeatedly
                   100
                   (fn [] (let [times (util/pmap-timeout (fn [n] (Thread/sleep n) n)
                                                         (repeatedly 8 #(+ 10 (* 10 (rand-int 6))))
                                                         50)]
                            (apply + (map #(if (number? %) % (:timeout %)) times))))))))))

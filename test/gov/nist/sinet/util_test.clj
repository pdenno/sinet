(ns gov.nist.sinet.util-test
  "Test of general sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.test :refer :all]
            [gov.nist.sinet.util :as util]))

#_(deftest pmap-timeout-test
  (testing "that this sleepy thing eventually finishes."
    (is (= 100
           (count (repeatedly
                   100
                   (fn [] (let [times (util/pmap-timeout (fn [n] (Thread/sleep n) n)
                                                         (repeatedly 8 #(+ 10 (* 10 (rand-int 6))))
                                                         50)]
                            (apply + (map #(if (number? %) % (:timeout %)) times))))))))))

#_(deftest busy-pmap-times-out
  (testing "that this busy thing eventually finishes."
    (let [result (repeatedly
                   10
                   #(util/pmap-timeout
                     (fn [_] (while (< (rand-int 10) 100)
                               (+ 1 (rand-int 5))))
                     (range 10)
                     50))]
      (is (== (count result) 100))
      (is (every? #(== (count %) 10) result)
      (is (every? (fn [t] (every? #(contains? % :timeout) t)) result))))))


(ns gov.nist.sinet.scada-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [gov.nist.sinet.scada :as scada]))

(deftest scada-log-form
  (testing "whether the clojure.spec constraints on the log catch anything"
    (stest/instrument 'scada/load-scada)
    (is (s/valid? :gov.nist.sinet.scada/scada-log
                  (-> "data/SCADA-logs/scada-m2-j1-starve-m2-out.clj"
                      scada/load-scada
                      (subvec 0 10))))))


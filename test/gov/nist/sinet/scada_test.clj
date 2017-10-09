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

;;;(write-pretty-log foo "data/SCADA-logs/scada-m2-j1-starve-m2-out.clj")
(defn write-pretty-log
  "A stand-alone utility: Translate messages from MJPdes format to pretty (PN) format and 
   write to a file. The result can then be used by load-scada."
  [log out-file]
  (let [line-cnt (atom -1)]
    (with-open [out-stream (if out-file (clojure.java.io/writer out-file :encoding "UTF-8") *out*)]
      (binding [*out* out-stream]
        (println "[")
        (doseq [msg log]
          (-> msg
              (assoc :line (swap! line-cnt inc))
              scada/mjpdes2pn
              println))
        (println "]")))))

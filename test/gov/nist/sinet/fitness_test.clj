(ns gov.nist.sinet.fitness-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer (cl-format pprint)]
            [loom.alg :as alg]
            [loom.graph :as graph]
            [gov.nist.spntools.core :as spn]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.pnml :as pnml]
            [gov.nist.spntools.core :as pn]
            [gov.nist.sinet.util :as util :refer (map->Inv app-info reset big-reset)]
            [gov.nist.sinet.app :as app]
            [gov.nist.sinet.run :as run]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.gp :as gp]
            [gov.nist.sinet.simulate :as sim]
            [gov.nist.sinet.pnn :as pnn]
            [gov.nist.sinet.fitness :as fit]))

(def ^:private diag (atom nil))

(defn =*
  "Check that v1 == v2 +/i tolerance."
  [v1 v2 tol]
  (< (- v1 tol) v2 (+ v1 tol)))


(def hopeful-pn (-> (load-file "data/PNs/hopeful-pn.clj")
                    (assoc :pulls-from {:m1 [], :m2 [:Place-103]})))

(def hopeful-pn-2 (-> (load-file "data/PNs/hopeful-pn-2.clj")
                      (assoc :pulls-from {:m1 [], :m2 [:Place-13], :m3 [:Place-14]})))

(def hopeful-pn-3 (-> (load-file "data/PNs/hopeful-pn-3.clj")
                      (assoc :pulls-from {:m1 [], :m2 [:Place-13], :m3 [:Place-14]})))

(deftest starving-is-ok
  (testing "that the starved? predicate works."
    (is (not (fit/starved?
              {:M [0 1 0 1 1], :fire :m2-complete-job, :Mp [1 1 0 0 1], :m :m2, :indx 224}
              {:act :m2-starved, :m :m2, :prev-act :m2-complete-job, :Mp [1 1 0 0 1], :state [1 1 0 0 1], :indx 225}
              hopeful-pn)))
    (is (fit/starved? 
         {:M [0 1 0 1 0], :fire :m2-complete-job, :Mp [1 1 0 0 0] :m :m2, :indx 224}
         {:act :m2-starved, :m :m2, :line 225, :mjpact :st}
         hopeful-pn))))

(defn winners-ok?
  "Returns true if calculated are as expected."
  [calculated expected]
  (every? (fn [[mark [msg value]]]
            (and (= msg    (-> (get expected mark) first))
                 (=* value (-> (get expected mark) second) 0.00001)))
          calculated))

;;; POD This one is worth lots more tests!!!
(deftest logs-interpret
  (testing "that interpretations can be found when they should be found."
    (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
          pn  (fit/find-interpretation hopeful-pn log 3 3)]
      (is (= 3002 (count (:interp pn)))))))

(deftest logs-interpret-2
  (testing "that interpretation works on 3-machine example")
  (let [log (scada/load-scada "data/SCADA-logs/scada-3m-2j-bufs-out.clj")]
    (is (== 3002
            (-> (load-file "data/PNs/hopeful-pn-3.clj")
                (fit/lax-reach 2)
                (assoc :diag-occupy-ok? true)
                (assoc :pulls-from {:m1 [], :m2 [:Place-13], :m3 [:Place-14]})
                (assoc :place-map {:b1 :Place-13 :b2 :Place-14})
                (assoc :occupy {:Place-13 2 :Place-14 2})
                (fit/prep-interp     log {:M [0 1 0 1 0 1 2 2], :fire :m3-complete-job, :Mp [1 1 0 1 0 0 2 2], :line 0})
                (fit/interpret-scada log {:M [0 1 0 1 0 1 2 2], :fire :m3-complete-job, :Mp [1 1 0 1 0 0 2 2], :line 0})
                (-> :interp count))))))

(def rgraph
  [{:M [1 1 0 0 2], :fire :m2-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m1-complete-job, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m1-complete-job, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [1 1 0 0 1], :fire :m2-start-job, :Mp [0 1 0 1 0], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m1-complete-job, :Mp [0 0 1 1 3], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m1-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m2-complete-job, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m1-start-job, :Mp [1 1 0 0 2], :rate 1.0}
   {:M [1 1 0 0 2], :fire :m1-complete-job, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 0 1 1 3], :fire :m2-complete-job, :Mp [1 0 1 0 3], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m1-start-job, :Mp [1 1 0 0 3], :rate 1.0}
   {:M [1 1 0 0 3], :fire :m2-start-job, :Mp [0 1 0 1 2], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m1-start-job, :Mp [0 1 0 1 3], :rate 1.0}
   {:M [1 0 1 0 3], :fire :m2-start-job, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m1-complete-job, :Mp [0 0 1 1 2], :rate 1.0}
   {:M [0 0 1 1 0], :fire :m1-start-job, :Mp [0 1 0 1 1], :rate 1.0}
   {:M [1 0 1 0 1], :fire :m2-start-job, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [0 0 1 1 2], :fire :m2-complete-job, :Mp [1 0 1 0 2], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m2-complete-job, :Mp [1 1 0 0 0], :rate 1.0}
   {:M [1 1 0 0 0], :fire :m1-complete-job, :Mp [1 0 1 0 0], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m2-complete-job, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [0 1 0 1 1], :fire :m1-complete-job, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [0 1 0 1 0], :fire :m1-complete-job, :Mp [0 0 1 1 0], :rate 1.0}
   {:M [1 0 1 0 2], :fire :m2-start-job, :Mp [0 0 1 1 1], :rate 1.0}
   {:M [1 0 1 0 0], :fire :m1-start-job, :Mp [1 1 0 0 1], :rate 1.0}
   {:M [0 0 1 1 1], :fire :m2-complete-job, :Mp [1 0 1 0 1], :rate 1.0}
   {:M [0 1 0 1 2], :fire :m2-complete-job, :Mp [1 1 0 0 2], :rate 1.0}
   {:M [0 1 0 1 3], :fire :m2-complete-job, :Mp [1 1 0 0 3], :rate 1.0}])

(def msg-table
  {:m2-starved   {[1 1 0 0 0] 32},
   :m2-unstarved {[1 1 0 0 1] 32},
   :m1-unblocked {[0 1 0 1 2] 60},
   :m1-blocked   {[0 1 0 1 3] 60}
   :ordinary     {[0 0 1 1 1] 195,
                  [0 1 0 1 0] 245,
                  [1 1 0 0 2] 194,
                  [0 1 0 1 3] 265,
                  [1 1 0 0 3] 265,
                  [0 1 0 1 1] 407,
                  [1 1 0 0 0] 32,
                  [0 0 1 1 0] 213,
                  [0 0 1 1 2] 266,
                  [1 1 0 0 1] 244,
                  [0 1 0 1 2] 460,
                  [1 0 1 0 0] 32}})

(def old-msg-table
  {:m2-starved   {[1 1 0 0 0] 32},
   :m2-unstarved {[1 1 0 0 1] 32},
   :m1-blocked   {[0 1 0 1 3] 60},
   :m1-unblocked {[0 1 0 1 2] 60},
   :ordinary     {[0 0 1 1 1] 195,
                  [0 1 0 1 0] 235,
                  [1 1 0 0 2] 194,
                  [0 1 0 1 3] 275,
                  [1 1 0 0 3] 274,
                  [0 1 0 1 1] 398,
                  [1 1 0 0 0] 32,
                  [0 0 1 1 0] 203,
                  [0 0 1 1 2] 276,
                  [1 1 0 0 1] 235,
                  [0 1 0 1 2] 469,
                  [1 0 1 0 0] 32}})

(def old-trans-counts
  {[0 0 1 1 1] {[0 1 0 1 2] 195},
   [0 1 0 1 0] {[0 0 1 1 0] 203, [1 1 0 0 0] 32},
   [1 1 0 0 2] {[0 1 0 1 1] 194},
   [0 1 0 1 3] {[1 1 0 0 3] 274, [0 0 1 1 3] 1},
   [1 1 0 0 3] {[0 1 0 1 2] 274},
   [0 1 0 1 1] {[0 0 1 1 1] 195, [1 1 0 0 1] 203},
   [1 1 0 0 0] {[1 0 1 0 0] 32},
   [0 0 1 1 0] {[0 1 0 1 1] 203},
   [0 0 1 1 2] {[0 1 0 1 3] 276},
   [1 1 0 0 1] {[0 1 0 1 0] 235},
   [0 1 0 1 2] {[1 1 0 0 2] 194, [0 0 1 1 2] 275},
   [1 0 1 0 0] {[1 1 0 0 1] 32}})

(def trans-counts
  {[0 0 1 1 1] {[0 1 0 1 2] 195},
   [0 1 0 1 0] {[0 0 1 1 0] 213, [1 1 0 0 0] 32},
   [1 1 0 0 2] {[0 1 0 1 1] 194},
   [0 1 0 1 3] {[1 1 0 0 3] 265},
   [1 1 0 0 3] {[0 1 0 1 2] 265},
   [0 1 0 1 1] {[1 1 0 0 1] 212, [0 0 1 1 1] 195},
   [1 1 0 0 0] {[1 0 1 0 0] 32},
   [0 0 1 1 0] {[0 1 0 1 1] 213},
   [0 0 1 1 2] {[0 1 0 1 3] 266},
   [1 1 0 0 1] {[0 1 0 1 0] 244},
   [0 1 0 1 2] {[1 1 0 0 2] 194, [0 0 1 1 2] 266},
   [1 0 1 0 0] {[1 1 0 0 1] 32}})

(def loom-prob  (fit/rgraph2loom-probability rgraph old-trans-counts))
(def loom-steps (fit/rgraph2loom-steps rgraph))
(def norm-factors (fit/normalize-marking-factors rgraph))

(deftest trans-counts-test
  (testing "that trans-counts works"
      (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
            pn (as-> (fit/find-interpretation hopeful-pn log 3 3) ?pn
                 (assoc ?pn :msg-table (fit/compute-msg-table ?pn)))] 
        (is (= trans-counts (fit/trans-counts (:interp pn)))))))
                                        
(deftest msg-table-test
  (testing "that the message table looks good"
    (is (= msg-table
           (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
                 patterns (scada/scada-patterns log)
                 msg-types (conj (scada/exceptional-msgs patterns log) :ordinary)]
             (as-> (fit/find-interpretation hopeful-pn log 3 3) ?pn
               (fit/compute-msg-table ?pn msg-types)))))))

(deftest full-winner-process
  (testing "that the process works to winners and that intermediate test data is in sync."
    (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
          patterns (scada/scada-patterns log)
          msg-types (conj (scada/exceptional-msgs patterns log) :ordinary)
          pn (as-> (fit/find-interpretation hopeful-pn log 3 3) ?pn
               (assoc  ?pn :msg-table (fit/compute-msg-table ?pn msg-types))
               (assoc  ?pn :norm-factors (fit/normalize-marking-factors (:rgraph ?pn)))
               (assoc  ?pn :trans-counts (fit/trans-counts (:interp ?pn)))
               (dissoc ?pn :interp)
               (assoc  ?pn :sigma 0.35)
               (assoc  ?pn :loom-prob (fit/rgraph2loom-probability (:rgraph ?pn) (:trans-counts ?pn)))
               (assoc  ?pn :distance-fn (fit/dist-fn-6 (:loom-prob ?pn) (:norm-factors ?pn)))
               (assoc  ?pn :pdf-fns
                       (zipmap (-> ?pn :msg-table keys)
                               (map #(fit/parzen-pdf-msg ?pn %)
                                    (-> ?pn :msg-table keys)))))]
      (is (= (:norm-factors pn) norm-factors))
      (is (= (set (mapv #(dissoc % :rate-fn) (:rgraph pn))) (set rgraph)))
      (is (= (:msg-table pn) msg-table))
      (is (= (:trans-counts pn) trans-counts))
      (is (= (fit/choose-winners pn)
               {[0 0 1 1 1] [:ordinary 0.07033297915479189],
                [0 1 0 1 0] [:ordinary 0.08989014956189567],
                [1 1 0 0 2] [:ordinary 0.06980207778492617],
                [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
                [1 1 0 0 3] [:ordinary 0.09433269071796964],
                [0 1 0 1 1] [:ordinary 0.15113887720003483],
                [1 1 0 0 0] [:m2-starved 1.0],
                [0 0 1 1 0] [:ordinary 0.07569992645101252],
                [0 0 1 1 2] [:ordinary 0.0960888468671096],
                [1 1 0 0 1] [:m2-unstarved 1.0],
                [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
                [1 0 1 0 0] [:ordinary 0.01139091655954467]}

               #_{[0 0 1 1 1] [:ordinary 0.07035003350586438],
                  [0 1 0 1 0] [:ordinary 0.08612941888443124],
                  [1 1 0 0 2] [:ordinary 0.06977395019946811],
                  [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
                  [1 1 0 0 3] [:ordinary 0.09753131509940632],
                  [0 1 0 1 1] [:ordinary 0.14762935943771455],
                  [1 1 0 0 0] [:m2-starved 1.0],
                  [0 0 1 1 0] [:ordinary 0.0721420233904942],
                  [0 0 1 1 2] [:ordinary 0.0996944685574537],
                  [1 1 0 0 1] [:m2-unstarved 1.0],
                  [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
                  [1 0 1 0 0] [:ordinary 0.01139091655954467]})))))

;;; In all tests that use 'distance' on markings, markings are normalized.
;;; I think this is necessary if sigma is going to mean anything. 
(deftest pnn-for-msgs-1 
  (testing "PNN-based classification based on 'traditional' euclid-dist2"
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :distance-fn (fit/dist-fn-1 norm-factors))
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :pdf-fns
                      (zipmap (keys old-msg-table)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      ;; Not so good values, even with medium sigma.
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.1772930229756261],           ; next best is 0.0001
            [0 1 0 1 0] [:ordinary 0.2019653717274339],           ; next best is 0.163
            [1 1 0 0 2] [:m2-unstarved 0.6353909887688034],       ; next best is 0.186
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],         ; next best is 0.635
            [1 1 0 0 3] [:m2-unstarved 0.16299121800184535],      ; next best is 0.155
            [0 1 0 1 1] [:m1-unblocked 0.6353909887688035],       ; next best is 0.316
            [1 1 0 0 0] [:m2-starved 1.0],                        ; next best is 0.635
            [0 0 1 1 0] [:ordinary 0.1320291240060683],           ; next best is 0
            [0 0 1 1 2] [:ordinary 0.15374605256549206],          ; next best is 0
            [1 1 0 0 1] [:m2-unstarved 1.0],                      ; next best is 0.635
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],       ; next best is 0.635
            [1 0 1 0 0] [:ordinary 0.011415187440842868]})))))    ; next best is 0

(deftest pnn-for-msgs-2
  (testing "PNN-based classification based on Distance = steps * euclid-dist2." 
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :distance-fn (fit/dist-fn-2 loom-steps norm-factors))
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :pdf-fns
                      (zipmap (keys old-msg-table)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn) ; results not very good with normalized!
           {[0 0 1 1 1] [:ordinary 0.11280115552657274],
            [0 1 0 1 0] [:ordinary 0.11964136621006477],
            [1 1 0 0 2] [:m2-unstarved 0.25652113562024753], ; wrong
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:ordinary 0.11490140358513679],
            [0 1 0 1 1] [:m1-unblocked 0.2565211356202476],  ; wrong
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.08979893169932006],
            [0 0 1 1 2] [:ordinary 0.11570085562261395],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:ordinary 0.011355578097432782]})))))
           
(deftest pnn-for-msgs-3
  (testing "Distance = product of probability along the 1/p cost path."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :distance-fn (fit/dist-fn-3 old-trans-counts loom-prob))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys) ;
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:m1-blocked 0.438586052885812],
            [0 1 0 1 0] [:m1-blocked 0.4240039342366138],
            [1 1 0 0 2] [:m2-starved 0.4894043305758072],
            [0 1 0 1 3] [:m2-starved 0.3631584213323572],
            [1 1 0 0 3] [:m2-starved 0.3644985206255141],
            [0 1 0 1 1] [:m1-blocked 0.18596221192489185],
            [1 1 0 0 0] [:m1-blocked 0.8897313188204132],
            [0 0 1 1 0] [:m1-blocked 0.47655278089878783],
            [0 0 1 1 2] [:m2-starved 0.3631584213323572],
            [1 1 0 0 1] [:m1-blocked 0.4240039342366138],
            [0 1 0 1 2] [:m2-starved 0.17773130408512924],
            [1 0 1 0 0] [:m1-blocked 0.8897313188204132]})))))

(deftest pnn-for-msgs-4
  (testing "Distance = product of probabilities along shortest path time euclidean distance."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :rgraph rgraph)
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :distance-fn (fit/dist-fn-4 loom-steps loom-prob norm-factors))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:m2-unstarved 0.999999999600041],
            [0 1 0 1 0] [:m1-unblocked 0.5632137924219007],
            [1 1 0 0 2] [:m2-unstarved 0.9999999998639456],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:m2-starved 1.0],
            [0 1 0 1 1] [:m2-unstarved 0.99999999942277],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.34927972517219386],
            [0 0 1 1 2] [:m2-unstarved 0.9999999997622476],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:m1-unblocked 0.7809764084470207]})))))

(deftest pnn-for-msgs-5 
  (testing "Distance = the sum of 1/p steps along shortest path."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :distance-fn (fit/dist-fn-5 loom-prob))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.06977147041215553],
            [0 1 0 1 0] [:ordinary 0.08502197400428994],
            [1 1 0 0 2] [:ordinary 0.06926258672468386],
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002],
            [1 1 0 0 3] [:ordinary 0.09925020351353822],
            [0 1 0 1 1] [:ordinary 0.14401317115106646],
            [1 1 0 0 0] [:m2-starved 1.0],
            [0 0 1 1 0] [:ordinary 0.07333414873688693],
            [0 0 1 1 2] [:ordinary 0.09901759234253096],
            [1 1 0 0 1] [:m2-unstarved 1.0],
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],
            [1 0 1 0 0] [:m2-starved 0.016879884148789895]})))))

(deftest pnn-for-msgs-6
  (testing "Distance = the sum of 1/p steps along shortest path times euclidean distance."
    (let [pn (as-> {} ?pn
               (assoc ?pn :sigma 0.35)
               (assoc ?pn :msg-table old-msg-table)
               (assoc ?pn :distance-fn (fit/dist-fn-6 loom-prob norm-factors))
               (assoc ?pn :pdf-fns
                      (zipmap (-> ?pn :msg-table keys)
                              (map #(fit/parzen-pdf-msg ?pn %)
                                   (-> ?pn :msg-table keys)))))]
      (is (winners-ok?
           (fit/choose-winners pn)
           {[0 0 1 1 1] [:ordinary 0.07035003350586438],  ; next best is 0
            [0 1 0 1 0] [:ordinary 0.08612941888443124],  ; next best is 0 
            [1 1 0 0 2] [:ordinary 0.06977395019946811],  ; next best is 0 
            [0 1 0 1 3] [:m1-blocked 1.0000000000000002], ; next best is 0.10
            [1 1 0 0 3] [:ordinary 0.09753131509940632],  ; next best is 0.003
            [0 1 0 1 1] [:ordinary 0.14762935943771455],  ; next best is 0.01
            [1 1 0 0 0] [:m2-starved 1.0],                ; next best is 0.011
            [0 0 1 1 0] [:ordinary 0.0721420233904942],   ; next best is 0
            [0 0 1 1 2] [:ordinary 0.0996944685574537],   ; next best is 0.00005
            [1 1 0 0 1] [:m2-unstarved 1.0],              ; next best is 0.0854
            [0 1 0 1 2] [:m1-unblocked 1.0000000000000002],   ; next best is 0.175
            [1 0 1 0 0] [:ordinary 0.01139091655954467]}))))) ; next best is 0.0031

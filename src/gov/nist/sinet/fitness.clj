(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [clojure.pprint :refer (cl-format pprint print-table)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan close!]]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [clojure.math.combinatorics :as combo]
            [loom.alg :as alg]
            [loom.graph :as graph]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability renumber-pids)]
            [gov.nist.sinet.simulate :as sim :refer-only (simulate)]
            [gov.nist.sinet.util :as util :refer (*debugging* app-info reset
                                                  related-places handling-evolve map->Inv)]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.pnn :as pnn]
            [gov.nist.sinet.report :as rep]))

(defn aliases []
  (alias 'fit  'gov.nist.sinet.fitness)
  (alias 'fitt 'gov.nist.sinet.fitness-test) ; POD temporary
  (alias 'gp   'gov.nist.sinet.gp)) ; POD temporary

(declare contemp-msgs next-time-line reasonably-marked-pn lax-reach max-marks full-interp? max-marks)
(declare interp-possible? act2trans rgraph2loom-steps buffers-to-constrain constrain-buffer-size)

(def ^:private diag (atom nil))
;;;===========================================
;;; QPN
;;;===========================================
;;; POD only collects from :act messages currently (no :on-act)
;;;  {:act :ej, :m :m2, :j [46], :fire :m2-complete-job}
(defn qpn-gather-tkn
  "Return every mention of token id in chronological order."
  [log tkn-id]
  (filter (fn [msg]
            (and (contains? msg :act)
                 #_(some #(= % tkn-id) (:j msg))
                 ;; POD not too sure about just using the newest token here. 
                 (when (not-empty (:j msg))
                   (== tkn-id (apply max (:j msg))))))
          log))

;;; POD Because I'm focusing on jobs here (qpn-gather-job), at some point I'm going to have to account for
;;; lines in the log that were not addressed by qpn-gather-job (and the things in-between it).
(defn qpn-act-is-intro? 
  "Return true if the named transition has an arc exiting it that 
   introduces a token."
  [pn act]
  (let [trans (act2trans pn act)]
    (some #(= :intro (-> % :bind :act))
          (filter #(= (:source %) trans) (:arcs pn)))))

;;; If qpn-act-is-intro? and this is not first mention of the token, then it is recycling.
;;; An example is {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]} above.
;;; Here I remove those. 
(defn qpn-log-about
  "Return in chronological order log entries about the argument tkn-id.
   This removes messages concerning the introduction of a token that is not the argument token."
  [pn tkn-id]
  (remove (fn [msg]
            (and (qpn-act-is-intro? pn (:act msg))
                 (some #(> (:id %) tkn-id) (:tkns msg))))
          (qpn-gather-tkn (-> pn :sim :log) tkn-id)))

;;; POD not used yet, but useful. 
(defn qpn-characterize-tkn-trace
  "Return a map describing the relative frequency that each event occurs in a token trace."
  [log tkn-id]
  (let [acts (distinct (map :act (qpn-gather-tkn log tkn-id)))]
    (reduce (fn [distrib msg]
              (update-in distrib [(:act msg)] inc))
            (zipmap acts (repeat (count acts) 0))
            (filter #(contains? % :act) log))))

;;;====================================================================================
;;; Exceptional Fitness
;;;====================================================================================
(defn ordinary?
  "Returns msg if the message isn't exceptional otherwise false."
  [msg]
  (if (contains? (-> (app-info) :problem :exceptional-msgs) (:act msg))
    false
    msg))

(defn starting-links
  "Based only on the rgraph and message firing, return all 
   links that could start interpretation." 
  [pn log]
  (if-let [msg (some #(when (ordinary? %) %) log)]
    (let [line (:line msg)
          fire (:act msg)]
      (distinct
       (filter #(= fire (:fire %))
               (map #(-> %
                         (dissoc :rate-fn :rate)
                         (assoc :line line))
                  (:rgraph pn)))))
    (throw (ex-info "Log has no ordinary messages" {}))))

(defn link+msg
  "Return a map that augments link info with msg info."
  [link msg]
  (-> link
      (assoc :m    (:m msg))
      (assoc :job  (:j msg))
      (assoc :clk  (:clk msg))
      (assoc :line (:line msg))
      (dissoc :rate-fn :clk :rate)))

;;; BTW 'link' here is a combination of spntools-like link info and MJPdes-like msg info. (see link+msg.)
(defn link-match
  "Return the link which follows from the current link and log msg."
  [pn action llink msg]
  (when-let [link (some #(when (and (= (:Mp llink) (:M %)) 
                                    (= (:fire %) (:act msg)))
                           %)
                        (:rgraph pn))]
    (link+msg link msg)))

(defn starved?
  "Return true if the argument machine (in msg) is starved.
   Doesn't actually check that it is busy, only that the buffer is empty."
  [llink msg ^clojure.lang.PersistentVector mkey buf]
  (when buf 
    (= 0 (nth (:Mp llink) (.indexOf mkey buf)))))

(defn diag-occupy-map
  "return :occupy Update match-info's :occupy occupancy info from the log message -- diagnostic only.
   (The point of interpretation is to figure this stuff out, but 
   MJPdes messages happen to provide occupancy.) Return updated occupy map."
  [pn]
  (let [^clojure.lang.PersistentVector mkey (:marking-key pn)
        place-map (:place-map pn)
        msg       (:msg pn)]
    (when-not (:occupy pn) (throw (ex-info "no :occupy in PN" {})))
    ;; Compute new occupy-map 
    (cond-> (:occupy pn)
      (= :sm (:mjpact msg))   (update ((:bf msg) place-map) dec)
      (= :bj (:mjpact msg))   (update ((:bf msg) place-map) inc))))

(defn diag-report-interp
  "Report on the message interpretation; change nothing (except maybe diagnostics); return pn"
  [pn]
  ;; Report message and link (i = interpretation).
  (let [link (:matched pn)
        save-diag-occupy-ok? (atom (:diag-occupy-ok? pn))]
    (println "\n msg =" (:msg pn))
    (println "i = "  (apply sorted-map (interleave (keys link) (vals link))))
    (println "occupy =" (:occupy pn))
    ;; When things are off, re-check consistency of occupy with :M
    (let [occ-map (:occupy pn)
          mkey (:marking-key pn)]
      (when (and (not (:diag-occupy-ok? pn))
                 (every? #(= (% occ-map)
                             (nth (-> pn :matched :M) (.indexOf mkey %)))
                         (keys occ-map)))
        (reset! save-diag-occupy-ok? true)
        (println "=======>  Occupancy back to correct"))
      ;; Check occupy map againts :Mp of the new link. 
      (doseq [key (keys occ-map)]
        (when-not (= (key occ-map)
                     (nth (:Mp link) (.indexOf mkey key)))
          (when (:diag-occupy-ok? pn)
            (reset! save-diag-occupy-ok? false)
            (println "=======>  Occupancy wrong on " key)))))
    (assoc pn :diag-occupy-ok? @save-diag-occupy-ok?)))

(defn match-starve-inconsistent
  "Interpretation failed because have work in buffers but reporting starving
   set :matched to nil."
  [pn msg]
  (when *debugging*
    (println "STARVED IS INCONSISTENT...................")
    (println "msg = " msg)
    (println "marking-key = " (:marking-key pn))
    (println "matched = " (:matched pn))
    (println "occupy = " (:occupy pn))
    (println "..................."))
  (assoc pn :matched nil))

;;; Process msgs in strict log-order:
;;; (1) If the msg is not ordinary...
;;;   (1.1) If starvation and not consistent, interpretation fails.
;;;   (1.2) If not starvation, no problem. <========= POD we know k-bounded, could we check blocked? too?
;;; (2) If the rgraph step matches, no problem.
;;; (3) If job is new and rgraph step matches no problem, update :active-jobs
;;; (5) If job not= current job but on :active-jobs and rgraph matches on that history,
;;;     no problem (add to interp with a note).
;;; (6) Otherwise interpretation failed.  (return nil)
(defn next-match
  "If the argument msg is not ordinary, return information about it and the llink. 
   If the argument msg can advance the rgraph (i.e. ordinary), return augmented
   link information. Otherwise return nil."
  [pn msg] 
  (let [job (:j msg)
        llink (:matched pn)
        slink (atom nil)]
    (as-> pn ?pn
      (cond (not (ordinary? msg))                                   ; (1)
            (if (and (= (:mjpact msg) :st)
                     (when-let [machine (:m msg)]
                       (not (starved? llink msg (:marking-key pn)
                                      (first (machine (:pulls-from pn)))))))
              (match-starve-inconsistent ?pn msg)
              (assoc ?pn :matched ; else create a link 
                     {:exceptional true :act (:act msg) :Mp (:Mp llink) 
                      :clk (:clk msg) :line (:line msg)})),
              
            (reset! slink (link-match ?pn :link llink msg))         ; (2)
            (assoc ?pn :matched @slink),                              

            (and (= :aj (:mjpact msg))                              ; (3)
                 (reset! slink (link-match ?pn :aj llink msg)))
            (assoc ?pn :matched @slink), 
              
            (and (contains? (:active-jobs ?pn) job)
                 (reset! slink (link-match ?pn :active llink msg))) ; (5)
            (assoc ?pn :matched @slink), 
              
            true (assoc ?pn :matched nil))                          ; (6)
            
            (cond-> ?pn
              true                    (assoc :msg msg) ;!4
              (= :aj (:mjpact msg))   (assoc :active-jobs (conj (:active-jobs ?pn) job)),
              (= :ej (:mjpact msg))   (assoc :active-jobs (set/difference (:active-jobs pn) #{job}))))))

(defn match-contemp-block
  "next-match any contemporary message; return pn updated."
  [pn]
  (let [old-match  (:matched pn)]
    (if-let [pn (some #(let [pn (next-match (assoc pn :matched old-match) %)] ;!
                         (when (:matched pn) pn))
                      (:msg-buf pn))]
      (as-> pn ?pn ;!3 and conj!
        (assoc ?pn :msg-buf (remove #(= (-> ?pn :matched :line) (:line %)) (:msg-buf ?pn)))
        (assoc ?pn :interp (conj (:interp ?pn) (:matched ?pn)))
        (cond-> ?pn
          *debugging* (assoc :occupy (diag-occupy-map ?pn))
          *debugging* (diag-report-interp)))
      (do 
        (when *debugging* (cl-format *out* "~%Failed on msg block: ~{~%    ~A~}~%" (:msg-buf pn)))
        (assoc pn :matched nil)))))

(defn prep-interp [pn log start-link]
  "Prepare the PN for interpretation."
  (when *debugging*
    (println "msg = " (first log))
    (println "start = " start-link))
  (as-> pn ?pn
    (assoc ?pn :msg-buf (remove #(= (:line %) (:line start-link))
                                (contemp-msgs log (:line start-link))))
    (assoc ?pn :active-jobs (scada/active-jobs log))
    (assoc ?pn :matched    start-link) ; needed because no (-> pn :interp last) with transient)
    (assoc ?pn :interp [start-link])))

(def diag-pn (atom nil))
(defn reset-diag-step-interp! []
  (reset! diag-pn (-> (load-file "data/PNs/hopeful-pn-3.clj")
                      (lax-reach 2)
                      (assoc :diag-occupy-ok? true)
                      (assoc :pulls-from {:m1 [], :m2 [:Place-13], :m3 [:Place-14]})
                      (assoc :place-map {:b1 :Place-13 :b2 :Place-14})
                      (assoc :occupy {:Place-13 2 :Place-14 2})
                      (prep-interp (-> (app-info) :problem :scada-log)
                                   {:M [0 1 0 1 0 1 2 2], :fire :m3-complete-job, :Mp [1 1 0 1 0 0 2 2], :line 0})))
  true)

(def last-step-pn (atom nil))
(defn diag-unstep-interp! ; POD probably not good for more that one step.
  []
  "Undo the effect of the last interpretation step."
  (reset! diag-pn @last-step-pn)
  true)

(defn diag-step-interp!
  []
  "Interpret one message, updating the diag-pn."
  (binding [*debugging* true]
    (let [pn @diag-pn
          log (-> (app-info) :problem :scada-log)]
      (if (full-interp? pn log)
        (println "Full interpretation!")
        (do (reset! last-step-pn pn)
            (reset! diag-pn 
                    (cond-> pn
                      (empty? (:msg-buf pn))
                      (assoc :msg-buf (contemp-msgs log (next-time-line log (-> pn :matched :line)))), ;!
                      true (match-contemp-block)))))
    true)))

(defn interpret-scada
  "Describe how the message stream could be accounted for by this PN. 
   Return pn with :interp set to a vector where an element is:
    - a link augmented with :line and :job (if an ordinary message is processed), or
    - a map naming an exceptional message (if an such a message is processed)."
  [pn log start-link] 
  (loop [pn (prep-interp pn log start-link)]
    (as-> pn ?pn
      (cond-> ?pn
        (empty? (:msg-buf ?pn)) 
        (assoc :msg-buf (contemp-msgs log (next-time-line log (-> ?pn :matched :line)))), ;!
        true (match-contemp-block))
      (cond (not (:matched ?pn))
            (assoc ?pn :interp []), 
            (full-interp? ?pn log)
            (dissoc ?pn :msg-buf :active-jobs),
            true   ; continue
            (recur ?pn)))))

(defn interp-k-some-start-link
  "Try to interpret the log where the rgraph reflects a given k-boundedness."
  [pn log]
  (some #(let [result-pn (interpret-scada pn log %)]
           (when (full-interp? result-pn log) result-pn))
        (starting-links pn log)))

(defn interp-some-k
  [pn log min-max-k max-max-k]
  (let [found (some (fn [max-k]
                      (as-> (lax-reach pn max-k) ?pn
                        (when-let [success (interp-k-some-start-link ?pn log)] success)))
                    (range min-max-k (inc max-max-k)))]
      (or found pn)))

(defn find-interpretation
  "At increasing values of max-k, find new starting links and try to interpret the entire log. 
   Return pn with :interp set to the first complete interpretation found, if any below max-max-k."
  ([pn log] (find-interpretation pn
                                 log
                                 (-> (app-info) :gp-params :min-max-k)
                                 (-> (app-info) :gp-params :max-max-k)))
  ([pn log min-max-k max-max-k] 
   (when (interp-possible? pn)
     (let [machines (util/machines-of pn)] 
       (as-> pn ?pn ; memoize util/pulls-from
         (assoc ?pn :pulls-from (zipmap machines (map #(util/pulls-from ?pn %) machines)))
         (interp-some-k ?pn log min-max-k max-max-k))))))

;;; Interp utils ==================
(defn next-time-line
  "Return the line number of a message after the time of the argument message
  or nil if none left."
  [log indx]
  (let [msg  (nth log indx)
        time (:clk  msg)
        last-indx (-> log last :line)]
    (loop [n (inc indx)]
      (cond (> n last-indx) nil,
            (> (:clk (nth log n)) time) n,
            :else (recur (inc n))))))

(defn contemp-msgs
  "Return all messages that occurred when the message at indx occurred."
  [log line]
  (if (not line) []
      (let [time (:clk (nth log line))
            max-line (-> log last :line)
            loop-fn (fn [inc-dec-fn hit-bound?]
                      (loop [col []
                             n line]
                        (cond (hit-bound? n) col 
                              (not= time (:clk (nth log n))) col
                              :else (recur (conj col (nth log n)) (inc-dec-fn n)))))]
        (into 
         (-> (loop-fn dec #(< % 0)) rest reverse vec)
         (loop-fn inc #(> % max-line))))))

(defn reasonably-marked-pn
  "Set PN marking so that things that look like machines have a state."
  [pn]
    (let [pn (pnr/renumber-pids pn)
          r-places (atom (util/related-places pn))
          imark (reduce (fn [mark place] ; this generates one of several possibilities. 
                          (if-let [machine (some #(when (contains? (% @r-places) place) %)
                                                 (keys @r-places))]
                            (do (swap! r-places dissoc machine)
                                (conj mark 1))
                            (conj mark 0)))
                        []
                        (:marking-key pn))]
      (pnu/set-marking pn imark)))

;;; POD For all combos, replace vals in r-places with index in marking, then choose one from each set (combinatorial)
;;;     Replace those values with 1s, all other values in marking key are zeros.
;;;     Using all possibilities, choose the rgraph that has most states.
;;;     It will probably be sufficient to use the first one found, as I do below. No need for multiple i-marks.
;;;     Should check for m-mp/mp-m errors (spec?)
(defn lax-reach
  "Set the marking-key such there is one token on each machine.
   Return the pn with an artificially k-bounded :rgraph associated with this marking."
  [pn max-k]
    (as-> pn ?pn 
      (reasonably-marked-pn ?pn) 
      (assoc ?pn :rgraph (pnr/simple-reach ?pn (max-marks ?pn max-k))) ; packed
      (assoc ?pn :k-limited? (-> ?pn :rgraph :k-limited?)) ; unpack
      (assoc ?pn :rgraph (-> ?pn :rgraph :rgraph vec))     ; unpack 
      (if (pnu/m-mp-mp-m-valid? (:rgraph ?pn))
        ?pn
        (dissoc ?pn :rgraph))))

(defn max-marks
  "Return a vector where buffer places are max-k and others are 1."
  [pn max-k]
  (let [combos (combo/permutations (util/machines-of pn))
        buffers (set (mapcat (fn [[m1 m2]] (util/buffers-between pn m1 m2)) combos))]
    (mapv #(if (contains? buffers %)
             max-k
             1)
          (:marking-key pn))))

(defn full-interp?
  "Return true if the interpretation read the whole log."
  [pn log]
  (let [llink (:matched pn)]
    (and (number? (:line llink))
         (== (-> log last :line)
             (:line llink)))))

;;; POD Needs work. Too restrictive! async serial line. 
(defn interp-possible?
  "Returns true if there are enough buffers for an async serial line."
  [pn]
  (when (s/valid? ::util/gppn pn)
    (let [m (util/machines-of pn)
          combos (combo/permutations m)]
      (>= (count (set (mapcat (fn [[m1 m2]] (util/buffers-between pn m1 m2)) combos)))
          (dec (count m))))))

;;;; ======== Exceptional Probabilty =================================
;;; You can have the same marking associated with more than one class. The more times you have
;;; it associated with a class, the stronger the result will be for that class. To make
;;; the following efficient, I'll have to count the number of times each marking is associated
;;; with each class. Then I'll use that as a factor in calculating the PDF.
;;; POD Note that I throw away :interps and :fails here. Returning a msg-table, not the pn. 
(defn compute-msg-table
  "Return a map indicating what markings are associated with what message types, 
   where message types are either ':ordinary' or some exceptional message type."
  ([pn] (compute-msg-table pn (conj (-> (app-info) :problem :exceptional-msgs) :ordinary)))
  ([pn msg-types] 
   (let [markings (map :M (:rgraph pn))]
     (when-let [interp (not-empty (:interp pn))]
       (let [report (reduce (fn [sum msg]
                              (if (contains? msg :act)
                                (update-in sum [(:act msg) (:Mp msg)] inc)
                                (update-in sum [:ordinary (:M msg)] inc)))
                            (zipmap msg-types
                                    (repeatedly (count msg-types)
                                                #(zipmap markings (repeat (count markings) 0))))
                            interp)]
         ;; Outer map is indexed by msg-types; inner map in indexed by markings, values are count.
         ;; Eliminate entries where the count is zero.
         (reduce (fn [map key]
                   (update-in map [key]
                              #(persistent!
                                (reduce (fn [m k] (if (== 0 (get m k)) (dissoc! m k) m))
                                        (transient %)
                                        (keys %)))))
                 report
                 msg-types))))))

(defn trans-prob
  "Calculate the probability of the transition from 
   log interpretation statistics." 
  [m mp trans-cnt]
  (if-let [entry (get trans-cnt m)]
    (if-let [to-mp (get entry mp)]
      (double(/ to-mp (apply + (vals entry))))
      0.00001) ; There are transitions in the rgraph that might not have been exercised in the log
    0.00001))

(defn rgraph2loom-probability 
  "Return a loom weighted-digraph where costs are based on probability (1/p)."
  [rgraph trans-cnt]
  (apply graph/weighted-digraph
         (map #(let [m  (:M %)
                     mp (:Mp %)
                     p (trans-prob m mp trans-cnt)]
                 (vector m mp (/ 1 p)))
              rgraph)))

(defn rgraph2loom-steps
  "Return a loom weighted-digraph that simply counts steps."
  [rgraph]
  (apply graph/weighted-digraph
         (map #(vector (:M %) (:Mp %) 1) rgraph)))

(defn trans-counts
  "Create a table indexed by :M and counts the number of transitions to :Mp
   in the argument interpretation. "
  [interp]
  (let [no-excepts (filter #(contains? % :M) interp)
        mkeys (distinct (map :M no-excepts))
        tcounts (zipmap mkeys (repeat (count mkeys) {}))]
    (reduce (fn [tcnt link]
              (update-in tcnt [(:M link)]
                         #(if (contains? % (:Mp link))
                            (update-in % [(:Mp link)] inc)
                            (assoc % (:Mp link) 1))))
            tcounts
            no-excepts)))

;;; Pattern layer: computes the Euclidean distance of the test case from the neuron’s center point
;;; and then applies the radial basis function kernel function using the sigma values. (Rama: "A
;;; hidden node has a spread factor s_i which determines the size of the respective field.")

;;; https://www.cs.utah.edu/~suyash/Dissertation_html/node11.html
;;; "A Parzen window essentially superimposes kernel function places at each observation or datum....
;;; There is another way to look at the estimation process, and this is where it derives its name from.
;;; Suppose that we want to estimate the value of the PDF P(X) at point x. Then, we can place a
;;; window function at x and determine how many observations x_i fall within our window or, rather, what
;;; is the contribution of each observation x_i to this window. The PDF value P(x) is then the sum total
;;; of the contributions from the observations to this window. 
(defn parzen-pdf-msg
  "Return the parzen-pdf function for the argument class using message counts.
   Notes that I don't divide by 1/sqrt(* 2 pi sigma sigma), thus it won't integrate to 1."
  [pn class]
  (let [msg-table (class (:msg-table pn))
        sigma (:sigma pn)
        dist-fn (:distance-fn pn)
        size (apply + (vals msg-table)) ; the total number of messages
        sig2 (* 2 sigma sigma)]
    (fn [x]
      (* (/ 1 size)
         (reduce (fn [sum [mark cnt]] ; cnt the number of messages with this marking
                   (+ sum (* cnt (Math/exp (- (/ (dist-fn mark x) sig2))))))
                 0.0
                 msg-table)))))

(defn pnn-classification-table
  "Return a table of the pnn scores for each class on each marking and certainty"
  [pn]
  (let [pdf-fns    (:pdf-fns pn)
        msg-table  (:msg-table pn)
        classes    (keys msg-table)
        marks  (distinct (mapcat keys (vals msg-table)))]
    (reduce (fn [table mark]
              (reduce (fn [table class]
                        (conj table {:mark mark :class class
                                     :score ((class pdf-fns) mark)}))
                      table classes))
            []
            marks)))

(defn pnn-certainty
  "Produce a table describing winners and certainty"
  [pn]
  (let [full-class (pnn-classification-table pn)
        marks (distinct (mapcat keys (vals (:msg-table pn))))]
    (reduce (fn [table mark]
              (let [on-mark (filter #(= (:mark %) mark) full-class)
                    sorted (sort #(> (:score %1) (:score %2)) on-mark)
                    best  (first sorted)
                    best2 (second sorted)]
                (conj table {:mark mark
                             :certainty (/ (- (:score best) (:score best2)) (:score best))
                             :best  (:class best) 
                             :2best (:class best2)
                             :score (:score best)})))
            []
            marks)))

;;; POD Just replace [calls to this?] with pnn-certainty or use pnn-classification-table above. 
(defn choose-winners
  "Map of the winners for each marking."
  [pn]
  (let [pdf-fns    (:pdf-fns pn)
        msg-table  (:msg-table pn)
        classes    (keys msg-table)
        marks (distinct (mapcat keys (vals msg-table)))]
    (reduce (fn [results mark]
              (let [result (reduce (fn [[best-class best-score] class]
                                     (let [my-score ((class pdf-fns) mark)]
                                       (if (> my-score best-score)
                                         [class  my-score]
                                         [best-class best-score])))
                                   [nil 0]
                                   classes)]
                (assoc results mark result)))
            {}
            marks)))

;;; We generate the reachability graph (including non-tangible states) and test the
;;; complete SCADA log against it. We aren't running the QPN, rather we are testing
;;; whether or not the SCADA log can be interpreted by it. For every message we successfully
;;; process, we associate the marking to response nil. For every message we fail to process,
;;; we associate the marking with the message. So how does this work? I guess there is an
;;; input node for every marking place. We run every input against every output in training.
(defn exceptional-fitness
  "Return the Inv with an :except value assessing how well the individual addresses 
   exceptional circumstances (blocking and starvation)."
  [inv]
  (handling-evolve [inv]
    (let [log (-> (app-info) :problem :scada-log)
              pn  (as-> (find-interpretation (:pn inv) log) ?pn
                    (assoc  ?pn :msg-table (compute-msg-table ?pn))
                    (assoc  ?pn :trans-counts (trans-counts (:interp ?pn)))
                    (dissoc ?pn :interp)
                    (assoc  ?pn :sigma (-> (app-info) :gp-params :exceptional-sigma))
                    (assoc  ?pn :loom-prob (rgraph2loom-probability (:rgraph ?pn) (:trans-counts ?pn)))
                    (assoc  ?pn :distance-fn #(second (alg/dijkstra-path-dist (:loom-prob ?pn) %1 %2)))
                    (assoc  ?pn :pdf-fns
                            (zipmap (-> ?pn :msg-table keys)
                                    (map #(parzen-pdf-msg ?pn %)
                                         (-> ?pn :msg-table keys))))
                    (assoc ?pn :winners (choose-winners ?pn))
                    ;; Constrain buffers if any look promising. POD mark for semantic operator. 
                    (if (:winners ?pn)
                      (reduce (fn [pn buf-info]
                                (constrain-buffer-size ?pn (:buffer buf-info) (:k buf-info)))
                              ?pn
                              (buffers-to-constrain ?pn))
                      ?pn))]
      (-> inv ; POD most of these are temporary.
          (assoc :except (cond
                           (not-empty (:trans-count pn)) 0.5
                           (not-empty (:winners pn))     0.1
                           true                          1.0))
          (assoc :pn pn)))))

;;;==================== Distance Measures for PNN =========================
(defn euclid-dist
  [x y]
  (Math/sqrt (apply + (map #(* (- %1 %2) (- %1 %2)) x y))))

(defn normalize-marking-factors
  "Compute normalizing factors for each component of the marking."
  [rgraph]
  (let [highs (reduce (fn [highs mark]
                        (map max highs mark))
                      (repeat (-> rgraph first :M count) 0)
                      (map :M rgraph))]
    ;; zero? implies a bad PN, BTW. 
    (mapv #(if (zero? %) 0 (/ 1 %)) highs)))

(defn dist-fn-1
  [norm-factors] 
  "Distance = simple normalized euclid-dist squared."
  (fn [x y]
    (let [xn (mapv * norm-factors x)
          yn (mapv * norm-factors y)]
      (pnn/euclid-dist2 xn yn))))

(defn dist-fn-2
  [loom-steps norm-factors]
  "Distance = steps * normalized euclid-dist2."
  (fn [x y]
    (let [path (alg/dijkstra-path loom-steps x y)
          xn (mapv * norm-factors x)
          yn (mapv * norm-factors y)]
      (* (count path) (pnn/euclid-dist2 xn yn)))))

(defn dist-fn-3 ; This one is not continuous.
  "Distance = product of probability along the 1/p cost path." 
  [trans-cnts loom-prob]
  (let  [adj-table (:adj loom-prob)]
    (fn [x y]
      (let [path (alg/dijkstra-path loom-prob x y)]
        (reduce (fn [probs ix]
                  (let [f (nth path ix)
                        t (nth path (inc ix))]
                    (* probs (/ 1 (get (get adj-table f) t))))) ; vals in adj-table are 1/p
                1
                (range (-> path count dec)))))))

(defn dist-fn-4 
  [loom-steps loom-prob norm-factors] 
  "Distance = product of probability along a '1 per step' (i.e. shortest) cost path."
  (let  [adj-table (:adj loom-prob)]
    (fn [x y]
      (let [ix (mapv #(-> % double Math/round) x)
            iy (mapv #(-> % double Math/round) y)
            path (alg/dijkstra-path loom-steps ix iy) ; loom-prob ???
            path-prob (reduce (fn [probs ix]
                                (let [f (nth path ix)
                                      t (nth path (inc ix))]
                                  (* probs (/ 1 (get (get adj-table f) t))))) ; vals in adj-table are 1/p
                              1
                              (range (-> path count dec)))
            xn   (mapv * norm-factors x)
            yn   (mapv * norm-factors y)]
        ;(println "path-prob = " path-prob "euclid dist = " (euclid-dist xn yn))
        (* path-prob (euclid-dist xn yn))))))

(defn dist-fn-5 ; This one is not continuous.
  "Distance =  sqrt of the sum of 1/p steps along shortest path." 
  [loom-prob]
  (fn [x y]
    (Math/sqrt (second (alg/dijkstra-path-dist loom-prob x y)))))

(defn dist-fn-6
  "Distance = sum of 1/p steps along shortest path 
   multiplied by normalized Euclidean distance (not squared)." 
  [loom-prob norm-factors]
  (fn [x y]
    (let [ifrom (mapv #(-> % double Math/round) x)
          ito   (mapv #(-> % double Math/round) y)
          path-cost (second (alg/dijkstra-path-dist loom-prob ifrom ito))
          xn   (mapv * norm-factors x)
          yn   (mapv * norm-factors y)]
      ;;(Math/sqrt (* path-cost (pnn/euclid-dist2 xn yn))) ; POD Better, but what it it?
      (* path-cost (euclid-dist xn yn)))))

;;; POD BBS NYI
(defn constrain-buffer-size
  "Return a PN where the buffer cannot exceed size N.
   This involves adding an inhibitor arc of multiplicity N to either
   where jobs start (BBS) or where they finish (BAS)." 
  [pn buffer N & {:keys [BAS?] :or {BAS? true}}]
  (when-let [trans (some #(when (= buffer (:target %)) (:source %)) (:arcs pn))]
    (let [trans-index (pnu/trans-index pn trans)]
      (as-> pn ?pn
        (update ?pn :arcs #(conj % (pnu/make-arc ?pn buffer trans :type :inhibitor :multiplicity N)))
        (assoc-in ?pn [:transitions trans-index :type] :immediate)))))
      
;([[0 1 0 1 3] [:m1-blocked 1.0000000000000002]])  
(defn buffers-to-constrain
  "Using exceptional messages, returns a vector of maps {:buffer <> :k <>} 
   listing buffers that could be constrained and the k-value."
  [pn]
  (let [blocking (remove (fn [[mark [msg _]]]
                           (or (= msg :ordinary)
                               (not= :bl (:mjpact (scada/msg-matching #(= (:act %) msg))))))
                         (:winners pn))
        machines (util/machines-of pn)
        ^clojure.lang.PersistentVector marking-key (:marking-key pn)]
    (reduce (fn [cmaps [marking [msg _]]]
                 (let [example-msg (scada/msg-matching #(= (:act %) msg))
                       m (:m example-msg)] ; POD first
                   (let [buf (some #(when-let [b (first (util/buffers-between pn m %))] b)
                                   machines)
                         size (nth marking (.indexOf marking-key buf))]
                     (if (and buf
                              (not (some #(and (= (:source %) buf) ; If so, already constrained. 
                                               (= (:type %) :inhibitor)
                                               (= (:multiplicity %) size)) (:arcs pn))))
                     (conj cmaps {:buffer buf :k size})
                     cmaps))))
            []
            blocking)))

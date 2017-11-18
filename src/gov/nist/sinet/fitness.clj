(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [clojure.pprint :refer (cl-format pprint print-table)]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [loom.alg :as alg]
            [loom.graph :as graph]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability renumber-pids)]
            [gov.nist.sinet.simulate :as sim :refer-only (simulate)]
            [gov.nist.sinet.util :as util :refer (app-info reset related-places)]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.pnn :as pnn]))

(alias 'fit 'gov.nist.sinet.fitness)

;;; ToDo: 
;;;         1) Create inhibitors from information learned from PNN.
;;;         2) Causal / Dynamic response (from Q matrix or simulation)
;;;         3) Colour/MJP fitness. 
;;;         4) Perhaps do the workflow analysis after I do the SCADA analysis
;;;            (and maybe reconceive its implementation to exploit lax interpretation work. 

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

(declare act2trans)
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

;;;===========================================
;;; Fitness measure
;;;===========================================
(defn act2trans
  "Return the transition (its name) responsible for the argument act."
  [pn act]
  (some #(when (= act (-> % :rep :act)) (:name %))
        (:transitions pn)))

(defn violates?
  "Return true if the qpn-job violates the argument relation."
  [qpn-job relation]
  (not (relation qpn-job)))

(defn avg-scada-process-steps
  "Calculate the weighted average number of steps in a SCADA pattern."
  [patterns]
  (let [npat (count patterns)]
    (when (zero? npat)
      (throw (ex-info "Insufficient data to find a pattern" {})))
    (let [njobs (apply + (map #(:njobs %) patterns))]
      (/ (apply + (map #(* (/ (:njobs %) njobs) (count (:form %))) patterns))
         npat))))

;;; +1 for every precedence constraint violated. +1 for each act not manifest in the QPN log. 
;;; Will need something more for loops, but we'll get to that later.
(defn calc-process-disorder
  "For a single QPN job-trace, return a map {:score <> :pattern-id <>} indicating the 
   score and pattern-id from the best matching SCADA patterns. Note that in assembly lines,
   there is only one SCADA pattern."
  [job-trace patterns]
  (loop [pats patterns
         best {:score 99999 :pattern-id -1}]
    (let [pat (first pats)
          ;; How many of the pattern actions are represented in this QPN trace?
          ;; POD Should this also consider acts in the qpn job trace but not in the pattern?
          nact-diff (Math/abs (- (count job-trace)
                                 (count (set/intersection (set (map :act (:form pat)))
                                                          (set (map :act job-trace))))))
          nviolates (reduce (fn [score rel] (if (violates? job-trace rel) (inc score) score))
                            0
                            (:relations pat))
          this-score (+ nact-diff nviolates) ; POD Add here to force failure.
          best  (if (< this-score (:score best))
                  {:score this-score :pattern-id (:id pat)}
                  best)]
      (cond (== this-score 0) {:score 0 :pattern-id (:id pat)}
            (empty? (next pats)) best
            true (recur (next pats) best)))))

(defn trunc-qpn-log-at-cycle
  "Return a log that stops when it sees the same message a second time on the same job."
  [qpn-log]
  (loop [log qpn-log
         short-log []]
    (let [msg (first log)]
      (if (or (empty? log) (some #(= msg %) short-log))
        short-log
        (recur (next log) (conj short-log msg))))))

;;; SCADA log processes produces multiple patterns. There is one pattern per colour for
;;; a transfer/flow or assembly line. Associated with each colour-tagged
;;; pattern are sojourn times and breakdown/repair rates. (POD, that is a ToDo!)
;;; workflow-fitness looks at a range (tkn-range) of qpn jobs, finding the error in each relative
;;; to the (typically one) SCADA log pattern, producing the average error relative to this pattern.

;;; What is the GP doing?
;;;   1) It is finding a PN that best matches the log. That PN has colour. SCADA logs
;;;      also have colour. The PNs could have multiple paths for different job types or
;;;      could combine paths where that makes more sense. 

;;; The individuals have to cope with all job types. I will keep scores on how well
;;; the PN does against each SCADA job type (colour). Then I can use crossover to combine
;;; the best of multiple colour paths. (One Inv does well on blue, another does well on red...)
;;; Maybe the GP is two-phase, where the first phase optimises for individual colours (no crossover)
;;; and the second phase predominantly does crossover on these individuals. Maybe they aren't
;;; so much phases as a function that increases the portion of crossovers as the colour-wise
;;; scores increase. Early on, perhaps scoring is about being good at one color, and later about
;;; being good at all of them. Maybe in addition to increasing cross-over, I penalize more for
;;; not handling multiple types (and do this by weighting, according to the proportion of each job
;;; type seen).

;;; So that's all good, but what do I mean by "does well on blue" etc.? With the SCADA log
;;; I'll have information about workstation reliability, colour of jobs, and time spent on
;;; at each workstation. I can keep patterns for each color. Indeed, it is not even necessary
;;; that something is reported at each workstation -- some workstations in the line could
;;; "disappear" and there would be a different section of path for some color where this occurs.
;;; I don't think there is a challenge here except in finding buffer sizes. Maybe that is a good
;;; thing. Do the ANN on the buffer size and be done with it. (BTW, maybe there are similar
;;; problems such as not having sufficient carriers, etc.)

;;; A problem here is that I don't have anything in the GP fitness measurement currently that
;;; would encourage the introduction of inhibitor arcs (and their multiplicity) as means of
;;; specifying buffer capacity. Should I just explicitly edit the PN according to the results
;;; of the ANN classification? (And how exactly do you I get the ANN to tell me that it is
;;; focusing on the quantity of tokens in place x?) [2017-10-07 That should not be hard.]

;;; The steady-state and dynamic analyses are looking more and more like validation activities.
;;; Maybe I translate to DES to do these. (Do I feed back the results? How? What?)

;;; A potentially negative aspect of the above is that it may completely separates jobs of
;;; different types. Can this be fixed with flexible cross-over? For example, I could 
;;; make some part of the red/blue, another part of the path separate red and blue. 


;;; (workflow-fitness (:pn i1) (:scada-patterns +problem+)) ; i1 is in the file data/test-m2-bas.clj
;;; Problem here is to run enough steps to get enough jobs to be able to trim some.
;;; POD Note that this treats jobs that return to workstation as damaged. 
(defn workflow-fitness
  "Generate a QPN log for the PN and return the score WRT SCADA patterns. The disorder score is the
   average (across a range of complete QPN jobs) of the process disorder of the best matched process.
   If there are very few jobs (perhaps because :elim :intro weirdness), then just score them.
   The total disorder score is number of violations of event orderings."
  [inv]
  (let [patterns (-> (util/app-info) :problem :scada-patterns)
        pn (sim/simulate (:pn inv) :max-steps (* 50 (avg-scada-process-steps patterns)))
        max-tkn (-> pn :sim :max-tkn) ; max-tkn is number of tokens generated by sim.
        warm-up (-> (util/app-info) :gp-params :aqpn-warm-up)
        disorder ;; Calculate disorder
        (if (> max-tkn 20)
          (let [tkn-range (range warm-up (- (-> pn :sim :max-tkn) warm-up))
                sum-error (reduce (fn [sum tkn-id] ; sum disorder on simulation job.
                                    ;; POD I am not using :pattern-id yet. Needs thought. 
                                    (+ sum (:score (calc-process-disorder (qpn-log-about pn tkn-id) patterns))))
                                  0
                                  tkn-range)]
            ;; Average over all the jobs. 
            (double (/ sum-error (count tkn-range))))
          ;; Otherwise at most just a few jobs. It is either not eliminating jobs-ids, or 
          ;; not even creating a log. 
          (let [tkn-id (max (Math/round (/ (-> pn :sim :max-tkn) 2.0)) 1)
                qpn-log (qpn-log-about pn tkn-id)]
            (+ (-> (util/app-info) :gp-params :no-new-jobs-penalty)
               (if (empty? qpn-log)
                 (-> (util/app-info) :gp-params :no-qpn-log-penalty)
                 (:score (calc-process-disorder
                          (trunc-qpn-log-at-cycle qpn-log)
                          patterns))))))]
    (assoc inv :disorder disorder)))

;;;====================================================================================
;;; Exceptional Fitness
;;;====================================================================================
(defn ordinary?
  "Returns msg if the message isn't exceptional otherwise false."
  [msg]
  (if (contains? (-> (app-info) :problem :exceptional-msgs) (:act  msg))
    false
    msg))

;;; POD no test on index okay? 
(defn next-ordinary
  "Return the next ordinary message, at index n or later."
  [pn log n]
  (let [last-ix (-> log last :line)]
    (loop [indx n]
      (if (> indx last-ix)
        nil
        (if-let [msg (ordinary? (nth log indx))]
          msg
          (recur (inc indx)))))))

(defn next-paths
  "Extend or eliminate paths depending on the PN's reachability graph."
  [pn log paths msg-indx]
  (let [next-msg (next-ordinary pn log msg-indx)
        from (-> paths first last :Mp) ; current state along first path
        all-steps  (filter #(= (:M %) from) (:rgraph pn))
        good-steps (filter #(= (:fire %) (:act next-msg)) all-steps)   ; matches a msg
        good-steps (map #(assoc % :indx (:line next-msg)) good-steps)] ; track where you found it.
    (if (empty? good-steps) ; This path is a dead end. 
      (rest paths)
      (into (mapv #(conj (first paths) %) good-steps) (rest paths))))) ; depth-first

(defn starting-links
  "Return all links (containing reference scada log line) that interpret 
   the SCADA log well from start-indx (usually 0)."
  [pn log start-indx & {:keys [diag-path]}]
  (let [rgraph (:rgraph pn)
        winners (atom [])]
    (loop [paths
           (or diag-path
               (mapv
                vector
                (mapv #(assoc % :indx start-indx)
                      (filter #(= (:act (next-ordinary pn log start-indx))
                                  (:fire %))
                              rgraph))))]
      (let [new-paths (if (> (-> paths first count) 50)
                        (do
                          (swap! winners #(conj % (-> paths first first)))
                          (rest paths))
                        paths)]
        (when (not-empty new-paths) 
          (recur (next-paths pn log new-paths (-> new-paths first last :indx inc))))))
    (let [job (:j (nth log start-indx))]
      (mapv #(assoc % :job job) @winners))))

(defn link+msg [link msg]
  (-> link
      (assoc :m    (:m msg))
      (assoc :job  (:j msg))
      (assoc :clk  (:clk msg))
      (assoc :indx (:line msg))))

;;; POD multimethod, except spec...
(defn link-match
  "Return the link which follows from the current link and log msg."
  [pn action llink msg]
  (let [glink (:graph-link pn)]
    (cond (= action :link) ; graph-link = llink? (use spec)
          (when-let [link (some #(when (and (= (:Mp llink) (:M %)) 
                                            (= (:fire %) (:act msg)))
                                   %)
                                (:rgraph pn))]
            (link+msg link msg)),
          ;; This relaxes conformance to rgraph
          ;; Use :graph-link to find which of the candidate states is nearest. 
          (or (= action :aj)      ; (3)
              (= action :active)) ; (5)
          (when-let [links (filter #(and #_(= (:Mp glink) (:M %))
                                         (= (:fire %) (:act msg)))
                                   (:rgraph pn))]
            (let [graph (:loom-steps pn)
                  from (:Mp glink)
                  dists (map
                         (fn [l] {:link l
                                  :dist (count (alg/dijkstra-path
                                                graph
                                                from
                                                (:M l)))})
                         links)
                  best (-> (sort #(< (:dist %1) (:dist %2)) dists) first :link)]
              (when best
                (as-> (link+msg best msg) ?link
                  (if (= action :aj)
                    (assoc ?link :relax? :add-job)
                    (assoc ?link :relax? :active)))))))))

;;; {:M [0 1 0 1 1], :fire :m2-complete-job,       :Mp [1 1 0 0 1], :rate 1.0, :job 1744, :clk 2066.1692850612535, :indx 224}
;;; {:act :m2-starved, :prev-act :m2-complete-job, :Mp [1 1 0 0 1], :clk 2066.1692850612535, :job 1744            :indx 225,}
;;; [:place-1 :place-2 :place-3 :place-4 :Place-103]
(defn starved?
  "Return true if the argument machine (in msg) is starved."
  [llink msg pn]
  (let [^clojure.lang.PersistentVector mkey (:marking-key pn)]
    (if (= (:m llink) (:m msg))
      (let [bufs (util/pulls-from pn (:m msg))]
        (if (= 0 (nth (:Mp llink)
                      (.indexOf mkey (first bufs))))
          true
          false))
      false)))

;;; Process msgs in strict log-order:
;;; (1) If the msg is not ordinary...
;;;   (1.1) If starvation and not consistent, interpretation fails.
;;;   (1.2) If not starvation, no problem.
;;; (2) If the rgraph step matches no problem.
;;; (3) If job is new and rgraph step matches no problem, update :active-jobs
;;; (4) If job not= current job but prior to first job, ignore message.
;;; (5) If job not= current job but on :active-jobs and rgraph matches on that history,
;;;     no problem (add to interp with a note).
;;; (6) Otherwise interpretation failed.  (return nil)
(defn next-match
  "If the argument msg is not ordinary, return information about it and the llink. 
   If the argument msg can advance the rgraph (i.e. ordinary), return *the* 
   corresponding link. Otherwise return nil."
  [pn llink msg job1] 
  (let [job (:j msg)
        old-job (:job llink)
        slink (atom nil)]
    (as-> pn ?pn
      (cond (not (ordinary? msg))                            ; (1)
            (if (and (= (:mjpact msg) :st)
                     (not (starved? llink msg ?pn)))
              nil
              (assoc ?pn :matched ; POD remove :Mp from exceptional
                     {:act (:act msg) :prev-act (:fire llink) :Mp (:Mp llink) :state (:Mp llink)
                      :clk (:clk msg) :job old-job :indx (:line msg)})),
            
            (reset! slink (link-match pn :link llink msg))   ; (2) or (6)
            (-> ?pn                                          ; (2)
                (assoc :matched @slink)
                (assoc :graph-link @slink)),  ; g-l tracks rgraph state change
      
            (= :aj (:mjpact msg))        ; (3) or (6)
            (when-let [link (link-match pn :aj nil msg)]     ; (3)
              (-> ?pn
                  (assoc :matched link)
                  (update :active-jobs conj (:j msg))
                  (assoc :graph-link link))),
            
            (< (:j msg) job1)              ; (4)
            (assoc ?pn :matched {:ignore? true :indx (:line msg) :job job}),
            
            (some #(== % job) (:active-jobs ?pn))
            (when-let [link (link-match pn :active job msg)] ; (5)
              (-> ?pn
                  (assoc :matched link)
                  (assoc :graph-link link)))
            
            true (assoc ?pn :matched nil))                   ; (6)
      (if (= :ej (:mjpact msg))
        (update ?pn :active-jobs (fn [aj] (filterv #(not= % job) aj)))
        ?pn))))

(declare rgraph2loom-steps)
(defn interpret-scada
  "Describe how the message stream could be accounted for by this PN. 
   Return a sequence where an element is:
    - a link augmented with :line and :job (if an ordinary message is processed), or
    - a map naming an exceptional message (if an such a message is processed)."
  [pn log start-link]
  (when start-link
    (let [last-indx (-> log last :line)
          job1 (:job start-link)]
      (loop [pn (as-> pn ?pn
                    (assoc ?pn :active-jobs (vector (:job start-link)))
                    (assoc ?pn :graph-link start-link)
                    (assoc ?pn :loom-steps (rgraph2loom-steps (:rgraph ?pn))))
             lasti start-link
             interp (transient (vector start-link))
             msg (nth log (-> start-link :indx inc))]
        (reset! diag {:lasti lasti :msg msg :job1 job1 :pn pn})
        (let [pn (next-match pn lasti msg job1)]
          ;;(println "matched = " (:matched pn))
          (cond (-> pn :matched not)
                (persistent! interp)
                (> (-> (:matched pn) :indx inc) last-indx)
                (persistent! (conj! interp (:matched pn)))
                true
                (let [lasti (:matched pn)]
                  (recur pn
                         lasti
                         (conj! interp lasti)
                         (nth log (-> lasti :indx inc))))))))))

;;; POD For all combos, replace vals in r-places with index in marking, then choose one from each set (combinatorial)
;;;     Replace those values with 1s, all other values in marking key are zeros.
;;;     Using all possibilities, choose the rgraph that has most states.
;;;     It will probably be sufficient to use the first one found, as I do below. No need for multiple i-marks.
;;;     Should check for m-mp/mp-m errors (spec?)
(defn lax-reach
  "Set the marking-key such there is one token on each machine.
   Return the pn with an :rgraph associated with this marking." 
  ([pn] (lax-reach pn 2))
  ([pn max-k]
   (let [r-places (atom (util/related-places pn))
         imark (reduce (fn [mark place] ; this generates one of several possibilities. 
                         (if-let [machine (some #(when (contains? (% @r-places) place) %)
                                                (keys @r-places))]
                           (do (swap! r-places dissoc machine)
                               (conj mark 1))
                           (conj mark 0)))
                       []
                       (:marking-key pn))]
     (as-> pn ?pn 
         (pnu/set-marking ?pn imark) ; POD better would be to keep it this way!
         (assoc ?pn :rgraph (pnr/simple-reach ?pn max-k))     ; packed
         (assoc ?pn :k-limited? (-> ?pn :rgraph :k-limited?)) ; unpack
         (assoc ?pn :rgraph (-> ?pn :rgraph :rgraph vec))     ; unpack 
         (if (pnu/m-mp-mp-m-valid? ?pn)
           ?pn
           (throw (ex-info "PN fails lax-reach" {:pn pn})))))))

(defn full-interp?
  "Return true if the interpretation read the whole log."
  [interp last-line]
  (and (number? (-> interp last :indx))
       (== last-line (-> interp last :indx))))

(defn find-interpretation
  "At increasing values of max-k, find new starting links and try to interpret
   the entire log. Return the first complete interpretation found, if any below
   max-max-k."
  [pn log]
  (let [last-line (-> log last :line)
        max-max-k (-> (app-info) :gp-params :max-max-k)]
    (loop [max-k  (-> (app-info) :gp-params :min-max-k)]
      (let [pn (lax-reach pn max-k) ; sets :rgraph, :k-limited
            good-interp (loop [starts (starting-links pn log 0)]
                          (let [interp (interpret-scada pn log (first starts))]
                            (cond (empty? starts) nil,
                                  (full-interp? interp last-line) interp,
                                  true (recur (rest starts)))))]
        (cond (not (empty? good-interp))
              (-> pn
                  (assoc :interp good-interp)
                  (assoc :max-k-used max-k))
              (> max-k max-max-k) nil 
              true (recur (inc max-k)))))))

;;; You can have the same marking associated with more than one class. The more times you have
;;; it associated with a class, the stronger the result will be for that class. To make
;;; the following efficient, I'll have to count the number of times each marking is associated
;;; with each class. Then I'll use that as a factor in calculating the PDF.
;;; POD Note that I throw away :interps and :fails here. Returning a msg-table, not the pn. 
(defn compute-msg-table
  "Return a map indicating what markings are associated with what message types, 
   where message types are either ':ordinary' or some exceptional message type."
  [pn] 
  (let [msg-types (conj (-> (app-info) :problem :exceptional-msgs) :ordinary)
        markings (map :M (:rgraph pn))]
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
                msg-types)))))

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

;;; POD Just replace this with pnn-certainty or use pnn-classification-table above. 
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
              (assoc ?pn :winners (choose-winners ?pn)))]
    (-> inv ; POD both of these are temporary.
        (assoc :except (if (not-empty (:winners pn)) 0 1))
        (assoc :pn pn))))


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

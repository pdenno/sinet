(ns gov.nist.sinet.fitness
  "Compute the fitness of an individual"
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]
            [loom.alg :as alg]
            [loom.graph :as graph]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [gov.nist.spntools.util.reach :as pnr :refer (reachability renumber-pids)]
            [gov.nist.spntools.util.pnml :as pnml :refer (read-pnml)] ; POD temporary
            [gov.nist.sinet.simulate :as sim :refer-only (simulate)]
            [gov.nist.sinet.util :as util :refer (app-info reset related-places)]
            [gov.nist.sinet.scada :as scada]
            [gov.nist.sinet.pnn :as pnn]))

(alias 'fit 'gov.nist.sinet.fitness)

;;; ToDo: Currently fitness only concerns violation of partial orders it should
;;;       additionally include:
;;;         0) Checking for work flows that are not reflected in the log. 
;;;         1) Dynamic response (from Q matrix or simulation)
;;;         2) Association to being blocked/unblocked starved/unstarved.
;;;            If the individual scores better without the PNN, then just consider that
;;;            its best score. 

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
(defn qpn-act-is-intro? [pn act]
  "Return true if the named transition has an arc exiting it that 
   introduces a token."
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

#_(defn diag-describe-pn-transition-binding
  [pn]
  (zipmap (map :name (:transitions pn))
          (map #((:fn %) :job-x) (:transitions pn))))

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
;;; POD reachability graph is apt to be too sensitive to initial marking???
;;; There is a loose end in this design concerning the PN's marking determining its rgraph. 
;;; Some markings may not necessarily enable the best interpretation of the sdata.
;;; I am probably going to have write some code to select a good initial marking
;;; before I generate the rgraph. Thus messing with tokens would no longer part of GP!
;;; Also, I would perhaps do the workflow analysis after I do the SCADA analysis
;;; (and maybe reconceive its implementation to exploit the SCADA analysis work).


;;; Idea: This (excep-starting-mark) could force an initial-marking on the PN.
;;;       That might be a good thing!
;;;       But what gets hard here is choosing a marking that will guess correctly
;;;       what is flowing through the PN/system. Maybe this isn't that hard, since we CAN
;;;       know the number of jobs in the queue.
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
  (let [last-ix (:last-line pn)]
    (loop [indx n]
      (if (> indx last-ix)
        nil
        (if-let [msg (ordinary? (nth log indx))]
          msg
          (recur (inc indx)))))))

;;; POD this is a candidate enhancement to use an ARG (Abbreviated Reachability Graph).
(defn next-paths
  "Extend or eliminate paths depending on the PN's reachability graph."
  [pn log paths msg-indx]
  (let [next-msg (next-ordinary pn log msg-indx)
        from (-> paths first last :Mp) ; current state along first path
        all-steps  (filter #(= (:M %) from) (:rgraph pn))
        good-steps (filter #(= (:fire %) (:act next-msg)) all-steps)   ; matches a msg
        good-steps (map #(assoc % :indx (:line next-msg)) good-steps)] ; track where you found it.
    ;(println "good-steps=" good-steps)
    ;(println "paths=" paths)
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
                          (swap! winners #(conj  % (-> paths first first)))
                          (rest paths))
                        paths)]
        (when (not-empty new-paths) 
          (recur (next-paths pn log new-paths (-> new-paths first last :indx inc))))))
    (let [job (:j (nth log start-indx))]
      (mapv #(assoc % :job job)  @winners))))

(defn link+msg [link msg]
  (-> link
      (assoc :job  (:j msg))
      (assoc :clk  (:clk msg))
      (assoc :indx (:line msg))))

;;; POD multimethod, except spec...
(defn link-match [pn action llink msg]
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
            (let [graph (:loom-graph pn)
                  from (:Mp glink)
                  dists (map
                         (fn [l] {:link l
                                  :dist (count (alg/dijkstra-path
                                                graph
                                                from
                                                (:M l)))})
                         links)
                  best (-> (sort #(< (:dist %1) (:dist %2)) dists) first :link)]
              (cl-format *out* "~%counts = ~{~A ~}" (map :dist dists))
              (when best
                (as-> (link+msg best msg) ?link
                  (if (= action :aj)
                    (assoc ?link :relax? :add-job)
                    (assoc ?link :relax? :active)))))))))

;;; Process msgs in log-order without exception:
;;; (1) If the msg is not ordinary, no problem.
;;; (2) If the job = current job and rgraph matches no problem.
;;; (3) If job is new and rgraph matches no problem, update :active-jobs
;;; (4) If job not= current job but prior to first job, ignore message.
;;; (5) If job not= current job but on :active-jobs and rgraph matches on that history,
;;;     no problem (add to interp with a note).
;;; (6) Otherwise interpretation failed.  (return nil)
(defn next-match
  "If the argument msg is not ordinary, return its act and the state it enters (Mp). 
   If the argument msg can advance the rgraph, return *the* corresponding link.
   otherwise return nil."
  [pn llink msg job1] 
  (let [job (:j msg)
        old-job (:job llink)
        slink (atom nil)]
    (reset! diag {:msg msg :interp-last llink :glink (:graph-link pn)})
    (as-> pn ?pn
      (cond (not (ordinary? msg))                            ; (1) 
            (assoc ?pn :matched
                   {:act (:act msg) :prev-act (:fire llink) :indx (:line msg)
                    :Mp (:Mp llink) :clk (:clk msg) :job old-job}),
            
            (reset! slink (link-match pn :link llink msg)) ;(== old-job job) ; (2) or (6)
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
            
            true (assoc ?pn :matched nil))                  ; (6)
      (if (= :ej (:mjpact msg))
        (update ?pn :active-jobs (fn [aj] (filterv #(not= % job) aj)))
        ?pn))))

(defn interpret-scada
  "Describe how the message stream could be accounted for by this PN. 
   Return a sequence where an element is:
    - a link augmented with :line and :job (if an ordinary message is processed), or
    - a map naming an exceptional message (if an such a message is processed)."
  [pn log start-link]
  (when start-link
    (let [last-indx (-> log last :line)
          job1 (:job start-link)]
      (loop [pn (-> pn
                    (assoc :active-jobs (vector (:job start-link)))
                    (assoc :graph-link start-link))
             lasti start-link
             interp (transient (vector start-link))
             msg (nth log (-> start-link :indx inc))]
        (let [pn (next-match pn lasti msg job1)]
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
   Return the rgraph associated with this marking." 
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
         (pnu/set-marking ?pn imark)
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
  [pn log] ; POD (-> (app-info) :gp-params :min-max-k)
  (let [last-line (-> log last :line)] ; POD remove pn's :last-line....
    (loop [max-k 2]
      (let [pn (lax-reach pn max-k)
            good-interp (loop [starts (fit/starting-links pn log 0)]
                          (let [interp (interpret-scada pn log (first starts))]
                            (cond (empty? starts) nil,
                                  (full-interp? interp last-line) interp,
                                  true (recur (rest starts)))))]
        (cond (not (empty? good-interp)) 
              (assoc pn :interp)
              (> max-k 6) nil ; POD (-> (app-info) :gp-params :max-max-k)
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
    (when-let [interp (not-empty (:interps pn))]
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

(defn rgraph2loom-graph
  "Return a loom weighted-digraph for the argument simple reachability graph."
  [rgraph]
  (apply graph/weighted-digraph
         (map #(vector (:M %) (:Mp %) 1) rgraph)))

(defn graph-distance-fn
  "Return a function that calculates graph distance for the PN."
  [pn]
  (let [graph (-> pn :loom-graph)]
    (fn [from to]
      (let [graph-distance (count (alg/dijkstra-path graph from to))]
        (* graph-distance 
           (reduce (fn [sum ix] (+ sum (Math/pow (- (nth from ix) (nth to ix)) 2)))
                   0.0
                   (range (count from))))))))

(defn parzen-pdf-msg
  "Return the parzen-pdf function for the argument class using message counts."
  [pn class]
  (reset! diag pn)
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

(defn choose-winners
  "Map of the winners for each marking."
  [pn]
  (when (not-empty (:pdf-fns pn))
    (let [pdf-fns    (:pdf-fns pn)
          msg-table  (:msg-table pn)
          classes    (keys msg-table)
          dist-fn    (:distance-fn pn)
          sigma      (:sigma pn)
          marks (distinct
                 (mapcat keys (map #(get msg-table %) classes)))]
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
              marks))))


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
        pn  (as-> (:pn inv) ?pn
              (pnr/renumber-pids ?pn)
              (assoc ?pn :last-line (-> ?pn :log last :line))
              (lax-reach ?pn 2)
              ;(assoc ?pn :rgraph (pnr/simple-reach ?pn 2))
              ;(assoc ?pn :k-limited? (-> ?pn :rgraph :k-limited?))
              ;(assoc ?pn :rgraph (-> ?pn :rgraph vec))
              (assoc ?pn :starting-links (starting-links ?pn log 0))
              (assoc ?pn :loom-graph (rgraph2loom-graph (-> ?pn :rgraph)))
              (assoc ?pn :msg-table (compute-msg-table ?pn))
              (assoc ?pn :sigma (-> (app-info) :gp-params :exceptional-sigma))
              (assoc ?pn :distance-fn (graph-distance-fn ?pn))
              (assoc ?pn :pdf-fns
                     (zipmap (-> ?pn :msg-table keys)
                             (map #(parzen-pdf-msg ?pn %)
                                  (-> ?pn :msg-table keys))))
              (assoc ?pn :winners (choose-winners ?pn)))]
    (-> inv ; POD both of these are temporary.
        (assoc :except (if (not-empty (:winners pn)) 0 1))
        (assoc :pn pn))))

(def hopeful-pn
  {:initial-marking [1 0 0 0 0], ; I changed this too! How do I fix this? GP operator? Try different ones in simple-reach? 
   :transitions
   [{:name :m1-start-job,
     :tid 38,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m1-start-job, :j 1991, :jt :jobType1, :ends 2356.5705647971827, :clk 2355.3103128463604, :line 1233, :mjpact :aj, :m :m1},
     :visible? true}
    {:name :m1-complete-job,
     :tid 39,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m1-complete-job, :bf :b1, :j 1991, :n 1, :clk 2356.5705647971827, :line 1238, :mjpact :bj, :m :m1},
     :visible? true}
    {:name :m2-start-job,
     :tid 40,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m2-start-job, :bf :b1, :j 1991, :n 3, :clk 2358.9070474961236, :line 1247, :mjpact :sm, :m :m2},
     :visible? true}
    {:name :m2-complete-job,
     :tid 41,
     :type :exponential,
     :rate 1.0,
     :rep {:act :m2-complete-job, :m :m2, :j 1991, :ent 2355.3103128463604, :clk 2360.0770474961237, :line 1248, :mjpact :ej},
     :visible? true}],
   :arcs
   [{:aid 74, :source :place-1, :target :m2-start-job, :EDITED true :name :aa-74, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 75, :source :m1-start-job, :target :place-2, :name :aa-75, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 76, :source :place-2, :target :m1-complete-job, :name :aa-76, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 77, :source :m1-complete-job, :target :place-3, :name :aa-77, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 78, :source :place-3, :target :m1-start-job, :EDITED true :name :aa-78, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 79, :source :m2-start-job, :target :place-4, :name :aa-79, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 80, :source :place-4, :target :m2-complete-job, :name :aa-80, :type :normal, :multiplicity 1, :bind {:jtype :blue}}
    {:aid 81, :source :m2-complete-job, :target :place-1, :name :aa-81, :type :normal, :multiplicity 1, :bind {:jtype :blue}, :priority 1}
    {:aid 205, :source :m1-start-job, :target :Place-103, :name :aa-205, :type :normal, :multiplicity 1, :bind {:jtype :blue} :priority 2}
    {:aid 206, :source :Place-103, :target :m2-start-job, :name :aa-206, :type :normal, :multiplicity 1 :bind {:jtype :blue}, :priority 1}],
   :marking-key [:place-1 :place-2 :place-3 :place-4 :Place-103],
   :places
   [{:name :place-1, :pid 0, :initial-tokens 1, :visible? true}
    {:name :place-2, :pid 1, :initial-tokens 0, :visible? true}
    {:name :place-3, :pid 2, :initial-tokens 0, :visible? true}
    {:name :place-4, :pid 3, :initial-tokens 0, :visible? true}
    {:name :Place-103, :pid 4, :initial-tokens 0}]})

(defn tryme []
  (let [log (scada/load-scada "data/SCADA-logs/m2-j1-n3-block-mild-out.clj")
        pn hopeful-pn]
    (as-> (find-interpretation pn log) ?pn
      (assoc ?pn :loom-graph (rgraph2loom-graph (:rgraph ?pn)))
      (assoc ?pn :msg-table (fit/compute-msg-table ?pn))
      (dissoc ?pn :interp)
      (assoc ?pn :sigma (-> (app-info) :gp-params :exceptional-sigma))
      (assoc ?pn :distance-fn (graph-distance-fn ?pn)))))



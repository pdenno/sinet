(ns gov.nist.sinet.simulate
  (:require [clojure.pprint :refer (cl-format pprint pp)]
            [gov.nist.spntools.util.reach :as pnr]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp as-pn-ok-> name2obj)]
            [gov.nist.spntools.util.pnml  :as pnml]))

;;; Purpose: Run a PN, producing a log of its execution.

;;; In ordinary GSPN code, a marking (:queues) is just a vector of integers signifying the tokens on a place.
;;; In our implementation, we instead keep maps of queues containing tokens. Where we need the ordinary GSPN marking,
;;; we can convert this queue-base marking to it with (map count (queues-marking-order pn)).
;;; The PN is initialized with default-coloured tokens. For example where the ordinary marking might be
;;; [2 0 0 0] ours would be [[{:type :a :id 1} {:type :a :id2}] [] [] []].

(def ^:private diag (atom nil))

;;; POD When I replace next-link with the QPN equivalent, this can go away. 
(defn queues-marking-order
  "Return a vector of queues in the marking order."
  [pn]
  (let [mk (:marking-key pn)
        queues (-> pn :sim :queues)]
    (vec (map #(% queues) mk))))

(declare sim-effects pick-link step-state update-log-for-move max-tkn)
;;; Not yet a stochastic simulation, also need to implement free choice.
;;; (simulate (:pn eee) :max-steps 2)
(defn simulate
  "Run a PN for max-steps or max-token whichever comes first."
  [pn & {:keys [max-token max-steps] :or {max-token 50 max-steps 200}}]
  (let [id (atom 0)]
    (as-> pn ?pn
      (pnr/renumber-pids ?pn)
      (assoc ?pn
             :sim {:log []
                   :max-tkn 1
                   :queues (zipmap
                            (:marking-key ?pn) ; POD next line will need work for colour. 
                            (map (fn [n] (vec (repeatedly n (fn [] {:jtype :blue :id (swap! id inc)}))))
                                 (:initial-marking ?pn)))})
      (reduce (fn [pn _]
                (if (>= (-> pn :sim :max-tkn) max-token) pn (sim-effects pn)))
              ?pn
              (range max-steps)))))

;;; POD: Currently I'm using next-links, because there is only one colour.
(defn sim-effects
  "Update the PN's :sim with the effects of one step."
  [pn]
  (let [marking (vec (map count (queues-marking-order pn)))
        next-links (pnr/next-links pn marking)]
    (if (empty? next-links) ; then ran out of tokens.
      pn
      (step-state pn (pick-link next-links)))))

;;; An entry in a queue looks like this: {:jtype :blue :id 4}
;;; POD currently I'm ignoring colour; specifically, I'm using next-link and not evaluating bindings.

;;; Regardless of the the change in marking from :M to Mp implies a change in the number of
;;; tokens, there needs to be a discipline regarding which tokens move where. It is as follows:

;;; A priority 1 to N was assigned to the N arcs out-going from a transition (that was done in the
;;; design of the PN). Each out-going arc on the transition has a unique priority. 
;;; Priority is therefore a total ordering on the out-going arcs.
;;; The priority assignments and the ids on token are used to determine what tokens
;;; will flow out of which arcs from a transition in simulation. The rules are as follows:
;;;
;;; (1) Negative balance: Tokens are removed from each in-coming place according to the
;;;     multiplicity of the arc in-coming and FIFO queueing. Among these, the oldest N tokens 
;;;     are removed to satisfy an imbalance of N tokens. WILL HAVE TO ABIDE BY COLOR WHEN IMPLEMENTED.
;;;     The remaining tokens are distributed so that the token requirements (multiplicity) of
;;;     the highest priority arc are satisfied first using the oldest remaining tokens,
;;;     then the second highest priority arc, and so on. WILL HAVE TO ABIDE BY COLOR WHEN IMPLEMENTED.
;;; (2) Positive balance/Perfect balance: New tokens are created to satisfy any imbalance. 
;;;     Tokens are distributed to the places as in (1).

;;; Binding makes GP a bit more complex. In GP you can have new tokens springing up / being eliminated
;;; anywhere. I think the need for intro/elim arises out of imbalance at a transition.
;;; Thankfully, there is a constraint propagation task here. When introducing a free choice pick
;;; among binding types, one can push that through the marked graph portion until a
;;; place where there is confluence of types is reached. At that point forward arcs accept a disjunction
;;; of the types in confluence.  When there are additional free choice (like in a buffer) there is the
;;; opportunity to to reuse the old binding types or choose new ones.

;;; BTW, there is no reason why an inhibitor can't have a binding. 

(defn new-tokens
  "Create a vector of n new tokens."
  [pn n]
  (let [tkns (->> pn :sim :queues (mapcat (fn [[_ v]] (map :id v))))
        max-tkn (if (empty? tkns) 0 (apply max tkns))]
    (reduce (fn [v id] (conj v {:jtype :blue :id id}))
            []
            (range max-tkn (+ max-tkn n)))))

(defn pull-tokens
  "Collect tokens from the arcs (adjusting queues); set (-> pn :sim :to-assign) to 
   the tokens that will be part of push-tokens."
  [pn a-ins balance]
  (as-> pn ?pn
    (assoc-in ?pn [:sim :to-assign] [])
    (reduce (fn [pn arc]
              (as-> pn ?pn1
                (update-in ?pn1 [:sim :to-assign]  ; collect
                           #(into % (subvec (->> ?pn1 :sim :queues ((:source arc)))
                                          0 (:multiplicity arc))))
                (update-in ?pn1 [:sim :queues (:source arc)]           ; trim queues
                           #(subvec % (:multiplicity arc)))))
            ?pn
            a-ins)
    (update-in ?pn [:sim :to-assign] (fn [v] (vec (sort #(< (:id %1) (:id %2)) v)))) ; oldest first
    (update-in ?pn [:sim :to-assign]
               #(cond (< balance 0) (subvec % (Math/abs balance))      ; remove
                      (> balance 0) (into % (new-tokens ?pn balance))  ; add
                      :else %))))                                      ; move

(defn push-tokens
  "Assign tokens from (-> pn :sim :to-assign) to the queues according
   to priority and multiplicity."
  [pn a-outs]
  (let [a-outs (sort #(< (:priority %1) (:priority %2)) a-outs)]
    (reduce (fn [pn arc]
              (let [mult (:multiplicity arc)]
                (as-> pn ?pn
                  (update-in ?pn [:sim :queues (:target arc)]
                             #(into % (subvec (-> pn :sim :to-assign) 0 mult)))
                  (update-in ?pn [:sim :to-assign] #(subvec % mult)))))
            pn
            a-outs)))

(defn flow-balance
  "Compute the difference tokens-out minus tokens in."
  [pn trans]
  (- (reduce (fn [sum arc] (+ sum (:multiplicity arc)))
             0
             (pnu/arcs-outof pn trans))
     (reduce (fn [sum arc] (+ sum (:multiplicity arc)))
             0
             (remove #(= (:type %) :inhibitor) (pnu/arcs-into pn trans)))))

(defn step-state
  "Update the (-> pn :sim :queues) for the effect of firing the argument transition."
  [pn link]
  (let [fire (:fire link)
        mkey (:marking-key pn)
        a-in (remove #(= :inhibitor (:type %)) (pnu/arcs-into pn fire))
        a-out (pnu/arcs-outof pn fire)
        balance (flow-balance pn fire)]
    (pnu/as-pn-ok-> pn ?pn
      (assoc-in ?pn [:sim :old-queues] (-> ?pn :sim :queues))
      (pull-tokens ?pn a-in balance)
      (push-tokens ?pn a-out)
      (update-log-for-move ?pn fire))))

(defn update-log-for-move
  "Add to log :add :remove and :move actions and transition :act."
  [pn fire]
  (let [old-queues (-> pn :sim :old-queues)
        queues (-> pn :sim :queues)
        old (-> old-queues vals flatten set)
        new (-> queues     vals flatten set)
        added   (clojure.set/difference new old)
        removed (clojure.set/difference old new)
        remain  (clojure.set/intersection old new)
        find-at (fn [tkn queues] (some (fn [[key val]] (when (some #(= % tkn) val) key)) queues))
        moved (reduce (fn [mvd stay]
                        (if (= (find-at stay old-queues) (find-at stay queues))
                          mvd
                          (conj mvd stay)))
                      [] remain)]
    (as-> pn ?pn
      (if (contains? (pnu/name2obj pn fire) :rep)
        (update-in ?pn [:sim :log] #(conj % (assoc (:rep (pnu/name2obj pn fire))
                                                   :j
                                                   (vec (map :id (clojure.set/union added moved)))
                                                   :fire
                                                   fire)))
        ?pn)
      (reduce (fn [pn rem]
                (update-in pn [:sim :log] #(conj % {:on-act fire :tkn rem :motion :remove})))
              ?pn removed)
      (reduce (fn [pn add]
                (update-in pn [:sim :log] #(conj % {:on-act fire :tkn add :motion :add})))
              ?pn added)
      (reduce (fn [pn mv]
                (update-in pn [:sim :log] #(conj % {:on-act fire :tkn mv :motion :move
                                                    :from (find-at mv (-> pn :sim :old-queues))
                                                    :to (find-at mv (-> pn :sim :queues))})))
              ?pn moved)
      (assoc-in ?pn [:sim :max-tkn] (max-tkn ?pn)))))

(defn pick-link
  "Return a random link according to the distribution provide by their rates."
  [links]
  (let [r (rand (reduce (fn [sum l] (+ sum (:rate l))) 0.0 links))]
    (loop [dist links
           sum (:rate (first links))]
      (if (> sum r)
        (first dist)
        (recur (rest dist)
               (+ sum (:rate (second dist))))))))

;;; :queues {:place-1 [], :place-2 [], :place-3 [{:jtype :blue, :id 1}], :place-4 []},
(defn max-tkn
  "Return the max-tkn found in the marking."
  [pn]
  (reduce (fn [mx queue]
            (let [ids (map :id queue)]
              (if (empty? ids)
                mx
                (max mx (apply max ids)))))
          0
          (-> pn :sim :queues vals)))

;;; POD This can't stay here uncommented (load ordering).
(defn m2-inhib-bas
  "Does 'the' correct answer score 0?"
 []       ;     Change...
  (-> "/Users/peterdenno/Documents/git/spntools/data/m2-inhib-bas.xml" 
      gov.nist.spntools.core/run-ready
      gov.nist.sinet.gp/add-color-binding
      gov.nist.sinet.gp/add-flow-priorities
      (simulate :max-steps 15)))


(ns gov.nist.sinet.util
  "General sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint pp)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan close!]]
            [clojure.spec.alpha :as s]
            [clojure.tools.namespace.repl :as nsp]
            [clojure.math.combinatorics :as combo]
            [clojure.core.async :as async :refer [chan alts!! go timeout >!]]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]))

(def ^:private diag (atom nil))

(defmacro VARS [& args] 
  "Prints (println) values of the arguments (VARS x y) prints 'x = ..., y = ...'"
  `(println (format ~(cl-format nil "~{ ~A = %s~^,~}" `~args) ~@args)))

(defn app-info
  "The way into the app for reading."
  []
  ((resolve 'gov.nist.sinet.run/app-info)))

(defn evolve-chan [] (-> (app-info) :gp-system :evolve-chan))

(def failed-evolve "An individual that had an exception in fitness code." (atom nil))

(defmacro handling-evolve [[data] & body]
  (let [e# nil]
    `(if (not @failed-evolve)
       (try
         ~@body
         (catch Exception e#
           (reset! failed-evolve {:exception e# :data ~data})
           (>!! (evolve-chan) "abort")))
       (throw (ex-info "handling-evolve " {:exception @failed-evolve})))))

; (set-param! [:app :foobar] :baz)
(defn set-param!
  "The way into the app for writing."
  [path value]
  (alter-var-root
   (resolve 'gov.nist.sinet.run/system)
   (fn [sys]
     (assoc-in sys path value))))

(defn gp-param
  "Convenient way into gp parameters for reading"
  [name]
  (-> (app-info) :gp-params name))

(defn pr-param [name]
  "Convenient way into problem parameters for reading"
  (-> (app-info) :problem name))

(defn reset
  "Reset the system, reloading changed code."
  []
  ;; Disable-reload! is here so that the atoms app/problem and app/gp-params don't get redefined.
  ;; I can then update them (e.g. in testing) to run various scenarios. 
  (nsp/disable-reload! (find-ns 'gov.nist.sinet.app))
  (nsp/disable-reload! (find-ns 'gov.nist.sinet.untouched)) 
  ;(nsp/disable-reload! (find-ns 'taoensso.sente))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.server))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.client))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.timer))
  ((resolve 'gov.nist.sinet.run/reset)))

(def save-http-server
  "Save HTTPServer stop fn so can do (.stop @save-http-server 100)"
  (atom :original-value))

;;; POD This isn't helping, but I'll leave it here and work on it next time I get stuck. 
(defn big-reset
  "Reset the system, getting out of a jam if possible."
  []
  (nsp/clear)
  ;(nsp/set-refresh-dirs)
  ;(nsp/disable-reload! (find-ns 'taoensso.sente))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.server))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.client))
  ;(nsp/disable-reload! (find-ns 'org.httpkit.timer))
  (nsp/refresh)
  ;; The server sometime does not stop through the normal process.
  (when-not (= :original-value @save-http-server)
    (org.httpkit.server.HttpServer/.stop @save-http-server 100))
  ((resolve 'gov.nist.sinet.run/reset)))

(def +log+ (atom []))
(defn log [msg] (swap! +log+ conj msg))

(defn uuid [] (.toString (java.util.UUID/randomUUID)))

(def ^:dynamic *debugging* false)

(defn when-debugging
  [& body]
  `(when *debugging*
     @body))

(defn pick-from-atom!
  "Randomly remove one element from the atom and return it."
  [atom]
  (let [picked (nth @atom (rand-int (count @atom)))]
    (swap! atom (fn [a] (remove #(= picked %) a)))
    picked))

(defn random-index
  "Create a vector of size n using each of the numbers 0 to n-1 once."
  [n]
  (let [patom (atom (range n))]
    (reduce (fn [v _] (conj v (pick-from-atom! patom)))
            []
            (range n))))

(defrecord Inv [pn id err disorder types history])

(defn print-inv [p writer]
  (.write writer (cl-format nil "#Inv [dis=~A,exc=~A]"
                            (if (number? (:disorder p)) 
                              (cl-format nil "~5,2F" (:disorder p))
                              :NA)
                            (if (number? (:except p)) 
                              (cl-format nil "~5,2F" (:except p))
                              :NA))))

(defmethod print-method Inv [p writer]
  (print-inv p writer))

(.addMethod clojure.pprint/simple-dispatch Inv (fn [p] (print-inv p *out*)))

(defn mean
  [v]
  (/ (apply + v) (count v)))

(defn variance
  "Var(X) = E[(X - mu)^2]"
  [v]
  (let [avg (mean v)]
    (mean (vec (map (fn [x]
                      (let [dif (- x avg)]
                        (* dif dif)))
                    v)))))

;;;========= These are PNs extended from spntools for use in sinet.  =========
(s/def ::clk number?)
(s/def ::line number?)
(s/def ::mjpact keyword?)
(s/def ::act keyword?)
(s/def ::rep (s/keys :req-un [::act ::mjpact ::line ::clk]))

;;; POD having a ::rep is equivalent to being :visible? Don't need :visible? on trans.
(s/def ::jtype keyword?)
(s/def ::bind (s/keys :req-un [::jtype]))
(s/def ::visible boolean?)
(s/def ::place       (s/keys :req-un [])) ; ::visible?
(s/def ::transition  (s/keys :req-un [])) ; POD doesn't need a ::rep! ::visible?
(s/def ::normal-arc  (s/keys :req-un [::bind]))
(s/def ::arc         (s/or :inhib #(= :inhibitor (:type %))
                           :normal (s/and #(= :normal (:type %))
                                          ::normal-arc)))

(s/def ::places      (s/and ::pnu/places      (s/coll-of ::place)))
(s/def ::transitions (s/and ::pnu/transitions (s/coll-of ::transition)))
(s/def ::arcs        (s/and ::pnu/arcs        (s/coll-of ::arc)))
(s/def ::gppn (s/and ::pnu/pn
                     (s/keys :req-un [::places ::transitions ::arcs])))

(defn check-pn
  "clojure.spec check the pn."
  [pn]
  (if (s/valid? ::gppn pn) pn nil))

(defn machines-of
  "Return collection of the machines used in the PN."
  [pn]
  (distinct (mapv #(-> % :rep :m)
                  (filter #(contains? % :rep) (:transitions pn)))))

(defn related-trans
  "Return a map where each key is machine name and each value is a set of 
   transition names related to that machine. (These trace back to a message)."
  [pn]
  (let [machines (machines-of pn)]
    (zipmap machines
            (map (fn [m]
                   (set (map :name (filter #(= m (-> % :rep :m))
                                           (:transitions pn)))))
                 machines))))

(defn related-places
   "Return a map where each key is machine names, and each value is a set of place names.
    The places must be between transitions related to the machine."
  [pn]
  (let [machines (machines-of pn)
        m-trans (related-trans pn)]
    (zipmap machines ; there is an arc that has this place as source and a m-trans machine as target
            (map (fn [m]  ; and an arc that has this place as target and a m-trans machine as source
                   (let [mset (get m-trans m)]
                     (set (map :name
                               (filter (fn [p] 
                                         (and (some #(and (contains? mset (:source %))
                                                          (= (:target %) (:name p)))
                                                    (:arcs pn))
                                              (some #(and (contains? mset (:target %))
                                                          (= (:source %) (:name p)))
                                                    (:arcs pn)))) ; (get m-arcs m))) <---- When the above is fixed.
                                       (:places pn))))))
                 machines))))

(defn iface-places
  "Return a map keyed by [mx my] where mx and my are keywords 
   naming machines. For each key [mx my] the map's value is a vector
   of places that connect a transition associated with mx to an 
   transition associated with my."
  [pn]
  (let [machines (machines-of pn)
        combos   (map vec (combo/combinations machines 2))
        from-to  (into combos (map (fn [[x y]] [y x]) combos)) ; machine pairs
        places   (map :name (:places pn))
        arcs     (:arcs pn)]
    (zipmap from-to
              (map (fn [[mx my]]
                     (filterv (fn [p] 
                                (and (some (fn [a] ; target of arc is the place; source is trans on mx. 
                                             (and (= (:target a) p)
                                                  (= mx (-> (pnu/name2obj pn (:source a)) :rep :m))))
                                           arcs)
                                     (some (fn [a] ; source of arc is the place; target is trans on my. 
                                             (and (= (:source a) p)
                                                  (= my (-> (pnu/name2obj pn (:target a)) :rep :m))))
                                           arcs)))
                              places))
                   from-to))))


(defn related-arcs
  "Return a map where the each key is a machine name and each value is a set of arc names.
   Both ends of the arcs must be connected a related-place or related-transition."
  [pn]
  (let [machines (machines-of pn)
        m-trans  (related-trans pn)
        m-places (related-places pn)]
    (zipmap machines
            (map (fn [m]
                   (let [tset (get m-trans m)
                         mset (get m-places m)]
                     (set (map :name
                               (filter #(or (and (contains? tset (:source %))  
                                                 (contains? mset (:target %)))
                                            (and (contains? mset (:source %))  
                                                 (contains? tset (:target %))))
                                       (:arcs pn))))))
                 machines))))

(defn first-contact
  "Return the path from the START (a transition) to :sm or :aj transition on MACHINE."
  [pn start machine]
  (let [end (some #(when (and (= machine (-> % :rep :m))
                              (contains? #{:aj :sm} (-> % :rep :mjpact)))
                     (:name %))
                  (:transitions pn))]
    (if (= (-> (pnu/name2obj pn start) :rep :m) machine)
      [start]
      (some #(let [paths (pnu/paths-to pn start end %)]
               (first paths))
            (map #(* % 4) (range 1 (+ 2 (count (machines-of pn)))))))))

(defn upstream? 
  "Return true if mx is upstream of my."
  [pn mx my]
  (let [start-trans (some #(when (= :aj (-> % :rep :mjpact)) (:name %)) (:transitions pn))]
    (< (count (first-contact pn start-trans mx))
       (count (first-contact pn start-trans my)))))

(defn next-machine
  "Return the next machine in the serial line. Does not wrap around unless
   optional 3rd argument is true."
  ([pn m] (next-machine pn m false))
  ([pn m wrap?]
   (let [candidates
         (as-> (machines-of pn) ?machs
           (remove #(= m %) ?machs)
           (if wrap? ?machs (filter #(upstream? pn m %) ?machs)))
         m-trans (some #(when (and (=   m (-> % :rep :m))
                                   (contains? #{:aj :sm} (-> % :rep :mjpact)))
                          (:name %))
                       (:transitions pn))
         [best _] (reduce (fn [[best bsize] [mcand path]]
                            (let [psize (count path)]
                              (if (and (> psize 0) (< psize bsize))
                                [mcand psize]
                                [best bsize])))
                          [nil 999999]
                          (zipmap candidates
                                  (map #(first-contact pn m-trans %)
                                       candidates)))]
     best)))
             
;;; POD This is a heuristic, at best. 
(defn buffers-between
  "Return all (only one?) buffers between the argument machines. "
  [pn m1 m2]
  (when (upstream? pn m1 m2)
    (get (iface-places pn) [m1 m2])))

;;; POD assembly scenarios (name*S*) NYT
;;; Find a place that is util/buffer-between and has an arc into a util/related-transition. 
(defn pulls-from
  "Return the place name(s) from which the argument machine pulls work."
  [pn m]
  (let [arcs (filter #(= (:type %) :normal) (:arcs pn))
        candidate-machines (remove #(= % m) (machines-of pn))
        bufs-between (zipmap
                      candidate-machines
                      (map #(buffers-between pn % m) candidate-machines))]
    ;; Given that there is a buffer between m and a candidate machine (cmach),
    ;; is there an (normal) arc from this buffer to related-trans
    (reduce (fn [winners cmach]
              (if-let [bufb (not-empty (cmach bufs-between))]
                (into winners (vec (reduce (fn [win buf]
                                             (if (some #(= buf (:target %)) arcs)
                                               (conj win buf)
                                               win))
                                           []
                                           bufb)))
                winners))
            []
            candidate-machines)))

(defn buffers-of
  "Return a list of all the things that look like buffers."
  [pn]
  (let [machines (machines-of pn)
        betweens (combo/combinations machines 2)]
    (dedupe ; <======================= distinct
     (flatten
      (filter identity (into (map (fn [[m1 m2]] (buffers-between pn m1 m2)) betweens)
                             (map (fn [[m1 m2]] (buffers-between pn m2 m1)) betweens)))))))

(defn bbs?
  "Returns true if machine m of pn is using block-before-service discipline."
  [pn m1]
  (when-let [m2 (next-machine pn m1)]
    (when-let [buffer (first (get (iface-places pn) [m1 m2]))]
      (let [m1-done (some #(when (= :bj (-> (pnu/name2obj pn %) :rep :mjpact)) %)
                          (get (related-trans pn) m1))]
        (and (some #(= :waiting (:purpose (pnu/name2obj pn %))) ; The machine has BBS or BAS. 
                   (get (related-places pn) m1))
             (some #(and (= (:source %) m1-done)
                         (= (:target %) buffer))
                   (:arcs pn)))))))

(defn bas?
  "Returns true if machine m of pn is using block-after-service discipline."
  [pn m1]
  (when-let [m2 (next-machine pn m1)]
    (when-let [buffer (first (get (iface-places pn) [m1 m2]))]
      (let [m1-start (some #(when (contains? #{:aj :sm} (-> (pnu/name2obj pn %) :rep :mjpact)) %)
                           (get (related-trans pn) m1))]
        (and (some #(= :waiting (:purpose (pnu/name2obj pn %))) ; The machine has BBS or BAS. 
                   (get (related-places pn) m1))
             (some #(and (= (:source %) m1-start)
                         (= (:target %) buffer))
                   (:arcs pn)))))))

(defn clean-pn
  "Remove stuff from the pn that can be easily calculated"
  [pn]
  (dissoc pn :trans-counts :matched :sigma :winners :distance-fn
          :k-limited? :pdf-fns :rgraph :msg :msg-table :loom-prob))
       


  

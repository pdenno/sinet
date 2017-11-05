(ns gov.nist.sinet.util
  "General sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint pp)]
            [clojure.spec.alpha :as s]
            [clojure.tools.namespace.repl :as nsp]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)] ; POD TEMPORARY!
            [clojure.core.async :as async :refer [chan alts!! go timeout >!]]))

(def ^:private diag (atom nil))

(defn app-info
  "The way into the app for reading."
  []
  ((resolve 'gov.nist.sinet.run/app-info)))

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
  (nsp/disable-reload! (find-ns 'gov.nist.sinet.untouched))
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
(s/def ::arc         (s/keys :req-un [::bind]))

(s/def ::places      (s/and ::pnu/places      (s/coll-of ::place)))
(s/def ::transitions (s/and ::pnu/transitions (s/coll-of ::transition)))
(s/def ::arcs        (s/and ::pnu/arcs        (s/coll-of ::arc)))
(s/def ::gppn (s/and ::pnu/pn
                     (s/keys :req-un [::places ::transitions ::arcs])))

(defn check-pn
  "clojure.spec check the pn."
  [pn]
  (s/assert ::gppn pn))

(defn machines-of
  "Return collection of the machines used in the PN."
  [pn]
  ;(s/assert ::gppn pn) ; POD needs investigation
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



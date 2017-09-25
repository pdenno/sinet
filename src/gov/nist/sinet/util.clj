(ns gov.nist.sinet.util
  "General sorts of things needed in several places in the sinet project."
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.tools.namespace.repl :as nsp]))

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
  ((resolve 'gov.nist.sinet.run/reset)))

;;; POD This isn't helping, but I'll leave it here and work on it next time I get stuck. 
(defn big-reset
  "Reset the system, getting out of a jam if possible."
  []
  (nsp/clear)
  #_(nsp/set-refresh-dirs)
  (nsp/refresh)
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
  (.write writer (cl-format nil "#Inv [err=~A]"
                            (if (number? (:disorder p)) ; POD temporary. Should be :err
                              (cl-format nil "~6,2F" (:disorder p))
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




 






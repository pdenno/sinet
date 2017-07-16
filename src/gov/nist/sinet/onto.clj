(ns gov.nist.sinet.onto
  "Management of turtle files"
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.walk :refer-only (prewalk prewalk-demo)]
            [clojure.zip :as zip]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp)]
            [tawny.owl :as owl]
            [tawny.query :as query]
            [tawny.read :as rowl]
            [tawny.lookup :as look]))

(owl/defontology sinet-onto
  :iri "http://modelmeth.nist.gov/sinet"
  :prefix "sinet:"
  :comment "An example ontology using my stuff"
  :versioninfo "Unreleased Version")

(defn read-onto-files []
  (rowl/read :iri "http://www.linkedmodel.org/schema/dtype"
             :namespace (create-ns 'onto.dtype)
             :location (clojure.java.io/file "resources/dtype.owl"))
  (rowl/read :iri "http://www.linkedmodel.org/schema/vaem"
             :namespace (create-ns 'onto.vaem)
             :location (clojure.java.io/file "resources/vaem.owl"))
  (rowl/read :iri "http://qudt.org/2.0/schema/qudt"
             :namespace (create-ns 'onto.qudt)
             :location (clojure.java.io/file "resources/SCHEMA_QUDT-v2.0.ttl"))
  (rowl/read :iri "http://modelmeth.nist.gov/modeling"
             :namespace (create-ns 'onto.model)
             :location (clojure.java.io/file "resources/modeling.ttl"))
  #_(rowl/read :iri "http://modelmeth.nist.gov/operations"
             :namespace (create-ns 'onto.ops)
             :location (clojure.java.io/file "resources/operations.ttl")))

(defn short-name [node]
  (->> node
       look/named-entity-as-string
       (re-matches #".*\#(.*)")
       second
       keyword))

(def onto-index "Define the parent/child relationship as a map."
  (reduce (fn [index node]
            (assoc index (short-name node)
                   (map short-name
                        (owl/direct-subclasses node))))
          {}
          (conj (owl/subclasses onto.model/Abstract)
                onto.model/Abstract)))

(def diag (atom nil))

(defn next-paths
  "Return all paths one-step further than the argument, if any."
  [path]
  (reset! diag {:path path})
  (if (empty? path)
    []
    (vec (map #(conj path %) (vec ((last path) onto-index))))))


;;(onto-root [[:Abstract]])
(defn onto-root
  "Define the ontology root structure for a zipper. It is a nested map."
  [p]
  (loop [accum {}
         paths p]
    (if (empty? paths)
      accum
      (recur
       (assoc-in accum (first paths) {})
       (conj (next-paths (first paths)) (vec (rest paths)))))))

;;; POD Might need more work. Switched to {} (in my mind). 
(def onto-zipper
  (zip/zipper
   (fn [obj] (and obj (not-empty (owl/direct-subclasses obj)))) ; branch? function
   (fn [obj] (owl/direct-subclasses obj)) ; children function
   (fn [node children] children)
   (onto-root [[:Abstract]])))


;;;\begin{description}
;;; \item[Challenge 1]: the lack of effective means to transform observed behaviors into
;;;  specifications written in a model formalism sufficent to drive analytical investigations of the
;;;  manufacturing system; and,
;;; \item[Challenge 2]: the lack of effective means to relate specifications such as these to analytical software addressing 
;;;   specific objectives (e.g. optimal production schedules).
;;;\end{description}

;;; POD Someday this will be created automatically (and then edited for content). 
#_(def index
   [:Abstract [:ModelAbstraction [:Equation []
                                  :Function []
                                  :ModelEntity []
                                  :Model [:PredictiveModel [:AnalyticalModel []
                                                            :NumericalModel [:FEAModel []]]]
                                  :ModelProperty []
                                  :ModelTechnology []
                                  :Symbol []]
               :Uncertainty [:AleatoryUncertainty []
                             :EpistemicUncertainty []
                             :ModelUncertainty []
                             :ParameterMeasurementUncertainty []
                             :PropertyMeasurementUncertainty []
                             :StatisticalUncertaintyOfModelParameters []]]])

#_(defn term-locs
  "Return a map of locations of each keyword."
  []
  (let [z-seq (->> index
                   zip/vector-zip
                   (iterate zip/next) ; a lazy seq of locs in pre-order.
                   (take-while #(not (zip/end? %)))) ; stop producing at end.
        key-locs (filter #(keyword? (zip/node %)) z-seq)]
    (zipmap (map zip/node key-locs) key-locs)))

#_(defn term-children
  "Return a map of the children of each keyword node."
  []
  (let [z-seq (->> index
                   zip/vector-zip
                   (iterate zip/next) ; a lazy seq of locs in pre-order.
                   (take-while #(not (zip/end? %)))) ; stop producing at end.
        key-locs (filter #(keyword? (zip/node %)) z-seq)]
    (zipmap (map zip/node key-locs)
            (map (fn [k-l]
                          (reset! diag k-l)
                          (vec (filter keyword?
                                      (-> k-l zip/right zip/node))))
                        key-locs))))

;;; POD NYI
#_(defn deeper
  "Return a vector removing toplevel atoms and merging toplevel lists."
  [terms]
  (as-> terms ?t
    (remove keyword? ?t)
    (vec (mapcat identity ?t))))

#_(defn index-depth
  "Return a natural number indicating how deep we are in the index."
  ([term] (index-depth term 0 index))
  ([term level terms]
   (cond (some #(= term %) terms) level
         (empty? terms) nil
         :else (index-depth term (inc level) (deeper terms)))))

;;; If the concept has children it is a (sub)*section.
;;; If it is a leaf it is a \begin{description}...\end{description}
  
            
            


             
            




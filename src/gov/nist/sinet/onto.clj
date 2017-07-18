(ns gov.nist.sinet.onto
  "Management of turtle files"
  {:author "Peter Denno"}
  (:require [clojure.pprint :refer (cl-format pprint)]
            [clojure.walk :refer-only (prewalk prewalk-demo)]
            [clojure.zip :as zip]
            [tawny.owl :as owl]
            [tawny.query :as query]
            [tawny.render]
            [tawny.read :as rowl]
            [tawny.lookup :as look])
  (:import
   (org.semanticweb.owlapi.model
    HasIRI
    OWLAxiom
    OWLEntity
    OWLObject
    OWLOntologyManager OWLOntology IRI
    OWLClassExpression OWLClass OWLAnnotation
    OWLIndividual OWLDatatype
    OWLObjectPropertyExpression
    OWLNamedObject OWLOntologyID)
   [org.semanticweb.owlapi.search EntitySearcher]))

(def diag (atom nil))

(def ontologies "A list of the ontologies used in this project"
  ["http://modelmeth.nist.gov/ontologies/pizza/pizza.owl"
   "http://www.linkedmodel.org/schema/dtype"
   "http://www.linkedmodel.org/schema/vaem"
   "http://qudt.org/2.0/schema/qudt"
   "http://modelmeth.nist.gov/modeling"
   "http://modelmeth.nist.gov/operations"])

(def manager (owl/owl-ontology-manager))

(defn clear-ontos
  "Remove all the ontologies"
  []
  (map #(owl/remove-ontology-maybe (OWLOntologyID. (owl/iri %))) ontologies))

(defn read-onto-files []
  (repeatedly 5 clear-ontos) ; Don't ask; I don't know.
  #_(rowl/read :iri "http://modelmeth.nist.gov/ontologies/pizza/pizza.owl"
             :namespace (create-ns 'pizza) ; POD for experimenting
             :location (clojure.java.io/file "resources/pizza.owl"))
  (rowl/read :iri "http://www.linkedmodel.org/schema/dtype"
             :namespace (create-ns 'onto) ; was onto.dtype
             :location (clojure.java.io/file "resources/dtype.owl"))
  (rowl/read :iri "http://www.linkedmodel.org/schema/vaem"
             :namespace (create-ns 'onto) ; was onto.vaem
             :location (clojure.java.io/file "resources/vaem.owl"))
  (rowl/read :iri "http://qudt.org/2.0/schema/qudt"
             :namespace (create-ns 'onto) ; was onto.qudt
             :location (clojure.java.io/file "resources/SCHEMA_QUDT-v2.0.ttl"))
  (rowl/read :iri "http://modelmeth.nist.gov/modeling"
             :namespace (create-ns 'onto.model)  ; was onto.model
             :location (clojure.java.io/file "resources/modeling.ttl"))
  #_(rowl/read :iri "http://modelmeth.nist.gov/operations"
             :namespace (create-ns 'onto.ops)
             :location (clojure.java.io/file "resources/operations.ttl")))

(read-onto-files)

(def onto-namespace "The name of the current ontology namespace"
  (atom 'onto.model))

(defn unscrew-tawny-annotations
  "Some are (:comment <pairs>). Some are (:annotation code-iri <pairs>)"
  [tawny-notes]
  (vec
   (map #(let [original %]
           (as-> original ?note
               (cond (= (first ?note) :comment) (second ?note),
                     (= (first ?note) :annotation ) (-> ?note rest rest first))
               (apply hash-map ?note)
               (assoc ?note :otype (first original))))
        tawny-notes)))

(defn thing-map
  "Return a map of information about the class. See also query/into-map-with"
  [thing]
  (reset! diag thing)
  (as-> (apply hash-map (tawny.render/as-form thing :keyword true)) ?map
    (assoc ?map :short-name (short-name thing)) ; POD (or label)
    (assoc ?map :var (get obj2var-map thing)) ; POD flatten is 'sort of' right.
    (assoc ?map :notes (unscrew-tawny-annotations (:annotation ?map)))))

;;; POD I expected this to be http://modelmeth.nist.gov/modeling#clojureCodeNote
(def ^:const code-iri "Used to identify clojure notes from thing-mapped objects."
  (list :iri "http://modelmeth.nist.gov/modeling#clojureCode"))

(defn clojure-code
  "Return any http://modelmeth.nist.gov/modeling#clojureCode annotation"
  [thing]
  (some #(when (and (= (:otype %) :annotation)
                    (= (:type %) code-iri))
           (:literal %))
        (-> thing thing-map :notes)))

(def tawny-types [:tawny.owl/class :tawny.owl/individual :tawny.owl/property
                  :tawny.owl/object-property :tawny.owl/data-property])

;;; POD needs to return true if a supertype is ignored. 
(defn ignore?
  "Returns true if the tawny thing has a clojure {:priority :ignore}"
  [thing]
  (if (some #(= (owl/guess-type (owl/get-current-ontology) thing) %) tawny-types)
    (when-let [code (clojure-code thing)]
      (= :ignore (:priority (read-string code))))
    true))

(def var2obj-map 
  (let [ks (remove #(ignore? (var-get %))
                   (vals (ns-interns @onto-namespace)))
        vs (map var-get ks)]
    (zipmap ks vs)))

(def obj2var-map
  (clojure.set/map-invert var2obj-map))

(defn short-name [node]
  (->> node
       look/named-entity-as-string
       (re-matches #".*\#(.*)")
       second))

(def onto-index "Define the parent/child relationship as a map."
  (let [m (reduce (fn [index node]
                    (assoc index (get obj2var-map node)
                           (map #(get obj2var-map %)
                                (owl/direct-subclasses node))))
                  {}
                  (conj (owl/subclasses onto.model/Abstract)
                        onto.model/Abstract))]
    (as-> m ?map
      (dissoc ?map nil)
      (reduce (fn [m k] (update m k #(vec (filter identity %))))
              ?map
              (keys ?map)))))

(defn next-paths
  "Return all paths one-step further than the argument, if any."
  [path]
  (if (empty? path)
    []
    (vec (map #(conj path %) (vec (get onto-index (last path)))))))

;;(onto-root-map {} [[#'onto.model/Abstract]])))
(defn onto-root-map
  "Define the ontology root structure as a nested map."
  [accum paths]
  (if (empty? paths)
    accum
    (recur
     (assoc-in accum (first paths) {})
     (let [nexts (next-paths (first paths))]
       (if (empty? nexts)
         (vec (next paths))
         (into nexts (vec (next paths))))))))

(defn vectify
  "Turn a nested map like that from onto-root-map into a nested vector
   where every var leaf is followed by a vector representing its subclasses 
   (could be empty)."
  [nested-map]
  (clojure.walk/prewalk
   #(if (var? %)
      %
      (vec (interleave (keys %) (vals %))))
   nested-map))

(def onto-root "Defines the vector thing suitable for zipping for LaTeX processing."
  (vectify (onto-root-map {} [[#'onto.model/Abstract]])))

#_(def onto-root
  [#'onto.model/Abstract
   [#'onto.model/UncertaintySource
    [#'onto.model/ModelPropertyMeasurementUncertainty []]
    #'onto.model/Modifier
    []]])

;;;============== Rendering ===============================================
(defn zip-depth
  "Return the depth of the location."
  [loc]
  (loop [loc loc
         depth 0]
    (if (not (zip/up loc))
      depth
      (recur (zip/up loc) (inc depth)))))

(defn latex-leaf-nodes
  "Return the onto vector structure with thing-maps replacing vars."
  [onto-vec]
  (loop [loc (-> onto-vec zip/vector-zip zip/down)]
    (as-> loc ?loc
      (if (var? (zip/node ?loc))
        (zip/edit ?loc #(-> (thing-map (var-get %))
                            (assoc :depth (dec (zip-depth ?loc))))) ; POD why dec?
        ?loc)
      (zip/next ?loc)
      (if (zip/end? ?loc)
        (zip/root ?loc)
        (recur ?loc)))))

(defn subsub [n]
  (apply str (repeat n "sub")))

(defn comment [tmap]
  (some #(when (= (:otype %) :comment) (:literal %))
        (:notes tmap)))

(def chilun (atom nil))

;;; POD NYI
(defn place-concepts-first
  "Sort concepts (thing-maps) before branches"
  [children]
  {:concepts (filter map? children)
   :sections (remove map? children)})

(defn write-concepts [tmap-list]
  (if (second tmap-list)
    (do (println "\\begin{description}")
        (map #(println (cl-format nil "   \\item[~A] ~A"
                                  (:short-name %) (comment %))))
        (println "\\end{description}"))
    (println (cl-format nil "\\\\  \\textbf{~A} ~A"
                        (:short-name (first tmap-list)
                                     (comment (first tmap-list)))))))

(defn write-section!
  "Write a \\section, \\subsection etc. Calls itself recursively on zip/children."
  [loc]
  (reset! diag loc)
  (cond (empty? loc) nil
        (map? loc) (write-concept loc)
        (var? loc) (println loc),
        (zip/end? loc) nil
        (zip/branch? loc)
        (let [tmap (-> loc zip/next zip/node)]
          (reset! diag {:loc loc :tmap tmap})
          (when (map? tmap)
            (println (cl-format nil "\\~Asection{~A}"
                                (subsub (:depth tmap))
                                (:short-name tmap))))
          ;; <================== HERE: USE THE MAP
          (when-let [chilun (reset! chilun (place-concepts-first (zip/children loc)))]
            (map #(write-section! (if (vector? %) (zip/vector-zip %) %))
                 chilun)))))
               

;;; <========== POD Right now it isn't picking up every subsection below abstract.
(defn latex-write-onto!
  "Write latex for the onto-root structure"
  [v]
  (-> v
      latex-leaf-nodes
      zip/vector-zip
      write-section!))


;;;\begin{description}
;;; \item[Challenge 1]: the lack of effective means to transform observed behaviors into
;;;  specifications written in a model formalism sufficent to drive analytical investigations of the
;;;  manufacturing system; and,
;;; \item[Challenge 2]: the lack of effective means to relate specifications such as these to analytical software addressing 
;;;   specific objectives (e.g. optimal production schedules).
;;;\end{description}

#_(defn ppp []
  (binding [clojure.pprint/*print-right-margin* 140]
    (pprint *1)))

#_(defn ppprint [arg]
  (binding [clojure.pprint/*print-right-margin* 140]
    (pprint arg)))

(ns gov.nist.sinet.report
  "Stuff for reporting to client (web or REPL)"
  {:author "Peter Denno"}
  (:require [clojure.tools.logging :as log] ; POD hardly used!
            [clojure.pprint :refer (cl-format pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! go-loop chan]]
            [gov.nist.spntools.core :as pn :refer :all]
            [gov.nist.spntools.util.utils :as pnu :refer (ppprint ppp pn-ok-> as-pn-ok->)]
            [gov.nist.sinet.util :as util :refer (app-info gp-param *debugging*)]
            [gov.nist.sinet.ws :as ws]))

;;; Sente (edn) can't send functions or records.
(defn clean-inv-for-transmit
  "Create a map of minimal PN and associated information"
  [inv]
  (-> {}
      (assoc :err (:err inv))
      (assoc :disorder (:disorder inv))
      (assoc :except  (:except inv))
      (assoc :places (-> inv :pn :places))
      (assoc :transitions (-> inv :pn :transitions))
      (assoc :arcs (-> inv :pn :arcs))
      (assoc :history (:history inv))))

;;; Respond to a request for an individual 
(ws/register-method
  :sinet/get-individual     
  (fn [{:as ev-msg :keys [?data ?reply-fn]}]
    (let [pop (-> (util/app-info) :pop)]
      (if (empty? pop)
        (log/info "No population in get-individual!")
        (let [pn-index  ?data]
          (println "get-individual:" pn-index)
          (when ?reply-fn
            (when (and (>= pn-index 0) (< pn-index (count pop)))
              (?reply-fn (-> (nth pop pn-index) clean-inv-for-transmit)))))))))

(def pause-evolve? "True if pausing evolution" (atom false))

(ws/register-method
 :sinet/evolve-run
 (fn [ev-msg]
   (>!! (util/evolve-chan) "init")
   (>!! (util/evolve-chan) "continue")))

 (ws/register-method
  :sinet/evolve-continue
  (fn [ev-msg]
    (>!! (util/evolve-chan) "continue")))

 (ws/register-method
  :sinet/evolve-pause
  (fn [ev-msg]
    (reset! pause-evolve? true)))

 (ws/register-method
  :sinet/evolve-abort
  (fn [ev-msg]
    (>!! (util/evolve-chan) "abort")))

(defn report-map [world]
  (let [pop (:pop world)
        best (first pop)]
    {:generation (:gen world)
     :best-error (:err best)
     :median-error (:err (nth pop (int (/ (gp-param :pop-size) 2))))
     :average-pn-size (pnu/avg (map #(-> % :pn pnu/pn-size) pop))
     :state (:state world)
     :pop-size (count pop)
     :total-mutations (reduce + 0 (map #(count (:history %)) pop))
     :elapsed-time (int (/ (- (System/currentTimeMillis) (:start-time world)) 1000))}))

(defn push-report
  "Push report of new generation to the client."
  [world]
  (let [report (report-map world)
        connect (-> (util/app-info) :ws-connection)
        uids (:connected-uids connect)]
    (if-let [uid (-> @uids :any first)]
      (ws/send! connect uid [:sinet/generation-report report])
      (println "No client on push-report."))))

(defn push-inv
  "Push an individual to the client for viewing"
  [inv]
  (let [connect (-> (util/app-info) :ws-connection)
        uids (:connected-uids connect)]
    (if-let [uid (-> @uids :any first)]
      (ws/send! connect uid [:sinet/diag-push-pn (-> inv clean-inv-for-transmit)])
      (println "No client on push-inv."))))

(defn client?
  "Returns true if there is a web client."
  []
  (-> (util/app-info) :ws-connection :connected-uids deref :any first))

(defn log-report
  [world]
  (-> world report-map util/log))

(defn report-gen
  "Either log results or send them to a client. Doesn't touch world."
  [world]
  (if (client?)
    (push-report world)
    (log-report world))
  world)

(defn pop-stats 
  "Report population statistics"
  [world]
  (let [pop (-> (app-info) :pop)]
    (println "\nGeneration:" (:gen world))
    (when (-> (app-info) :pop first :err)
      (println "Best Error:"      (cl-format nil "~5,3F" (->> pop first :err)))
      (println "Avg Error:"       (cl-format nil "~5,3F" (->> pop (map :err) util/mean))))
    (println "Avg Arc count:"
             (cl-format nil "~5,3F"
                        (->> pop (map #(->> % :pn :arcs (filter (fn [a] (= (:type a) :normal))) count)) util/mean)))
    (println "Avg Inhib count:"
             (cl-format nil "~5,3F"
                        (->> pop (map #(->> % :pn :arcs (filter (fn [a] (= (:type a) :inhibitor))) count)) util/mean)))
    (println "Avg Trans count:" (cl-format nil "~5,3F" (->> pop (map #(-> % :pn :transitions count)) util/mean)))
    (println "Avg Place count:" (cl-format nil "~5,3F" (->> pop (map #(-> % :pn :places count)) util/mean)))
    (when (-> (app-info) :pop first :err)
      (println "SD Error:"        (cl-format nil "~5,3F" (->> pop (map :err) util/variance Math/sqrt))))
    (println "SD Arc count:"    (cl-format nil "~5,3F" (->> pop (map #(-> % :pn :arcs count)) util/variance Math/sqrt)))
    (println "SD Trans count:"  (cl-format nil "~5,3F" (->> pop (map #(-> % :pn :transitions count)) util/variance Math/sqrt)))
    (println "SD Place count:"  (cl-format nil "~5,3F" (->> pop (map #(-> % :pn :places count)) util/variance Math/sqrt)))))


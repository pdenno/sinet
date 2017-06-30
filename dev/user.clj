(ns gov.nist.sinet.user
  (:require
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer [javadoc]]
   [clojure.pprint :refer [pprint]]
   [clojure.reflect :refer [reflect]]
   [clojure.repl :refer [apropos dir doc find-doc pst source]]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.test :as test]
   [com.stuartsierra.component :as component]
   [clojure.tools.namespace.repl :refer [refresh refresh-all]]
   [gov.nist.sinet.config :as config]
   [gov.nist.sinet.system :as system]))

(def system nil)

(defn init []
  (alter-var-root #'system (fn [huh?] (system/system (config/get-config))))) ; POD added huh?

(defn start []
  (alter-var-root #'system component/start))

(defn stop []
  (alter-var-root #'system
    (fn [s] (when s (component/stop s)))))

(defn run []
  (init)
  (start))

(defn reset []
  (stop)
  (refresh :after 'user/run))

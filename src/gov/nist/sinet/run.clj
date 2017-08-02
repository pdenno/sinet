(ns gov.nist.sinet.run
  (:gen-class)
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [gov.nist.sinet.config :as config]
            [gov.nist.sinet.system :as system]
            [gov.nist.sinet.gp :as gp :refer-only (start-evolve-loop!)]))

(defonce system nil)

;;; These are used in development AND production.
(defn init []
  (alter-var-root #'system (fn [_] (system/system (config/get-config))))) 

(defn start []
  (alter-var-root #'system component/start))

(defn stop []
  (alter-var-root #'system
    (fn [s] (when s (component/stop s)))))

(defn run []
  (init)
  (start)
  ;(Thread/sleep 2000)
  (gp/start-evolve-loop!)
  system)

(defn reset []
  (stop)
  ;; Reload changed files in dependency order, then do run/run. 
  (refresh :after 'gov.nist.sinet.run/run)) 

;;; POD This is essential to getting past component!
(defn app-info []
  (:app system))

;;; This is for production executable. 
(defn -main [& args]
  (let [config (config/get-config)]
    (run)
    (log/info "Sinet started")
    system))

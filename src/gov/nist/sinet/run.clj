(ns gov.nist.sinet.run
  (:gen-class)
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.config :as config]
            [gov.nist.sinet.system :refer [system]]))

(defn -main [& args]
  (let [config (config/get-config)]
    (component/start (system config))
    (log/info "Sinet started")))

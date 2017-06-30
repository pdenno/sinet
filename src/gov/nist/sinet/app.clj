(ns gov.nist.sinet.app
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [gov.nist.sinet.ws :as ws]))

(defrecord App [ws-connection]
  component/Lifecycle
  (start [component]
    (log/debug "GP Application logic started")
    component)
  (stop [component]
    (log/debug "GP Application logic stopped")
    component))

(defn new-app []
  (map->App {})) ; POD +gp-params+ plus +problem+ goes here!

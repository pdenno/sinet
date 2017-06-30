(ns gov.nist.sinet.system
  (:require [com.stuartsierra.component :as component]
            [gov.nist.sinet.ws :as ws]
            [gov.nist.sinet.server :as server]
            [gov.nist.sinet.app :as app]))

(defn system [config]
  (component/system-map
   :ws-connection (ws/new-ws-connection)
   :http-server (component/using (server/new-http-server (:port config)) [:ws-connection])
   :app (component/using (app/new-app) [:ws-connection]))) ; POD GP goes here!

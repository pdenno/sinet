(ns gov.nist.sinet.system
  (:require [com.stuartsierra.component :as component]
            [gov.nist.sinet.ws :as ws]
            [gov.nist.sinet.server :as server]
            [gov.nist.sinet.app :as app]))

(defn system [config]
  (let [ws-connection (ws/new-ws-connection)]
    (component/system-map
     :ws-connection ws-connection
     :http-server (component/using (server/new-http-server (:port config) ws-connection) [:ws-connection])
     :app (component/using (app/new-app ws-connection) [:ws-connection]))))

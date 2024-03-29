(ns gov.nist.sinet.server
  (:require [clojure.tools.logging :as log]
            [com.stuartsierra.component :as component]
            [compojure.core :refer [routes GET POST]]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.resource :refer (wrap-resource)]
            [org.httpkit.server :refer (run-server)]
            [gov.nist.sinet.util :as util]
            [gov.nist.sinet.ws :as ws]))

(def ^:private diag (atom nil))

(defn handler [ajax-post-fn ajax-get-or-ws-handshake-fn]
  (routes
   (GET  "/"     _   (clojure.java.io/resource "index.html"))
   (GET  "/chsk" req (ajax-get-or-ws-handshake-fn req))
   (POST "/chsk" req (ajax-post-fn req))
   (route/not-found "<h1>Page not found</h1>")))

(defn app [handler]
  (let [ring-defaults-config
        (-> site-defaults
            (assoc-in
             [:security :anti-forgery]
             {:read-token (fn [req] (-> req :params :csrf-token))})
            (assoc-in [:static :resources] "public"))]
    (-> handler
        (wrap-defaults ring-defaults-config)
        (wrap-resource "/META-INF/resources"))))

(defrecord HttpServer [port ws-connection server-stop]
  component/Lifecycle
  (start [component]
    (if server-stop
      component
      (let [component (component/stop component)
            {:keys [ajax-post-fn ajax-get-or-ws-handshake-fn]}
            (ws/ring-handlers ws-connection)
            handler (handler ajax-post-fn ajax-get-or-ws-handshake-fn)
            server-stop (run-server (app handler) {:port port})]
        (reset! util/save-http-server (:server (meta server-stop)))
        (log/debug "HTTP server started")
        (assoc component :server-stop server-stop))))
  (stop [component]
    (if server-stop
      (server-stop)
      (log/debug "Not HTTP server on component stop!"))
    ((:stop-fn ws-connection)) ; Added in an attempt to get big-reset working. No help?
    (log/debug "HTTP server stopped")
    (assoc component :server-stop nil)))

;;; This is used in system.clj:
(defn new-http-server [port ws-connection]
  (if ws-connection
    (let [{:keys [ajax-post-fn ajax-get-or-ws-handshake-fn]}
          (ws/ring-handlers ws-connection)
          handler (handler ajax-post-fn ajax-get-or-ws-handshake-fn)
          server-stop (run-server (app handler) {:port port})]
      (reset! util/save-http-server (:server (meta server-stop)))
      (log/debug "HTTP server started")
      (map->HttpServer {:port port
                        :server-stop server-stop}))
    (log/debug "No ws-connection on new-http-server!")))

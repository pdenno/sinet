(ns gov.nist.sinet.config
  (:require [environ.core :refer [env]]))

(defn get-config []
  {:port (Integer/parseInt (or (env :port) "8080"))})

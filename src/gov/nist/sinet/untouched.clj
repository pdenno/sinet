(ns gov.nist.sinet.untouched
  "Stuff that would be in gov.nist.sinet.app, but should not be reloaded with util/big-reset."
  (:require [clojure.tools.logging :as log]
            [clojure.pprint :refer (pprint)]
            [clojure.core.async :as async :refer [>! <! >!! <!! chan]]
            [gov.nist.sinet.gp :as gp]))

(defonce old-channels (atom []))

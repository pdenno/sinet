(ns gov.nist.sinet.untouched
  "Stuff that would be in gov.nist.sinet.app, but should not be reloaded with util/big-reset.")

(defonce old-channels (atom []))

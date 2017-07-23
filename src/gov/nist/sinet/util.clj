(ns gov.nist.sinet.util
  "General sorts of things needed in several places in the sinet project.")

(defn app-info []
  ((resolve 'gov.nist.sinet.run/app-info)))



(ns gov.nist.sinet.start
  (:require [figwheel.client :as fw]
            [gov.nist.sinet.client.app :as app]))

(enable-console-print!)

(fw/watch-and-reload
 :websocket-url "ws://localhost:3449/figwheel-ws"
 :jsload-callback #(swap! app/state update-in [:re-render-flip] not))

(app/main)

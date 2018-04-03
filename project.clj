(defproject gov.nist/sinet "0.1.0-SNAPSHOT"
  :description "System identification of discrete events dynamic systems through genetic programming"
  :url "http://nist.gov"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*assert* true}
  :jvm-opts ["-Xmx900m"] ; So far starting at 288m. 
  :dependencies [[org.clojure/clojure            "1.9.0"]
                 [org.clojure/clojurescript      "1.9.946"]
                 [org.clojure/tools.trace        "0.7.9"]
                 [org.clojure/core.async         "0.4.474" :exclusions [org.clojure/data.priority-map]]
                 [com.cemerick/piggieback        "0.2.2"]
                 [com.stuartsierra/component     "0.3.2"]
                 ;[net.mikera/vectorz-clj        "0.47.0"] ; causal only
                 ;[net.mikera/core.matrix        "0.61.0"] ; causal only
                 [environ                        "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"] 
                 [org.clojure/tools.logging      "0.4.0"]
                 [net.cgrand/xforms              "0.16.0"]
                 
                 [ring                           "1.6.3" #_:exclusions #_[org.clojure/tools.namespace org.clojure/data.priority-map]]
                 [ring/ring-defaults             "0.3.1"]
                 [compojure                      "1.6.0"]
                 [http-kit                       "2.2.0"]

                 [com.taoensso/sente             "1.11.0-POD" :exclusions [org.clojure/data.priority-map]]

                 [reagent                        "0.7.0"]
                 [reagent-forms                  "0.5.35"]
                 [re-frame                       "0.10.4"] 
                 [re-frisk                       "0.5.3" :exclusions [org.clojure/data.priority-map]] 
                 [org.webjars/bootstrap          "3.3.7"] ; 4 beta breaks things, no webjar for 4.0
                 [quil                           "2.6.0"]

                 [datawalk                       "0.1.12"]

                 [aysylu/loom                    "1.0.0"]
                 [pdenno/utils4pmap              "0.1.0" :exclusions [org.clojure/data.priority-map]]
                 [pdenno/pn-draw                 "0.1.0-SNAPSHOT"]
                 [pdenno/gspn                    "0.1.0-SNAPSHOT"]
                 [gov.nist/MJPdes                "0.3.0"]
                 [gov.nist/spntools              "0.1.0"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src"]
  :resource-paths ["resources" "resources-index/prod"]
  :target-path "target/%s"

  :main ^:skip-aot gov.nist.sinet.run 
  ;; There is a user.clj in dev/. By design of clojure, it gets loaded if it on the path...
  ;; https://github.com/bhauman/figwheel-template/blob/master/src/leiningen/new/figwheel/project.clj
  :cljsbuild {:builds 
              [{:id "dev"
                :source-paths ["src"] ; <==================== Try "src/client" here???
                ;; The presence of a :figwheel configuration here
                ;; will cause figwheel to inject the figwheel client
                ;; into your build
                :figwheel {:on-jsload "gov.nist/sinet.core/on-js-reload"
                           ;; :open-urls will pop open your application
                           ;; in the default browser once Figwheel has
                           ;; started and compiled your application.
                           ;; Comment this out once it no longer serves you.
                           :open-urls ["http://localhost:3449/index.html"]}
                
                :compiler {:main gov.nist/sinet.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/sinet.js" ; sanitized. 
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                           ;; https://github.com/binaryage/cljs-devtools
                           :preloads [devtools.preload]}}
               
               :css-dirs ["resources/public/css"]
               
               
               :client {:source-paths ["src/gov/nist/sinet/client" "dev"]
                        :compiler {:optimizations :none ; https://clojurescript.org/reference/compiler-options
                                   :output-to "resources/public/js/app.js"   ; The path to the .js file that will be output
                                   :output-dir "dev-resources/public/js/out" ; Temporary files used during compilation
                                   :source-map true}}]}
  :figwheel {:css-dirs ["resources/public/css"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.9"]
                                  [figwheel-sidecar "0.5.15"]
                                  [com.cemerick/piggieback "0.2.2"]]
                   ;; need to add dev source path here to get user.clj loaded
                   :source-paths ["src" "dev"]
                   ;; for CIDER
                   :plugins [[cider/cider-nrepl "0.17.0-snapshot"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   ;; need to add the compliled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}}
  :aliases  {"start-repl" ["do" "clean," "cljsbuild" "once," "repl" ":headless"]
             "start"      ["do" "clean," "cljsbuild" "once," "run"]
             "package"    ["with-profile" "prod" "do" "clean" ["cljsbuild" "once"]]})

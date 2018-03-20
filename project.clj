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
                 
                 [ring                           "1.6.3" :exclusions [org.clojure/tools.namespace org.clojure/data.priority-map]]
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
  :profiles {:dev {:cljsbuild ; https://github.com/emezeske/lein-cljsbuild
                   {:builds 
                    {:client {:source-paths ["src/gov/nist/sinet/client" "dev"]
                              :compiler {:optimizations :none ; https://clojurescript.org/reference/compiler-options
                                         :output-to "resources/public/js/app.js"   ; The path to the .js file that will be output
                                         :output-dir "dev-resources/public/js/out" ; Temporary files used during compilation
                                         :source-map true}}}}
                   :figwheel {:http-server-root "public"
                              :server-port 3449
                              :repl false
                              :css-dirs ["resources/public/css"]}
                   :dependencies [[org.clojure/tools.namespace "0.2.10" :exclusions [org.clojure/data.priority-map]]
                                  [com.cemerick/piggieback     "0.2.2"] 
                                  [figwheel                    "0.5.14" :exclusions [org.clojure/data.priority-map]]
                                  [figwheel-sidecar            "0.5.14" :exclusions [org.clojure/data.priority-map]]]
                   :source-paths   ["dev"]
                   :resource-paths ^:replace ["resources" "dev-resources" "resources-index/dev"]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   :plugins [[lein-figwheel  "0.5.14"]
                             [lein-cljsbuild "1.1.7" ]
                             [lein-environ   "1.0.1" ]]}
             :prod {:cljsbuild
                    {:builds 
                     {:client {:compiler {:optimizations :advanced :elide-asserts true :pretty-print false}}}}}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}}
  :aliases  {"start-repl" ["do" "clean," "cljsbuild" "once," "repl" ":headless"]
             "test-all"   ["with-profile" "default:+1.8:+1.9" "test"]
             "start"      ["do" "clean," "cljsbuild" "once," "run"]
             "package"    ["with-profile" "prod" "do" "clean" ["cljsbuild" "once"]]})

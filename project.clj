(defproject gov.nist/sinet "0.1.0-SNAPSHOT"
  :description "System identification of discrete events dynamic systems through genetic programming"
  :url "http://nist.gov"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*assert* true}
  :dependencies [[org.clojure/clojure            "1.9.0-beta2"]
                 [org.clojure/clojurescript      "1.9.946"]
                 [org.clojure/tools.trace        "0.7.9"]
                 [org.clojure/core.async         "0.3.443"]
                 [com.cemerick/piggieback        "0.2.2"]
                 [com.stuartsierra/component     "0.3.2"]
                 [environ                        "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"] 
                 [org.clojure/tools.logging      "0.4.0"]
                 

                 [ring                       "1.6.2" :exclusions [org.clojure/tools.namespace]]
                 [ring/ring-defaults         "0.3.1"]
                 [compojure                  "1.6.0"]
                 [http-kit                   "2.2.0"]

                 [com.taoensso/sente         "1.11.0-POD"] ; POD

                 [reagent                    "0.7.0"]
                 [reagent-forms              "0.5.31"]
                 [re-frame                   "0.10.2"] 
                 [re-frisk                   "0.5.0"] 
                 [org.webjars/bootstrap      "3.3.7"] ; "4.0.0-alpha" had problems with menu
                 [quil                       "2.6.0"]

                 [datawalk                  "0.1.10"]

                 [aysylu/loom                "1.0.0"]
                 [pdenno/utils4pmap          "0.1.0"]
                 [gov.nist/spntools          "0.1.0-SNAPSHOT" :exclusions [org.clojure/clojure]]]

  :plugins [[lein-figwheel "0.5.14"]
            [lein-cljsbuild "1.1.4"]]
  :hooks [leiningen.cljsbuild]
  
  :source-paths ["src"]
  :resource-paths ["resources" "resources-index/prod"]
  :target-path "target/%s"

  :main ^:skip-aot gov.nist.sinet.run ; POD tried .user with cljs-repl (NG?)

  :cljsbuild
  {:builds
   {:client {:source-paths ["src/gov/nist/sinet/client"]
             :figwheel true
             :compiler
             {:output-to "resources/public/js/app.js"
              :output-dir "dev-resources/public/js/out"}}}}
  
  :profiles {:dev-config {}
             ;; There is a user.clj in dev/. By design of clojure, it gets loaded if it on the path...
             :dev [:dev-config ; This pattern of use from rente. 
                   {:dependencies [[org.clojure/tools.namespace "0.2.10"]
                                   [com.cemerick/piggieback "0.2.2"] 
                                   [figwheel "0.5.14"]
                                   [figwheel-sidecar "0.5.14"]]
                    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                    :plugins [[lein-figwheel "0.5.14"]
                              [lein-environ "1.0.1"]]
                              
                    :source-paths ["dev"] ;...now it is on the path. 
                    :resource-paths ^:replace
                    ["resources" "dev-resources" "resources-index/dev"]

                    :cljsbuild
                    {:builds
                     {:client {:source-paths ["dev"]
                               :compiler
                               {:optimizations :none
                                :source-map true}}}}

                    :figwheel {:http-server-root "public"
                               :server-port 3449
                               :repl false
                               :css-dirs ["resources/public/css"]}}]

             :prod {:cljsbuild
                    {:builds 
                     {:client {:compiler {:optimizations :advanced
                                          :elide-asserts true
                                          :pretty-print false}}}}}}
  :aliases  {"start-repl" ["do" "clean," "cljsbuild" "once," "repl" ":headless"]
             "start"      ["do" "clean," "cljsbuild" "once," "run"]
             "package"    ["with-profile" "prod" "do" "clean" ["cljsbuild" "once"]]})

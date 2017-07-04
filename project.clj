(defproject gov.nist/sinet "0.1.0-SNAPSHOT"
  :description "System identification of discrete events dynamic systems through genetic programming"
  :url "http://nist.gov"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*assert* true}
  :dependencies [[org.clojure/clojure        "1.8.0"]
                 [org.clojure/tools.reader   "1.0.0"] ; this one can probably go. 
                 [org.clojure/clojurescript  "1.9.660"]
                 [medley                     "1.0.0"]
                 [org.clojure/core.async     "0.3.443"]
                 [com.cemerick/piggieback    "0.2.2"] ; sente exlusions https://github.com/ptaoussanis/sente/issues/277
                 [com.stuartsierra/component "0.3.2"]
                 [environ "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"] ; this one might go.
                 [org.clojure/tools.logging      "0.4.0"]      ; likewise this one. 
                 [com.taoensso/sente             "1.11.0" :exclusions [com.taoensso/encore]]

                 [com.taoensso/timbre        "4.10.0" :exclusions [com.taoensso/encore]]
                 [com.taoensso/encore        "2.91.1"] ; 2.91.1 is modern but 2.87.0 for issue 277 -- NG
                 
                 [ring                       "1.6.1" :exclusions [org.clojure/tools.namespace]]
                 [ring/ring-defaults         "0.3.0"]
                 [hiccup                     "1.0.5"] ; This goes away when reagent has proven itself. 
                 [compojure                  "1.6.0"]
                 [http-kit                   "2.2.0"]

                 [gov.nist/spntools          "0.1.0-SNAPSHOT" :exclusions [org.clojure/clojure]]
                 [quil                       "2.6.0"]
                 [reagent                    "0.7.0"]
                 [org.webjars/bootstrap      "3.3.7"]
                 #_[org.webjars/bootstrap "4.0.0-alpha"]]

  :plugins [[lein-figwheel "0.5.10"]
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

             :dev [:dev-config
                   {:dependencies [[org.clojure/tools.namespace "0.2.10"]
                                   [com.cemerick/piggieback "0.2.2"] ; doesn't belong inside client nor figwheel
                                   [figwheel "0.5.10"]
                                   [figwheel-sidecar "0.5.10"]]
                    :plugins [[lein-figwheel "0.5.10"]
                              [lein-environ "1.0.1"]]
                              
                    :source-paths ["dev"]
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
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  ;:figwheel {:nrepl-port 8877 :css-dirs ["css"]} 
  ;:main gov.nist.sinet.util.server ; POD was util.server ???
  ;; Call `lein start-repl` to get a (headless) development repl that you can
  ;; connect to with Cider+emacs or your IDE of choice:
  :aliases  {"start-repl" ["do" "clean," "cljsbuild" "once," "repl" ":headless"]
             "start"      ["do" "clean," "cljsbuild" "once," "run"]
             "package"    ["with-profile" "prod" "do" "clean" ["cljsbuild" "once"]]})







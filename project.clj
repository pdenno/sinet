(defproject gov.nist/sinet "0.1.0-SNAPSHOT"
  :description "System identification of discrete events dynamic systems through genetic programming"
  :url "http://nist.gov"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*assert* true}
  :dependencies [[org.clojure/clojure       "1.8.0"]
                 [org.clojure/clojurescript "1.9.562"]
                 [org.clojure/core.async    "0.3.443"]
                 [com.taoensso/sente        "1.11.0"]
                 [http-kit                  "2.2.0"]
                 [ring                      "1.6.1"]
                 [ring/ring-defaults        "0.3.0"]
                 [hiccup                    "1.0.5"]
                 ;; Might not keep the following four:
                 [compojure                 "1.6.0"]  ; Or routing lib of your choice
                 [com.taoensso/encore       "2.91.1"]
                 [org.clojure/tools.reader  "1.0.0"]
                 [com.taoensso/timbre       "4.10.0"]
                 
                 [medley                    "1.0.0"]
                 [gov.nist/spntools         "0.1.0-SNAPSHOT"]
                 [quil                      "2.6.0"]]
  :plugins [#_[lein-figwheel "0.5.10"]
            [lein-cljsbuild      "1.1.4"]]
  :profiles {:dev { :dependencies [[figwheel-sidecar "0.5.4-6"]] ; POD added :profiles for figwheel-sidecar
                   :source-paths ["src"]}}
  :cljsbuild {:builds
              [{:id :cljs-client
                :figwheel true
                :source-paths ["src"]
                :compiler {:output-to "target/main.js" ; POD This won't run with :optimization :none !!!
                           :optimizations :whitespace #_:advanced ; POD commented out :whitespace, added :none for figwheel
                           :pretty-print true}}]}
               #_{:id "dev-ignore"
                :source-paths ["src"]
                :figwheel true
                :compiler {:output-to "js/main.js"
                           :output-dir "out"
                           :main "gov.nist.sinet.util.draw"
                           :optimizations :none
                           :pretty-print true}}
;  :figwheel { :css-dirs ["css"]}
  :main gov.nist.sinet.util.server
  ;; Call `lein start-repl` to get a (headless) development repl that you can
  ;; connect to with Cider+emacs or your IDE of choice:
  :aliases  {"start-repl" ["do" "clean," "cljsbuild" "once," "repl" ":headless"]
             "start"      ["do" "clean," "cljsbuild" "once," "run"]})







(defproject testbug "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.3.4"]
                 [ring/ring-defaults "0.1.2"]
                 [org.clojure/clojurescript "1.7.48"]
                 [org.omcljs/om "0.9.0"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.1.0"]]
  :ring {:handler testbug.handler/app}
  :source-paths ["src/clj" "src/cljs"]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :cljsbuild {:builds [{:source-paths ["src/clj"
                                       "src/cljs"]
                        :compiler {:pretty-print true
                                   :optimizations :whitespace
                                   :output-to "resources/public/app.js"}}

                       {:id "production-test"
                        :source-paths ["src/clj"
                                       "src/cljs"]
                        :compiler {:pretty-print true
                                   :optimizations :advanced
                                   :pseudo-names true
                                   :output-to "resources/public/app.test.js"}}
                       ]}
)

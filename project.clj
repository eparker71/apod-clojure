(defproject apod-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [enlive "1.1.6"]
                 [org.imsglobal/basiclti-util "1.1.2"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler apod-clojure.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})

;(ns apod-clojure.handler
;  (:use compojure.core)
;  (:require [compojure.core :refer :all]
;            [clojure.string :as str]
;            [compojure.route :as route]
;            [net.cgrand.enlive-html :as html]
;            [ring.middleware.defaults :refer [wrap-defaults site-defaults]
;            [apod-clojure.controllers.views :as views-controller]]))
;

(ns apod-clojure.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [clojure.string :as str]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]
            [ring.util.response :as resp]
            [apod-clojure.controllers.views :as views-controller]))

(defroutes app-routes
  (GET "/" [] (views-controller/index))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
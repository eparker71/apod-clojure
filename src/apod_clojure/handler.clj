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
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

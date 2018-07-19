(ns apod-clojure.controllers.views
  (:require
    [clostache.parser :as clostache]
    [clojure.string :as str]
    [net.cgrand.enlive-html :as html]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
    (str "public/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(def apod-base-url "https://apod.nasa.gov/")

(def apod-img-page "https://apod.nasa.gov/apod/astropix.html")

(defn build-full-url
  [base-url img-path]
  (str/join [base-url img-path]))

(defn get-apod-image-from-page
  [url]
  (:src (:attrs (first (html/select (html/html-resource (java.net.URL. url)) [:img])))))

(def apod-image-string (get-apod-image-from-page apod-img-page))

(def apod-img-full (str/join [apod-base-url apod-image-string]))

(defn index [] 
  (render-template "index" {:url apod-img-full}))
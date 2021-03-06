(ns apod-clojure.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [apod-clojure.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.startsWith (:body response) "<html>\n"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

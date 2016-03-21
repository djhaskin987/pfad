(ns pfad.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.typed :as t]
            [pfad.core :refer :all]))

(deftest types
         (testing "Types check out"
                  (is (t/check-ns 'pfad.core))))

(deftest minfree-test
         (testing "Smallest number"
                  (is (= (minfree
                           '(8 23 9 0 12 11 1 10 13 7 41 4 14 21 5 17 3 19 2 6)) 15))
                  (is (= (minfree
                           '(0 1 3)) 2)))
         (testing "Edge cases"
                  (is (= (minfree
                         '(0 1 2)) 3))

                  (is (= (minfree
                           '()) 0))))


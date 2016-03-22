(ns pfad.surpasser-test
  (:require [clojure.test :refer :all]
            [pfad.surpasser :refer :all]))

(deftest ^:surpasser surpasser-test
         (testing "GENERATING"
                  (is (= (msc "GENERATING") 6))))

(ns pfad.minfree-test
  (:require [clojure.test :refer :all]
            [pfad.minfree :refer :all]))

(deftest ^:minfree minfree-test
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

(deftest ^:minfree minfree-multi-test
         (testing "Smallest number"
                  (is (= (minfree-multi
                           '(8 23 9 0 12 11 1 10 13 7 41 4 14 21 5 17 3 19 2 6)) 15))
                  (is (= (minfree-multi
                           '(0 1 3)) 2)))
         (testing "Edge cases"
                  (is (= (minfree-multi
                         '(0 1 2)) 3))

                  (is (= (minfree-multi
                           '()) 0)))
         (testing "Non-unique"
                  (is (= (minfree-multi '(0 1 2 3 4))
                         (minfree-multi '(0 1 2 3 4 1))))))

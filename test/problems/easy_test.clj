(ns problems.easy-test
  (:require [clojure.test :as t]
            [problems.easy :as p]))

(t/deftest two-sum
  (t/testing "example 1"
    (t/is (= [0 1] (p/two-sum [2 7 11 15] 9))))
  (t/testing "example 2"
    (t/is (= [1 2] (p/two-sum [3 2 4] 6))))
  (t/testing "example 3"
    (t/is (= [0 1] (p/two-sum [3 3] 6)))))

(t/deftest majority-element
  (t/testing "majority element is 2"
    (t/is (= 2 (p/majority-element [2 2 2 2 3 3 4]))))
  (t/testing "majority element is 9"
    (t/is (= 9 (p/majority-element [1 9 2 9 3 9 4 9])))))

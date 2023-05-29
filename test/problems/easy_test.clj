(ns problems.easy-test
  (:require [clojure.test :as t]
            [problems.easy :as p]))

(t/deftest best-time-to-buy-and-sell-stock
  (t/testing "[7 1 5 3 6 4]=>5"
    (t/is (= 5 (p/best-time-buy-sell-stock [7 1 5 3 6 4]))))
  (t/testing "[4 3 2 1]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock [4 3 2 1]))))
  (t/testing "[]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock []))))
  (t/testing "[1 2 3 4]=>3"
    (t/is (= 3 (p/best-time-buy-sell-stock [1 2 3 4]))))
  (t/testing "[1 1 1 1]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock [1 1 1 1])))))

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

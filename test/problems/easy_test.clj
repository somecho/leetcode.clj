(ns problems.easy-test
  (:require [clojure.test :as t]
            [problems.easy :as pe]))

(t/deftest majorityElement
  (t/testing "majority element is 2"
    (t/is (= 2 (pe/majorityElement [2 2 2 2 3 3 4]))))
  (t/testing "majority element is 9"
    (t/is (= 9 (pe/majorityElement [1 9 2 9 3 9 4 9])))))

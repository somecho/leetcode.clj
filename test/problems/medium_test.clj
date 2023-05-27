(ns problems.medium-test
  (:require [clojure.test :as t]
            [problems.medium :as p]))

(t/deftest house-robber
  (t/testing "[1 2 3 1]=>4"
    (t/is (= 4 (p/rob [1 2 3 1]))))
  (t/testing "[2 7 9 3 1]=>12"
    (t/is (= 12 (p/rob [2 7 9 3 1]))))
  (t/testing "[2 1 1 2]=>4"
    (t/is (= 4 (p/rob [2 1 1 2]))))
  (t/testing "[ ]=>nil"
    (t/is (= nil (p/rob []))))
  (t/testing "[69]=>69"
    (t/is (= 69 (p/rob [69])))))

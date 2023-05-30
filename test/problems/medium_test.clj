(ns problems.medium-test
  (:require [clojure.test :as t]
            [problems.medium :as p]))

(t/deftest best-time-to-buy-and-sell-stock-ii

  (t/testing "[7 1 5 3 6 4]=>7"
    (t/is (= 7 (p/best-time-buy-sell-stock-ii [7 1 5 3 6 4]))))

  (t/testing "[1 2 3 4 5]=>4"
    (t/is (= 4 (p/best-time-buy-sell-stock-ii [1 2 3 4 5]))))

  (t/testing "[]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock-ii []))))

  (t/testing "[1]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock-ii [1]))))

  (t/testing "[5 4 3 2 1]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock-ii [5 4 3 2 1]))))

  (t/testing "[1 1 1 1 1]=>0"
    (t/is (= 0 (p/best-time-buy-sell-stock-ii [1 1 1 1 1])))))

(t/deftest house-robber

  (t/testing "[1 2 3 1]=>4" (t/is (= 4 (p/rob [1 2 3 1]))))

  (t/testing "[2 7 9 3 1]=>12" (t/is (= 12 (p/rob [2 7 9 3 1]))))

  (t/testing "[2 1 1 2]=>4" (t/is (= 4 (p/rob [2 1 1 2]))))

  (t/testing "[ ]=>nil" (t/is (= nil (p/rob []))))

  (t/testing "[69]=>69" (t/is (= 69 (p/rob [69])))))

(t/deftest remove-duplicates-from-sorted-array-ii

  (t/testing "[1 1 1 2 2 2 3 3 3]=>[1 1 2 2 3 3]"
    (let [nums [1 1 1 2 2 2 3 3 3]
          expected [1 1 2 2 3 3]
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual))))

  (t/testing "[]=>[]"
    (let [nums []
          expected []
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual))))

  (t/testing "[1]=>[1]"
    (let [nums [1]
          expected [1]
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual))))

  (t/testing "[1 1]=>[1 1]"
    (let [nums [1 1]
          expected [1 1]
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual))))

  (t/testing "[1 2]=>[1 2]"
    (let [nums [1 2]
          expected [1 2]
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual))))

  (t/testing "30000 times 99=>[99 99]"
    (let [nums (repeat 30000 99)
          expected [99 99]
          actual (p/remove-duplicates-ii nums)]
      (t/is (= expected actual)))))

(t/deftest rotate-array

  (t/testing "[1 2 3 4 5 6 7] 3=>[5 6 7 1 2 3 4]"
    (t/is (= [5 6 7 1 2 3 4] (p/rotate-array [1 2 3 4 5 6 7] 3))))

  (t/testing "[-1 -100 3 99] 2=>[3 99 -1 -100]"
    (t/is (= [3 99 -1 -100] (p/rotate-array [-1 -100 3 99] 2))))

  (t/testing "[] 2=>[]"
    (t/is (= [] (p/rotate-array [] 2)))))

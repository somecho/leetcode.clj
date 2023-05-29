(ns problems.easy)

(defn two-sum
  "1. Two Sum
  https://leetcode.com/problems/two-sum/

  Given an array of integers `nums` and an integer `target`,
  return indices of the two numbers such that they add up
  to `target`.

  You may assume that each input would have exactly one
  solution, and you may not use the same element twice.

  You can return the answer in any order."
  [nums target]
  (-> (map-indexed #(vec [%1 %2]) nums)
      (as-> indexed
            (for [x indexed
                  y indexed]
              (when (and (= (+ (last x) (last y)) target)
                         (not= (first x) (first y)))
                [x y])))
      (as-> pairs (filter not-empty pairs))
      (first)
      (as-> pair (map first pair))))

(defn best-time-buy-sell-stock
  "121. Best Time to Buy and Sell Stock
  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

  You are given an array `prices` where `prices[i]` is the price of a given stock
  on the `ith` day.

  You want to maximize your profit by choosing a single day to buy one stock and
  choosing a different day in the future to sell that stock.

  Return the maximum profit you can achieve from this transaction. If you cannot
  achieve any profit, return 0.
  "
  [prices]
  (loop [p prices
         profit 0
         cheapest 11111]
    (if (= 0 (count p))
      profit
      (let [p-now (first p)
            cheapest (min p-now cheapest)
            profit (max (- p-now cheapest) profit)]
        (recur (rest p)
               profit
               cheapest)))))

(defn majority-element
  "169. Majority Element
  https://leetcode.com/problems/majority-element/

  Given an array nums of size `n`, return the majority element.

  The majority element is the element that appears more than
  `⌊n / 2⌋` times. You may assume that the majority element
  always exists in the array."
  [nums]
  (->> nums
       (frequencies)
       (sort-by val)
       (last)
       (first)))

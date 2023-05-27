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

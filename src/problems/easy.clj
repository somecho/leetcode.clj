(ns problems.easy)

(defn majorityElement
  "
  169. Majority Element
  https://leetcode.com/problems/majority-element/

  Given an array nums of size `n`, return the majority element.

  The majority element is the element that appears more than
  `⌊n / 2⌋` times. You may assume that the majority element
  always exists in the array.
  "
  [nums]
  (->> nums
       (frequencies)
       (sort-by val)
       (last)
       (first)))

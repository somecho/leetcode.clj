(ns problems.medium)

(defn rotate-array
  "189. Rotate Array

  Given an integer array `nums`, rotate the array to the right by `k` steps, where 
  `k` is non-negative.
  "
  [nums k]
  (if-not (or (empty? nums)
              (= k 0))
    (loop [num-rotations (mod k (count nums))
           to-rotate nums]
      (if (= num-rotations 0)
        to-rotate
        (recur (dec num-rotations)
               (concat `(~(last to-rotate))
                       (take (dec (count nums)) to-rotate)))))
    []))

(defn rob
  "198. House Robber
  https://leetcode.com/problems/house-robber/

  You are a professional robber planning to rob houses along a street. Each
  house has a certain amount of money stashed, the only constraint stopping you
  from robbing each of them is that adjacent houses have security systems
  connected and it will automatically contact the police if two adjacent houses
  were broken into on the same night.

  Given an integer array `nums` representing the amount of money of each house,
  return the maximum amount of money you can rob tonight without alerting the
  police."
  [nums]
  (when-not (empty? nums)
    (loop [houses nums
           a 0
           b 0]
      (let [n (first houses)]
        (if (= (count houses) 1)
          (max (+ b n) a)
          (recur (rest houses) (max (+ b n) a) a))))))

(ns problems.medium)

(defn jump-game
  "55. Jump Game
  https://leetcode.com/problems/jump-game/description/

  You are given an integer array nums. You are initially positioned at the
  array's first index, and each element in the array represents your maximum jump
  length at that position.
 
  Return true if you can reach the last index, or false otherwise. "
  [nums]
  (loop [can-jump true
         j (dec (count nums))
         i (- (count nums) 2)]
    (if (< i 0)
      can-jump
      (let [sum (+ i (nth nums i))]
        (recur (>= sum j)
               (if (>= sum j) i j)
               (dec i))))))

; this problem requires you to modify an array in place
; we ain't gonna do that here
(defn remove-duplicates-ii
  "80. Remove Duplicates from Sorted Array II
  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

  Given an integer array nums sorted in non-decreasing order, remove some
  duplicates in-place such that each unique element appears at most twice. The
  relative order of the elements should be kept the same.
 
  Since it is impossible to change the length of the array in some languages, you
  must instead have the result be placed in the first part of the array nums.
  More formally, if there are k elements after removing the duplicates, then the
  first k elements of nums should hold the final result. It does not matter what
  you leave beyond the first k elements.
 
  Return k after placing the final result in the first k slots of nums.
 
  Do not allocate extra space for another array. You must do this by modifying
  the input array in-place with O(1) extra memory. "
  [nums]
  (loop [indices (range (count nums))
         c 0
         results []]
    (if (= 0 (count indices))
      results
      (let [i (first indices)
            n (nth nums i)
            previ (- c 2)
            prev (if (> previ -1) (nth results previ) n)
            addable (or (> n prev) (< c 2))]
        (recur (rest indices)
               (if addable (inc c) c)
               (if addable (concat results [n]) results))))))

(defn best-time-buy-sell-stock-ii
  "122. Best Time to Buy and Sell Stock II
  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

  You are given an integer array prices where prices[i] is the price of a given
  stock on the ith day.
 
  On each day, you may decide to buy and/or sell the stock. You can only hold at
  most one share of the stock at any time. However, you can buy it then
  immediately sell it on the same day.
 
  Find and return the maximum profit you can achieve. "
  [nums]
  (if (empty? nums) 0
      (let [isPeak? #(and (< (first %) (second %)) (>= (second %) (last %)))
            isValley? #(and (>= (first %) (second %)) (< (second %) (last %)))]
        (-> (concat [(first nums)] nums [(last nums)])
            (as-> pad (partition 3 1 pad))
            (as-> ptns (filter #(or (isPeak? %) (isValley? %)) ptns))
            (as-> peaks-valleys (map second peaks-valleys))
            (as-> values (partition 2 2 (reverse values)))
            (as-> ptns (filter #(= (count %) 2) ptns))
            (as-> pairs (apply + (map #(apply - %) pairs)))))))

(defn rotate-array
  "189. Rotate Array

  Given an integer array `nums`, rotate the array to the right by `k` steps, where 
  `k` is non-negative. "
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

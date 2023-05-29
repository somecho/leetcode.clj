(ns problems.medium)

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

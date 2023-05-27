(ns problems.medium)

(defn rob
  "198. House Robber
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

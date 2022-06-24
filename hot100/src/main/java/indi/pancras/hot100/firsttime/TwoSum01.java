package indi.pancras.hot100.firsttime;

import java.util.HashMap;

public class TwoSum01 {

  class Solution {

    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length < 2) {
        return new int[0];
      }
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
          return new int[]{map.get(target - nums[i]), i};
        } else {
          map.put(nums[i], i);
        }
      }
      return new int[0];
    }
  }
}

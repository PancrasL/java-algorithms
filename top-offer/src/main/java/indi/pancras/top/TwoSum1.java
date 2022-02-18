package indi.pancras.top;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    // 哈希表+两次循环
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> pos = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                pos.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                Integer secondPos = pos.get(target - nums[i]);
                if (secondPos != null && secondPos != i) {
                    return new int[]{i, pos.get(target - nums[i])};
                }
            }
            return new int[]{};
        }
    }

    // 哈希表+一次循环
    class Solution1 {
        class Solution {
            public int[] twoSum(int[] nums, int target) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                    if (map.containsKey(target - nums[i])) {
                        return new int[]{i, map.get(target - nums[i])};
                    }
                    map.put(nums[i], i);
                }
                return null;
            }
        }
    }
}

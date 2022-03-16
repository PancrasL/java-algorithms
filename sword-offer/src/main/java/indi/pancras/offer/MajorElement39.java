package indi.pancras.offer;

import java.util.HashMap;

public class MajorElement39 {
    // 哈希表：时间换空间
    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = nums.length / 2;
            for (int num : nums) {
                int cnt = map.getOrDefault(num, 0) + 1;
                map.put(num, cnt);
                if (cnt > len) {
                    return num;
                }
            }
            return -1;
        }
    }

    // 数组特性：两两抵消
    class Solution1 {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int cnt = 1;
            int val = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (cnt == 0) {
                    val = nums[i];
                    cnt++;
                } else if (nums[i] == val) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            return val;
        }
    }
}

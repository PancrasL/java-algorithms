package indi.pancras.labuladuo.math;

import java.util.Arrays;

public class MissingNumber268 {
    // 排序
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    // 哈希表
    class Solution1 {
        public int missingNumber(int[] nums) {
            boolean[] exist = new boolean[nums.length + 1];
            for (int num : nums) {
                exist[num] = true;
            }
            for (int i = 0; i < exist.length; i++) {
                if (!exist[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    // 异或运算
    class Solutino2 {
        public int missingNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            for (int i = 0; i <= nums.length; i++) {
                res ^= i;
            }
            return res;
        }
    }
}

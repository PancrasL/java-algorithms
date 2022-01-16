package indi.pancras.labuladuo.math;

import java.util.Arrays;

public class FindErrorNums645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            Arrays.sort(nums);
            int duplicate = -1;
            int disappear = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    duplicate = nums[i];
                } else if (nums[i] != nums[i - 1] + 1) {
                    disappear = nums[i - 1] + 1;
                }
            }
            if (disappear == -1) {
                disappear = nums[0] == 1 ? nums.length : 1;
            }
            return new int[]{duplicate, disappear};
        }
    }
}

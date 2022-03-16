package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class PartTwoSubsets416 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.canPartition(new int[]{1, 2, 5}));
    }

    // 动态规划
    static class Solution1 {
        // 可以看成从nums中选取一些数字，使其和为sum/2
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2;
            // dp[i][j]表示选到第i个数字，和为j的方案是否存在
            boolean[][] dp = new boolean[nums.length][sum + 1];
            // 选到第i个数字，和为0的方案总是存在
            for (boolean[] booleans : dp) {
                booleans[0] = true;
            }
            if (nums[0] <= sum)
                dp[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j < nums[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[nums.length - 1][sum];
        }
    }

    // 回溯算法，超时
    class Solution {
        private int average = 0;

        public boolean canPartition(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = -nums[i];
            }
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = -nums[i];
            }
            for (int num : nums) {
                sum += num;
            }
            average = sum / 2;
            return backtrack(nums, 0, 0, 0);
        }

        private boolean backtrack(int[] nums, int index, int cur1, int cur2) {
            if (index == nums.length) {
                return cur1 == cur2;
            }
            if (cur1 > average || cur2 > average) {
                return false;
            }
            if (backtrack(nums, index + 1, cur1 + nums[index], cur2)) {
                return true;
            }
            return backtrack(nums, index + 1, cur1, cur2 + nums[index]);
        }
    }
}

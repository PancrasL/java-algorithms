package indi.pancras.dynamic;

public class CanPartition416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            sum /= 2;
            if (nums[0] > sum) {
                return false;
            }
            // 从nums中选取部分元素，使其和位sum
            // dp[i][j]表示前i个数，是否包含和为j的序列
            boolean[][] dp = new boolean[nums.length][sum + 1];
            dp[0][0] = true;
            dp[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length - 1][sum];
        }
    }
}

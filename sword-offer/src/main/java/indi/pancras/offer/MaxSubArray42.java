package indi.pancras.offer;

public class MaxSubArray42 {
    class Solution {
        public int maxSubArray(int[] nums) {
            // dp[i]表示前i个数字的最大和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = nums[i] + dp[i - 1];
                } else {
                    dp[i] = nums[i];
                }
            }
            int maxVal = dp[0];
            for (int i : dp) {
                maxVal = Math.max(maxVal, i);
            }
            return maxVal;
        }
    }
}

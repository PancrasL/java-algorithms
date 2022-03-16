package indi.pancras.labuladuo.dynamic;

public class MaxSubArray53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            }
            int res = Integer.MIN_VALUE;
            for (int i : dp) {
                res = Math.max(res, i);
            }
            return res;
        }
    }
}

package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class LengthOfLTS300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // dp[i]记录以nums[i]结尾的严格递增子序列长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int maxLen = 0;
            for (int i : dp) {
                maxLen = Math.max(maxLen, i);
            }
            return maxLen;
        }
    }
}

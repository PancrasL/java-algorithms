package indi.pancras.offer;

import java.util.Arrays;

public class NumWays10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.numWays(45);
    }

    static class Solution {
        private final long INF = -1;
        private final long MOD = 10_0000_0007;

        public int numWays(int n) {
            long[] dp = new long[n + 2];
            Arrays.fill(dp, INF);
            dp[0] = 1;
            dp[1] = 1;
            return (int) dynamic(dp, n);
        }

        private long dynamic(long[] dp, int n) {
            if (dp[n] != INF) {
                return dp[n];
            }
            dp[n] = (dynamic(dp, n - 1) + dynamic(dp, n - 2)) % MOD;
            return dp[n];
        }
    }
}

package indi.pancras.labuladuo.dynamic;

public class MinFallingPathSum931 {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int lastLevel = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        lastLevel = Math.min(lastLevel, dp[i - 1][j - 1]);
                    }
                    if (j + 1 < n) {
                        lastLevel = Math.min(lastLevel, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = matrix[i][j] + lastLevel;
                }
            }

            int result = Integer.MAX_VALUE;
            for (int len : dp[n - 1]) {
                result = Math.min(result, len);
            }
            return result;
        }
    }
}

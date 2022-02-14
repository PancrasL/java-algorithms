package indi.pancras.dynamic;

public class FindMaxForm474 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int maxForm = s.findMaxForm(new String[]{
                "11111", "100", "1101", "1101", "11000"
        }, 5, 7);
        System.out.println(maxForm);
    }

    static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            // dp[i][j][k]表示前i个字符串，最多包含j个0和k个1时的最大子串数量
            int[][][] dp = new int[strs.length][m + 1][n + 1];
            int[] cnt = caculateZeroAndOne(strs[0]);
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i >= cnt[0] && j >= cnt[1]) {
                        dp[0][i][j] = 1;
                    }
                }
            }
            for (int i = 1; i < strs.length; i++) {
                int[] count = caculateZeroAndOne(strs[i]);
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (j >= count[0] && k >= count[1]) {
                            dp[i][j][k] = Math.max(dp[i - 1][j - count[0]][k - count[1]] + 1, dp[i - 1][j][k]);
                        } else {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                        }
                    }
                }
            }
            return dp[strs.length - 1][m][n];
        }

        private int[] caculateZeroAndOne(String s) {
            int zeroCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
            }
            return new int[]{zeroCnt, s.length() - zeroCnt};
        }
    }
}

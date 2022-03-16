package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class EditDistance72 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("horse", "ros"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            if (word1.length() == 0) {
                return word2.length();
            }
            if (word2.length() == 0) {
                return word1.length();
            }
            int[][] dp = new int[word1.length()][word2.length()];
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            dynamic(dp, word1, word1.length() - 1, word2, word2.length() - 1);
            return dp[word1.length() - 1][word2.length() - 1];
        }

        private int dynamic(int[][] dp, String word1, int i, String word2, int j) {
            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                return i + 1;
            }
            if (dp[i][j] != Integer.MAX_VALUE) {
                return dp[i][j];
            }
            if (word1.charAt(i) == word2.charAt(j)) {
                dp[i][j] = dynamic(dp, word1, i - 1, word2, j - 1);
                return dp[i][j];
            } else {
                int cnt1 = dynamic(dp, word1, i - 1, word2, j) + 1;
                int cnt2 = dynamic(dp, word1, i, word2, j - 1) + 1;
                int cnt3 = dynamic(dp, word1, i - 1, word2, j - 1) + 1;
                int res = Math.min(Math.min(cnt1, cnt2), cnt3);
                dp[i][j] = res;
                return dp[i][j];
            }
        }
    }
}

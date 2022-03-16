package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class LongestCommonSubseq1143 {
    class Solution {
        private final int INF = -1;

        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            for (int[] ints : dp) {
                Arrays.fill(ints, INF);
            }
            dynamic(dp, text1, text1.length() - 1, text2, text2.length() - 1);
            return dp[text1.length() - 1][text2.length() - 1];
        }

        private int dynamic(int[][] dp, String text1, int index1, String text2, int index2) {
            if (index1 == -1 || index2 == -1) {
                return 0;
            }
            if (dp[index1][index2] != INF) {
                return dp[index1][index2];
            }
            if (text1.charAt(index1) == text2.charAt(index2)) {
                dp[index1][index2] = dynamic(dp, text1, index1 - 1, text2, index2 - 1) + 1;
            } else {
                int len1 = dynamic(dp, text1, index1 - 1, text2, index2);
                int len2 = dynamic(dp, text1, index1, text2, index2 - 1);
                dp[index1][index2] = Math.max(len1, len2);
            }
            return dp[index1][index2];
        }
    }
}

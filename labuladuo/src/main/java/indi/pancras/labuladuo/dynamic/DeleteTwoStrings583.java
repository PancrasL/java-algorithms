package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class DeleteTwoStrings583 {
    class Solution {
        private final int INF = -1;

        public int minDistance(String word1, String word2) {
            int len = commonSubseq(word1, word2);
            return word1.length() + word2.length() - 2 * len;
        }

        private int commonSubseq(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()];
            for (int[] ints : dp) {
                Arrays.fill(ints, INF);
            }
            dynamic(dp, word1, word1.length() - 1, word2, word2.length() - 1);
            return dp[word1.length() - 1][word2.length() - 1];
        }

        private int dynamic(int[][] dp, String word1, int index1, String word2, int index2) {
            if (index1 == INF || index2 == INF) {
                return 0;
            }
            if (dp[index1][index2] != INF) {
                return dp[index1][index2];
            }
            if (word1.charAt(index1) == word2.charAt(index2)) {
                dp[index1][index2] = dynamic(dp, word1, index1 - 1, word2, index2 - 1) + 1;
            } else {
                int len1 = dynamic(dp, word1, index1 - 1, word2, index2);
                int len2 = dynamic(dp, word1, index1, word2, index2 - 1);
                dp[index1][index2] = Math.max(len1, len2);
            }
            return dp[index1][index2];
        }
    }
}

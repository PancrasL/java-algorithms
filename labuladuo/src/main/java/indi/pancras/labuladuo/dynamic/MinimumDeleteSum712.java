package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class MinimumDeleteSum712 {
    class Solution {
        private final int INF = -1;

        public int minimumDeleteSum(String s1, String s2) {
            int[][] dp = new int[s1.length()][s2.length()];
            for (int[] ints : dp) {
                Arrays.fill(ints, INF);
            }
            dynamic(dp, s1, s2, s1.length() - 1, s2.length() - 1);
            return dp[s1.length() - 1][s2.length() - 1];
        }

        private int dynamic(int[][] dp, String s1, String s2, int index1, int index2) {
            if (index1 == -1 || index2 == -1) {
                int sum = 0;
                while (index1 != -1) {
                    sum += s1.charAt(index1--);
                }
                while (index2 != -1) {
                    sum += s2.charAt(index2--);
                }
                return sum;
            }
            if (dp[index1][index2] != INF) {
                return dp[index1][index2];
            }
            if (s1.charAt(index1) == s2.charAt(index2)) {
                dp[index1][index2] = dynamic(dp, s1, s2, index1 - 1, index2 - 1);
            } else {
                int sum1 = dynamic(dp, s1, s2, index1 - 1, index2) + s1.charAt(index1);
                int sum2 = dynamic(dp, s1, s2, index1, index2 - 1) + s2.charAt(index2);
                dp[index1][index2] = Math.min(sum1, sum2);
            }
            return dp[index1][index2];
        }
    }
}

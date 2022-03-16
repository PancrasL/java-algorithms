package indi.pancras.offer;

public class MaxValue47 {
    class Solution {
        public int maxValue(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];

            dp[0][0] = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int fromUp = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int fromLeft = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(fromUp, fromLeft) + grid[i][j];
                }
            }
            return dp[grid.length - 1][grid[0].length - 1];
        }
    }
}

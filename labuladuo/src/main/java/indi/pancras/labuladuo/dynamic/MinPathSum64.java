package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class MinPathSum64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            // dp[i][j]表示到达(i,j)的最短路径和
            int[][] dp = new int[M][N];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    } else if (i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else if (j - 1 >= 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }
                System.out.println(Arrays.toString(dp[i]));
            }
            return dp[M - 1][N - 1];
        }
    }
}

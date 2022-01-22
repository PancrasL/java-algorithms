package indi.pancras.labuladuo.dynamic;

public class MinimumHP174 {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int M = dungeon.length;
            int N = dungeon[0].length;
            // dp[i][j]表示从(i,j)到终点所需要的最小生命值
            int[][] dp = new int[M][N];
            dp[M - 1][N - 1] = Math.max(1, 1 - dungeon[M - 1][N - 1]);
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (i + 1 < M && j + 1 < N) {// 可以从右边和下边到达终点
                        int down = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                        int right = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                        dp[i][j] = Math.min(down, right);
                    } else if (i + 1 < M && j + 1 >= N) {// 只能从下边到达终点
                        dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                    } else if (i + 1 >= M && j + 1 < N) {// 只能从右边到达终点
                        dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                    }
                }
            }
            return dp[0][0];
        }
    }
}

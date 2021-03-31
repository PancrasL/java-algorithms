package indi.pancras.dynamic;

/**
 * @author pancras
 * @tip 对于任意一点，最近的0必在其左上、左下、右上、右下四个方向之一。
 * @create 2021/3/25 10:51
 * @see <a href="https://leetcode-cn.com/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/">01矩阵</a>
 */
public class ZeroOneMatrixDP {
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0][0];
            }
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = (matrix[i][j] == 0) ? 0 : 0x3f3f3f3f;
                }
            }

            // 从左上角开始
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }

            // 从右下角开始
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 < m) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }

            return dp;
        }
    }
}

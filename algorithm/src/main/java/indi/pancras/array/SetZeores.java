package indi.pancras.array;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 * @tip 第一遍遍历记录包含0的行和列，第二遍遍历置0.
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/">零矩阵</a>
 */
public class SetZeores {
    public int[][] run(int[][] matrix) {
        Solution s = new Solution();
        s.setZeroes(matrix);
        return matrix;
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int rowCnt = matrix.length;
            int colCnt = matrix[0].length;

            int[] zeroRow = new int[rowCnt];
            int[] zeroCol = new int[colCnt];

            for (int i = 0; i < rowCnt; i++) {
                for (int j = 0; j < colCnt; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRow[i] = 1;
                        zeroCol[j] = 1;
                    }
                }
            }

            for (int i = 0; i < zeroRow.length; i++) {
                if (zeroRow[i] == 1) {
                    for (int j = 0; j < colCnt; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < zeroCol.length; i++) {
                if (zeroCol[i] == 1) {
                    for (int j = 0; j < rowCnt; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}

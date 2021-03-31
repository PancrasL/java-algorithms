package indi.pancras.array;

/**
 * @author pancras
 * @create 2021/3/11 17:23
 * @tip 按对角条带遍历，注意矩阵的行和列数不同，小心边界处理
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/">对角线遍历</a>
 */
public class DiagonalOrder {
    public int[] run(int[][] matrix) {
        Solution s = new Solution();
        return s.findDiagonalOrder(matrix);
    }

    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }

            int rowCnt = matrix.length;
            int colCnt = matrix[0].length;

            int[] result = new int[rowCnt * colCnt];
            int[] subResult = null;

            boolean isUpDown = false;
            int index = 0;

            int minNum = Math.min(rowCnt, colCnt);
            int maxNum = Math.max(rowCnt, colCnt);
            for (int i = 0; i < rowCnt + colCnt - 1; i++) {
                if (i < minNum) {
                    subResult = traverseDiagonal(matrix, isUpDown, 0, i, i + 1);
                } else if (i < maxNum - 1) {
                    if (rowCnt <= colCnt) {
                        subResult = traverseDiagonal(matrix, isUpDown, 0, i, rowCnt);
                    } else {
                        subResult = traverseDiagonal(matrix, isUpDown, i - colCnt + 1, colCnt - 1, colCnt);
                    }
                } else {
                    subResult = traverseDiagonal(matrix, isUpDown, i - colCnt + 1, colCnt - 1, rowCnt + colCnt - 1 - i);
                }

                if (isUpDown) {//正序拷贝
                    for (int j = 0; j < subResult.length; j++) {
                        result[index++] = subResult[j];
                    }
                } else {//倒叙拷贝
                    for (int j = subResult.length - 1; j >= 0; j--) {
                        result[index++] = subResult[j];
                    }
                }

                isUpDown = !isUpDown;
            }

            return result;
        }

        private int[] traverseDiagonal(int[][] matrix, boolean isUpDown, int x, int y, int cnt) {
            int[] result = new int[cnt];

            int index = 0;
            for (int i = 0; i < cnt; i++) {
                result[index++] = matrix[x][y];
                x += 1;
                y -= 1;
            }

            return result;
        }
    }
}

package indi.pancras.array;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 * @tip 原位旋转，从最外圈旋转，一直到最内圈
 * @see <a href= "https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/">旋转矩阵</a>
 */
public class RotateMatrix {
    public int[][] run(int[][] matrix) {
        Solution s = new Solution();
        s.rotate(matrix);

        return matrix;
    }

    class Solution {
        public void rotate(int[][] matrix) {
            int N = matrix.length;
            for (int row = 0; row < N / 2; row++) {
                rotateImp(matrix, row, N - row - 1, row, N - row - 1);
            }
        }

        private void rotateImp(int[][] matrix, int row1, int row2, int col1, int col2) {
            for (int offset = 0; offset < (col2 - col1); offset++) {
                int temp = matrix[row1][col1 + offset];
                matrix[row1][col1 + offset] = matrix[row2 - offset][col1];
                matrix[row2 - offset][col1] = matrix[row2][col2 - offset];
                matrix[row2][col2 - offset] = matrix[row1 + offset][col2];
                matrix[row1 + offset][col2] = temp;
            }
        }
    }
}
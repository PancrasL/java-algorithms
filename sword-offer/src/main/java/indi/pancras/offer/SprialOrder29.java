package indi.pancras.offer;

public class SprialOrder29 {
    class Solution {
        int[] res;
        int index = 0;

        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            res = new int[matrix.length * matrix[0].length];
            int i1 = 0, j1 = 0;
            int i2 = matrix.length - 1, j2 = matrix[0].length - 1;
            while (i1 <= i2 && j1 <= j2) {
                printMatrix(matrix, i1, j1, i2, j2);
                i1++;
                j1++;
                i2--;
                j2--;
            }
            return res;
        }

        private void printMatrix(int[][] matrix, int i1, int j1, int i2, int j2) {
            //上
            for (int col = j1; col <= j2; col++) {
                res[index++] = matrix[i1][col];
            }
            //右
            for (int row = i1 + 1; row <= i2; row++) {
                res[index++] = matrix[row][j2];
            }
            //下
            if (i1 < i2) {
                for (int col = j2 - 1; col >= j1; col--) {
                    res[index++] = matrix[i2][col];
                }
            }

            //左
            if (j1 < j2) {
                for (int row = i2 - 1; row > i1; row--) {
                    res[index++] = matrix[row][j1];
                }
            }
        }
    }
}

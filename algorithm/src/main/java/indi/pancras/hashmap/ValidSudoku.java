package indi.pancras.hashmap;

/**
 * @author pancras
 * @tip 哈希表
 * @create 2021/4/6 9:14
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/">有效的数独</a>
 */
public class ValidSudoku {
    public boolean run(char[][] board) {
        return new Solution().isValidSudoku(board);
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (!isValidRow(board, i) || !isValidCol(board, i) || !isValidCell(board, (i / 3) * 3, (i % 3) * 3, 3))
                    return false;
            }

            return true;
        }

        private boolean isValidRow(char[][] board, int row) {
            int[] map = new int[256];

            for (int i = 0; i < board[0].length; i++) {
                char c = board[row][i];
                if (c == '.')
                    continue;
                if (map[c] == 1) {
                    return false;
                }
                map[c] = 1;
            }
            return true;
        }

        private boolean isValidCol(char[][] board, int col) {
            int[] map = new int[256];

            for (int i = 0; i < board.length; i++) {
                char c = board[i][col];
                if (c == '.')
                    continue;
                if (map[c] == 1) {
                    return false;
                }
                map[c] = 1;
            }
            return true;
        }

        private boolean isValidCell(char[][] board, int row, int col, int cnt) {
            int[] map = new int[256];

            int rowCnt = row + cnt;
            int colCnt = col + cnt;
            for (int i = row; i < rowCnt; i++) {
                for (int j = col; j < colCnt; j++) {
                    char c = board[i][j];
                    if (c == '.')
                        continue;
                    if (map[c] == 1) {
                        return false;
                    }
                    map[c] = 1;
                }
            }

            return true;
        }
    }
}

package indi.pancras.labuladuo.backtrack;

public class SolveSudoku37 {
    class Solution {
        public void solveSudoku(char[][] board) {
            backtrack(board, 0, 0);
        }

        public boolean backtrack(char[][] board, int row, int col) {
            // 穷举到最后一列的话就换到下一行重新开始。
            if (col == 9) {
                return backtrack(board, row + 1, 0);
            }
            // 找到一个可行解
            if (row == 9) {
                return true;
            }
            // 如果有预设数字，不用我们穷举
            if (board[row][col] != '.') {
                return backtrack(board, row, col + 1);
            }
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (backtrack(board, row, col)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }

        // 判断 board[i][j] 是否可以填入 n
        boolean isValid(char[][] board, int r, int c, char n) {
            for (int i = 0; i < 9; i++) {
                // 判断行是否存在重复
                if (board[r][i] == n) {
                    return false;
                }
                // 判断列是否存在重复
                if (board[i][c] == n) {
                    return false;
                }
                // 判断 3 x 3 方框是否存在重复
                if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                    return false;
                }
            }
            return true;
        }

    }
}

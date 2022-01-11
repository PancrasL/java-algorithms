package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    class Solution {
        private List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            backtrack(board, 0);
            return ans;
        }

        // 在第row行放置皇后
        private void backtrack(char[][] board, int row) {
            int n = board.length;
            if (row == n) {
                List<String> finish = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (char[] chars : board) {
                    for (char c : chars) {
                        sb.append(c);
                    }
                    finish.add(sb.toString());
                    sb.setLength(0);
                }
                ans.add(finish);
            }
            for (int k = 0; k < n; k++) {
                if (isValid(board, row, k)) {
                    board[row][k] = 'Q';
                    backtrack(board, row + 1);
                    board[row][k] = '.';
                }
            }
        }

        private boolean isValid(char[][] board, int row, int col) {//判断在row行col列放置皇后是否合法
            int n = board.length;
            //不再同一列
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            //不在同一左对角线
            for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            //不在同一右对角线
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
}

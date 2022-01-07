package indi.pancras.labuladuo.datastructure.graph;

public class SurroundedRegions130 {
    class Solution {
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            boolean[][] visit = new boolean[row][col];
            // 遍历最外围的边，将和外围相连的连通的'O'标记为已访问
            // 上
            for (int j = 0; j < col; j++) {
                if (!visit[0][j] && board[0][j] == 'O') {
                    dfs(board, visit, 0, j);
                }
            }
            // 下
            for (int j = 0; j < col; j++) {
                if (!visit[row - 1][j] && board[row - 1][j] == 'O') {
                    dfs(board, visit, row - 1, j);
                }
            }
            // 左
            for (int i = 0; i < row; i++) {
                if (!visit[i][0] && board[i][0] == 'O') {
                    dfs(board, visit, i, 0);
                }
            }
            // 右
            for (int i = 0; i < row; i++) {
                if (!visit[i][col - 1] && board[i][col - 1] == 'O') {
                    dfs(board, visit, i, col - 1);
                }
            }
            // 将剩下的未被访问的'O'标记为X
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visit[i][j] && board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void dfs(char[][] board, boolean[][] visit, int i, int j) {
            visit[i][j] = true;
            if (valid(board, visit, i - 1, j)) {
                dfs(board, visit, i - 1, j);
            }
            if (valid(board, visit, i + 1, j)) {
                dfs(board, visit, i + 1, j);
            }
            if (valid(board, visit, i, j - 1)) {
                dfs(board, visit, i, j - 1);
            }
            if (valid(board, visit, i, j + 1)) {
                dfs(board, visit, i, j + 1);
            }
        }

        private boolean valid(char[][] board, boolean[][] visit, int i, int j) {
            int row = board.length;
            int col = board[0].length;
            return i >= 0 && i < row && j >= 0 && j < col && !visit[i][j] && board[i][j] == 'O';
        }
    }
}

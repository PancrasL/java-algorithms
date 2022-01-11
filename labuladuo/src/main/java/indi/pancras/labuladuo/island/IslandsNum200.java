package indi.pancras.labuladuo.island;

public class IslandsNum200 {
    class Solution {
        boolean[][] visit;

        public int numIslands(char[][] grid) {
            int num = 0;
            visit = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (valid(grid, i, j)) {
                        dfs(grid, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (!valid(grid, i, j)) {
                return;
            }
            visit[i][j] = true;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }

        private boolean valid(char[][] grid, int i, int j) {
            return i >= 0 && i < visit.length && j >= 0 && j < visit[0].length && !visit[i][j] && grid[i][j] == '1';
        }
    }
}

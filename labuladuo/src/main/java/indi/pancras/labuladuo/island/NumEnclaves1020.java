package indi.pancras.labuladuo.island;

public class NumEnclaves1020 {
    class Solution {
        boolean[][] visit;

        public int numEnclaves(int[][] grid) {
            visit = new boolean[grid.length][grid[0].length];
            traverseBorder(grid);
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    num += dfs(grid, i, j);
                }
            }
            return num;
        }

        // 从边界出发，将可以通过边界直达的岛屿标记为已访问
        private void traverseBorder(int[][] grid) {
            // 上下
            for (int i = 0; i < grid[0].length; i++) {
                dfs(grid, 0, i);
                dfs(grid, grid.length - 1, i);
            }
            // 左右
            for (int i = 0; i < grid.length; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, grid[0].length - 1);
            }
        }

        // 从坐标(x,y)出发，将可达的岛屿标记为已访问
        private int dfs(int[][] grid, int x, int y) {
            if (!validIsland(grid, x, y)) {
                return 0;
            }
            visit[x][y] = true;
            int sum = 0;
            sum += dfs(grid, x - 1, y);
            sum += dfs(grid, x + 1, y);
            sum += dfs(grid, x, y - 1);
            sum += dfs(grid, x, y + 1);
            return sum + 1;
        }

        // 判断(x,y)是否为一个未被访问的有效岛屿
        private boolean validIsland(int[][] grid, int x, int y) {
            // 边界合法 且 (x,y)是未被访问的岛屿
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visit[x][y];
        }

    }
}

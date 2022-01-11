package indi.pancras.labuladuo.island;

public class MaxAreaOfIsland695 {
    class Solution {
        boolean[][] visit;

        public int maxAreaOfIsland(int[][] grid) {
            visit = new boolean[grid.length][grid[0].length];
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    num = Math.max(num, dfs(grid, i, j));
                }
            }
            return num;
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

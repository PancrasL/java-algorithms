package indi.pancras.labuladuo.island;

public class CountSubIsland {
    class Solution {
        private boolean[][] visit;

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            visit = new boolean[grid1.length][grid1[0].length];

            int num = 0;
            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (valid(grid2, i, j)) {
                        if (dfs(grid1, grid2, i, j)) {
                            num++;
                        }
                    }
                }
            }
            return num;
        }

        // 从(x,y)出发，遍历所有的陆地，如果是子岛屿返回true，不是返回false
        private boolean dfs(int[][] grid1, int[][] grid2, int x, int y) {
            if (!valid(grid2, x, y)) {
                return true;
            }
            boolean isSubIsland = isSubland(grid1, grid2, x, y);
            visit[x][y] = true;
            isSubIsland &= dfs(grid1, grid2, x - 1, y);
            isSubIsland &= dfs(grid1, grid2, x + 1, y);
            isSubIsland &= dfs(grid1, grid2, x, y - 1);
            isSubIsland &= dfs(grid1, grid2, x, y + 1);
            return isSubIsland;
        }

        private boolean isSubland(int[][] grid1, int[][] grid2, int x, int y) {
            return grid1[x][y] == 1 && grid2[x][y] == 1;
        }

        private boolean valid(int[][] grid, int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visit[x][y];
        }
    }
}

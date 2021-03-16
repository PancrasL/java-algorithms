package indi.pancras.dfs;

/**
 * @author pancras
 * @解题思路 使用DFS求解
 * @create 2021/3/17 10:07
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/kbcqv/">岛屿数量</a>
 */
public class IslandsNumDFS {
    public int run(char[][] grid) {
        return new Solution().numIslands(grid);
    }

    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int result = 0;
            boolean[][] visited = new boolean[300][300];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        DFS(grid, visited, i, j);
                        result++;
                    }
                }
            }

            return result;
        }

        private void DFS(char[][] grid, boolean[][] visited, int x, int y) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    visited[x][y] = true;
                    DFS(grid, visited, x - 1, y);
                    DFS(grid, visited, x + 1, y);
                    DFS(grid, visited, x, y - 1);
                    DFS(grid, visited, x, y + 1);
                }
            }
        }
    }
}

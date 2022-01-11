package indi.pancras.labuladuo.island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctIslands694 {
    class Solution {
        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        class Island {
            private List<Point> points = new ArrayList<>();

            public void addPoint(int x, int y) {
                points.add(new Point(x, y));
            }

            // 计算每个点和第一个点的相对坐标，并进行扁平化处理，因为遍历顺序一定，所以可以平移变换的岛屿扁平化之后是相等的
            public String flat() {
                Point first = points.get(0);
                StringBuilder sb = new StringBuilder();
                for (Point point : points) {
                    sb.append(point.x - first.x).append(',').append(point.y - first.y).append(';');
                }
                return sb.toString();
            }
        }

        private boolean[][] visit;

        private HashSet<String> islandSet = new HashSet<>();

        public int numDistinctIslands(int[][] grid) {
            visit = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (valid(grid, i, j)) {
                        Island island = new Island();
                        dfs(grid, i, j, island);
                        islandSet.add(island.flat());
                    }
                }
            }
            return islandSet.size();
        }

        private boolean valid(int[][] grid, int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visit[x][y];
        }

        private void dfs(int[][] grid, int x, int y, Island island) {
            if (!valid(grid, x, y)) {
                return;
            }
            visit[x][y] = true;
            island.addPoint(x, y);
            dfs(grid, x - 1, y, island);
            dfs(grid, x + 1, y, island);
            dfs(grid, x, y - 1, island);
            dfs(grid, x, y + 1, island);
        }
    }
}

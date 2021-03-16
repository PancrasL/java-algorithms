package indi.pancras.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pancras
 * @解题思路 使用队列+BFS求解
 * @create 2021/3/17 9:11
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/kbcqv/">岛屿数量</a>
 */
public class IslandsNumBFS {
    public int run(char[][] grid) {
        return new Solution().numIslands(grid);
    }

    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[300][300];

            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        queue.add(new Node(i, j));
                        result++;

                        while (!queue.isEmpty()) {
                            Node front = queue.poll();

                            // 上
                            if (front.x - 1 >= 0 && grid[front.x - 1][front.y] == '1' && !visited[front.x - 1][front.y]) {
                                queue.add(new Node(front.x - 1, front.y));
                                visited[front.x - 1][front.y] = true;
                            }
                            // 下
                            if (front.x + 1 < grid.length && grid[front.x + 1][front.y] == '1' && !visited[front.x + 1][front.y]) {
                                queue.add(new Node(front.x + 1, front.y));
                                visited[front.x + 1][front.y] = true;
                            }
                            // 左
                            if (front.y - 1 >= 0 && grid[front.x][front.y - 1] == '1' && !visited[front.x][front.y - 1]) {
                                queue.add(new Node(front.x, front.y - 1));
                                visited[front.x][front.y - 1] = true;
                            }
                            // 右
                            if (front.y + 1 < grid[0].length && grid[front.x][front.y + 1] == '1' && !visited[front.x][front.y + 1]) {
                                queue.add(new Node(front.x, front.y + 1));
                                visited[front.x][front.y + 1] = true;
                            }
                        }
                    }
                }
            }

            return result;
        }

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Node)) {
                    return false;
                }
                Node obj1 = (Node) obj;
                return this.x == obj1.x && this.y == obj1.y;
            }
        }

    }
}

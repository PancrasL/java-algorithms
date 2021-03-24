package indi.pancras.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pancras
 * @解题思路 BFS图遍历，将0视为原点，然后从各个0开始一圈一圈向外扩散
 * @create 2021/3/23 17:07
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/g7pyt/">01矩阵</a>
 */
public class ZeroOneMatrix {
    public int[][] run(int[][] matrix) {
        return new Solution().updateMatrix(matrix);
    }

    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0][0];
            }

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        visited[i][j] = true;
                        queue.add(new Node(i, j));
                    }
                }
            }

            int[][] result = new int[matrix.length][matrix[0].length];

            int dis = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                dis++;
                for (int i = 0; i < size; i++) {
                    Node front = queue.poll();

                    result[front.x][front.y] = dis;
                    if (front.x - 1 >= 0 && !visited[front.x - 1][front.y]) {
                        visited[front.x - 1][front.y] = true;
                        queue.add(new Node(front.x - 1, front.y));
                    }
                    if (front.x + 1 < matrix.length && !visited[front.x + 1][front.y]) {
                        visited[front.x + 1][front.y] = true;
                        queue.add(new Node(front.x + 1, front.y));
                    }
                    if (front.y - 1 >= 0 && !visited[front.x][front.y - 1]) {
                        visited[front.x][front.y - 1] = true;
                        queue.add(new Node(front.x, front.y - 1));
                    }
                    if (front.y + 1 < matrix[0].length && !visited[front.x][front.y + 1]) {
                        visited[front.x][front.y + 1] = true;
                        queue.add(new Node(front.x, front.y + 1));
                    }
                }
            }

            return result;
        }

        class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}

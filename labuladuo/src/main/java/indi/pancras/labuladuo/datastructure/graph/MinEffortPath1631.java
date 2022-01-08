package indi.pancras.labuladuo.datastructure.graph;

import java.util.PriorityQueue;

public class MinEffortPath1631 {
    class Solution {
        class Node {// 从源点到[i,j]的体力数
            int i;
            int j;
            int effort;

            public Node(int i, int j, int effort) {
                this.i = i;
                this.j = j;
                this.effort = effort;
            }
        }

        private int rowCnt;
        private int colCnt;
        boolean[][] visit;
        PriorityQueue<Node> queue;
        int[][] distance;

        public int minimumEffortPath(int[][] heights) {
            rowCnt = heights.length;
            colCnt = heights[0].length;
            // 从(0, 0)到(i,j)所耗费的体力数
            distance = new int[rowCnt][colCnt];
            for (int i = 0; i < rowCnt; i++) {
                for (int j = 0; j < colCnt; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            distance[0][0] = 0;
            visit = new boolean[rowCnt][colCnt];
            queue = new PriorityQueue<>((o1, o2) -> {
                return o1.effort - o2.effort;
            });
            queue.add(new Node(0, 0, 0));
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (visit[cur.i][cur.j]) {
                    continue;
                }
                visit[cur.i][cur.j] = true;
                if (cur.i == rowCnt - 1 && cur.j == colCnt - 1) {
                    return distance[cur.i][cur.j];
                }
                traverse(heights, cur.i - 1, cur.j, cur.i, cur.j);
                traverse(heights, cur.i + 1, cur.j, cur.i, cur.j);
                traverse(heights, cur.i, cur.j - 1, cur.i, cur.j);
                traverse(heights, cur.i, cur.j + 1, cur.i, cur.j);
            }
            return -1;
        }

        private boolean valid(int i, int j) {
            return i >= 0 && i < rowCnt && j >= 0 && j < colCnt && !visit[i][j];
        }

        private void traverse(int[][] heights, int i, int j, int oldi, int oldj) {
            if (!valid(i, j)) {
                return;
            }
            int oldDis = distance[i][j];
            int newDis = Math.max(distance[oldi][oldj], Math.abs(heights[i][j] - heights[oldi][oldj]));
            if (newDis < oldDis) {
                distance[i][j] = newDis;
                queue.add(new Node(i, j, distance[i][j]));
            }
        }
    }
}

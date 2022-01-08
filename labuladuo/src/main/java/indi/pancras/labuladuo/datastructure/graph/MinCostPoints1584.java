package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成树
 */
public class MinCostPoints1584 {
    class Solution {
        class Edge {
            int a;
            int b;
            int cost;

            public Edge(int a, int b, int cost) {
                this.a = a;
                this.b = b;
                this.cost = cost;
            }
        }

        private int[] root;

        public int minCostConnectPoints(int[][] points) {
            List<Edge> edges = new ArrayList<>();
            root = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                root[i] = i;
                for (int j = i + 1; j < points.length; j++) {
                    int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new Edge(i, j, cost));
                }
            }
            edges.sort((o1, o2) -> o1.cost - o2.cost);
            int edgeCnt = 0;
            int cost = 0;
            for (Edge edge : edges) {
                int rootA = find(edge.a);
                int rootB = find(edge.b);
                if (rootA != rootB) {
                    union(rootA, rootB);
                    edgeCnt++;
                    cost += edge.cost;
                }
                if (edgeCnt == points.length - 1) {
                    break;
                }
            }
            return edgeCnt == points.length - 1 ? cost : -1;
        }

        private int find(int x) {
            while (x != root[x]) {
                root[x] = root[root[x]];
                x = root[x];
            }
            return x;
        }

        private void union(int x, int y) {
            root[find(x)] = y;
        }
    }
}

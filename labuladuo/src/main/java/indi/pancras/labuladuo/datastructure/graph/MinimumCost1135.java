package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumCost1135 {
    // Kruskal算法
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

        public int minimumCost(int n, int[][] connections) {
            root = new int[n + 1];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
            List<Edge> edges = new ArrayList<>(connections.length);
            for (int[] connection : connections) {
                edges.add(new Edge(connection[0], connection[1], connection[2]));
            }
            edges.sort((o1, o2) -> o1.cost - o2.cost);

            int cost = 0;
            int edgeCnt = 0;
            for (Edge edge : edges) {
                int rootA = find(edge.a);
                int rootB = find(edge.b);
                if (rootA != rootB) {
                    cost += edge.cost;
                    union(rootA, rootB);
                    edgeCnt++;
                    if (edgeCnt == n - 1) {
                        break;
                    }
                }
            }
            return edgeCnt == n - 1 ? cost : -1;
        }

        private void union(int x, int y) {
            root[find(x)] = y;
        }

        private int find(int x) {
            while (x != root[x]) {
                root[x] = root[root[x]];
                x = root[x];
            }
            return x;
        }
    }
    // Prim算法
    class Solution1{

    }
}

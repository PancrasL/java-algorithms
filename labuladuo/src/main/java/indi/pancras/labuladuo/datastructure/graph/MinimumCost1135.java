package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最小生成树
 */
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
    class Solution1 {
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

        public int minimumCost(int n, int[][] connections) {
            // build graph
            List<Edge>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] connection : connections) {
                graph[connection[0]].add(new Edge(connection[0], connection[1], connection[2]));
                graph[connection[1]].add(new Edge(connection[1], connection[0],connection[2]));
            }
            // Prim
            boolean[] visit = new boolean[n + 1];
            PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
            visit[1] = true;
            queue.addAll(graph[1]);
            int cost = 0;
            int edgeCnt = 0;
            while (!queue.isEmpty()) {
                Edge poll = queue.poll();
                if (visit[poll.b]) {
                    continue;
                }
                cost += poll.cost;
                edgeCnt++;
                visit[poll.b] = true;
                if (edgeCnt == n - 1) {
                    break;
                }
                for (Edge edge : graph[poll.b]) {
                    if (!visit[edge.b]) {
                        queue.add(edge);
                    }
                }
            }
            return edgeCnt == n - 1 ? cost : -1;
        }
    }
}


package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProbability1514 {
    class Solution {
        class Edge {
            int a;
            int b;
            double probability;

            public Edge(int a, int b, double probability) {
                this.a = a;
                this.b = b;
                this.probability = probability;
            }
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<Edge>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                double prob = succProb[i];
                graph[a].add(new Edge(a, b, prob));
                graph[b].add(new Edge(b, a, prob));
            }
            return maxDijkstra(graph, new double[n], new boolean[n], start, end);
        }

        private double maxDijkstra(List<Edge>[] graph, double[] prob, boolean[] visit, int start, int end) {
            PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> {
                if (o2.probability > o1.probability) {
                    return 1;
                } else if (o2.probability < o1.probability) {
                    return -1;
                } else {
                    return 0;
                }
            });

            prob[start] = 1;
            queue.add(new Edge(start, start, 1));
            while (!queue.isEmpty()) {
                Edge poll = queue.poll();
                if (visit[poll.b]) {
                    continue;
                }
                visit[poll.b] = true;
                if (poll.b == end) {// 到达目标节点，返回结果
                    return prob[poll.b];
                }

                for (Edge edge : graph[poll.b]) {
                    if (visit[edge.b]) {
                        continue;
                    }
                    prob[edge.b] = Math.max(prob[edge.b], prob[poll.b] * edge.probability);
                    queue.add(new Edge(start, edge.b, prob[edge.b]));
                }
            }
            return prob[end];
        }
    }
}

package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
    class Solution {
        class Node {
            int node;
            int time;

            public Node(int node, int time) {
                this.node = node;
                this.time = time;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            int[] distance = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            List<Node>[] graph = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] time : times) {
                graph[time[0]].add(new Node(time[1], time[2]));
            }
            return dijkstra(graph, distance, new boolean[n + 1], k);
        }

        public int dijkstra(List<Node>[] graph, int[] distance, boolean[] visit, int src) {
            PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
                return o1.time - o2.time;
            });
            distance[src] = 0;
            queue.add(new Node(src, 0));
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (visit[poll.node]) {
                    continue;
                }
                visit[poll.node] = true;
                // 访问所有的邻接点
                for (Node edge : graph[poll.node]) {
                    if(!visit[edge.node]){// 更新权重
                        distance[edge.node] = Math.min(distance[edge.node], distance[poll.node]+edge.time);
                        queue.add(new Node(edge.node, distance[edge.node]));
                    }
                }
            }
            int maxDis = 0;
            for (int dis : distance) {
                if(dis == Integer.MAX_VALUE){
                    return -1;
                }
                maxDis = Math.max(maxDis, dis);
            }
            return maxDis;
        }
    }
}

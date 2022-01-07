package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition886 {
    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 初始化图
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] dislike : dislikes) {
                graph[dislike[0]].add(dislike[1]);
                graph[dislike[1]].add(dislike[0]);
            }

            // 开始着色
            int[] color = new int[n + 1];
            boolean[] visit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (visit[i]) {
                    continue;
                }
                if (!dfs(graph, color, visit, i, 1)) {
                    return false;
                }
            }
            return true;
        }

        public boolean dfs(List<Integer>[] graph, int[] color, boolean[] visit, int cur, int c) {
            visit[cur] = true;
            color[cur] = c;
            for (Integer neighbor : graph[cur]) {
                if (visit[neighbor]) {
                    if (color[neighbor] == color[cur]) {// 着色冲突，返回false
                        return false;
                    }
                } else {
                    if (!dfs(graph, color, visit, neighbor, -1 * c)) {// 邻居节点着色冲突，返回false
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

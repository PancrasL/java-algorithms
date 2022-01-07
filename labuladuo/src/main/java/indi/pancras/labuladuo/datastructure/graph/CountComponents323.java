package indi.pancras.labuladuo.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class CountComponents323 {
    class Solution {
        private int[] parent;

        public int countComponents(int n, int[][] edges) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            for (int[] edge : edges) {
                union(edge[0], edge[1]);
            }

            Set<Integer> components = new HashSet<>();
            for (int i = 0; i < n; i++) {
                components.add(find(i));
            }
            return components.size();
        }

        private int find(int x) {
            while (x != parent[x]) {
                // 路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        private void union(int x, int y) {
            parent[find(x)] = y;
        }
    }
}

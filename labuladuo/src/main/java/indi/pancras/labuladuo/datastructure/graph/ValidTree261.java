package indi.pancras.labuladuo.datastructure.graph;

public class ValidTree261 {
    class Solution {
        private int[] parent;

        public boolean validTree(int n, int[][] edges) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            for (int[] edge : edges) {
                int rootX = find(edge[0]);
                int rootY = find(edge[1]);
                if(rootX == rootY){// 存在环
                    return false;
                }else{
                    union(rootX, rootY);
                }
            }
            int root = find(0);
            for (int i = 1; i < n; i++) {
                if (find(i) != root) {
                    return false;
                }
            }
            return true;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            parent[rootX] = y;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}

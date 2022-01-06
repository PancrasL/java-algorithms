package indi.pancras.labuladuo.datastructure.graph;

// 可以看成图的二元着色
public class IsBipartite785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] visit = new int[graph.length];
            // 因为图不一定是联通的，可能存在多个子图，所以要重复遍历
            for (int i = 0; i < graph.length; i++) {
                if(visit[i] != 0){
                    continue;
                }
                if(!dfs(graph,visit,i,1)){
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int[] visit, int cur, int color) {
            visit[cur] = color;
            for (int neighbor : graph[cur]) {
                if (visit[neighbor] == visit[cur]) {// 着色冲突
                    return false;
                }
                if (visit[neighbor] == 0) {
                    if(!dfs(graph, visit, neighbor, -color)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

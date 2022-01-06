package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPaths797 {
    class Solution {

        List[] cache;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            cache = new List[graph.length];
            return dfs(graph, 0, graph.length - 1);
        }

        private List<List<Integer>> dfs(int[][] graph, int cur, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (cur == target) {
                ans.add(Arrays.asList(cur));
                return ans;
            }
            for (int i : graph[cur]) {
                List<List<Integer>> paths;
                paths = cache[i];
                if (paths == null) {
                    paths = dfs(graph, i, target);
                    cache[i] = paths;
                }
                for (List<Integer> path : paths) {
                    ArrayList<Integer> newPath = new ArrayList<>(path.size() + 1);
                    newPath.add(cur);
                    newPath.addAll(path);
                    ans.add(newPath);
                }
            }
            return ans;
        }
    }
}

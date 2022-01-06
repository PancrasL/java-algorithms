package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourcesListTwo210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 创建图，并统计节点的入度
            int[] inDegrees = new int[numCourses];
            List<Integer>[] graph = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : prerequisites) {
                graph[edge[0]].add(edge[1]);
                inDegrees[edge[1]]++;
            }

            // 将度为0的节点入队
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }
            // 出队遍历所有节点
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                result.add(poll);
                for (Integer adjNode : graph[poll]) {
                    inDegrees[adjNode]--;
                    if (inDegrees[adjNode] == 0) {
                        queue.add(adjNode);
                    }
                }
            }
            if (result.size() != numCourses) {
                return new int[0];
            }
            Collections.reverse(result);
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}

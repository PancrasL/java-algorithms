package indi.pancras.labuladuo.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRotateSteps514 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int rotateSteps = s.findRotateSteps("godding", "gnd");
        System.out.println(rotateSteps);
    }

    static class Solution {
        private final Map<Character, List<Integer>> posMap = new HashMap<>();
        //圆盘的长度
        int N;

        public int findRotateSteps(String ring, String key) {
            N = ring.length();
            // 统计各个字符出现的位置
            for (int i = 0; i < N; i++) {
                List<Integer> pos = posMap.computeIfAbsent(ring.charAt(i), v -> new ArrayList<>());
                pos.add(i);
            }

            ArrayList<Node>[] dp = new ArrayList[key.length()];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<>();
            }
            for (Integer p : posMap.get(key.charAt(0))) {
                dp[0].add(new Node(p, minDis(0, p) + 1));
            }
            for (int i = 1; i < key.length(); i++) {
                // 旋转到上一个字符后圆盘的位置
                List<Node> lastDp = dp[i - 1];
                // 对于当前字符的每个位置，从上一个字符可能位置出发，到当前字符的每个位置的最小操作数
                for (Integer po : posMap.get(key.charAt(i))) {// 当前字符的所有可能位置
                    int minCnt = Integer.MAX_VALUE;
                    for (Node node : lastDp) {// 上一个字符所有可能位置出发
                        minCnt = Math.min(minCnt, node.cnt + minDis(po, node.pos) + 1);
                    }
                    dp[i].add(new Node(po, minCnt));
                }
            }
            int minCnt = Integer.MAX_VALUE;
            for (Node node : dp[dp.length - 1]) {
                if (node.cnt < minCnt) {
                    minCnt = node.cnt;
                }
            }
            return minCnt;
        }

        // 圆环位置pos1旋转到pos2的最小距离
        private int minDis(int pos1, int pos2) {
            int dis = Math.abs(pos2 - pos1);
            return Math.min(dis, N - dis);
        }

        class Node {
            int pos;
            int cnt;

            public Node(int pos, int cnt) {
                this.pos = pos;
                this.cnt = cnt;
            }
        }
    }
}

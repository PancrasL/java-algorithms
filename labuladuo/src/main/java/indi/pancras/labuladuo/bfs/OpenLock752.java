package indi.pancras.labuladuo.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class OpenLock752 {
    class Solution {
        private Map<String, Integer> visit = new HashMap<>();
        private Set<String> deadSet = new HashSet<>();

        public int openLock(String[] deadends, String target) {
            deadSet.addAll(Arrays.asList(deadends));
            return bfs("0000", target);
        }

        private int bfs(String start, String target) {
            if (deadSet.contains(start)) {
                return -1;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            visit.put(start, 1);
            int size;
            int step = 0;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                    if (poll.equals(target)) {
                        return step;
                    }
                    for (int j = 0; j < 4; j++) {
                        String nextUp = up(poll, j);
                        if (!visit.containsKey(nextUp) && !deadSet.contains(nextUp)) {
                            visit.put(nextUp, 1);
                            queue.add(nextUp);
                        }
                        String nextDown = down(poll, j);
                        if (!visit.containsKey(nextDown) && !deadSet.contains(nextDown)) {
                            visit.put(nextDown, 1);
                            queue.add(nextDown);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        // 将第i位向大拨动
        String up(String str, int i) {
            byte[] next = str.getBytes();
            if (next[i] == '9') {
                next[i] = '0';
            } else {
                next[i] = (byte) (next[i] + 1);
            }
            return new String(next);
        }

        // 将第i位向小拨动
        String down(String str, int i) {
            byte[] next = str.getBytes();
            if (next[i] == '0') {
                next[i] = '9';
            } else {
                next[i] = (byte) (next[i] - 1);
            }
            return new String(next);
        }
    }
}

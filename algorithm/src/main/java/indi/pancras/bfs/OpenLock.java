package indi.pancras.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author pancras
 * @解题思路 BFS，使用 addOne 和 minusOne 简化代码
 * @create 2021/3/17 11:09
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/kj48j/">打开转盘锁</a>
 */
public class OpenLock {
    public int run(String[] deadends, String target) {
        return new Solution().openLock(deadends, target);
    }

    class Solution {

        public int openLock(String[] deadends, String target) {
            Queue<String> queue = new LinkedList<>();

            Map<String, Integer> dead = new HashMap<>();

            int step = 0;
            queue.add("0000");

            for (String s : deadends) {
                dead.put(s, 1);
            }

            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String front = queue.poll();
                    if (front.equals(target)) {
                        return step - 1;
                    }
                    if (!dead.containsKey(front)) {
                        dead.put(front, 1);
                        for (int j = 0; j < front.length(); j++) {
                            queue.add(addOne(front, j));
                            queue.add(minusOne(front, j));
                        }
                    }
                }

            }

            return -1;
        }

        private String addOne(String s, int i) {
            char[] chars = s.toCharArray();
            if (chars[i] == '9') {
                chars[i] = '0';
            } else {
                chars[i] += 1;
            }
            return new String(chars);
        }

        private String minusOne(String s, int i) {
            char[] chars = s.toCharArray();
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
            }
            return new String(chars);
        }
    }
}

package indi.pancras.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// TODO:动态规划解法
public class UglyNumber49 {
    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            Set<Long> visited = new HashSet<>();
            queue.add(1L);
            int cnt = 0;
            while (true) {
                Long num = queue.poll();
                if (visited.contains(num)) {
                    continue;
                }
                visited.add(num);
                if (++cnt == n) {
                    return num.intValue();
                }
                queue.add(2 * num);
                queue.add(3 * num);
                queue.add(5 * num);
            }
        }
    }

    class Solution1 {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(num2, Math.min(num3, num5));
                if (num2 == dp[i]) {
                    p2++;
                }
                if (num3 == dp[i]) {
                    p3++;
                }
                if (num5 == dp[i]) {
                    p5++;
                }
            }
            return dp[n];
        }
    }
}

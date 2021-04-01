package indi.pancras.recursion;

/**
 * @author pancras
 * @create 2021/3/30 16:42
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/4d0d7/">爬楼梯</a>
 */
public class ClimbStairs {
    class Solution {
        private final int[] cache = new int[10001];

        public int climbStairs(int n) {
            if (cache[n] != 0)
                return cache[n];
            return (n == 0 || n == 1) ? (cache[n] = 1) : (cache[n] = climbStairs(n - 1) + climbStairs(n - 2));
        }
    }
}

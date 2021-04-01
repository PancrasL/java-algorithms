package indi.pancras.recursion;

/**
 * @author pancras
 * @create 2021/3/30 16:38
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/4wi01/">斐波那契数</a>
 */
public class FibNum {

    class Solution {
        public int fib(int n) {
            return (n == 0 || n == 1) ? n : fib(n - 1) + fib(n - 2);
        }
    }
}

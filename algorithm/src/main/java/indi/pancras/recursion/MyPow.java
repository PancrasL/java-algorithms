package indi.pancras.recursion;

/**
 * @author pancras
 * @tip a^n = (a^n/2)*(a^n/2)
 * @create 2021/3/31 11:30
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/4t1eg/">pow(x,n)</a>
 */
public class MyPow {
    public double run(double x, int n) {
        return new Solution().myPow(x, n);
    }

    class Solution {
        public double myPow(double x, int n) {
            return n >= 0 ? powHelper(x, n) : (1.0 / powHelper(x, -n));
        }

        private double powHelper(double x, int n) {
            if (n == 0)
                return 1;
            double answer = powHelper(x, n / 2);
            answer *= answer;
            return (n & 1) == 1 ? answer * x : answer;
        }
    }
}

package indi.pancras.math;

/**
 * @author pancras
 * @create 2021/4/6 16:35
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/">整数反转</a>
 */
public class ReverseInt {

    class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                result = 10 * result + x % 10;
                x /= 10;
            }
            return result;
        }
    }
}

package indi.pancras.bitoperation;

/**
 * @author pancras
 * @tip 混合位运算
 * @create 2021/4/8 17:04
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnc5vg/">颠倒二进制位</a>
 */
public class ReverseBits {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result |= (n & 1);
                n >>>= 1;
            }
            return result;
        }
    }
}

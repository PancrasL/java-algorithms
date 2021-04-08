package indi.pancras.bitoperation;

/**
 * @author pancras
 * @tip 移位
 * @create 2021/4/8 16:56
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn1m0i/">位1的个数</a>
 */
public class HammingWeight {
    public int run(int n) {
        return new Solution().hammingWeight(n);
    }

    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += n & 1;
                n >>>= 1;
            }
            return count;
        }
    }
}

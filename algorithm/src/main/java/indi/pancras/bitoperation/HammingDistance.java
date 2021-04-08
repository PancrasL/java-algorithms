package indi.pancras.bitoperation;

/**
 * @author pancras
 * @tip 移位+异或
 * @create 2021/4/8 17:01
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnyode/">汉明距离</a>
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += (x & 1) ^ (y & 1);
                x >>>= 1;
                y >>>= 1;
            }
            return count;
        }
    }
}

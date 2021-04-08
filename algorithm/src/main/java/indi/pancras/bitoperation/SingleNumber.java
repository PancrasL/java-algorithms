package indi.pancras.bitoperation;

/**
 * @author pancras
 * @tip 位运算
 * @create 2021/4/1 19:55
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xhsyr2/">只出现一次的数字</a>
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }

            return ans;
        }
    }
}

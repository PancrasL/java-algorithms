package indi.pancras.bitoperation;

/**
 * @author pancras
 * @tip 和自然数[1, n]异或
 * @create 2021/4/8 17:11
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/">缺失的数字</a>
 */
public class LossNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result ^= (i ^ nums[i]);
            }
            result ^= nums.length;
            return result;
        }
    }
}

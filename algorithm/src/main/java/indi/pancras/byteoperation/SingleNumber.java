package indi.pancras.byteoperation;

/**
 * @author pancras
 * @tip 按位异或
 * @create 2021/4/3 15:25
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/">只出现一次的数字</a>
 */
public class SingleNumber {
    public int run(int[] nums) {
        return new Solution().singleNumber(nums);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
}

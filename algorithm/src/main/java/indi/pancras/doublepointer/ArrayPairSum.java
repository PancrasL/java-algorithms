package indi.pancras.doublepointer;

import java.util.Arrays;

/**
 * @author pancras
 * @tip
 * @create 2021/3/15 11:01
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c24he/">数组拆分 I</a>
 */
public class ArrayPairSum {
    public int run(int[] nums) {
        Solution sl = new Solution();

        return sl.arrayPairSum(nums);
    }

    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int p = 0;

            int result = 0;
            while (p < nums.length) {
                result += nums[p];
                p += 2;
            }

            return result;
        }
    }
}

package indi.pancras.sort;

import java.util.Arrays;

/**
 * @author pancras
 * @tip 排序 + 遍历
 * @create 2021/4/2 10:39
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/">存在重复元素</a>
 */
public class ContainDuplicate {
    public boolean run(int[] nums) {
        return new Solution().containsDuplicate(nums);
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;

            int[] numsCp = new int[nums.length];
            System.arraycopy(nums, 0, numsCp, 0, nums.length);

            Arrays.sort(numsCp);

            for (int i = 1; i < nums.length; i++) {
                if (numsCp[i] == numsCp[i - 1])
                    return true;
            }

            return false;
        }
    }
}

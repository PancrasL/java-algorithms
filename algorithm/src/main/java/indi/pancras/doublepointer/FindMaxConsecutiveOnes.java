package indi.pancras.doublepointer;

/**
 * @author pancras
 * @解题思路 双指针寻找所有连续的‘1’序列，输出最长的长度
 * @create 2021/3/15 17:23
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cd71t/">最大连续1的个数</a>
 */
public class FindMaxConsecutiveOnes {
    public int run(int[] nums) {
        return new Solution().findMaxConsecutiveOnes(nums);
    }

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;

            int left, right;
            left = right = 0;

            while (true) {
                left = findNextOne(nums, right);
                right = findNextZero(nums, left);
                if (right - left > result) {
                    result = right - left;
                }
                if (right == nums.length) {
                    break;
                }
            }

            return result;
        }

        private int findNextOne(int[] nums, int start) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 1) {
                    return i;
                }
            }
            return nums.length;
        }

        private int findNextZero(int[] nums, int start) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 0) {
                    return i;
                }
            }
            return nums.length;
        }
    }
}

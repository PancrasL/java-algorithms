package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 双指针
 * @create 2021/3/16 16:36
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c3ki5/">寻找旋转排序数组中的最小值</a>
 */
public class FindMinInRotateArray {
    public int run(int[] nums) {
        return new Solution().findMin(nums);
    }

    class Solution {
        public int findMin(int[] nums) {
            int last = 0;
            int cur = 1;
            while (cur < nums.length) {
                if (nums[cur++] < nums[last++]) {
                    return nums[cur - 1];
                }
            }
            return nums[0];
        }
    }
}

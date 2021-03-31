package indi.pancras.array;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 * @tip 二分查找
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/">搜素插入位置</a>
 */
public class SearchInsert {
    public int run(int[] nums, int target) {
        Solution s = new Solution();
        return s.searchInsert(nums, target);
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low, high, mid;

            low = 0;
            high = nums.length - 1;
            //避免溢出
            mid = ((high - low) >> 1) + low;

            while (low <= high) {
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                mid = ((high - low) >> 1) + low;
            }
            return low;
        }
    }
}

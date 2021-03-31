package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 双指针
 * @create 2021/3/16 16:45
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cq376/">删除排序数组中的重复项</a>
 */
public class RemoveDuplicate {
    public int run(int[] nums) {
        return new Solution().removeDuplicates(nums);
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int fast = 0;

            while (fast < nums.length) {
                if (nums[slow] == nums[fast]) {
                    fast++;
                } else {
                    while (fast + 1 < nums.length && nums[fast] == nums[fast + 1]) {
                        fast++;
                    }
                    nums[++slow] = nums[fast];
                }
            }

            return slow + 1;
        }
    }
}

package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 用双指针模拟队列：右侧入队直到>target → 左侧出队直到<target → 更新result → 重复执行第一步
 * @create 2021/3/15 19:43
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c0w4r/">长度最小的子数组</a>
 */
public class MinSubArrayLen {
    public int run(int target, int[] nums) {
        return new Solution().minSubArrayLen(target, nums);
    }

    class Solution {
        final int INT_MAX = 0x3f3f3f3f;

        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;

            int sum = 0;
            int result = INT_MAX;
            while (true) {
                // 从右侧开始入队
                while (sum < target && right < nums.length) {
                    sum += nums[right++];
                }
                if (sum < target && right == nums.length) {
                    break;
                }

                // 从左侧开始出队
                while (sum >= target) {
                    sum -= nums[left++];
                }

                // 更新result，子区间为 nums[left-1, right)，长度为right - left + 2
                if (right - left + 1 < result) {
                    result = right - left + 1;
                }
            }

            return result == INT_MAX ? 0 : result;
        }
    }
}

package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 快慢指针
 * @create 2021/3/15 15:02
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cwuyj/">去除重复元素</a>
 */
public class RemoveElement {
    public int run(int[] nums, int val) {
        Solution sl = new Solution();

        return sl.removeElement(nums, val);
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            int fast = 0;

            // 找到 val 第一次出现的位置
            while (slow < nums.length) {
                if (nums[slow] != val) {
                    slow++;
                } else {
                    break;
                }
            }
            // nums中没有val
            if (slow == nums.length) {
                return nums.length;
            }

            // 将 fast 定位到slow后面第一个不等于 val 的位置
            for (fast = slow; fast < nums.length && nums[fast] == val; fast++) ;
            // slow后面没有val
            if (fast == nums.length) {
                return slow;
            }

            while (fast < nums.length) {
                nums[slow++] = nums[fast++];
                while (fast < nums.length && nums[fast] == val) {
                    fast++;
                }
            }

            return slow;
        }
    }
}

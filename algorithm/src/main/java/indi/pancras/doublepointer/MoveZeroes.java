package indi.pancras.doublepointer;

/**
 * @author pancras
 * @解题思路 双指针，慢指针顺序遍历，快指针跳过0遍历，最后把慢指针之后的元素置零
 * @create 2021/3/16 19:58
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c6u02/">移动零</a>
 */
public class MoveZeroes {
    public int[] run(int[] nums) {
        new Solution().moveZeroes(nums);

        return nums;
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            int fast = 0;

            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    fast++;
                } else {
                    nums[slow++] = nums[fast++];
                }
            }
            while (slow < nums.length) {
                nums[slow++] = 0;
            }
        }
    }
}

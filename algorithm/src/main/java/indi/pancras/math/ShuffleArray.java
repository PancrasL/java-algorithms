package indi.pancras.math;

import java.util.Arrays;

/**
 * @author pancras
 * @tip 遍历一遍数组，将nums[i]和其后的随机元素交换位置
 * @create 2021/4/8 16:07
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn6gq1/">打乱数组</a>
 */
public class ShuffleArray {

    class Solution {
        int[] originNums;
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            this.originNums = Arrays.copyOf(nums, nums.length);
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            nums = Arrays.copyOf(originNums, originNums.length);
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                int ranIndex = (int) (Math.random() * (nums.length - i) + i);
                int temp = nums[ranIndex];
                nums[ranIndex] = nums[i];
                nums[i] = temp;
            }

            return nums;
        }
    }
}
package indi.pancras.offer;

public class Exchange21 {
    class Solution {
        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[right] % 2 == 1) {
                    swap(nums, left, right);
                    left++;
                    right--;
                } else {
                    right--;
                }
            }
            return nums;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}

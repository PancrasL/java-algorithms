package indi.pancras.offer;

public class TwoSum57 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 1) {
                return new int[0];
            }
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[0];
        }
    }
}

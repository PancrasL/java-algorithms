package indi.pancras.labuladuo.binarysearch;

public class SearchRange34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int mid = binarysearch(nums, target);
            if (mid == -1) {
                return new int[]{-1, -1};
            }
            int leftBound = mid;
            int rightBound = mid;
            while (leftBound - 1 >= 0 && nums[leftBound - 1] == nums[mid]) {
                leftBound--;
            }
            while (rightBound + 1 < nums.length && nums[rightBound + 1] == nums[mid]) {
                rightBound++;
            }
            return new int[]{leftBound, rightBound};
        }

        private int binarysearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}

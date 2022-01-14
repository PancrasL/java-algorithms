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

    static class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{binarySearchLeft(nums, target), binarySearchRight(nums, target)};
        }

        public int binarySearchLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        private int binarySearchRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {// 从左侧查找
                    right = mid - 1;
                } else {//从右侧查找
                    left = mid + 1;
                }
            }
            if (right == -1 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int res = s.binarySearchRight(new int[]{1, 2, 2, 3, 4, 5}, 2);
        System.out.println(res);
    }
}

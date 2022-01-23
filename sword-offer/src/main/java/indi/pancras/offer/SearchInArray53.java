package indi.pancras.offer;

public class SearchInArray53 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{1, 3, 5}, 3));
        System.out.println(s.search(new int[]{1, 3, 5}, 4));
        System.out.println(s.search(new int[]{1, 3, 5}, 6));
        System.out.println(s.search(new int[]{1, 3, 5}, 0));
        System.out.println(s.search(new int[]{1}, 1));
        System.out.println(s.search(new int[]{1, 1}, 1));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = findLeft(nums, target);
            if (left == -1) {
                return 0;
            }
            int right = findRight(nums, target);
            return right - left + 1;
        }

        private int findLeft(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (target > nums[mid]) {
                    low = mid + 1;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    high = mid - 1;
                }
            }
            if (low == nums.length || nums[low] != target) {//没找到
                return -1;
            }
            return low;
        }

        private int findRight(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (target > nums[mid]) {
                    low = mid + 1;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (high == -1 || nums[high] != target) {//没找到
                return -1;
            }
            return high;
        }
    }
}

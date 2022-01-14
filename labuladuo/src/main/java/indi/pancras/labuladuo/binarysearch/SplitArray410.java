package indi.pancras.labuladuo.binarysearch;

public class SplitArray410 {
    static class Solution {
        public int splitArray(int[] nums, int m) {
            int left = 1;
            int right = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (isPossible(nums, mid, m)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }

        // 将数组nums分为m个子数组，确保每个子数组和不超过sum能否实现
        private boolean isPossible(int[] nums, int sum, int m) {
            int index = 0;
            for (int i = 0; i < m; i++) {
                int arrSum = 0;
                while (index < nums.length && nums[index] + arrSum < sum) {
                    arrSum += nums[index];
                    index++;
                }
                if (index == nums.length) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        s.splitArray(new int[]{7,2,5,10,8},2);
    }
}

package indi.pancras.labuladuo.sort;

import java.util.Arrays;

public class QsortKthLargest215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            qsort(nums, 0, nums.length - 1);
            int i = nums.length - 1;
            while (i >= 0) {
                if (k == 1) {
                    return nums[i];
                }
                k--;
                i--;
            }
            return -1;
        }

        private void qsort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int index = findIndex(nums, start, end);
            qsort(nums, start, index - 1);
            qsort(nums, index + 1, end);
        }

        private int findIndex(int[] nums, int start, int end) {
            int temp = nums[start];

            // isStart=true，从前向后；isStart=false，从后向前
            boolean isStart = false;
            while (start != end) {
                while (start != end && nums[end] >= temp) {
                    end--;
                }
                nums[start] = nums[end];
                while (start != end && nums[start] <= temp) {
                    start++;
                }
                nums[end] = nums[start];
            }
            nums[start] = temp;
            return start;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{6, 5, 4, 3,3,4,2,2,2, 2, 1};
        s.qsort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

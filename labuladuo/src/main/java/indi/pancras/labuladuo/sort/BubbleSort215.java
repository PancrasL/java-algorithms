package indi.pancras.labuladuo.sort;

import java.util.Arrays;

public class BubbleSort215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            bubbleSort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                if (k == 1) {
                    return nums[i];
                }
                k--;
            }
            return -1;
        }

        private void bubbleSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j < nums.length - i; j++) {
                    if (nums[j - 1] > nums[j]) {
                        swap(nums, j - 1, j);
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{
                6, 5, 4, 3,3,4,2,2,2, 2, 1
        };
        s.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

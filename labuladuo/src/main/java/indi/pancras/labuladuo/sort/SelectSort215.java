package indi.pancras.labuladuo.sort;

import java.util.Arrays;

public class SelectSort215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            selectSort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                if (k == 1) {
                    return nums[i];
                }
                k--;
            }
            return -1;
        }

        public void selectSort(int[] nums) {
            // 选择n次，每次将最小的元素放到最前面
            for (int i = 0; i < nums.length; i++) {
                // 找到最小元素下标
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(nums, i, minIndex);
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
        int[] nums = new int[]{3,2,1,5,6,4};
        s.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

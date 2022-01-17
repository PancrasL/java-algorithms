package indi.pancras.labuladuo.backtrack;

import java.util.Arrays;

public class KSubsets698 {
    // 把数字放入桶中
    static class Solution {
        // k个桶，将数字装入桶中，当数字装完后，判断桶中数字之和是否相等
        private int[] buckets;
        // 如果可以划分，那么平均每个桶数字之和为average，由于nums中的数都是非负数，因此可以使用average进行剪枝
        private int average;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            buckets = new int[k];
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            average = sum / k;
            Arrays.sort(nums);
            return backtrack(nums, nums.length - 1);
        }

        private boolean backtrack(int[] nums, int index) {
            if (index == -1) {
                for (int i = 1; i < buckets.length; i++) {
                    if (buckets[i] != buckets[i - 1]) {
                        return false;
                    }
                }
                return true;
            }

            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] + nums[index] > average) {
                    continue;
                }
                buckets[i] += nums[index];
                if (backtrack(nums, index - 1)) {
                    return true;
                }
                buckets[i] -= nums[index];
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{98, 102, 9, 36, 57, 44, 30, 35, 28, 9851, 90, 29, 9751, 44, 66, 9652};
        boolean b = s.canPartitionKSubsets(nums, 8);
        System.out.println(b);
    }
}

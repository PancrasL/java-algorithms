package indi.pancras.labuladuo.datastructure.array;

public class SubArraySum560 {
    class Solution {
        private int[] sum;

        public int subarraySum(int[] nums, int k) {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int subArrSum;
                    if (i == 0) {
                        subArrSum = sum[j];
                    } else {
                        subArrSum = sum[j] - sum[i - 1];
                    }
                    if (subArrSum == k) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
}

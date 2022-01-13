package indi.pancras.labuladuo.datastructure.array;

public class NumArray303 {
    class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum[0] = nums[0];
                } else {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sum[right];
            } else {
                return sum[right] - sum[left - 1];
            }
        }
    }
}

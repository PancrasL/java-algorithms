package indi.pancras.labuladuo.dynamic;

public class Fib509 {
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int[] nums = new int[n + 1];
            nums[1] = 1;
            nums[0] = 0;
            for (int i = 2; i <= n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n];
        }
    }
}

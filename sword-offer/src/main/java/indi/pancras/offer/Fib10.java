package indi.pancras.offer;

public class Fib10 {
    class Solution {
        private final long MOD = 1000000007;

        public int fib(int n) {
            long[] nums = new long[n + 2];
            nums[0] = 0;
            nums[1] = 1;
            for (int i = 2; i <= n; i++) {
                nums[i] = (nums[i - 1] + nums[i - 2]) % MOD;
            }
            return (int) nums[n];
        }
    }
}

package indi.pancras.labuladuo.math;

public class PowerOfTwo231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return (n & (n - 1)) == 0;
        }
    }
}

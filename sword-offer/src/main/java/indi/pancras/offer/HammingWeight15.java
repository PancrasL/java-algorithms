package indi.pancras.offer;

public class HammingWeight15 {
    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            while (n != 0) {
                cnt++;
                // 消除最右边的1
                n = n & (n - 1);
            }
            return cnt;
        }
    }
}

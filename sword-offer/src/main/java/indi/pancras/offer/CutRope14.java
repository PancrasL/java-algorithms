package indi.pancras.offer;

public class CutRope14 {
    class Solution {
        // 尽量将绳子分为3的小段
        public int cuttingRope(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            //尽可能多的去减长度为3的绳子段
            int timesOf3 = n / 3;
            //当绳子剩下长度为4的时候，需要剪成两个长度为2的绳子段（因为2*2 > 3*1）
            if (n - timesOf3 * 3 == 1) {
                timesOf3 -= 1;
            }
            int timesOf2 = (n - timesOf3 * 3) / 2;
            long a = 1;
            for (int i = 0; i < timesOf3; i++) {
                a = a * 3 % 1000000007;
            }
            long b = (long) (Math.pow(2, timesOf2));
            return (int) ((a * b) % 1000000007);
        }
    }
}

package indi.pancras.offer;

public class MyPow16 {
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return n == 0 ? 1 : 0;
            }
            boolean nagetive = false;
            if (n < 0) {
                nagetive = true;
                n = -n;
            }
            return nagetive ? 1 / powHelper(x, n) : powHelper(x, n);
        }

        private double powHelper(double x, long n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            double res = powHelper(x, n / 2);
            if ((n & 1) == 1) {// n是奇数
                return res * res * x;
            } else {
                return res * res;
            }
        }
    }
}

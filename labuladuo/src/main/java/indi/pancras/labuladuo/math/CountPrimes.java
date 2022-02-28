package indi.pancras.labuladuo.math;

public class CountPrimes {
    class Solution {
        boolean[] flag;

        public int countPrimes(int n) {
            flag = new boolean[n];
            for (int i = 2; i < n / 2; i++) {
                for (int j = 2; j * i < n; j++) {
                    flag[i * j] = true;
                }
            }
            int res = 0;
            for (int i = 2; i <= n; i++) {
                if (!flag[i]) {
                    res++;
                }
            }
            return res;
        }
    }
}

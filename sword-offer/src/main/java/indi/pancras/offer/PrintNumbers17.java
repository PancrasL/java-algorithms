package indi.pancras.offer;

public class PrintNumbers17 {
    class Solution {
        public int[] printNumbers(int n) {
            int bound = 1;
            for (int i = 0; i < n; i++) {
                bound *= 10;
            }
            int[] res = new int[bound - 1];
            for (int i = 1; i < bound; i++) {
                res[i - 1] = i;
            }
            return res;
        }
    }
}

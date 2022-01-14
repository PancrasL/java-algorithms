package indi.pancras.labuladuo.random;

import java.util.Random;

public class PickIndex528 {
    class Solution {
        // 桩
        int[] piles;
        // 所有权重之和
        int total;

        public Solution(int[] w) {
            piles = new int[w.length + 1];
            piles[0] = 0;
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                piles[i + 1] = total;
            }
        }

        public int pickIndex() {
            int random = new Random().nextInt(total) + 1;
            return binarySearch(random);
        }

        private int binarySearch(int target) {
            int left = 0;
            int right = piles.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == piles[mid]) {
                    return mid - 1;
                } else if (target < piles[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left - 1;
        }
    }
}

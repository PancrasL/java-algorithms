package indi.pancras.labuladuo.binarysearch;

public class KeKeEatingbananas875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int maxK = piles[0];
            for (int pile : piles) {
                maxK = Math.max(maxK, pile);
            }
            int left = 1;
            int right = maxK;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossible(piles, mid, h)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // 计算以速度k吃香蕉，能否在h小时内吃完
        private boolean isPossible(int[] piles, int k, int h) {
            int totalH = 0;
            for (int pile : piles) {
                totalH += (pile - 1) / k + 1;
                if (totalH > h) {
                    return false;
                }
            }
            return true;
        }
    }
}

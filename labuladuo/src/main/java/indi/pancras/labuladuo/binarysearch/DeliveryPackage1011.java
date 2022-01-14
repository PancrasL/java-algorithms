package indi.pancras.labuladuo.binarysearch;

public class DeliveryPackage1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int maxWeight = 0;
            int totalWeight = 0;
            for (int weight : weights) {
                maxWeight = Math.max(maxWeight, weight);
                totalWeight += weight;
            }
            int left = maxWeight;
            int right = totalWeight;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossible(weights, mid, days)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // 判断负载为load的情形下，能否在days天将weights运送完毕
        private boolean isPossible(int[] weights, int load, int days) {
            int index = 0;
            for (int i = 0; i < days; i++) {
                int totalWeight = 0;
                while (index < weights.length && totalWeight + weights[index] <= load) {
                    totalWeight += weights[index];
                    index++;
                }
                if (index == weights.length) {
                    return true;
                }
            }
            return false;
        }
    }
}

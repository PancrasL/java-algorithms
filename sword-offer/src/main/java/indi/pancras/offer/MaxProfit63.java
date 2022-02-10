package indi.pancras.offer;

public class MaxProfit63 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }
            int minPrice = prices[0];
            int profit = 0;
            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                profit = price - minPrice;
            }
            return profit;
        }
    }
}

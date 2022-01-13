package indi.pancras.labuladuo.stock;

public class BuyStock121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }

            int minPrice;
            minPrice = prices[0];
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                profit = Math.max(profit, prices[i] - minPrice);
            }
            return profit;
        }
    }
}

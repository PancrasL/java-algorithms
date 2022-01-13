package indi.pancras.labuladuo.stock;

public class BuyStockTwo122 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int buyPrice = prices[0];
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buyPrice) {
                    buyPrice = prices[i];
                } else if (prices[i] > buyPrice) {
                    profit += prices[i] - buyPrice;
                    buyPrice = prices[i];
                }
            }
            return profit;
        }
    }
}

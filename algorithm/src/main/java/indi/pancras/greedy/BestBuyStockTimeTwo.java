package indi.pancras.greedy;

/**
 * @author pancras
 * @tip 贪心算法
 * @create 2021/4/1 15:33
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/">买卖股票的最佳时机
 * II</a>
 */
public class BestBuyStockTimeTwo {
    public int run(int[] prices) {
        return new Solution().maxProfit(prices);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1)
                return 0;

            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                }
            }

            return profit;
        }
    }
}

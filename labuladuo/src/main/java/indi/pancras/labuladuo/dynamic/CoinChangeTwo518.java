package indi.pancras.labuladuo.dynamic;

public class CoinChangeTwo518 {
    class Solution {
        public int change(int amount, int[] coins) {
            if (amount == 0) {
                return 1;
            }
            // dp[i]凑成i元的种类数
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = 0; i <= amount; i++) {
                    if (i - coin >= 0) {
                        dp[i] += dp[i - coin];
                    }
                }
            }
            return dp[amount];
        }
    }
}

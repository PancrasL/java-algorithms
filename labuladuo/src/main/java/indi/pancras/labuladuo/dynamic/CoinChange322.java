package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class CoinChange322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // counts[i]表示兑换i元的最少硬币数
            int[] counts = new int[amount + 1];
            Arrays.fill(counts, -1);
            counts[0] = 0;
            for (int i = 0; i <= amount; i++) {
                if (counts[i] == -1) {
                    continue;
                }
                // 最少用counts[i]个硬币可以组合成i元，拿counts[i]+1和counts[i+coin]对比更新
                for (int coin : coins) {
                    if (coin > amount) {
                        continue;
                    }
                    int sum = i + coin;
                    if (sum <= amount) {
                        if (counts[sum] == -1 || counts[i] + 1 < counts[sum]) {
                            counts[sum] = counts[i] + 1;
                        }
                    }
                }
            }
            return counts[amount];
        }
    }

    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {// 子问题无解
                        continue;
                    }
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}

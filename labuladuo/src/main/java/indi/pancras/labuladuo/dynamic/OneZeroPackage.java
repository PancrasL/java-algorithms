package indi.pancras.labuladuo.dynamic;

public class OneZeroPackage {
    class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可 计算01背包问题的结果
         *
         * @param V  int整型 背包的体积
         * @param n  int整型 物品的个数
         * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
         * @return int整型
         */
        public int knapsack(int V, int n, int[][] vw) {
            // dp[i][j]记录前i件商品，背包容量为j时所能装下的最大重量
            int[][] dp = new int[n][V + 1];
            // base：装入第0件商品
            for (int volume = 0; volume <= V; volume++) {
                if (volume >= vw[0][0]) {
                    dp[0][volume] = vw[0][1];
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= V; j++) {
                    if (vw[i][0] > j) {//第i件商品的体积大于背包容量，无法装入
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i][0]] + vw[i][1]);
                    }
                }
            }
            return dp[n - 1][V];
        }
    }
}

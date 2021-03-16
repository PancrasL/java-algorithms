package indi.pancras.dynamic;

/**
 * @author pancras
 * @解题思路 动态规划，i从1到n，依次寻找i的最优值
 * @create 2021/3/22 11:03
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/kfgtt/">完全平方数</a>
 */
public class NumSquares {
    public int run(int n) {
        return new Solution().numSquares(n);
    }

    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[10001];

            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                int j = 1;
                while (j * j <= i) {
                    int dp1 = dp[i - j * j] + 1;
                    if (dp1 < dp[i]) {
                        dp[i] = dp1;
                    }
                    j++;
                }
            }
            return dp[n];
        }
    }
}

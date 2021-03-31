package indi.pancras.dfs;

/**
 * @author pancras
 * @tip 使用递归，枚举所有可能出现的情况，即处理到第i个数时，采取+i和-i两种方式向下搜索。
 * @create 2021/3/23 15:23
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/ga4o2/">目标和</a>
 */
public class TargetSum {
    public int run(int[] nums, int S) {
        return new Solution().findTargetSumWays(nums, S);
    }

    class Solution {
        //TODO 01背包问题，使用动态规划求解
        public int findTargetSumWays(int[] nums, int S) {
            return (int) DFS(nums, 0, S, 0);
        }

        private long DFS(int[] nums, int index, long targetSum, long curSum) {
            if (index == nums.length) {
                return curSum == targetSum ? 1 : 0;
            }
            long result = 0;

            result += DFS(nums, index + 1, targetSum, curSum + nums[index]);
            result += DFS(nums, index + 1, targetSum, curSum - nums[index]);

            return result;
        }
    }
}

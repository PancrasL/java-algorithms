package indi.pancras.dynamic;

/**
 * @author pancras
 * @tip 动态规划：dp[i]=max(dp[i−2]+nums[i],dp[i−1])
 * @create 2021/4/8 11:40
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/">打家劫舍</a>
 */
public class Rob {
    public int run(int[] nums) {
        return new Solution().rob(nums);
    }

    class Solution {
        public int rob(int[] nums) {
            int[] amount = new int[nums.length + 1];

            amount[0] = 0;
            amount[1] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                amount[i + 1] = Math.max(amount[i - 1] + nums[i], amount[i]);
            }

            return amount[nums.length];
        }
    }
}

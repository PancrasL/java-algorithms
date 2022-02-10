package indi.pancras.dynamic;

public class TargetSum494 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        int res1 = s.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
        System.out.println(res);
        System.out.println(res1);
    }

    static class Solution {
        int offset;
        int[][] dp;

        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            offset = sum;
            // dp[i][j]表示前i个数，和为j的方案数
            dp = new int[nums.length][2 * sum + 1];
            set(0, nums[0], 1);
            set(0, -nums[0], get(0, -nums[0]) + 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = -sum; j <= sum; j++) {
                    int val = get(i - 1, j - nums[i]) + get(i - 1, j + nums[i]);
                    set(i, j, val);
                }
            }
            return get(nums.length - 1, target);
        }

        private int get(int i, int j) {
            int index = j + offset;
            if (index >= 0 && index < dp[0].length) {
                return dp[i][index];
            }
            return 0;
        }

        private void set(int i, int j, int val) {
            dp[i][j + offset] = val;
        }
    }
}

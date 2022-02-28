package indi.pancras.labuladuo.backtrack;

public class FindTargetSumWays494 {
    class Solution {
        int cnt = 0;

        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums, 0, 0, target);
            return cnt;
        }

        private void backtrack(int[] nums, int index, int curSum, int target) {
            if (index == nums.length) {
                if (curSum == target) {
                    cnt++;
                }
                return;
            }
            backtrack(nums, index + 1, curSum + nums[index], target);
            backtrack(nums, index + 1, curSum - nums[index], target);
        }
    }
}

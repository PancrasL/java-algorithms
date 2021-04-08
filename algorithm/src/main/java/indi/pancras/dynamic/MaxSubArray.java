package indi.pancras.dynamic;

/**
 * @author pancras
 * @tip 动态规划 f(i)=max{f(i−1)+nums[i],nums[i]}
 * @create 2021/4/8 11:28
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/">最大子序和</a>
 */
public class MaxSubArray {
    public int run(int[] nums) {
        return new Solution().maxSubArray(nums);
    }

    class Solution {
        public int maxSubArray(int[] nums) {

            int maxSum = nums[0];
            int tempSum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (tempSum < 0) {
                    tempSum = nums[i];
                } else {
                    tempSum += nums[i];
                }
                if (tempSum > maxSum)
                    maxSum = tempSum;
            }
            if (tempSum > maxSum)
                maxSum = tempSum;
            return maxSum;
        }
    }
}

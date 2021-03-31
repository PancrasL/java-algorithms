package indi.pancras.array;


/**
 * @author pancras
 * @create 2021/3/11 16:49
 * @tip 第一遍遍历数组计算累加和，第二遍遍历数组寻找中间索引。
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/">寻找数组的中心索引</a>
 */
public class PivotIndex {
    public int run(int[] nums) {
        Solution s = new Solution();
        return s.pivotIndex((nums));
    }

    class Solution {
        public int pivotIndex(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }

            int[] sum = new int[nums.length];

            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            int total = sum[nums.length - 1];

            // 左边界
            if (total - sum[0] == 0) {
                return 0;
            }
            for (int i = 1; i < nums.length; i++) {
                if (sum[i - 1] + sum[i] == total) {
                    return i;
                }
            }
            return -1;
        }
    }
}

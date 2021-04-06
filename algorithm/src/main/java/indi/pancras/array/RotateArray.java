package indi.pancras.array;

/**
 * @author pancras
 * @tip 环状替换，将被替换的元素保存在变量 startNum 中，从而避免了额外数组的开销。
 * @create 2021/4/2 9:51
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/">旋转数组</a>
 */
public class RotateArray {
    public int[] run(int[] nums, int k) {
        new Solution().rotate(nums, k);
        return nums;
    }

    class Solution {
        public void rotate(int[] nums, int k) {

            if (k == 0 || nums == null || nums.length == 0) {
                return;
            }

            k %= nums.length;
            int count = gcd(nums.length, k);
            for (int i = 0; i < count; i++) {
                int startNum = nums[i];
                int startIndex = i;

                do {
                    int newPos = (startIndex + k) % nums.length;
                    int temp = nums[newPos];
                    nums[newPos] = startNum;
                    startNum = temp;
                    startIndex = newPos;
                } while (startIndex != i);
            }
        }

        private int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }
}

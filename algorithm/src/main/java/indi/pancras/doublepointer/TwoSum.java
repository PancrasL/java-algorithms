package indi.pancras.doublepointer;

import java.util.Arrays;

/**
 * @author pancras
 * @create 2021/3/15 14:09
 * @解题思路 二分查找法：略  双指针法：左右指针向中间靠拢，和大了右指针左移，和小了左指针右移
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cnkjg/">两数之和 II - 输入有序数组</a>
 */
public class TwoSum {
    public int[] run(int[] numbers, int target) {
        Solution sl = new Solution();
        return sl.twoSum(numbers, target);
    }

    public int[] run1(int[] numbers, int target) {
        Solution sl = new Solution();
        return sl.twoSum1(numbers, target);
    }

    class Solution {
        // 二分查找法
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[]{-1, -1};

            for (int i = 0; i < numbers.length; i++) {
                int index = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
                if (index >= 0) {
                    result[0] = i + 1;
                    result[1] = index + 1;
                    break;
                }
            }

            return result;
        }

        // 双指针法
        public int[] twoSum1(int[] numbers, int target) {
            int left, right;
            left = 0;
            right = numbers.length - 1;

            int[] result = new int[]{-1, -1};

            while (left < right) {
                // 和小了左指针右移
                if (numbers[left] + numbers[right] < target) {
                    left++;
                }
                // 和大了右指针左移
                else if (numbers[left] + numbers[right] > target) {
                    right--;
                }
                // 和等了退出循环
                else {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    break;
                }
            }

            return result;
        }
    }
}

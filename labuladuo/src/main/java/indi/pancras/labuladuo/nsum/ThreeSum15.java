package indi.pancras.labuladuo.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length <= 2) {
                return result;
            }
            Arrays.sort(nums);

            // 固定第一个数，将问题转换为两数之和
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return result;
                }
                // 跳过重复元素
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (nums[i] + sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
}

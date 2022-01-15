package indi.pancras.labuladuo.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length <= 3) {
                return result;
            }
            Arrays.sort(nums);
            // 固定前两个数，将问题转换为两数之和
            for (int aIndex = 0; aIndex < nums.length; aIndex++) {
                for (int bIndex = aIndex + 1; bIndex < nums.length; bIndex++) {
                    int abSum = nums[aIndex] + nums[bIndex];
                    int cIndex = bIndex + 1;
                    int dIndex = nums.length - 1;
                    while (cIndex < dIndex) {
                        int cdSum = nums[cIndex] + nums[dIndex];
                        if (abSum + cdSum == target) {
                            result.add(Arrays.asList(nums[aIndex], nums[bIndex], nums[cIndex], nums[dIndex]));
                            while (cIndex < dIndex && nums[cIndex] == nums[cIndex + 1]) {
                                cIndex++;
                            }
                            cIndex++;
                            while (cIndex < dIndex && nums[dIndex - 1] == nums[dIndex]) {
                                dIndex--;
                            }
                            dIndex--;
                        } else if (abSum + cdSum < target) {
                            cIndex++;
                        } else {
                            dIndex--;
                        }
                    }
                    while (bIndex + 1 < nums.length && nums[bIndex] == nums[bIndex + 1]) {
                        bIndex++;
                    }
                    while (aIndex < bIndex && nums[aIndex] == nums[aIndex + 1]) {
                        aIndex++;
                    }
                }
            }
            return result;
        }
    }
}

package indi.pancras.offer;

import java.util.Arrays;

public class IsStraight61 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(s.isStraight(new int[]{0, 0, 1, 8, 5}));
    }

    static class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeroCnt = 0;
            int index = 0;
            while (nums[index] == 0) {
                index++;
                zeroCnt++;
            }
            for (int i = index; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return false;
                } else if (nums[i] + 1 != nums[i + 1]) {
                    int sub = nums[i + 1] - nums[i] - 1;
                    if (sub > zeroCnt) {
                        return false;
                    }
                    zeroCnt -= sub;
                }

            }
            return true;
        }
    }
}

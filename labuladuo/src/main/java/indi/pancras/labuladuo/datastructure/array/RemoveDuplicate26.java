package indi.pancras.labuladuo.datastructure.array;

public class RemoveDuplicate26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int left = 1, right = 1;
            while (true) {
                while (right < nums.length && nums[right] == nums[right - 1]) {
                    right++;
                }
                if (right == nums.length) {
                    return left;
                }
                if (left == right) {
                    left++;
                    right++;
                } else {
                    nums[left] = nums[right];
                    left++;
                    right++;
                }
            }
        }
    }
}

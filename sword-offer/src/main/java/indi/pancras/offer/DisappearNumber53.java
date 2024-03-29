package indi.pancras.offer;

public class DisappearNumber53 {
    class Solution {
        public int missingNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res ^= i;
                res ^= nums[i];
            }
            res ^= nums.length;
            return res;
        }
    }
}

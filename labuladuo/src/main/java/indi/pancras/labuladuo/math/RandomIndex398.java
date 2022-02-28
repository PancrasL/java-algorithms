package indi.pancras.labuladuo.math;

import java.util.Random;

public class RandomIndex398 {
    class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int i = 0;
            int res = 0;
            Random random = new Random();
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] == target) {
                    if (random.nextInt(i) == 0) {
                        res = k;
                    }
                    i++;
                }
            }
            return res;
        }
    }

}

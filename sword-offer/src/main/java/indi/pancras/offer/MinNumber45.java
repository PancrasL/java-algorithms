package indi.pancras.offer;

import java.util.Arrays;

public class MinNumber45 {
    class Solution {
        public String minNumber(int[] nums) {
            String[] numStrs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numStrs[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(numStrs, (o1, o2) -> {
                String sum1 = o1 + o2;
                String sum2 = o2 + o1;
                return sum1.compareTo(sum2);
            });
            StringBuilder sb = new StringBuilder();
            for (String numStr : numStrs) {
                sb.append(numStr);
            }
            return sb.toString();
        }
    }
}

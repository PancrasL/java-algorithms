package indi.pancras.offer;

import java.util.BitSet;

public class DuplicateNum03 {
    class Solution {
        BitSet bit = new BitSet(100001);

        public int findRepeatNumber(int[] nums) {
            for (int num : nums) {
                if (bit.get(num)) {
                    return num;
                }
                bit.set(num);
            }
            return -1;
        }
    }
}

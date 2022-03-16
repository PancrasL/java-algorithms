package indi.pancras.math;

import java.util.HashMap;

public class FourNumAdd {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> map = new HashMap<>(60000);
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    map.merge(nums1[i] + nums2[j], 1, Integer::sum);
                }
            }

            int cnt = 0;
            for (int i = 0; i < nums3.length; i++) {
                for (int j = 0; j < nums4.length; j++) {
                    cnt += map.getOrDefault(-nums3[i] - nums4[j], 0);
                }
            }

            return cnt;
        }
    }
}

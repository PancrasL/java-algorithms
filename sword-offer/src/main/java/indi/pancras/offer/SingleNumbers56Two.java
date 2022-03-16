package indi.pancras.offer;

import java.util.HashMap;
import java.util.Map;

public class SingleNumbers56Two {
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}

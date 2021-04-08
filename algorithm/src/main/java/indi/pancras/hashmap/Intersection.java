package indi.pancras.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author pancras
 * @tip 哈希表 或者 排序+双指针
 * @create 2021/4/1 20:10
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xh4sec/">两个数组的交集</a>
 */
public class Intersection {
    public int[] run(int[] nums1, int[] nums2) {
        return new Solution().intersection(nums1, nums2);
    }

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();

            Map<Integer, Integer> map = new HashMap<>();
            for (int j : nums1) {
                map.put(j, 1);
            }

            for (int j : nums2) {
                if (map.containsKey(j)) {
                    set.add(j);
                }
            }

            int[] result = new int[set.size()];
            int index = 0;
            for (Integer i : set) {
                result[index++] = i;
            }

            return result;
        }
    }
}

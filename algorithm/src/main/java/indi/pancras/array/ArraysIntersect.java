package indi.pancras.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pancras
 * @tip 1. 哈希表法 2. 排序+双指针
 * @create 2021/4/3 15:31
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/">两个数组的交集Ⅱ</a>
 */
public class ArraysIntersect {
    public int[] run(int[] nums1, int[] nums2) {
        //return new Solution().intersect(nums1, nums2);
        return new Solution().intersect1(nums1, nums2);
    }

    class Solution {
        // 哈希表法
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : nums1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int i : nums2) {
                int count = map.getOrDefault(i, 0);
                if (count > 0) {
                    map.put(i, count - 1);
                    list.add(i);
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        // 排序+双指针
        public int[] intersect1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int curr1, curr2;
            curr1 = curr2 = 0;
            List<Integer> list = new ArrayList<>();
            while (curr1 < nums1.length && curr2 < nums2.length) {
                if (nums1[curr1] == nums2[curr2]) {
                    list.add(nums1[curr1]);
                    curr1++;
                    curr2++;
                } else if (nums1[curr1] < nums2[curr2]) {
                    curr1++;
                } else {
                    curr2++;
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

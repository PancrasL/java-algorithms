package indi.pancras.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pancras
 * @tip 1. 利用map结构，边插入边查询，效率低 2. 使用排序，效率高
 * @create 2021/4/1 19:35
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xhzjp6/">存在重复元素</a>
 */
public class ContainsDuplicate {
    public boolean run(int[] nums) {
        return new Solution().containsDuplicate(nums);
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                if (map.containsKey(num))
                    return true;
                map.putIfAbsent(num, 1);
            }

            return false;
        }

        // 使用排序法解决
        public boolean containsDuplicate2(int[] nums) {
            Arrays.sort(nums);

            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == nums[i])
                    return true;
            }

            return false;
        }
    }
}

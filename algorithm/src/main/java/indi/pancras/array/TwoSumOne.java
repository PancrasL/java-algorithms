package indi.pancras.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pancras
 * @tip 1. 排序+双指针 2. 哈希表
 * @create 2021/4/3 16:41
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/">两数之和</a>
 */
public class TwoSumOne {
    public int[] run(int[] nums, int target) {
        int[] result = new Solution().twoSum1(nums, target);
        Arrays.sort(result);
        return result;
    }

    class Solution {
        // 排序法 + 双指针
        public int[] twoSum(int[] nums, int target) {
            Node[] nodes = new Node[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nodes[i] = new Node(nums[i], i);
            }

            Arrays.sort(nodes, (o1, o2) -> o1.val != o2.val ? (o1.val - o2.val) : (o1.prevIndex - o2.prevIndex));

            int begin = 0;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nodes[begin].val + nodes[end].val;
                if (sum < target)
                    begin++;
                else if (sum > target)
                    end--;
                else
                    break;
            }

            return new int[]{nodes[begin].prevIndex, nodes[end].prevIndex};
        }

        // 哈希表法
        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    result[0] = i;
                    result[1] = map.get(target - nums[i]);
                    break;
                }
                map.put(nums[i], i);
            }
            return result;
        }

        private class Node {
            int val;
            int prevIndex;


            public Node(int val, int prevIndex) {
                this.val = val;
                this.prevIndex = prevIndex;
            }
        }
    }
}

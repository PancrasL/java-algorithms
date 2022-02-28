package indi.pancras.labuladuo.nsum;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum1 {
    class Solution {
        class Node {
            int val;
            int index;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        public int[] twoSum(int[] nums, int target) {
            Node[] nodes = new Node[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nodes[i] = new Node(nums[i], i);
            }
            Arrays.sort(nodes, Comparator.comparingInt(node -> node.val));
            int a = 0, b = nums.length - 1;
            while (a < b) {
                int sum = nodes[a].val + nodes[b].val;
                if (sum == target) {
                    return new int[]{nodes[a].index, nodes[b].index};
                } else if (sum < target) {
                    a++;
                } else {
                    b--;
                }
            }
            return null;
        }
    }
}

package indi.pancras.labuladuo.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AdvantageShuffle870 {
    static class Solution {
        class Node {
            int val;
            int index;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        public int[] advantageCount(int[] nums1, int[] nums2) {
            List<Node> list1 = new ArrayList<>();
            LinkedList<Node> list2 = new LinkedList<>();
            for (int i = 0; i < nums1.length; i++) {
                list1.add(new Node(nums1[i], i));
                list2.add(new Node(nums2[i], i));
            }
            list1.sort(Comparator.comparingInt(o -> o.val));
            list2.sort(Comparator.comparingInt(o -> o.val));
            int[] ans = new int[nums1.length];
            int i = 0;
            while (!list2.isEmpty()) {
                Node node1 = list1.get(i++);
                Node node2 = list2.getFirst();
                if (node1.val > node2.val) {
                    ans[node2.index] = node1.val;
                    list2.removeFirst();
                } else {
                    node2 = list2.getLast();
                    ans[node2.index] = node1.val;
                    list2.removeLast();
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.advantageCount(new int[]{1,2,3,4},new int[]{1,2,3,4});
    }
}

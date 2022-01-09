package indi.pancras.labuladuo.datastructure.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    map.put(nums2[i], -1);
                    stack.add(nums2[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                        stack.pop();
                    }
                    map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                    stack.push(nums2[i]);
                }
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}

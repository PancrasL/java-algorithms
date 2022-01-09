package indi.pancras.labuladuo.datastructure.stack;

import java.util.Stack;

public class NextGreaterElementTwo503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[nums.length];
            for (int i = 2 * nums.length - 1; i >= 0; i--) {
                int index = i % nums.length;
                if (stack.isEmpty()) {
                    ans[index] = -1;
                    stack.add(nums[index]);
                } else {
                    while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                        stack.pop();
                    }
                    ans[index] = stack.isEmpty() ? -1 : stack.peek();
                    stack.add(nums[index]);
                }
            }
            return ans;
        }
    }
}

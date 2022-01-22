package indi.pancras.offer;

import java.util.Stack;

import indi.pancras.ListNode;

public class ReversePrint06 {
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head.next != null) {
                stack.add(head.val);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                res[index++] = stack.pop();
            }
            return res;
        }
    }
}

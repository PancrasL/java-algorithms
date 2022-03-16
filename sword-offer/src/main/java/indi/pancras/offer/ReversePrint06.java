package indi.pancras.offer;

import java.util.Stack;

import indi.pancras.ListNode;

public class ReversePrint06 {
    // 栈
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

    // 统计长度+倒序放置
    class Solution1 {
        public int[] reversePrint(ListNode head) {
            int len = listLen(head);
            int[] res = new int[len];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = head.val;
                head = head.next;
            }
            return res;
        }

        private int listLen(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}

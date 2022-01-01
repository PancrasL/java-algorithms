package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class ReverseGroup25 {
    class Solution {
        private ListNode front;
        private ListNode tail;

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) {
                return head;
            }

            ListNode fakeHead = new ListNode(0, head);
            ListNode preNode = fakeHead;
            while (true) {
                reverseNextKNodes(preNode.next, k);
                if (tail == null) {
                    preNode.next = front;
                    break;
                }
                preNode.next = front;
                preNode = tail;
            }

            return fakeHead.next;
        }

        private void reverseNextKNodes(ListNode head, int k) {
            ListNode p = head;
            for (int i = 0; i < k; i++) {
                if (p == null) {
                    front = head;
                    tail = null;
                    return;
                }
                p = p.next;
            }
            tail = head;
            ListNode p1 = head;
            ListNode p2 = head.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = temp;
            }
            front = p1;
            tail.next = p2;
        }
    }
}

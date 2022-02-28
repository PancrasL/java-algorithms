package indi.pancras.offer;

import indi.pancras.ListNode;

public class DeleteListNode18 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if (head.val == val) {
                return head.next;
            }
            ListNode p = head.next;
            ListNode last = head;
            while (p != null) {
                if (p.val == val) {
                    last.next = p.next;
                    break;
                }
                last = p;
                p = p.next;
            }
            return head;
        }
    }
}

package indi.pancras.offer;

import indi.pancras.ListNode;

public class MergeTwoLists25 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    p.next = l2;
                    l2 = l2.next;
                    p = p.next;
                } else if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                    p = p.next;
                } else {
                    p.next = l1;
                    l1 = l1.next;
                    p.next.next = l2;
                    l2 = l2.next;
                    p = p.next.next;
                }
            }
            if (l1 == null) {
                p.next = l2;
            }
            if (l2 == null) {
                p.next = l1;
            }
            return head.next;
        }
    }
}

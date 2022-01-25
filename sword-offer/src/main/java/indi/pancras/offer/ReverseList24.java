package indi.pancras.offer;

import indi.pancras.ListNode;

public class ReverseList24 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode p = head;
            ListNode last = null;
            while (p != null) {
                ListNode temp = p.next;
                p.next = last;
                last = p;
                p = temp;
            }
            return last;
        }
    }
}

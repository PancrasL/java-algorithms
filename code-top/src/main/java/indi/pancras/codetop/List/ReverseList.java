package indi.pancras.codetop.List;

import indi.pancras.codetop.ListNode;

public class ReverseList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            return helper(null, head);
        }

        private ListNode helper(ListNode prev, ListNode cur) {
            ListNode next = cur.next;
            cur.next = prev;
            if (next != null) {
                return helper(cur, next);
            }
            return cur;
        }
    }

    class Solution01 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev, cur;
            prev = null;
            cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}

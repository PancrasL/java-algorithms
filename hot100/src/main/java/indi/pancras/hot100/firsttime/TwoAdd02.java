package indi.pancras.hot100.firsttime;

import indi.pancras.hot100.ListNode;

public class TwoAdd02 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            int val = 0;
            // 头节点
            ListNode head = new ListNode(0);
            ListNode cur = head;
            while (l1 != null || l2 != null) {
                int l1val = l1 == null ? 0 : l1.val;
                int l2val = l2 == null ? 0 : l2.val;
                int sum = l1val + l2val + carry;
                carry = sum / 10;
                val = sum % 10;
                cur.next = new ListNode(val);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return head.next;
        }
    }
}

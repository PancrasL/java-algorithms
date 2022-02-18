package indi.pancras.top;

import indi.pancras.ListNode;

public class TwoAdd2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0, carry = 0;
            ListNode fakeHead = new ListNode();
            ListNode cur = fakeHead;
            while (l1 != null || l2 != null) {
                int l1val = 0, l2val = 0;
                if (l1 != null) {
                    l1val = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2val = l2.val;
                    l2 = l2.next;
                }
                sum = l1val + l2val + carry;
                carry = sum / 10;
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return fakeHead.next;
        }
    }
}

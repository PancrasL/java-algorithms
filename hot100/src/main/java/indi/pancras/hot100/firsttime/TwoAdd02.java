package indi.pancras.hot100.firsttime;

import indi.pancras.hot100.ListNode;

public class TwoAdd02 {

  class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = new ListNode();
      ListNode cur = head;

      int sum = 0, carry = 0;
      while (l1 != null || l2 != null) {
        sum = 0;
        if (l1 != null) {
          sum += l1.val;
          l1 = l1.next;
        }
        if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
        }
        sum += carry;
        carry = sum / 10;
        sum %= 10;
        cur.next = new ListNode(sum);
        cur = cur.next;
      }
      if (carry == 1) {
        cur.next = new ListNode(1);
      }
      return head.next;
    }
  }
}

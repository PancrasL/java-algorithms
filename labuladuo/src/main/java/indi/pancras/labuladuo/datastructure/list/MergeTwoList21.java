package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class MergeTwoList21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode p = head;
            while (true) {
                if (list1 == null) {
                    p.next = list2;
                    break;
                }
                if (list2 == null) {
                    p.next = list1;
                    break;
                }
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                    p = p.next;
                } else if (list1.val == list2.val) {
                    p.next = list1;
                    list1 = list1.next;

                    p.next.next = list2;
                    list2 = list2.next;

                    p = p.next.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                    p = p.next;
                }
            }
            return head.next;
        }
    }
}

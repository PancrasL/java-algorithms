package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class ReverseList206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next ==null){
                return head;
            }

            ListNode p1, p2;
            p1 = head;
            p2 = head.next;
            while (p2 !=null){
                ListNode next = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = next;
            }
            head.next = null;
            return p1;
        }
    }
}

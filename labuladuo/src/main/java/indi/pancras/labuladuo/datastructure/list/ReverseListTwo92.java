package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class ReverseListTwo92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head.next == null || left == right){
                return head;
            }

            ListNode fakeHead = new ListNode(0, head);
            ListNode preLeft = fakeHead;
            for (int i = 0; i < left - 1; i++) {
                preLeft = preLeft.next;
            }
            ListNode leftNode = preLeft.next;
            ListNode p1 = preLeft.next;
            ListNode p2 = preLeft.next.next;
            for (int i = left; i <right ; i++) {
                ListNode temp = p2.next;
                p2.next = p1;

                p1 = p2;
                p2 = temp;
            }
            preLeft.next = p1;
            leftNode.next = p2;
            return fakeHead.next;
        }
    }
}

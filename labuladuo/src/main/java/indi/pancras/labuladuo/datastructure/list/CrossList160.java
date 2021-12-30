package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class CrossList160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getListLength(headA);
            int lenB = getListLength(headB);
            // 预处理，保证headA和headB到链表尾部的距离一样
            if (lenA < lenB) {
                int cnt = lenB - lenA;
                for (int i = 0; i < cnt; i++) {
                    headB = headB.next;
                }
            }
            if (lenA > lenB) {
                int cnt = lenA - lenB;
                for (int i = 0; i < cnt; i++) {
                    headA = headA.next;
                }
            }
            // 此时headA和headB到链表尾部的距离一样
            while (headA != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        private int getListLength(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}

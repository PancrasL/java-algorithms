package indi.pancras.offer;

import indi.pancras.ListNode;

public class IntersectionNode52 {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int lenA = listLength(headA);
            int lenB = listLength(headB);
            while (lenA < lenB) {
                lenB--;
                headB = headB.next;
            }
            while (lenB < lenA) {
                lenA--;
                headA = headA.next;
            }

            // A、B一样长
            while (headA != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        private int listLength(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}

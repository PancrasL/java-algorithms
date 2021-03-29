package indi.pancras.doublepointer;

/**
 * @author pancras
 * @解题思路 1. 计算ListA, ListB的长度 2. 移动较长的链表，使两个链表长度一致 3. 从长度一致的位置向链表尾部移动，如果相交，那么它们必定在未来的某一点相遇
 * @create 2021/3/29 20:37
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/jjbj2/">相交链表</a>
 */
public class IntersectionNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            int lenA = getListLength(headA);
            int lenB = getListLength(headB);

            ListNode lA = headA;
            ListNode lB = headB;
            if (lenA < lenB) {
                while (lenB > lenA) {
                    lB = lB.next;
                    lenB--;
                }
            } else {
                while (lenB < lenA) {
                    lA = lA.next;
                    lenA--;
                }
            }

            boolean isInter = false;
            while (lA != null) {
                if (lA == lB) {
                    isInter = true;
                    break;
                }
                lA = lA.next;
                lB = lB.next;
            }

            return isInter ? lA : null;
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

package indi.pancras.list;

/**
 * @author pancras
 * @解题思路 将链表组成环，确定旋转后的新头和新尾的位置，然后在新尾的位置拆开环
 * @create 2021/3/30 15:34
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/f00a2/">旋转链表</a>
 */
public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null)
                return null;

            int len = getListLength(head);
            k %= len;

            ListNode tail = getNthNode(head, len - 1);
            ListNode newTail = getNthNode(head, len - k - 1);

            tail.next = head;
            ListNode newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }

        // 计算链表的长度
        private int getListLength(final ListNode head) {
            ListNode cur = head;
            int len = 0;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            return len;
        }

        // 获取第N个链表节点
        private ListNode getNthNode(final ListNode head, int n) {
            ListNode curr = head;
            while (n-- != 0) {
                curr = curr.next;
            }
            return curr;
        }
    }
}

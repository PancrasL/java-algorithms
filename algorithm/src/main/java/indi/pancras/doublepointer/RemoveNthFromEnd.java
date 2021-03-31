package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 快指针先于满指针移动n步
 * @create 2021/3/29 20:58
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/jf1cc/">删除链表的倒数第N个节点</a>
 */
public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null)
                return null;

            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                if (fast == null) {//n超过链表的长度
                    return null;
                }
                fast = fast.next;
            }

            if (fast == null) {//删除头节点
                head = head.next;
            } else {
                fast = fast.next;
                while (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
            }

            return head;
        }
    }
}

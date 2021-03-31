package indi.pancras.list;

/**
 * @author pancras
 * @解题思路 利用头节点简化代码
 * @create 2021/3/30 13:37
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fnzd1/">合并两个有序链表</a>
 */
public class MergeTwoLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 添加头节点，简化代码
            ListNode head = new ListNode(-1);
            head.next = l1;

            ListNode pre1, cur1, cur2;
            pre1 = head;
            cur1 = l1;
            cur2 = l2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val > cur2.val) {
                    ListNode temp = cur2.next;
                    pre1.next = cur2;
                    cur2.next = cur1;
                    cur2 = temp;
                } else {
                    cur1 = cur1.next;
                }
                pre1 = pre1.next;
            }

            if (cur1 == null) {
                pre1.next = cur2;
            }

            return head.next;
        }
    }
}

package indi.pancras.list;

/**
 * @author pancras
 * @解题思路 添加假头节点简化代码
 * @create 2021/3/30 11:52
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/f9izv/">移除链表元素</a>
 */
public class RemoveListElements {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pseudoHead = new ListNode(0);
            pseudoHead.next = head;
            ListNode curr = pseudoHead;
            while (curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return pseudoHead.next;
        }
    }
}

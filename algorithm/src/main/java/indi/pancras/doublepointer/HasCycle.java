package indi.pancras.doublepointer;

/**
 * @author pancras
 * @解题思路 快慢指针，看两指针是否会相交
 * @create 2021/3/29 19:44
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/jbex5/">环形链表</a>
 */
public class HasCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public boolean hasCycle(ListNode head) {
            boolean result = false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    result = true;
                    break;
                }
            }
            return result;
        }
    }
}

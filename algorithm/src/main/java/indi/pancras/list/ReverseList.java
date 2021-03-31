package indi.pancras.list;

/**
 * @author pancras
 * @解题思路 迭代法、递归法
 * @create 2021/3/30 11:41
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/f58sg/">反转链表</a>
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    class Solution {

        // 迭代法
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode last = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = last;
                last = cur;
                cur = temp;
            }

            return last;
        }

        // 递归法
        public ListNode reverseList1(ListNode head) {
            return reverse(null, head);
        }

        private ListNode reverse(ListNode last, ListNode cur) {
            if (cur == null) {
                return last;
            } else {
                ListNode temp = cur.next;
                cur.next = last;
                return reverse(cur, temp);
            }
        }
    }
}

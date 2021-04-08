package indi.pancras.recursion;

/**
 * @author pancras
 * @tip 递归求解
 * @create 2021/3/30 16:12
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/4p9kt/">两两交换链表中的节点</a>
 */
public class SwapListPairs {
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;

            return swapHelper(head);
        }

        private ListNode swapHelper(ListNode curr) {
            if (curr == null || curr.next == null) {
                return curr;
            }

            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;

            curr.next = swapHelper(curr.next);

            return next;
        }
    }
}

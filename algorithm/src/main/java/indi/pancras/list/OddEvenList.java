package indi.pancras.list;

/**
 * @author pancras
 * @tip 双指针交叉前进
 * @create 2021/3/31 19:39
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fe0kj/">奇偶链表</a>
 */
public class OddEvenList {

    public class ListNode {
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null)
                return null;

            ListNode secondHead = head.next;

            ListNode first = head;
            ListNode second = secondHead;
            while (true) {
                if (second == null || second.next == null) {
                    first.next = secondHead;
                    break;
                }
                first.next = second.next;
                first = first.next;
                second.next = second.next.next;
                second = first.next;
            }

            return head;
        }
    }
}

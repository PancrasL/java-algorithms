package indi.pancras.list;

/**
 * @author pancras
 * @tip 1.使用快慢指针找到链表的后半段 2.使用原位算法将后半段反转 3.判断前半段和后端段是否相等 4. 复原链表
 * @create 2021/3/31 20:03
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fov6t/">回文链表</a>
 */
public class PalindromeList {

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
        public boolean isPalindrome(ListNode head) {
            if (head == null)
                return true;

            ListNode slow, fast;
            slow = fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode lastHalfRev = reverseList(slow);
            ListNode resumeTag = lastHalfRev;

            ListNode topHalf = head;
            boolean isPalin = true;
            while (lastHalfRev != null) {
                if (lastHalfRev.val != topHalf.val) {
                    isPalin = false;
                    break;
                }
                lastHalfRev = lastHalfRev.next;
                topHalf = topHalf.next;
            }

            //复原链表
            reverseList(resumeTag);

            return isPalin;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev, curr;
            prev = null;
            curr = head;

            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }
    }
}

package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

public class PalindromeList234 {
    /**
     * 递归解法
     */
    class Solution {
        private ListNode front;

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            front = head;
            return isPalindromeHelper(head);
        }

        private boolean isPalindromeHelper(ListNode cur) {
            boolean res = true;
            if (cur.next != null) {
                if(!isPalindromeHelper(cur.next)) {
                    return false;
                }
            }
            if(cur.val != front.val){
                return false;
            }
            front = front.next;
            return true;
        }
    }
}

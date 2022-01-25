package indi.pancras.offer;

import indi.pancras.ListNode;

public class KthFromEnd22 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null || k == 0) {
                return null;
            }
            ListNode left = head, right = head;
            for (int i = 0; i < k; i++) {
                if (right == null) {
                    return null;
                }
                right = right.next;
            }
            while (right != null) {
                left = left.next;
                right = right.next;
            }
            return left;
        }
    }
}

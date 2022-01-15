package indi.pancras.labuladuo.datastructure.array;

import indi.pancras.labuladuo.ListNode;

public class RemoveDuplicateList83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pNode = head;
            while (pNode.next != null) {
                if (pNode.val == pNode.next.val) {
                    pNode.next = pNode.next.next;
                    continue;
                }
                pNode = pNode.next;
            }
            return head;
        }
    }
}

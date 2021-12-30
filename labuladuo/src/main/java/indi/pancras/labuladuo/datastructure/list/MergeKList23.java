package indi.pancras.labuladuo.datastructure.list;

import java.util.Comparator;
import java.util.PriorityQueue;

import indi.pancras.labuladuo.ListNode;

public class MergeKList23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> minHead = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (ListNode list : lists) {
                if (list != null) {
                    minHead.add(list);
                }
            }
            ListNode head = new ListNode();
            ListNode cur = head;
            while (true) {
                ListNode minNode = minHead.poll();
                if (minNode == null) {
                    break;
                }
                cur.next = minNode;
                cur = cur.next;
                if (minNode.next != null) {
                    minHead.add(minNode.next);
                }
            }
            return head.next;
        }
    }
}

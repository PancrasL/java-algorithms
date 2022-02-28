package indi.pancras.labuladuo.math;

import java.util.Random;

import indi.pancras.labuladuo.ListNode;

/**
 * 每次以1/i的概率选择元素
 */
public class RandomListNode382 {
    class Solution {

        ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = 0;
            int i = 0;
            ListNode p = head;

            Random random = new Random();
            while (p != null) {
                i++;
                if (random.nextInt(i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
}

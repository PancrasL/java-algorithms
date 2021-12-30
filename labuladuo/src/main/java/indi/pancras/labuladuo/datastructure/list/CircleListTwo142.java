package indi.pancras.labuladuo.datastructure.list;

import indi.pancras.labuladuo.ListNode;

/**
 * <p>
 * 1. fastDistance = slowDistance + n*环的周长
 * <p>
 * 2. fastDistance = 2 * slowDistance
 * <p>
 * 3. 解得：fastDistance = 2n*环的周长 slowDistance = n*环的周长
 * <p>
 * 4. 环的入口地址x满足 x=a + k*环的周长(a是从head直接走到环入口的距离,k是正整数)
 * <p>
 * 此时slow的位置满足 slowDistance = n * 环的周长，那么slow再向前移动距离a就能到达环的入口
 * <p>
 * 同样地，让一个满指针从head出发，走a步也能到达环的入口，那么这两个指针的相遇点就是入口
 */
public class CircleListTwo142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }
            if (hasCycle) {//存在环
                ListNode slow2 = head;
                while (slow != slow2) {// slow2从head出发，它们再次相遇的点就是圆环的入口点
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
            return null;
        }
    }
}

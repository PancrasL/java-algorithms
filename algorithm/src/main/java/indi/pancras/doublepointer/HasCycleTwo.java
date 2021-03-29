package indi.pancras.doublepointer;

/**
 * @author pancras
 * @解题思路 快慢指针，看两指针是否会相交. 1. fastDistance = slowDistance + n*环的周长 2. fastDistance = 2 * slowDistance
 * 3. 解得：fastDistance = 2n*环的周长 slowDistance = n*环的周长 4. 环的入口地址x满足 x=a + k*环的周长 此时slow的位置满足
 * slowDistance = n * 环的周长，那么slow再向前移动距离a就能到达环的入口 a可以通过从head到环入口获得，即将fast置为head，然后fast和slow依次移动一步，相交位置即为环的入口点
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/“></a>
 * @create 2021/3/29 19:54
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/jjhf6/">环形链表Ⅱ</a>
 */
public class HasCycleTwo {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            boolean hasCycle = false;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }

            if (!hasCycle) {
                return null;
            } else {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            return slow;
        }
    }
}

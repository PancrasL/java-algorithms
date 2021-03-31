package indi.pancras.list;

/**
 * @author pancras
 * @create 2021/3/30 14:02
 * @解题思路 遍历链表，注意遍历完毕后需要判断最高位是否有进位，如果有需要再添加一个‘1’节点
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fv6w7/">两数相加</a>
 */
public class AddTwoNum {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode result = new ListNode(-1);
            ListNode insertPos = result;

            int carry = 0;
            while (cur1 != null || cur2 != null) {
                int tempResult;

                if (cur1 == null) {
                    tempResult = cur2.val + carry;
                    cur2 = cur2.next;
                } else if (cur2 == null) {
                    tempResult = cur1.val + carry;
                    cur1 = cur1.next;
                } else {
                    tempResult = cur1.val + cur2.val + carry;
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }

                carry = tempResult / 10;
                tempResult %= 10;
                insertPos = insertNode(insertPos, tempResult);

            }
            if (carry == 1) {
                insertNode(insertPos, 1);
            }

            return result.next;
        }

        private ListNode insertNode(ListNode pre, int val) {
            ListNode node = new ListNode(val);
            node.next = pre.next;
            pre.next = node;

            return node;
        }
    }
}

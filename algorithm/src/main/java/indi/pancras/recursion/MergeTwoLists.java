package indi.pancras.recursion;

/**
 * @author pancras
 * @tip 1. 因为链表是升序的， 我们只需要遍历每个链表的头，比较一下哪个小就把哪个链表的头拿出来放到新的链表中. 2. 一直这样循环，直到有一个链表为空，然后我们再把另一个不为空的链表挂到新的链表中。
 * @create 2021/3/31 16:52
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/436xj/">合并有序链表</a>
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

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
}

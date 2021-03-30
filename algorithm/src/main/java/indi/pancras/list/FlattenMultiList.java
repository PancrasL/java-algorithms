package indi.pancras.list;

/**
 * @author pancras
 * @解题思路 类似于二叉树的先序遍历
 * @create 2021/3/30 14:27
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fw8v5/">扁平化多级双向链表</a>
 */
public class FlattenMultiList {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }

            //添加头节点简化代码
            Node pseudoHead = new Node(0, null, head, null);
            pseudoHead.next = head;
            head.prev = pseudoHead;

            dfs(pseudoHead, head);
            head.prev = null;
            head.child = null;

            return head;
        }

        private Node dfs(Node prev, Node curr) {
            if (curr == null)
                return prev;

            prev.next = curr;
            curr.prev = prev;

            Node tempNext = curr.next;
            Node tail = dfs(curr, curr.child);
            curr.child = null;

            return dfs(tail, tempNext);

        }
    }
}

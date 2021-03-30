package indi.pancras.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pancras
 * @解题思路 哈希表
 * @create 2021/3/30 15:16
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/fdi26/">复制带随机指针的链表</a>
 */
public class CopyRandomList {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;

            Map<Node, Node> map = new HashMap<>();
            map.put(null, null);

            // 添加假的头节点以简化代码
            Node copyList = new Node(0);

            Node prev = copyList;
            for (Node node = head; node != null; node = node.next) {
                prev.next = new Node(node.val);
                prev = prev.next;
                map.put(node, prev);
            }

            Node curr = copyList.next;
            for (Node node = head; node != null; node = node.next) {
                curr.random = map.get(node.random);
                curr = curr.next;
            }

            return copyList.next;
        }
    }
}

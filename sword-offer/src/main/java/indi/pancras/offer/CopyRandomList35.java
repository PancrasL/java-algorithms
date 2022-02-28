package indi.pancras.offer;


import java.util.ArrayList;
import java.util.HashMap;

public class CopyRandomList35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            HashMap<Node, Integer> map = new HashMap<>();
            ArrayList<Node> newList = new ArrayList<>();

            // 为旧链表的每个节点编上编号，并创建新链表节点
            int number = 0;
            for (Node p = head; p != null; p = p.next) {
                map.put(p, number);
                number = number + 1;
                Node newNode = new Node(p.val);
                if (!newList.isEmpty()) {
                    newList.get(newList.size() - 1).next = newNode;
                }
                newList.add(newNode);
            }

            // 将新链表节点的random连接到一起
            int index = 0;
            for (Node p = head; p != null; p = p.next) {
                if (p.random == null) {
                    newList.get(index).random = null;
                } else {
                    Integer pos = map.get(p.random);
                    newList.get(index).random = newList.get(pos);
                }
                index++;
            }
            return newList.get(0);
        }
    }
}

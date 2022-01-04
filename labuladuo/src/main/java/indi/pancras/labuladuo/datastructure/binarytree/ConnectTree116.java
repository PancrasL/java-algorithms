package indi.pancras.labuladuo.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import indi.pancras.labuladuo.Node;

public class ConnectTree116 {
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                Node last = null;
                Node cur;
                for (int i = 0; i < cnt; i++) {
                    cur = queue.remove();
                    if (last != null) {
                        last.next = cur;
                    }
                    last = cur;
                    if (cur.left != null && cur.right != null) {
                        queue.add(cur.left);
                        queue.add(cur.right);
                    }
                }
            }
            return root;
        }
    }
}

package indi.pancras.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author pancras
 * @解题思路 使用hashMap存储已经拷贝过的节点，其中key为原节点，value为拷贝节点
 * @create 2021/3/23 13:39
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/gmcr6/">客隆图</a>
 */
public class CloneGraph {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        HashMap<Node, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            return DFSClone(node, map);
        }

        private Node DFSClone(Node node, HashMap<Node, Node> map) {
            if (node == null) {
                return null;
            }

            if (map.containsKey(node)) {
                return map.get(node);
            }

            Node head = new Node(node.val, new ArrayList<>());
            map.put(node, head);

            for (Node neightbor : node.neighbors) {
                head.neighbors.add(DFSClone(neightbor, map));
            }

            return head;
        }
    }
}

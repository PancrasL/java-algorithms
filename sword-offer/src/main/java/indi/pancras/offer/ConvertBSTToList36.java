package indi.pancras.offer;

public class ConvertBSTToList36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node[] nodes = inorderTraverse(root);
            Node head = nodes[0];
            Node tail = nodes[1];
            head.left = tail;
            tail.right = head;
            return head;
        }

        // Node[0]为当前子树的最小节点，Node[1]为当前子树的最大节点
        private Node[] inorderTraverse(Node root) {
            if (root == null) {
                return null;
            }
            Node minNode = root, maxNode = root;
            Node[] left = inorderTraverse(root.left);
            if (left != null) {
                minNode = left[0];
                left[1].right = root;
                root.left = left[1];
            }
            Node[] right = inorderTraverse(root.right);
            if (right != null) {
                maxNode = right[1];
                root.right = right[0];
                right[0].left = root;
            }
            return new Node[]{minNode, maxNode};
        }
    }
}

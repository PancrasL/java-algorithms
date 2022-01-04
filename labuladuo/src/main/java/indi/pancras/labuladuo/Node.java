package indi.pancras.labuladuo;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, indi.pancras.labuladuo.Node _left, indi.pancras.labuladuo.Node _right, indi.pancras.labuladuo.Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

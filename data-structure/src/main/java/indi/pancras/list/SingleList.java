package indi.pancras.list;

/**
 * @author pancras
 * @create 2021/3/25 11:47
 * @see <a href="https://leetcode-cn.com/leetbook/read/linked-list/jy291/">单链表</a>
 */
public class SingleList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public SingleList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0)
            insertFirstNode(val);
        else {
            Node node = new Node(val, null);
            node.next = head;
            head = node;
            size++;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0)
            insertFirstNode(val);
        else {
            Node node = new Node(val, null);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (size == 0)
            insertFirstNode(val);

        if (index > size || index < 0)
            return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node node = new Node(val, null);
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0)
            return;
        if (size == 1)
            deleteLastNode();
        else if (index == 0) {// 删除头节点
            head = head.next;
            size--;
        } else {// 删除中间节点
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (index == size - 1) {
                tail = cur;
            }
            size--;
        }
    }

    private void insertFirstNode(int val) {
        Node node = new Node(val, null);
        head = tail = node;
        size++;
    }

    private void deleteLastNode() {
        head = tail = null;
        size = 0;
    }

    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

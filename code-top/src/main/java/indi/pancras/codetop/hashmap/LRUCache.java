package indi.pancras.codetop.hashmap;

import java.util.HashMap;
import java.util.Set;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;

    HashMap<Integer, Node> cache;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node;
        if ((node = cache.get(key)) != null) {// key存在，返回值
            markRencently(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if ((node = cache.get(key)) != null) {// key存在，更新值
            node.val = value;
            markRencently(node);
        } else {// key不存在
            if (size < capacity) {// 缓存不满，直接插入
                node = new Node(key, value);
                cache.put(key, node);
                addFirst(node);
                size++;
            } else {// 缓存已满，替换掉链表尾部的节点
                Node remove = removeLast();
                cache.remove(remove.key);
                node = new Node(key, value);
                cache.put(key, node);
                addFirst(node);
            }
        }
        Set<Integer> integers = cache.keySet();
        System.out.println(integers.toString());
    }

    private void markRencently(Node node) {
        Node n = remove(node);
        addFirst(n);
    }

    private Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    private Node removeLast() {
        return remove(tail.prev);
    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }
}

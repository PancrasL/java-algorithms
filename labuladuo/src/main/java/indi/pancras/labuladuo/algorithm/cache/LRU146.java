package indi.pancras.labuladuo.algorithm.cache;

import java.util.HashMap;

public class LRU146 {
    class LRUCache {
        class ListNode {
            int key;
            int value;
            ListNode prev;
            ListNode next;

            public ListNode(int key, int value, ListNode prev, ListNode next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, ListNode> hashMap;
        private ListNode head;
        private ListNode tail;
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.hashMap = new HashMap<>();
            head = new ListNode(-2, -2);
            tail = new ListNode(-2, -2);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                ListNode listNode = hashMap.get(key);
                markRecently(listNode);
                return listNode.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                ListNode node = hashMap.get(key);
                node.value = value;
                markRecently(node);
            } else {
                if (size < capacity) {
                    addRecently(key, value);
                    size++;
                } else {
                    removeLeastRecently();
                    addRecently(key,value);
                }
            }
        }

        // 将node节点移动到头部
        private void markRecently(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void addRecently(int key, int value) {
            // 创建节点
            ListNode node = new ListNode(key, value);
            // 添加到头部
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            // 创建映射
            hashMap.put(key, node);
        }

        private void removeLeastRecently() {
            // 删除链表尾部节点
            ListNode old = tail.prev;
            old.prev.next = tail;
            tail.prev = old.prev;

            hashMap.remove(old.key);
        }
    }
}

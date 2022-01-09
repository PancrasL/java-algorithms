package indi.pancras.labuladuo.algorithm.cache;

import java.util.HashMap;

public class LFU460 {
    class LFUCache {
        class ListNode {
            int key;
            int value;
            int freq;
            ListNode prev;
            ListNode next;

            public ListNode(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }
        }

        class LinkedList {
            ListNode head;
            ListNode tail;
            int size;

            public LinkedList() {
                head = new ListNode(-1, -1, -1);
                tail = new ListNode(-1, -1, -1);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addFirst(ListNode node) {
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
                size++;
            }

            public void deleteNode(ListNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            public ListNode removeLast() {
                ListNode node = tail.prev;
                deleteNode(node);
                return node;
            }

            public boolean isEmpty() {
                return size == 0;
            }
        }

        private HashMap<Integer, ListNode> kToValue = new HashMap<>();
        private HashMap<Integer, LinkedList> freqToList = new HashMap<>();
        private LinkedList frequences = new LinkedList();
        private int capacity;
        private int size;
        private int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.minFreq = -1;
        }

        public int get(int key) {
            if (kToValue.containsKey(key)) {
                ListNode node = kToValue.get(key);
                updateFreq(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (kToValue.containsKey(key)) {
                ListNode node = kToValue.get(key);
                node.value = value;
                updateFreq(node);
            } else {
                if (size < capacity) {
                    ListNode node = new ListNode(key, value, 1);
                    kToValue.put(key, node);
                    addNew(node);
                    size++;
                } else {
                    removeOld();
                    ListNode node = new ListNode(key, value, 1);
                    kToValue.put(key, node);
                    addNew(node);
                }
            }
        }

        private void addNew(ListNode node) {
            if (!freqToList.containsKey(node.freq)) {
                freqToList.put(node.freq, new LinkedList());
            }
            freqToList.get(node.freq).addFirst(node);
            minFreq = 1;
        }

        private void removeOld() {
            LinkedList list = freqToList.get(minFreq);
            ListNode old = list.removeLast();
            kToValue.remove(old.key);
        }

        private void updateFreq(ListNode node) {
            // 将node从频率为i的链表中移除，如果移除后链表为空，则将链表也移除
            LinkedList list = freqToList.get(node.freq);
            list.deleteNode(node);
            if (list.isEmpty()) {//如果移除后链表为空，则将链表也移除
                freqToList.remove(node.freq);
                if (node.freq == minFreq) {
                    minFreq++;
                }
            }

            // 将node放到频率为i+1的链表中，如果链表不存在，则先创建链表
            node.freq++;
            if (!freqToList.containsKey(node.freq)) {
                LinkedList newList = new LinkedList();
                newList.addFirst(node);
                freqToList.put(node.freq, newList);
            } else {
                freqToList.get(node.freq).addFirst(node);
            }
        }
    }
}

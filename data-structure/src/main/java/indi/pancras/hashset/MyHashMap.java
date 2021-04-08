package indi.pancras.hashset;

/**
 * @author pancras
 * @create 2021/4/1 17:36
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xhqwd3/">设计哈希映射</a>
 */
public class MyHashMap {

    static final int INIT_BARREL_SIZE = 10;

    DataNode[] barrels;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        barrels = new DataNode[10];
        // 简化假头节点，简化插入删除操作
        for (int i = 0; i < barrels.length; i++) {
            barrels[i] = new DataNode(0, 0);
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        DataNode prev = barrels[key % barrels.length];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next.value = value;
                break;
            }
            prev = prev.next;
        }
        if (prev.next == null) {
            DataNode node = new DataNode(key, value);
            node.next = null;
            prev.next = node;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
        DataNode curr = barrels[key % barrels.length].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        DataNode prev = barrels[key % barrels.length];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
    }

    private class DataNode {
        int key;
        int value;
        DataNode next;

        public DataNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

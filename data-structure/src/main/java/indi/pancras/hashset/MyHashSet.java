package indi.pancras.hashset;

/**
 * @author pancras
 * @create 2021/3/31 21:32
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xh377h/">设计哈希集合</a>
 */
public class MyHashSet {
    static final int INIT_BARREL_SIZE = 10;

    DataNode[] barrels;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        barrels = new DataNode[INIT_BARREL_SIZE];
        // 简化假头节点，简化插入删除操作
        for (int i = 0; i < barrels.length; i++) {
            barrels[i] = new DataNode(0);
        }
    }

    public void add(int key) {
        if (!contains(key)) {
            DataNode barrel = barrels[key % barrels.length];
            DataNode temp = new DataNode(key);
            temp.next = barrel.next;
            barrel.next = temp;
        }
    }

    public void remove(int key) {
        DataNode barrel = barrels[key % barrels.length];
        DataNode prev, curr;
        prev = barrel;
        curr = barrel.next;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        DataNode curr = barrels[key % barrels.length].next;
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DataNode barrel : barrels) {
            for (DataNode curr = barrel.next; curr != null; curr = curr.next) {
                sb.append(curr.key).append(',');
            }
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    private class DataNode {
        int key;
        DataNode next;

        public DataNode(int key) {
            this.key = key;
            this.next = null;
        }
    }


}
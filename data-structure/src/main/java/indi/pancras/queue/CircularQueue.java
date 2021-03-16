package indi.pancras.queue;

/**
 * @author pancras
 * @create 2021/3/16 20:49
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/kzlb5/">循环队列</a>
 */
public class CircularQueue {
    private final int capacity;
    private int[] data = null;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = -1;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (size == data.length) {
            return false;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int front() {
        if (size == 0) {
            return -1;
        }
        return data[head];
    }

    public int rear() {
        if (size == 0) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

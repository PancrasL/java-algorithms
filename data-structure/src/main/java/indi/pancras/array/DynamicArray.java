package indi.pancras.array;

import java.util.Arrays;


/**
 * @author pancras
 * @version 1.0
 */
public class DynamicArray<E> {

    /**
     * 默认初始化大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int size;
    private Object[] elements;

    /**
     * 构造函数
     *
     * @param capacity 初始数组容量
     * @throws IllegalArgumentException 越界
     */
    public DynamicArray(final int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: +" + capacity);
        }
        this.capacity = capacity;
        size = 0;

    }

    /**
     * 无参构造函数
     */
    public DynamicArray() {
        elements = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    /**
     * 向数组尾部添加一个元素，如果数组已满，则创建新的刷组，将数据拷贝至新数组
     *
     * @param element 要添加的元素
     */
    public void add(final E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * 向数组 index 位置添加新元素，如果数组已满，则创建新的刷组，并将数据拷贝至新数组
     *
     * @param element 添加的元素
     * @param index   添加的位置
     * @throws IndexOutOfBoundsException 越界
     */
    public void add(final E element, final int index) {
        rangeCheck(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 将类型为E的元素放到指定位置
     *
     * @param element 放置的元素
     * @param index   放置的位置
     * @throws IndexOutOfBoundsException 越界
     */
    public void put(final E element, final int index) {
        rangeCheck(index);

        elements[index] = element;
    }

    /**
     * 获取指定位置的元素
     *
     * @return index位置的元素值
     * @throws IndexOutOfBoundsException 越界
     */
    @SuppressWarnings("unchecked")
    public E get(final int index) {
        rangeCheck(index);

        return (E) elements[index];
    }

    /**
     * 移除指定位置的元素，并将元素左移
     *
     * @return 移除的元素
     * @throws IndexOutOfBoundsException 越界
     */
    public E remove(final int index) {
        rangeCheck(index);

        @SuppressWarnings("unchecked") E oldValue = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[index] = elements[index + 1];
        }
        size--;

        return oldValue;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 数组中元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否不包含任何元素
     *
     * @return 如果数组不包含元素返回true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString()).append(", ");
        }
        return sb.toString();
    }

    /**
     * 检查元素索引值是否越界
     *
     * @param index 元素索引值
     * @throws IndexOutOfBoundsException 越界
     */
    private void rangeCheck(final int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 保证数组容量不小于 minCapacity
     *
     * @param minCapacity 数组最小容量
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            grow(minCapacity);
        }
    }

    /**
     * 将数组容量扩充为不小于minCapacity
     *
     * @param minCapacity 最小容量
     * @return 最小数组容量
     */
    private void grow(int minCapacity) {
        // 未考虑溢出
        while (capacity < minCapacity) {
            capacity *= 2;
        }
        elements = Arrays.copyOf(elements, capacity);
    }
}

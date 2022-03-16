package indi.pancras.labuladuo.datastructure.heap;

public class FindKthLargest215 {
    class Solution {
        class MinHeap {
            int capacity;
            int size;
            int[] heap;

            public MinHeap(int capacity) {
                this.capacity = capacity;
                this.heap = new int[capacity + 1];
                this.size = 0;
            }

            public void push(int val) {
                if (size == capacity) {
                    throw new IllegalStateException("Heap is full.");
                }
                heap[++size] = val;
                // 上浮
                int index = size;
                while (index > 1 && heap[index] < heap[index / 2]) {
                    swap(index, index / 2);
                    index /= 2;
                }
            }

            public int poll() {
                int removeElement = peek();
                heap[1] = heap[size--];
                // 下沉
                int index = 1;
                while (index <= size / 2) {
                    int leftChild = index * 2;
                    int rightChild = index * 2 + 1;
                    // 当删除节点的元素大于 左孩子节点或者右孩子节点，代表该元素的值大，此时需要将该元素与左、右孩子节点中最小的值进行交换
                    if (heap[index] > heap[leftChild] || heap[index] > heap[rightChild]) {
                        if (heap[leftChild] < heap[rightChild]) {
                            swap(index, leftChild);
                            index = leftChild;
                        } else {
                            swap(index, rightChild);
                            index = rightChild;
                        }
                    } else {
                        break;
                    }
                }
                return removeElement;
            }

            public int peek() {
                if (size == 0) {
                    throw new IllegalStateException("Heap is empty.");
                }
                return heap[1];
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public int size() {
                return size;
            }

            private void swap(int index1, int index2) {
                int temp = heap[index1];
                heap[index1] = heap[index2];
                heap[index2] = temp;
            }
        }

        public int findKthLargest(int[] nums, int k) {
            MinHeap heap = new MinHeap(k);
            for (int num : nums) {
                if (heap.size() < k) {
                    heap.push(num);
                } else {
                    if (num > heap.peek()) {
                        heap.poll();
                        heap.push(num);
                    }
                }
            }
            return heap.peek();
        }
    }
}

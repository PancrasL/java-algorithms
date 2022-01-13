package indi.pancras.labuladuo.datastructure.heap;

public class FindKthLargest215 {
    class Solution {
        class MaxHeap {
            int capacity;
            int size;
            int[] maxHeap;

            public MaxHeap(int capacity) {
                this.capacity = capacity;
                this.maxHeap = new int[capacity + 1];
                this.size = 0;
            }

            public void push(int val) {
                if (size == capacity) {
                    throw new IllegalStateException("Heap is full.");
                }
                maxHeap[++size] = val;
                // 上浮
                int index = size;
                while (index > 1 && maxHeap[index] > maxHeap[index / 2]) {
                    swap(index, index / 2);
                    index /= 2;
                }
            }

            public int poll() {
                int removeElement = peek();
                maxHeap[1] = maxHeap[size--];
                // 下沉
                int index = 1;
                while (index <= size / 2) {
                    int leftChild = index * 2;
                    int rightChild = index * 2 + 1;
                    if (maxHeap[index] < maxHeap[leftChild] || maxHeap[index] < maxHeap[rightChild]) {
                        if (maxHeap[leftChild] > maxHeap[rightChild]) {
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
                return maxHeap[1];
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public int size() {
                return size;
            }

            private void swap(int index1, int index2) {
                int temp = maxHeap[index1];
                maxHeap[index1] = maxHeap[index2];
                maxHeap[index2] = temp;
            }
        }
        public int findKthLargest(int[] nums, int k) {
            MaxHeap heap = new MaxHeap(nums.length);
            for (int num : nums) {
                heap.push(num);
            }
            int res = 0;
            for (int i = 0; i < k; i++) {
                res = heap.poll();
            }
            return res;
        }
    }
}

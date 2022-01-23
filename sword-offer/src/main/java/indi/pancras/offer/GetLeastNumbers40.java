package indi.pancras.offer;

import java.util.Arrays;

public class GetLeastNumbers40 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.getLeastNumbers(new int[]{6, 5, 4, 3, 2, 1}, 3);
        System.out.println(Arrays.toString(ans));
    }

    // O(n),仅当可以修改arr时可用
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            MaxHeap heap = new MaxHeap(k);
            for (int i = 0; i < k; i++) {
                heap.add(arr[i]);
            }
            for (int i = k; i < arr.length; i++) {
                if (arr[i] <= heap.peek()) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }

            int[] res = new int[k];
            int index = k;
            while (!heap.isEmpty()) {
                res[--index] = heap.poll();
            }
            return res;
        }

        class MaxHeap {
            int[] heap;
            int size;
            int capacity;

            public MaxHeap(int capacity) {
                heap = new int[capacity + 1];
                this.capacity = capacity;
                size = 0;
            }

            public int peek() {
                if (size == 0) {
                    throw new IllegalStateException("heap is null");
                }
                return heap[1];
            }

            public void add(int val) {
                if (size == capacity) {
                    throw new IllegalStateException("heap if full");
                }
                heap[++size] = val;
                int i = size;
                // 上浮
                while (i > 1 && heap[i] > heap[i / 2]) {
                    swap(i, i / 2);
                    i /= 2;
                }
            }

            public int poll() {
                int res = peek();
                heap[1] = heap[size--];
                int i = 1;
                while (i * 2 <= size) {
                    int left = i * 2;
                    int right = i * 2 + 1;
                    if (heap[i] >= heap[left] && heap[i] >= heap[right]) {
                        break;
                    } else {
                        if (heap[left] >= heap[right]) {
                            swap(i, left);
                            i = left;
                        } else {
                            swap(i, right);
                            i = right;
                        }
                    }
                }
                return res;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            private void swap(int i, int j) {
                int temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
            }
        }
    }
}

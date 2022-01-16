package indi.pancras.labuladuo.sort;

public class KthLargest215 {

    class Solution {
        class MaxHeap {
            private int[] nums;
            private int size;
            private int capacity;

            public MaxHeap(int n) {
                // 下标0不存放元素
                nums = new int[n + 1];
                size = 0;
                capacity = n;
            }

            public void add(int val) {
                if (size == capacity) {
                    throw new IllegalStateException("Heap is full.");
                }
                // 将val插入到最后一个位置，然后上浮
                nums[++size] = val;
                int i = size;
                while (i > 1 && nums[i] > nums[i / 2]) {
                    swap(i, i / 2);
                    i /= 2;
                }
            }

            public int poll() {
                int res = peek();
                // 将最后一个元素放到堆头，然后下沉
                nums[1] = nums[size--];
                int i = 1;
                while (i * 2 <= size) {
                    int left = i * 2;
                    int right = i * 2 + 1;
                    if (nums[i] < nums[left] || nums[i] < nums[right]) {
                        if (nums[left] > nums[right]) {
                            swap(i, left);
                            i = left;
                        } else {
                            swap(i, right);
                            i = right;
                        }
                    } else {
                        break;
                    }
                }
                return res;
            }

            public int peek() {
                if (size == 0) {
                    throw new IllegalStateException("Heap is empty");
                }
                return nums[1];
            }

            private void swap(int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        public int findKthLargest(int[] nums, int k) {
            MaxHeap heap = new MaxHeap(nums.length);
            for (int num : nums) {
                heap.add(num);
            }
            int res = 0;
            for (int i = 0; i < k; i++) {
                res = heap.poll();
            }
            return res;
        }
    }
}

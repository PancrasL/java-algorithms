package indi.pancras.labuladuo.slidewindow;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = k - 1;
            // 单调队列：入队的元素如果大于队首元素，则将队首元素出队后再入队，保证队首元素是窗口中的最大值
            LinkedList<Integer> queue = new LinkedList<>();
            // 初始化窗口
            queue.add(nums[left]);
            for (int i = left + 1; i <= right; i++) {
                while (!queue.isEmpty() && nums[i] > queue.getFirst()) {
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                    queue.removeLast();
                }
                queue.add(nums[i]);
            }
            result[left] = queue.getFirst();
            while (true) {
                // 移动窗口
                // 如果移出窗口的元素和队首元素相同，则将队首元素移除
                if (queue.getFirst() == nums[left]) {
                    queue.removeFirst();
                }
                left++;
                right++;
                if (right == nums.length) {
                    break;
                }
                // 如果移入窗口的元素大于队首元素，则将队首元素移除
                while (!queue.isEmpty() && nums[right] > queue.getFirst()) {
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && nums[right] > queue.getLast()) {
                    queue.removeLast();
                }
                queue.add(nums[right]);
                result[left] = queue.getFirst();
            }
            return result;
        }
    }

    class Solution1 {

        class Node {
            int index;
            int value;

            public Node(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
            for (int i = 0; i < k; i++) {
                queue.add(new Node(i, nums[i]));
            }
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = k - 1;
            while (true) {
                Node front = queue.peek();
                while (front.index < left) {
                    queue.poll();
                    front = queue.peek();
                }
                result[left] = front.value;
                left++;
                right++;
                if (right == nums.length) {
                    break;
                }
                queue.add(new Node(right, nums[right]));
            }
            return result;
        }
    }
}

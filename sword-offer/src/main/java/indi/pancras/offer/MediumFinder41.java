package indi.pancras.offer;

import java.util.PriorityQueue;

public class MediumFinder41 {
    class MedianFinder {
        PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        // 保证左边数字比右边数字多0个或1个
        public void addNum(int num) {
            if (left.size() == right.size()) {// 左右数字一样多
                if (left.isEmpty() || num <= right.peek()) {
                    left.add(num);
                } else {
                    left.add(right.poll());
                    right.add(num);
                }
            } else if (left.size() == right.size() + 1) {// 左边数字比右边多1个
                if (num < left.peek()) {
                    right.add(left.poll());
                    left.add(num);
                } else {
                    right.add(num);
                }
            }
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("---");
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }
}

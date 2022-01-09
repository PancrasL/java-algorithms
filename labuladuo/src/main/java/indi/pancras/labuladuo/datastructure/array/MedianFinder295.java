package indi.pancras.labuladuo.datastructure.array;

import java.util.PriorityQueue;

public class MedianFinder295 {
    class MedianFinder {
        private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        private PriorityQueue<Integer> right = new PriorityQueue<>();
        private boolean even = true;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                if(right.isEmpty()){
                    left.add(num);
                }else{
                    if(num>right.peek()){
                        left.add(right.poll());
                        right.add(num);
                    }else{
                        left.add(num);
                    }
                }
            } else if (left.size() > right.size()) {
                if (num > left.peek()) {
                    right.add(num);
                } else {
                    right.add(left.poll());
                    left.add(num);
                }
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {// 至少2个元素
                return (left.peek() + right.peek()) / 2.0;
            } else {// 至少1个元素
                return left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            }
        }
    }
}

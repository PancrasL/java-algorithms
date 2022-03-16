package indi.pancras.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue59 {
    class MaxQueue {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> maxValue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return maxValue.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!maxValue.isEmpty() && value > maxValue.getLast()) {
                maxValue.removeLast();
            }
            maxValue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int remove = queue.poll();
            if (remove == maxValue.getFirst()) {
                maxValue.removeFirst();
            }
            return remove;
        }
    }
}

package indi.pancras.labuladuo.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack225 {
    class MyStack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            queue1.add(x);
            move(queue2, queue1);
            move(queue1, queue2);
        }

        public int pop() {
            return queue2.poll();
        }

        public int top() {
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }

        private void move(Queue<Integer> from, Queue<Integer> to) {
            while (!from.isEmpty()) {
                to.add(from.poll());
            }
        }

    }
}

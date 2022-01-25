package indi.pancras.offer;

import java.util.Stack;

public class CQueue09 {
    class CQueue {
        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}

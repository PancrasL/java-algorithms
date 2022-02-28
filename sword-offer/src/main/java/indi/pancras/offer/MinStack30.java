package indi.pancras.offer;

import java.util.Objects;
import java.util.Stack;

public class MinStack30 {
    class MinStack {
        private final Stack<Integer> data;
        private final Stack<Integer> minStack;

        public MinStack() {
            data = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (Objects.equals(data.peek(), minStack.peek())) {
                minStack.pop();
            }
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}

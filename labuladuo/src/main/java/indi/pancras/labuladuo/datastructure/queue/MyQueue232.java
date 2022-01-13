package indi.pancras.labuladuo.datastructure.queue;

import java.util.Stack;

public class MyQueue232 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.empty()) {
            move();
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.empty()) {
            move();
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    private void move() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }
}

package indi.pancras.stack;

import java.util.Stack;

/**
 * @author pancras
 * @解题思路 使用辅助栈minStack记录最小元素，当入栈时，元素条件性入辅助栈; 当出栈时，元素条件行出辅助栈。注意：Integer的比较要使用obj1.equals(obj2)
 * @create 2021/3/22 11:31
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/g5l7d/">最小栈</a>
 */
public class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
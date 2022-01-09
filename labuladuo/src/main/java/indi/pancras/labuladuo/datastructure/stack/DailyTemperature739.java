package indi.pancras.labuladuo.datastructure.stack;

import java.util.Stack;

public class DailyTemperature739 {
    class Solution {
        class Node {
            int temperature;
            int day;

            public Node(int temperature, int day) {
                this.temperature = temperature;
                this.day = day;
            }
        }

        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Node> stack = new Stack<>();
            int[] ans = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    ans[i] = 0;
                    stack.add(new Node(temperatures[i], i));
                } else {
                    while (!stack.isEmpty() && stack.peek().temperature <= temperatures[i]) {
                        stack.pop();
                    }
                    ans[i] = stack.isEmpty() ? 0 : stack.peek().day - i;
                    stack.add(new Node(temperatures[i], i));
                }
            }
            return ans;
        }
    }
}

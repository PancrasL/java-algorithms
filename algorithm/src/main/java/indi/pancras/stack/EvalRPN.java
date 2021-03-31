package indi.pancras.stack;

import java.util.Stack;

/**
 * @author pancras
 * @tip 遇到数字入栈，遇到算符出栈两次计算后再入栈
 * @create 2021/3/22 20:13
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/gomvm/">逆波兰表达式求值</a>
 */
public class EvalRPN {
    public int run(String[] tokens) {
        return new Solution().evalRPN(tokens);
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            for (String token : tokens) {
                int top1;
                int top2;
                switch (token) {
                    case "+":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        stack.push(top1 + top2);
                        break;
                    case "-":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        stack.push(top2 - top1);
                        break;
                    case "*":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        stack.push(top1 * top2);
                        break;
                    case "/":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        stack.push(top2 / top1);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    }
}

package indi.pancras.stack;

import java.util.Stack;

/**
 * @author pancras
 * @解题思路 对于每一个温度，当栈为空或小于等于栈首元素时入栈，当大于栈首元素时出栈，出到栈为空或小于等于栈首元素，在出栈时生成对应结果集。
 * @create 2021/3/22 19:20
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/genw3/">每日温度</a>
 */
public class DailyTemperatures {
    public int[] run(int[] T) {
        return new Solution().dailyTemperatures(T);
    }

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T == null || T.length == 0) {
                return new int[0];
            }

            Stack<Node> stack = new Stack<>();

            int[] result = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                while (!stack.isEmpty() && T[i] > stack.peek().val) {
                    Node top = stack.pop();
                    result[top.index] = i - top.index;
                }
                stack.push(new Node(T[i], i));
            }

            return result;
        }

        class Node {
            int val;
            int index;

            Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
    }
}

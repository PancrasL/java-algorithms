package indi.pancras.stack;

import java.util.Stack;

/**
 * @author pancras
 * @tip 左括号入栈，右括号出栈，如果左右括号不匹配则无效
 * @create 2021/3/22 18:22
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/g9d0h/">有效的括号</a>
 */
public class ValidParentheses {
    public boolean run(String s) {
        return new Solution().isValid(s);
    }

    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            Stack<Character> stack = new Stack<>();

            boolean result = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.empty() || !isPair(stack.pop(), c)) {
                        result = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                result = false;
            }

            return result;
        }

        private boolean isPair(char c1, char c2) {
            return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
        }
    }
}

package indi.pancras.stack;

import java.util.Stack;

/**
 * @author pancras
 * @解题思路 使用栈，如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈 如果当前的字符为字母或者左括号，直接进栈 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
 * 作者：LeetCode-Solution 链接：https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @create 2021/3/22 20:45
 * @see <a href= "https://leetcode-cn.com/leetbook/read/queue-stack/gdwjv/">字符串解码</a>
 */
public class DecodeString {
    public String run(String s) {
        return new Solution().decodeString(s);
    }

    class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[' || Character.isLetter(c)) {// 字符入栈
                    stack.push(String.valueOf(c));
                } else if (Character.isDigit(c)) {// 数字入栈
                    int start = i;
                    int end = i;
                    while (end < s.length() && Character.isDigit(s.charAt(end))) {
                        end++;
                    }
                    stack.push(s.substring(start, end));
                    i = end - 1;
                } else {// 右括号，开始出栈，出到左括号为止
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                        String top = stack.pop();
                        if (top.equals("[")) {
                            int count = Integer.parseInt(stack.pop());
                            String temp = sb.reverse().toString();
                            sb.setLength(0);
                            while (count-- > 0) {
                                sb.append(temp);
                            }
                            stack.push(sb.reverse().toString());
                            break;
                        } else {
                            sb.append(top);
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            while (!stack.empty()) {
                result.append(stack.pop());
            }

            return result.reverse().toString();
        }
    }
}

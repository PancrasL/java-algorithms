package indi.pancras.string;

import java.util.Stack;

/**
 * @author pancras
 * @解题思路 手写split，使用left和right定位单词的左边界和有边界
 * @create 2021/3/15 9:55
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/crmp5/">翻转字符串里的单词</a>
 */
public class ReverseWords1 {
    public String run(String s) {
        Solution sl = new Solution();
        return sl.reverseWords(s);
    }

    class Solution {
        public String reverseWords(String s) {
            Stack<String> stack = new Stack<>();

            int left, right;

            left = right = 0;
            while (right < s.length()) {
                //找到单词的左边界
                while (left < s.length()) {
                    if (isSpace(s.charAt(left))) {
                        left++;
                    } else {
                        break;
                    }
                }
                if (left == s.length()) {
                    break;
                }

                //找到单词的右边界
                right = left;
                while (right < s.length()) {
                    if (!isSpace(s.charAt(right))) {
                        right++;
                    } else {
                        break;
                    }
                }
                stack.push(s.substring(left, right));

                left = right;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.empty()) {
                sb.append(stack.pop());
                sb.append(' ');
            }

            //移除尾部的空格
            sb.setLength(sb.length() - 1);

            return sb.toString();
        }


        private boolean isSpace(char c) {
            return c == ' ';
        }
    }
}

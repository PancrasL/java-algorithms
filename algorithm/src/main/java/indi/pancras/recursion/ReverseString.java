package indi.pancras.recursion;

/**
 * @author pancras
 * @create 2021/3/30 16:07
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/490ye/">反转字符串</a>
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            helper(s, 0, s.length - 1);
        }

        private void helper(char[] s, int start, int end) {
            if (start >= end)
                return;
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            helper(s, start + 1, end - 1);
        }
    }
}

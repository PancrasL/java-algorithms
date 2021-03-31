package indi.pancras.doublepointer;

/**
 * @author pancras
 * @tip 双指针遍历
 * @create 2021/3/15 10:53
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cacxi/">反转字符串</a>
 */
public class ReverseString {
    public char[] run(char[] s) {
        Solution sl = new Solution();
        sl.reverseString(s);

        return s;
    }

    class Solution {
        public void reverseString(char[] s) {
            int left, right;
            left = 0;
            right = s.length - 1;

            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                left++;
                right--;
            }
        }
    }
}

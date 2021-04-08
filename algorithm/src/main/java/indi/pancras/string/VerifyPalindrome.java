package indi.pancras.string;

/**
 * @author pancras
 * @tip 双指针
 * @create 2021/4/6 16:41
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/">验证回文串</a>
 */
public class VerifyPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                char sCh = Character.toLowerCase(s.charAt(start));
                char eCh = Character.toLowerCase(s.charAt(end));
                if (!Character.isLetterOrDigit(sCh)) {
                    start++;
                } else if (!Character.isLetterOrDigit(eCh)) {
                    end--;
                } else if (sCh == eCh) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}

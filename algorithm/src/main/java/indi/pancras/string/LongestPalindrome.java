package indi.pancras.string;

/**
 * @author pancras
 * @create 2021/3/12 13:58
 * @解题思路 中心扩散法：以每一个字符为中心寻找回文串
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/conm7/">最长回文子串</a>
 */
public class LongestPalindrome {
    public String run(String s) {
        Solution sl = new Solution();
        return sl.longestPalindrome(s);
    }

    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }

            String result = "";
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int left, right;

                // 形如 aba的回文串
                left = right = i;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        sb.append(s.charAt(right));
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }

                String palindrome = null;
                if (sb.length() == 1) {
                    palindrome = sb.toString();
                } else {
                    String temp = sb.substring(1);
                    palindrome = sb.reverse().toString() + temp;
                }
                result = result.length() < palindrome.length() ? palindrome : result;
                sb.setLength(0);

                // 形如aa的回文串
                left = i;
                right = i + 1;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        sb.append(s.charAt(right));
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                String temp = sb.toString();
                palindrome = sb.reverse().toString() + temp;
                result = result.length() < palindrome.length() ? palindrome : result;

                sb.setLength(0);
            }

            return result;
        }
    }
}

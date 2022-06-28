package indi.pancras.top;

public class LongestPalindrome5 {
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = findPalindrome(s, i, i);
                res = s1.length() > res.length() ? s1 : res;
                if (i + 1 < s.length()) {
                    String s2 = findPalindrome(s, i, i + 1);
                    res = s2.length() > res.length() ? s2 : res;
                }
            }
            return res;
        }

        private String findPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            return s.substring(left, right + 1);
        }
    }
}

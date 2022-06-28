package indi.pancras.hot100.firsttime;

public class LongestPalindrome {

    public static void main(String[] args) {
        Solution s = new Solution();
        String abbd = s.longestPalindrome("abbd");
        System.out.println(abbd);
    }

    static class Solution {

        public String longestPalindrome(String s) {
            int start = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] res = findPalindrome(s, i, i);
                if (res[1] > maxLen) {
                    start = res[0];
                    maxLen = res[1];
                }
                res = findPalindrome(s, i, i + 1);
                if (res[1] > maxLen) {
                    start = res[0];
                    maxLen = res[1];
                }
            }
            return s.substring(start, start + maxLen);
        }

        private int[] findPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            left++;
            right--;
            return new int[]{left, right - left + 1};
        }
    }
}

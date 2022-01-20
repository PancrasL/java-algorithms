package indi.pancras.labuladuo.hot;

public class LongestPalindrome5 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("abcba"));
        System.out.println(s.longestPalindrome("abccba"));
        System.out.println(s.longestPalindrome("cbbd"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            // 左右边界
            int[] res = new int[]{0, 0};
            for (int i = 1; i < s.length(); i++) {
                int[] p1 = findPalindrome(s, i, i);
                if (res[1] - res[0] < p1[1] - p1[0]) {
                    res = p1;
                }
                int[] p2 = findPalindrome(s, i - 1, i);
                if (res[1] - res[0] < p2[1] - p2[0]) {
                    res = p2;
                }
            }
            return s.substring(res[0], res[1] + 1);
        }

        // 从left，right向两侧搜索回文串，返回回文串的左边界和右边界(包括)
        private int[] findPalindrome(String s, int left, int right) {
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                if (left < 0 || right >= s.length()) {
                    break;
                }
            }
            return new int[]{left + 1, right - 1};
        }
    }
}

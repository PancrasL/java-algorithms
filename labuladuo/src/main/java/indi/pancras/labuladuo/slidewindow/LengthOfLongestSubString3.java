package indi.pancras.labuladuo.slidewindow;

public class LengthOfLongestSubString3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int maxLength = 0;
            boolean[] hasChar = new boolean[256];
            while (right < s.length()) {
                char leftCh = s.charAt(left);
                char rightCh = s.charAt(right);
                if (hasChar[rightCh]) {// 如果右窗口发现重复元素，则缩短左窗口，直到去除重复元素
                    while (leftCh != rightCh) {
                        left++;
                        hasChar[leftCh] = false;
                        leftCh = s.charAt(left);
                    }
                    hasChar[leftCh] = false;
                    left++;
                } else {
                    hasChar[rightCh] = true;
                    right++;
                    maxLength = Math.max(maxLength, right - left);
                }
            }
            return maxLength;
        }
    }
}

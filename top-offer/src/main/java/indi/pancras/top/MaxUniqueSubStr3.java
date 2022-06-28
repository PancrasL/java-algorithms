package indi.pancras.top;

public class MaxUniqueSubStr3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int[] count = new int[256];
            int left = 0, right = 0;
            count[s.charAt(0)]++;
            int longestLength = 1;
            while (++right < s.length()) {
                while (count[s.charAt(right)] == 1) {// 如果新加入的元素已经在窗口中存在，则移动左边界，直到去除该元素
                    count[s.charAt(left)] = 0;
                    left++;
                }
                count[s.charAt(right)] = 1;
                longestLength = Math.max(longestLength, right - left + 1);
            }
            return longestLength;
        }
    }
}

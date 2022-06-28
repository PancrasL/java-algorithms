package indi.pancras.hot100.firsttime;

public class LengthOfLongestSubString03 {

  class Solution {

    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.isEmpty()) {
        return 0;
      }
      int left = 0;
      int right = 0;
      int[] map = new int[256];
      map[s.charAt(0)] = 1;
      int maxLength = 1;
      while (true) {
        right++;
        if (right == s.length()) {
          break;
        }
        map[s.charAt(right)]++;
        while (map[s.charAt(right)] > 1) {
          map[s.charAt(left)]--;
          left++;
        }
        maxLength = Math.max(maxLength, right - left + 1);
      }
      return maxLength;
    }
  }
}

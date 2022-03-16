package indi.pancras.offer;

public class FindUniqChar50 {
    class Solution {
        public char firstUniqChar(String s) {
            if (s.isEmpty()) {
                return ' ';
            }
            int[] cnt = new int[256];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i)]++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (cnt[s.charAt(i)] == 1) {
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }
}

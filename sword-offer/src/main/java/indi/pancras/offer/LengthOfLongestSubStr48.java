package indi.pancras.offer;

public class LengthOfLongestSubStr48 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int left = 0, right = 0;
            boolean[] visit = new boolean[256];
            visit[s.charAt(0)] = true;
            int cnt = 1;
            while (++right != s.length()) {
                int rightC = s.charAt(right);
                while (visit[rightC]) {
                    visit[s.charAt(left)] = false;
                    left++;
                }
                visit[rightC] = true;
                cnt = Math.max(cnt, right - left + 1);
            }
            return cnt;
        }
    }
}

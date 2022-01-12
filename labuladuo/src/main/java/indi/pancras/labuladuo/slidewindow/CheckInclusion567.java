package indi.pancras.labuladuo.slidewindow;

public class CheckInclusion567 {
    class Solution {
        private int[] s1Map = new int[256];

        public boolean checkInclusion(String s1, String s2) {
            // 统计s1的词频
            for (int i = 0; i < s1.length(); i++) {
                s1Map[s1.charAt(i)]++;
            }

            for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
                if (s1Map[s2.charAt(i)] != 0) {
                    if (valid(s2, i, i + s1.length())) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean valid(String s, int start, int end) {
            int[] s2Map = new int[256];
            for (int i = start; i < end; i++) {
                char c = s.charAt(i);
                if (s1Map[c] == 0) {
                    return false;
                }
                s2Map[c]++;
                if (s2Map[c] > s1Map[c]) {
                    return false;
                }
            }
            return true;
        }
    }
}

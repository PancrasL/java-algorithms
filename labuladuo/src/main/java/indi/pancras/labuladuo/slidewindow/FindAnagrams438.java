package indi.pancras.labuladuo.slidewindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams438 {
    class Solution {
        int[] cnt = new int[256];
        int[] window = new int[256];

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (p.length() > s.length()) {
                return result;
            }

            for (int i = 0; i < p.length(); i++) {
                cnt[p.charAt(i)]++;
                window[s.charAt(i)]++;
            }
            if (judge(p)) {
                result.add(0);
            }
            int left = 0;
            int right = p.length();
            while (right < s.length()) {
                char lc = s.charAt(left++);
                char rc = s.charAt(right++);
                window[lc]--;
                window[rc]++;
                if (judge(p)) {
                    result.add(left);
                }
            }
            return result;
        }

        private boolean judge(String p) {
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (window[c] != cnt[c]) {
                    return false;
                }
            }
            return true;
        }
    }
}

package indi.pancras.offer;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation38 {
    class Solution {
        Set<String> result = new HashSet<>();

        public String[] permutation(String s) {
            if (s.isEmpty()) {
                return new String[0];
            }
            char[] chars = new char[s.length()];
            backtrack(s, 0, chars);
            return result.toArray(new String[0]);
        }

        private void backtrack(String s, int index, char[] chars) {
            if (index == s.length()) {
                result.add(new String(chars));
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 0) {
                    chars[i] = s.charAt(index);
                    backtrack(s, index + 1, chars);
                    chars[i] = 0;
                }
            }
        }
    }
}

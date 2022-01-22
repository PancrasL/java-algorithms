package indi.pancras.labuladuo.string;

public class Strstr28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            int len = haystack.length() - needle.length() + 1;
            for (int i = 0; i < len; i++) {
                if (isSubstr(haystack, needle, i)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean isSubstr(String haystack, String needle, int start) {
            if (haystack.length() - start < needle.length()) {
                return false;
            }
            for (int i = 0; i < needle.length(); i++) {
                if (haystack.charAt(start++) != needle.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}

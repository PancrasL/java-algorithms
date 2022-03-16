package indi.pancras.offer;

import java.util.ArrayList;

public class ReverseWords58 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.reverseWords("  hello world!  ");
        System.out.println(s1);
    }

    static class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            ArrayList<String> list = new ArrayList<>();
            int left = -1, right = 0;
            while (true) {
                left = nextChar(s, right);
                if (left == s.length()) {
                    break;
                }
                right = nextSpace(s, left);
                list.add(s.substring(left, right));
            }
            if (list.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i)).append(' ');
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        // 下一个非空字符
        private int nextChar(String s, int index) {
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            return index;
        }

        // 下一个空字符
        private int nextSpace(String s, int index) {
            while (index < s.length() && s.charAt(index) != ' ') {
                index++;
            }
            return index;
        }
    }
}

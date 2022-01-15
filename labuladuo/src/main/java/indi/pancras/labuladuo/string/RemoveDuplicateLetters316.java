package indi.pancras.labuladuo.string;

import java.util.LinkedList;

public class RemoveDuplicateLetters316 {
    static class Solution {
        int[] cnts = new int[26];

        public String removeDuplicateLetters(String s) {
            // 统计s的词频
            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i) - 'a']++;
            }

            // 单调栈
            LinkedList<Character> list = new LinkedList<>();
            list.addFirst(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                while (!list.isEmpty() && c < list.getLast() && cnts[list.getLast() - 'a'] > 1) {
                    cnts[list.getLast() - 'a']--;
                    list.removeLast();
                }
                list.addLast(c);
            }
            StringBuilder sb = new StringBuilder();
            while (!list.isEmpty()) {

                sb.append(list.removeFirst());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = s.removeDuplicateLetters("bcabc");
        System.out.println(str);
    }
}

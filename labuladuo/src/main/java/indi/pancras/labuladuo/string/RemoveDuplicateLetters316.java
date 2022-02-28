package indi.pancras.labuladuo.string;

import java.util.LinkedList;

public class RemoveDuplicateLetters316 {
    static class Solution {
        // 记录串s中余下串的各个字符的词频
        int[] cnts = new int[26];
        // 记录单调栈中是否存在该字符
        boolean[] exists = new boolean[26];

        public String removeDuplicateLetters(String s) {
            // 统计s的词频
            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i) - 'a']++;
            }

            // 单调栈
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnts[c - 'a']--;
                if (isExist(c)) {//栈中已有该元素，则不再入栈
                    continue;
                }
                while (!list.isEmpty() && c < list.getLast() && cnts[list.getLast() - 'a'] > 0) {
                    setExist(list.getLast(), false);
                    list.removeLast();
                }
                list.addLast(c);
                setExist(list.getLast(), true);
            }
            StringBuilder sb = new StringBuilder();

            while (!list.isEmpty()) {
                char c = list.removeFirst();
                sb.append(c);
            }
            return sb.toString();
        }

        private boolean isExist(char c) {
            return exists[c - 'a'];
        }

        private void setExist(char c, boolean val) {
            exists[c - 'a'] = val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //String str = s.removeDuplicateLetters("bbcaac");
        //String str2 = s.removeDuplicateLetters("bddbccd");
        String str3 = s.removeDuplicateLetters("ecbacba");
        //System.out.println(str);
       // System.out.println(str2);
        System.out.println(str3);
    }
}

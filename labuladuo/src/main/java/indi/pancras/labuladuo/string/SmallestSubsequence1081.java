package indi.pancras.labuladuo.string;

import java.util.LinkedList;

public class SmallestSubsequence1081 {
    class Solution {
        public String smallestSubsequence(String s) {
            // 统计s的词频
            int[] cnts = new int[256];
            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i)]++;
            }

            // 单调栈
            LinkedList<Character> list = new LinkedList<>();
            // 记录单调栈中是否存在字符c
            boolean[] exist = new boolean[256];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnts[c]--;
                if (exist[c]) {
                    continue;
                }
                while (!list.isEmpty() && c < list.getLast() && cnts[list.getLast()] > 0) {
                    exist[list.getLast()] = false;
                    list.removeLast();
                }
                list.addLast(c);
                exist[c] = true;
            }
            StringBuilder sb = new StringBuilder();
            while (!list.isEmpty()) {
                sb.append(list.removeFirst());
            }
            return sb.toString();
        }
    }
}

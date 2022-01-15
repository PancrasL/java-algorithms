package indi.pancras.labuladuo.string;

import java.util.LinkedList;

public class RemoveKDigits402 {
    static class Solution {
        public String removeKdigits(String num, int k) {
            LinkedList<Character> list = new LinkedList<>();

            list.addLast(num.charAt(0));
            int deleteNum = 0;
            for (int i = 1; i < num.length(); i++) {
                char c = num.charAt(i);
                while (deleteNum != k && !list.isEmpty() && c < list.getLast()) {
                    list.removeLast();
                    deleteNum++;
                }
                list.addLast(c);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length() - k; i++) {
                sb.append(list.removeFirst());
            }
            String zeroS = sb.toString();
            int i = 0;
            while (i < zeroS.length() && zeroS.charAt(i) == '0') {
                i++;
            }
            return i == zeroS.length() ? "0" : zeroS.substring(i);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.removeKdigits("123456", 3);
        String s2 = s.removeKdigits("10001", 4);
        System.out.println(s1);
        System.out.println(s2);
        String s3 = s.removeKdigits("1234567890", 9);
        System.out.println(s3);
    }
}

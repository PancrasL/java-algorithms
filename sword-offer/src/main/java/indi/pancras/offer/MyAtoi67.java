package indi.pancras.offer;

public class MyAtoi67 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strToInt("1"));
        System.out.println(s.strToInt("42"));
        System.out.println(s.strToInt("  -42"));
        System.out.println(s.strToInt("  -42  "));
        System.out.println(s.strToInt("  -42abc"));
        System.out.println(s.strToInt("  a-42abc"));
        System.out.println(s.strToInt("  9999999999999"));
        System.out.println(s.strToInt("  -9999999999999"));
    }

    static class Solution {
        public int strToInt(String str) {
            int pos = 0;
            int len = str.length();
            int flag = 1;
            while (pos < len) {
                char c = str.charAt(pos);
                if (Character.isWhitespace(c)) {
                    pos++;
                } else if (c == '+') {
                    flag = 1;
                    pos++;
                    break;
                } else if (c == '-') {
                    flag = -1;
                    pos++;
                    break;
                } else if (Character.isDigit(c)) {
                    break;
                } else {
                    return 0;
                }
            }

            long value = 0;
            while (pos < len) {
                char c = str.charAt(pos);
                if (!Character.isDigit(c)) {
                    break;
                }
                value = value * 10 + c - '0';
                if (value > Integer.MAX_VALUE) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                pos++;
            }
            return (int) (value * flag);
        }
    }
}

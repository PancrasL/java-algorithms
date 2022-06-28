package indi.pancras.top;

public class ReverseInteger7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse((int) 8463847412L));
        System.out.println(s.reverse(Integer.MAX_VALUE));
        System.out.println(s.reverse(Integer.MIN_VALUE));
    }

    static class Solution {
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            int flag = x >= 0 ? 1 : -1;
            x *= flag;
            int res = 0;
            while (x != 0) {
                if (res > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                res = res * 10 + (x % 10);
                x /= 10;
            }
            return res * flag;
        }
    }
}

package indi.pancras.offer;

public class FindNthDigit44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNthDigit(100));
        System.out.println(s.findNthDigit(10));
        System.out.println(s.findNthDigit(11));
    }

    static class Solution {
        // 1位数有1*9个
        // 2位数有10*9个
        // 3位数有100*9个
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 1;

            while (true) {
                count += start * 9 * digit;
                if (count >= n) {
                    count -= start * 9 * digit;
                    break;
                }
                start *= 10;
                digit++;
            }
            n = (int) (n - count);
            // 跳出循环后，从start开始，向后数n位就是答案
            long num = start + n / digit;
            return Long.toString(num).charAt(n % digit) - '0';
        }
    }
}

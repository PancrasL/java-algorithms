package indi.pancras.math;

public class ConvertInteger {
    static class Solution {
        public int convertInteger(int A, int B) {
            int cnt = 0;
            for(int c = A^B;c!=0;c&=(c-1),cnt++);
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.convertInteger(15, 29);
        System.out.println(res);
    }
}

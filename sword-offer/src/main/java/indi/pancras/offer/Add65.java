package indi.pancras.offer;

public class Add65 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.add(-10, 22));
    }

    static class Solution {
        public int add(int a, int b) {
            int sum = 0;
            int carry = 0;
            for (int i = 0; i < 32; i++) {
                int aBit = a & 1;
                int bBit = b & 1;
                sum |= (aBit ^ bBit ^ carry) << i;
                carry = (aBit & bBit) | ((aBit ^ bBit) & carry);
                a >>= 1;
                b >>= 1;
            }
            return sum;
        }
    }
}

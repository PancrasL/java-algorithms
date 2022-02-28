package indi.pancras.offer;

public class ReverseLeftWords58 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            n = n % s.length();
            return s.substring(n) +
                    s.substring(0, n);
        }
    }
}

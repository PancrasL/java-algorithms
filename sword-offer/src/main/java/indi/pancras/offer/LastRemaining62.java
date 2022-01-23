package indi.pancras.offer;

import java.util.ArrayList;

public class LastRemaining62 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastRemaining(5, 3));//3
        System.out.println(s.lastRemaining(10, 17));//2
        System.out.println(s.lastRemaining(3, 4));//1
        System.out.println(s.lastRemaining(70866, 116922));//1
    }

    static class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }
}

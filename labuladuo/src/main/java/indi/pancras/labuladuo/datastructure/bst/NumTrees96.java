package indi.pancras.labuladuo.datastructure.bst;

public class NumTrees96 {
    static class Solution {
        public int numTrees(int n) {
            int[] cnt = new int[n + 1];

            cnt[0] = 1;
            cnt[1] = 1;
            for (int i = 2; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= i; j++) {
                    sum += cnt[j - 1] * cnt[i - j];
                }
                cnt[i] = sum;
            }
            return cnt[n];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(1));
        System.out.println(s.numTrees(2));
        System.out.println(s.numTrees(3));
        System.out.println(s.numTrees(4));
    }
}

package indi.pancras.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinousSeq57 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.findContinuousSequence(1);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    static class Solution {
        public int[][] findContinuousSequence(int target) {
            ArrayList<int[]> seqList = new ArrayList<>();
            int left = 1, right = 1;
            int window = 1;
            for (int i = 1; i < target; i++) {
                if (window == target) {
                    seqList.add(getSeq(left, right));
                    right++;
                    window = window + right - left;
                    left++;
                } else if (window < target) {
                    right++;
                    window += right;
                } else {
                    window -= left;
                    left++;
                }
            }
            int[][] result = new int[seqList.size()][];
            int index = 0;
            for (int[] seq : seqList) {
                result[index++] = seq;
            }
            return result;
        }

        private int[] getSeq(int start, int end) {
            int[] seq = new int[end - start + 1];
            int index = 0;
            for (int i = start; i <= end; i++) {
                seq[index++] = i;
            }
            return seq;
        }
    }
}

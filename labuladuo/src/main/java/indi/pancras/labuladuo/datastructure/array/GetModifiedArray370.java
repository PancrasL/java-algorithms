package indi.pancras.labuladuo.datastructure.array;

public class GetModifiedArray370 {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] nums = new int[length];
            for (int[] update : updates) {
                for (int i = update[0]; i <= update[1]; i++) {
                    nums[i] += update[2];
                }
            }
            return nums;
        }
    }

    class Solution1 {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] arr = new int[length + 1];
            for (int[] update : updates) {
                int start = update[0];
                int end = update[1];
                int inc = update[2];
                arr[start] += inc;
                arr[end + 1] -= inc;
            }
            int[] result = new int[length];
            result[0] = arr[0];
            for (int i = 1; i < result.length; i++) {
                result[i] = result[i - 1] + arr[i];
            }
            return result;
        }
    }
}

package indi.pancras.offer;

import java.util.Arrays;

public class SingleNumbers56 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.singleNumbers(new int[]{1, 1, 2, 3});
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] singleNumbers(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            // xor = x ^ y，xor一定不为0
            // 找到xor为1的位
            int m = 0;
            while ((xor & 1) != 1) {
                xor >>= 1;
                m++;
            }
            // xor的第m位为1，且x,y的第m位一定不同
            // 以第m位是否为1的进行分组，可以保证x，y分到两组中（因为x、y的第m位一定不同）
            int x = 0, y = 0;
            for (int num : nums) {
                if (((num >> m) & 1) == 1) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};
        }
    }
}

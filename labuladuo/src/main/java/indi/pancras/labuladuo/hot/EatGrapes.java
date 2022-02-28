package indi.pancras.labuladuo.hot;

import java.util.Arrays;
import java.util.Scanner;

public class EatGrapes {
    public static void main(String[] args) {
        int T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt(10);
        for (int i = 0; i < T; i++) {
            long[] nums = new long[3];
            nums[0] = s.nextLong(10);
            nums[1] = s.nextLong(10);
            nums[2] = s.nextLong(10);
            System.out.println(eatGrape(nums));
        }
    }

    private static long eatGrape(long[] nums) {
        Arrays.sort(nums);
        // 平均每个人吃avg个葡萄
        long avg = (nums[0] + nums[1] + nums[2]) / 3;
        long flag = (nums[0] + nums[1] + nums[2]) % 3;
        // 排序后一定存在nums[0] <= avg, nums[2] >= avg
        if (nums[1] <= avg) {
            // 先吃nums1，然后吃nums0
            if (avg - nums[1] >= nums[0]) {
                nums[0] = 0;
            } else {
                nums[0] -= avg - nums[1];
            }
            nums[2] -= avg - nums[0];
            nums[2] -= avg;
            return avg + (1 + nums[2]) / 2;
        } else {
            nums[1] -= avg;
            nums[2] -= avg - nums[0];
            long sum = nums[1] + nums[2];
            return flag == 2 ? sum - 1 : sum;
        }
    }
}

package indi.pancras.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 5, 8, 9, 3};
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    // 排序nums的[start, end]区间
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = findIndex(nums, start, end);
        sort(nums, start, index - 1);
        sort(nums, index + 1, end);
    }

    private static int findIndex(int[] nums, int start, int end) {
        // 将数组中大于temp的元素放到后面，小于temp的元素放到前面
        int temp = nums[start];

        while (start != end) {
            // 从后向前搜索，找到第一个值小于temp的数，交换位置，然后从前向后搜索
            while (start != end && nums[end] >= temp) {
                end--;
            }
            nums[start] = nums[end];
            // 交换完位置后，从前向后搜索，找到第一个值大于temp的元素，交换位置
            while (start != end && nums[start] <= temp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
}

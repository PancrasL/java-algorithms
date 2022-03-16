package indi.pancras.offer;

public class RotateArray11 {
    class Solution {
        public int minArray(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }
            return numbers[0];
        }
    }

    // 二分查找法：可以看成两个有序数组，且右数组的所有元素小于左数组的任一元素
    class Solution1 {
        public int minArray(int[] numbers) {
            int left = 0, right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < numbers[right]) {//mid在右边，旋转点位于[left,mid]
                    right = mid;
                } else if (numbers[mid] > numbers[right]) {//mid在左边，旋转点位于[mid+1,right]
                    left = mid + 1;
                } else {//无法确定
                    right = right - 1;
                }
            }
            return numbers[right + 1];
        }
    }
}

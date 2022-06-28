package indi.pancras.hot100.firsttime;

public class MaxArea11 {

    class Solution {

        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxCapacity = 0;
            while (left < right) {
                int width = right - left;
                if (height[right] < height[left]) {
                    maxCapacity = Math.max(maxCapacity, width * height[right]);
                    right--;
                } else {
                    maxCapacity = Math.max(maxCapacity, width * height[left]);
                    left++;
                }
            }
            return maxCapacity;
        }
    }
}

package indi.pancras.hot100.firsttime;

public class FindMedianSortedArrays04 {

    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];
            int p1 = 0, p2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (p1 != nums1.length && p2 != nums2.length) {
                    if (nums1[p1] < nums2[p2]) {
                        nums[i] = nums1[p1];
                        p1++;
                    } else {
                        nums[i] = nums2[p2];
                        p2++;
                    }
                } else if (p1 != nums1.length) {
                    nums[i] = nums1[p1];
                    p1++;
                } else if (p2 != nums2.length) {
                    nums[i] = nums2[p2];
                    p2++;
                }
            }
            if ((nums.length & 1) == 1) {
                return nums[nums.length / 2];
            } else {
                return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
            }
        }
    }
}

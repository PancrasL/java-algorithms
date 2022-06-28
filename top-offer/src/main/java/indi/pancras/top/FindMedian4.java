package indi.pancras.top;

public class FindMedian4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6, 7}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    // TODO 二分查找算法
//    class Solution1 {
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        }
//    }

    static class Solution {
        int index1, index2;

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int numCount = nums1.length + nums2.length;
            boolean flag = (numCount & 1) == 0;

            numCount /= 2;
            int first = 0;
            index1 = 0;
            index2 = 0;
            for (int i = 0; i < numCount; i++) {
                first = findNext(nums1, nums2);
            }
            if (flag) {//偶数个
                int second = findNext(nums1, nums2);
                return (first + second) / 2.0;
            } else {//奇数个
                return findNext(nums1, nums2);
            }
        }

        private int findNext(int[] nums1, int[] nums2) {
            int val;
            if (index1 == nums1.length) {
                val = nums2[index2++];
            } else if (index2 == nums2.length) {
                val = nums1[index1++];
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    val = nums1[index1++];
                } else {
                    val = nums2[index2++];
                }
            }
            return val;
        }
    }
}

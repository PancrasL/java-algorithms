package indi.pancras.array;

/**
 * @author pancras
 * @tip 从尾部合并
 * @create 2021/4/8 11:04
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/">合并两个有序数组</a>
 */
public class MergeTwoArrays {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int last1 = m - 1;
            int last2 = n - 1;

            int pos = m + n - 1;

            while (last1 >= 0 && last2 >= 0) {
                if (nums1[last1] > nums2[last2]) {
                    nums1[pos--] = nums1[last1--];
                } else if (nums1[last1] < nums2[last2]) {
                    nums1[pos--] = nums2[last2--];
                } else {
                    nums1[pos--] = nums1[last1--];
                    nums1[pos--] = nums2[last2--];
                }
            }
            while (last2 >= 0) {
                nums1[pos--] = nums2[last2--];
            }
        }
    }
}

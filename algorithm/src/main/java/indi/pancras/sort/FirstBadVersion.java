package indi.pancras.sort;

/**
 * @author pancras
 * @tip 二分查找
 * @create 2021/4/8 11:11
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/">第一个错误版本</a>
 */
public class FirstBadVersion {

    boolean isBadVersion(int version) {
        return false;
    }

    class Solution {
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;

            while (low <= high) {
                int mid = ((high - low) / 2) + low;
                if (isBadVersion(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}

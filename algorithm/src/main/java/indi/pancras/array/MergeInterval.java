package indi.pancras.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 * @解题思路 将区间按照起始值排序，然后遍历一边，将连起来的区间组合在一起。
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/">合并区间</a>
 */
public class MergeInterval {
    public int[][] run(int[][] intervals) {
        Solution s = new Solution();
        return s.merge(intervals);
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            // 将区间按照起始值进行升序排序
            Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);

            ArrayList<int[]> result = new ArrayList<>();

            int expandingLeft, expandingRight;
            expandingLeft = intervals[0][0];
            expandingRight = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= expandingRight) {
                    expandingRight = Math.max(expandingRight, intervals[i][1]);
                } else {
                    result.add(createInterval(expandingLeft, expandingRight));
                    expandingLeft = intervals[i][0];
                    expandingRight = intervals[i][1];
                }
            }
            result.add(createInterval(expandingLeft, expandingRight));

            return result.toArray(new int[0][]);
        }

        private int[] createInterval(int left, int right) {
            int[] t = new int[2];
            t[0] = left;
            t[1] = right;
            return t;
        }
    }
}

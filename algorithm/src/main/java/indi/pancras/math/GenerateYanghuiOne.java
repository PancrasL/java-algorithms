package indi.pancras.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pancras
 * @解题思路 略
 * @create 2021/3/15 21:35
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/cuj3m/">前n行杨辉三角</a>
 */
public class GenerateYanghuiOne {
    public List<List<Integer>> run(int numRows) {
        return new Solution().generate(numRows);
    }

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            for (int i = 1; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i; j++) {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                list.add(1);
                result.add(list);
            }

            return result;
        }
    }
}

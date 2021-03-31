package indi.pancras.math;

import java.util.Arrays;
import java.util.List;

/**
 * @author pancras
 * @tip 原位处理，空间复杂度O(n)，基于第n行杨辉三角从尾部生成第n+1行的数据
 * @create 2021/3/15 21:35
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/ctyt1/">第n行杨辉三角</a>
 */
public class GenerateYanghuiTwo {
    public List<Integer> run(int rowIndex) {
        return new Solution().getRow(rowIndex);
    }

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            Integer[] result = new Integer[rowIndex + 1];

            result[0] = 1;
            for (int i = 1; i <= rowIndex; i++) {
                result[i] = 1;
                for (int j = i - 1; j > 0; j--) {
                    result[j] = result[j] + result[j - 1];
                }
            }
            return Arrays.asList(result);
        }
    }
}

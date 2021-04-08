package indi.pancras.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pancras
 * @tip 倒叙相加，结果反转，注意进位
 * @create 2021/4/3 16:25
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/">加一</a>
 */
public class PlusOneArray {
    public int[] run(int[] digits) {
        return new Solution().plusOne(digits);
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            List<Integer> result = new ArrayList<>();

            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i] + carry;
                carry = num / 10;
                num %= 10;

                result.add(num);
            }
            if (carry == 1)
                result.add(1);
            Collections.reverse(result);

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

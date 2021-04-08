package indi.pancras.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pancras
 * @create 2021/4/8 16:20
 * @tip 三遍遍历
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/">FizzBuzz</a>
 */
public class FizzBuzz {
    public List<String> run(int n) {
        return new Solution().fizzBuzz(n);
    }

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                list.add(Integer.toString(i + 1));
            }
            for (int i = 2; i < n; i += 3) {
                list.set(i, "Fizz");
            }
            for (int i = 4; i < n; i += 5) {
                list.set(i, "Buzz");
            }
            for (int i = 14; i < n; i += 15) {
                list.set(i, "FizzBuzz");
            }
            return list;
        }
    }
}
package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backtrack(n, 0, 0, new ArrayList<>());
            return result;
        }

        private void backtrack(int n, int leftNum, int rightNum, List<Character> cur) {
            if (leftNum == n && rightNum == n) {
                StringBuilder sb = new StringBuilder();
                for (Character c : cur) {
                    sb.append(c);
                }
                result.add(sb.toString());
                return;
            }
            // 添加一个左括号
            if (leftNum < n) {
                cur.add('(');
                backtrack(n, leftNum + 1, rightNum, cur);
                cur.remove(cur.size() - 1);
            }

            // 添加一个右括号
            if (rightNum < leftNum) {
                cur.add(')');
                backtrack(n, leftNum, rightNum + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

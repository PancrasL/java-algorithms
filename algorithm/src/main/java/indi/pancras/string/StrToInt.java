package indi.pancras.string;

/**
 * @author pancras
 * @tip 字符串处理
 * @create 2021/4/6 16:42
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/">字符串转整数</a>
 */
public class StrToInt {
    public int run(String s) {
        return new Solution().myAtoi(s);
    }

    class Solution {
        public int myAtoi(String s) {
            int len = s.length();
            int flag = 1;

            int pos = 0;
            while (pos < len) {
                char ch = s.charAt(pos);
                if (Character.isWhitespace(ch))
                    pos++;
                else if (ch == '+') {
                    flag = 1;
                    pos++;
                    break;
                } else if (ch == '-') {
                    flag = -1;
                    pos++;
                    break;
                } else if (Character.isDigit(ch))
                    break;
                else
                    return 0;
            }

            long result = 0;
            while (pos < len && Character.isDigit(s.charAt(pos))) {
                result = result * 10 + s.charAt(pos) - '0';
                if (result > Integer.MAX_VALUE) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                pos++;
            }
            return (int) result * flag;
        }
    }
}

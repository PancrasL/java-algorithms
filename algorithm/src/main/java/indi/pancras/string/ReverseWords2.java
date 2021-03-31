package indi.pancras.string;

/**
 * @author pancras
 * @tip 根据空格截取单词，然后对单词进行翻转
 * @create 2021/3/16 16:15
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/c8su7/">反转字符串中的单词 III</a>
 */
public class ReverseWords2 {
    public String run(String s) {
        return new Solution().reverseWords(s);
    }

    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            int left = 0;
            int right;
            while (left < s.length()) {
                right = s.indexOf(' ', left);
                if (right == -1) {
                    int rBorder = s.length() - 1;
                    while (rBorder >= left) {
                        sb.append(s.charAt(rBorder--));
                    }
                    sb.append(' ');
                    break;
                } else {
                    int rBorder = right - 1;
                    while (rBorder >= left) {
                        sb.append(s.charAt(rBorder--));

                    }
                    sb.append(' ');
                    left = right + 1;
                }
            }
            sb.setLength(sb.length() - 1);

            return sb.toString();
        }
    }
}

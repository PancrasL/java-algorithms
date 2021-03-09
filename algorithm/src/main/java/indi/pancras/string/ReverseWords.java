package indi.pancras.string;

/**
 * @author pancras
 * @解题思路 调用库函数s.split()
 * @create 2021/3/15 9:31
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/crmp5/">翻转字符串里的单词</a>
 */
public class ReverseWords {
    public String run(String s) {
        Solution sl = new Solution();
        return sl.reverseWords(s);
    }

    class Solution {
        public String reverseWords(String s) {

            String[] arr = s.split("\\s+");

            StringBuilder sb = new StringBuilder();

            int bound = arr[0].equals("") ? 1 : 0;
            int index = arr.length - 1;
            while (index >= bound) {
                sb.append(arr[index]);
                sb.append(' ');
                index--;
            }
            sb.setLength(sb.length() - 1);

            return sb.toString();
        }
    }
}

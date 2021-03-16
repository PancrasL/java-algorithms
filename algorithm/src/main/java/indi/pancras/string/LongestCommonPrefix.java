package indi.pancras.string;

/**
 * @author pancras
 * @create 2021/3/12 13:36
 * @解题思路 顺序遍历找最长公共前缀
 * @see <a href="https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/">最长公共前缀</a>
 */
public class LongestCommonPrefix {
    public String run(String[] strs) {
        Solution s = new Solution();
        return s.longestCommonPrefix(strs);
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0 || strs[0].length() == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);

                boolean isPrefix = true;
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                        isPrefix = false;
                        break;
                    }
                }

                if (isPrefix) {
                    sb.append(c);
                } else {
                    break;
                }
            }

            return sb.toString();
        }
    }
}

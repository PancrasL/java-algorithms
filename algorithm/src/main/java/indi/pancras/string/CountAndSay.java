package indi.pancras.string;

/**
 * @author pancras
 * @tip 将数字分为组，按组进行描述
 * @create 2021/4/7 16:56
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/">外观数列</a>
 */
public class CountAndSay {
    public String run(int n) {
        return new Solution().countAndSay(n);
    }

    class Solution {
        public String countAndSay(int n) {
            String str = "1";
            for (int i = 2; i <= n; i++) {
                StringBuilder sb = new StringBuilder();
                int start = 0;
                while (start < str.length()) {
                    int count = countChar(str, start, str.charAt(start));
                    sb.append(count).append(str.charAt(start));
                    start += count;
                }
                str = sb.toString();
            }

            return str;
        }

        private int countChar(String s, int start, char ch) {
            int count = 0;
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(i) != ch)
                    break;
                count++;
            }
            return count;
        }
    }
}


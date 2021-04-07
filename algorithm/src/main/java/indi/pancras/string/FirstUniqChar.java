package indi.pancras.string;

/**
 * @author pancras
 * @tip 哈希表
 * @create 2021/4/6 16:36
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/">字符串中第一个唯一字符</a>
 */
public class FirstUniqChar {
    class Solution {
        public int firstUniqChar(String s) {
            int[] map = new int[256];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)]++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (map[s.charAt(i)] == 1)
                    return i;
            }
            return -1;
        }
    }
}

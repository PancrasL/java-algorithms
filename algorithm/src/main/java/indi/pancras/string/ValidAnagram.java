package indi.pancras.string;

import java.util.Arrays;

/**
 * @author pancras
 * @tip 1. 哈希表 2. 排序
 * @create 2021/4/6 16:37
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/">有效的字母异位词</a>
 */
public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;

            int[] map1 = new int[256];
            int[] map2 = new int[256];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                map1[s.charAt(i)]++;
                map2[t.charAt(i)]++;
            }

            for (int i = 'a'; i <= 'z'; i++) {
                if (map1[i] != map2[i])
                    return false;
            }
            return true;
        }

        public boolean isAnagram1(String s, String t) {
            char[] ch1 = s.toCharArray();
            char[] ch2 = t.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            return Arrays.equals(ch1, ch2);
        }
    }
}

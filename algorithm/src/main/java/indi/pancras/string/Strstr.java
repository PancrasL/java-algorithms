package indi.pancras.string;

/**
 * @author pancras
 * @tip 1. 使用String.indexof() 2. KMP算法<a href="https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/">KMP</a>
 * @create 2021/4/6 19:24
 */
public class Strstr {
    class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

}

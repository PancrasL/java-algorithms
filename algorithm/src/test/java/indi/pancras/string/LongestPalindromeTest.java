package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/12 14:16
 */
class LongestPalindromeTest {

    @Test
    void test() {
        LongestPalindrome t = new LongestPalindrome();
        assertEquals("", t.run(""));
        assertEquals("a", t.run("abcde"));
        assertEquals("bab", t.run("babad"));
        assertEquals("bcdefgfedcb", t.run("abcdefgfedcbb"));
        assertEquals("bcdeffedcb", t.run("abcdeffedcbb"));
    }
}
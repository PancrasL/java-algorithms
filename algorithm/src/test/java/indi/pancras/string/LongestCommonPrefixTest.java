package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/12 13:45
 */
class LongestCommonPrefixTest {

    @Test
    void test() {
        LongestCommonPrefix t = new LongestCommonPrefix();

        assertEquals("", t.run(new String[0]));
        assertEquals("", t.run(new String[]{"", "ab", "ccc"}));

        assertEquals("aa", t.run(new String[]{"aaa", "aa", "aab"}));
        assertEquals("afa", t.run(new String[]{"afaaadadasf", "afa", "afabdd"}));


    }
}
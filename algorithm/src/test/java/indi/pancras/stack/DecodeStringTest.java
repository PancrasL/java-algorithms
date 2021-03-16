package indi.pancras.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/23 13:12
 */
class DecodeStringTest {

    @Test
    void test() {
        DecodeString t = new DecodeString();

        assertEquals("aaabcbc", t.run("3[a]2[bc]"));
        assertEquals("accaccacc", t.run("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", t.run("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", t.run("abc3[cd]xyz"));

    }
}
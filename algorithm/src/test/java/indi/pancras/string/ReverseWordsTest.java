package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/15 9:38
 */
class ReverseWordsTest {

    @Test
    void test() {
        ReverseWords t = new ReverseWords();

        assertEquals("world! hello", t.run("  hello  world!  "));
        assertEquals("d abc", t.run("   abc     d"));
        assertEquals("a", t.run("   a   "));
        assertEquals("blue is sky the", t.run("the sky is blue"));

    }
}
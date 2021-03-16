package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/16 16:28
 */
class ReverseWords2Test {

    @Test
    void test() {
        ReverseWords2 t = new ReverseWords2();

        assertEquals("a", t.run("a"));
        assertEquals("cba", t.run("abc"));

        assertEquals("a ba cba ba !a", t.run("a ab abc ab a!"));
    }

}
package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/7 16:58
 */
class CountAndSayTest {

    @Test
    void test() {
        CountAndSay t = new CountAndSay();
        assertEquals("1", t.run(1));
        assertEquals("11", t.run(2));
        assertEquals("21", t.run(3));
        assertEquals("1211", t.run(4));
        assertEquals("111221", t.run(5));
        //assertEquals("111221", t.run(30));
    }
}
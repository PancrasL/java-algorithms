package indi.pancras.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/6 16:43
 */
class StrToIntTest {

    @Test
    void test() {
        StrToInt t = new StrToInt();

        assertEquals(123, t.run("00123"));
        assertEquals(-1234, t.run("-1234"));
        assertEquals(0, t.run("    -  "));
        assertEquals(4193, t.run("4193 with words"));
        assertEquals(0, t.run("words and 987"));
        assertEquals(Integer.MIN_VALUE, t.run("-91283472332"));
        assertEquals(Integer.MIN_VALUE, t.run("-6147483648"));
        assertEquals(Integer.MAX_VALUE, t.run("91283472332"));
    }
}
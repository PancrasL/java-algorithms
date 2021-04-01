package indi.pancras.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/31 16:46
 */
class MyPowTest {

    @Test
    void test() {
        MyPow t = new MyPow();
        assertEquals(1.0, t.run(1, 0));
        assertEquals(1.0, t.run(1, 10000));

        assertEquals(0, t.run(0, 10000));
        assertEquals(1.0, t.run(0, 0));

        assertEquals(0.25, t.run(2, -2));
        assertEquals(1024, t.run(2, 10));
    }
}
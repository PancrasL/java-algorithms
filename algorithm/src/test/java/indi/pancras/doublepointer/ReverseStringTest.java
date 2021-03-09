package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/15 10:57
 */
class ReverseStringTest {

    @Test
    void test() {
        ReverseString t = new ReverseString();
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, t.run(new char[]{'d', 'c', 'b', 'a'}));
        assertArrayEquals(new char[]{' '}, t.run(new char[]{' '}));
    }
}
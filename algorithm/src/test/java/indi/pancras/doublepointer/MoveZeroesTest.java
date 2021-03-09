package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/16 20:17
 */
class MoveZeroesTest {

    @Test
    void test() {
        MoveZeroes t = new MoveZeroes();

        assertArrayEquals(new int[]{0, 0, 0}, t.run(new int[]{0, 0, 0}));
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, t.run(new int[]{1, 0, 2, 0, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0, 0}, t.run(new int[]{0, 1, 0, 2, 0, 3, 0}));
        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0, 0, 0}, t.run(new int[]{1, 0, 0, 0, 2, 0, 3, 0}));
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, t.run(new int[]{1, 2, 0, 3, 0}));

    }
}
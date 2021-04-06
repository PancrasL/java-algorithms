package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/4/3 16:33
 */
class PlusOneArrayTest {

    @Test
    void test() {
        PlusOneArray t = new PlusOneArray();

        assertArrayEquals(new int[]{1, 2, 4}, t.run(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, t.run(new int[]{9, 9, 9}));

    }
}
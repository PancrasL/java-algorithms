package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/11 17:18
 */
class SetZeoresTest {

    @Test
    void test() {
        SetZeores t = new SetZeores();
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, t.run(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertArrayEquals(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, t.run(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));

        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 1}}, t.run(new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
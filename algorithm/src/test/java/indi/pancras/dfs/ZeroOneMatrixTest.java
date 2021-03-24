package indi.pancras.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/24 9:33
 */
class ZeroOneMatrixTest {

    @Test
    void test() {
        ZeroOneMatrix t = new ZeroOneMatrix();

        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, t.run(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, t.run(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        assertArrayEquals(new int[][]{{0}, {1}}, t.run(new int[][]{{0}, {1}}));
        assertArrayEquals(new int[][]{{0, 1, 0, 1, 2}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}, t.run(new int[][]{{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}));

    }
}
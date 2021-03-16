package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 */
class RotateMatrixTest {
    @Test
    void test() {
        RotateMatrix t = new RotateMatrix();

        assertArrayEquals(new int[][]{{1}}, t.run(new int[][]{{1}}));
        assertArrayEquals(new int[][]{{2, 1}, {2, 1}}, t.run(new int[][]{{1, 1}, {2, 2}}));
        assertArrayEquals(new int[][]{{3, 2, 1}, {3, 2, 1}, {3, 2, 1}}, t.run(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}));
        assertArrayEquals(new int[][]{{4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}}, t.run(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}}));
    }

}
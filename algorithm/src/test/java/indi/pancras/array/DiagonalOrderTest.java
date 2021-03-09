package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/11 19:39
 */
class DiagonalOrderTest {
    @Test
    void test() {
        DiagonalOrder t = new DiagonalOrder();

        assertArrayEquals(new int[0], t.run(null));

        int[][] m1 = new int[0][0];
        assertArrayEquals(new int[0], t.run(m1));

        int[][] m2 = new int[][]{{1}};
        assertArrayEquals(new int[]{1}, t.run(m2));

        int[][] m3 = new int[][]{{1, 1}, {2, 2}};
        assertArrayEquals(new int[]{1, 1, 2, 2}, t.run(m3));

        int[][] m4 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, t.run((m4)));

        int[][] m5 = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        assertArrayEquals(new int[]{1, 1, 2, 3, 2, 1, 1, 2, 3, 4, 4, 3, 2, 3, 4, 4}, t.run((m5)));

        int[][] m6 = new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5}};
        assertArrayEquals(new int[]{1, 1, 2, 3, 2, 1, 2, 3, 4, 5, 4, 3, 4, 5, 5}, t.run((m6)));

        int[][] m7 = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}};
        assertArrayEquals(new int[]{1, 1, 2, 3, 2, 1, 1, 2, 3, 3, 2, 1, 2, 3, 3}, t.run((m7)));

    }

}
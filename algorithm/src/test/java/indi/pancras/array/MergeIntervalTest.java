package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 */
class MergeIntervalTest {
    @Test
    void test() {
        MergeInterval t = new MergeInterval();

        assertArrayEquals(new int[][]{{1, 7}}, t.run(new int[][]{{3, 7}, {2, 4}, {1, 5}}));
        assertArrayEquals(new int[][]{{-1, 2}, {3, 9}}, t.run(new int[][]{{3, 9}, {-1, 2}}));

        assertArrayEquals(new int[][]{{1, 9}}, t.run(new int[][]{{1, 3}, {2, 5}, {4, 9}}));
        assertArrayEquals(new int[][]{{1, 6}, {8, 13}}, t.run(new int[][]{{1, 5}, {4, 6}, {8, 10}, {9, 13}, {9, 10}}));
    }
}
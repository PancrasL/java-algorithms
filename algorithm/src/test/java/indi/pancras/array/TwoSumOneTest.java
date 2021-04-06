package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/4/3 16:51
 */
class TwoSumOneTest {

    @Test
    void test() {
        TwoSumOne t = new TwoSumOne();

        assertArrayEquals(new int[]{0, 1}, t.run(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, t.run(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, t.run(new int[]{2, 7, 11, 15}, 9));

    }
}
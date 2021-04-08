package indi.pancras.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/8 11:35
 */
class MaxSubArrayTest {

    @Test
    void test() {
        MaxSubArray t = new MaxSubArray();

        assertEquals(1, t.run(new int[]{1}));
        assertEquals(-1, t.run(new int[]{-1}));
        assertEquals(0, t.run(new int[]{0}));
        assertEquals(1, t.run(new int[]{-2, 1}));
        assertEquals(-1, t.run(new int[]{-2, -1}));
        assertEquals(0, t.run(new int[]{-1, 0, -2}));
        assertEquals(6, t.run(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }
}
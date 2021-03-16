package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 */
class PivotIndexTest {
    @Test
    void test() {
        PivotIndex t = new PivotIndex();

        //空数组
        assertEquals(-1, t.run(new int[0]));
        //单数组
        assertEquals(0, t.run(new int[]{1}));

        assertEquals(-1, t.run(new int[]{1, 2}));
        assertEquals(-1, t.run(new int[]{1, -1}));
        assertEquals(0, t.run(new int[]{2, 1, -1}));
        assertEquals(3, t.run(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(2, t.run(new int[]{1, -1, 2}));
    }
}
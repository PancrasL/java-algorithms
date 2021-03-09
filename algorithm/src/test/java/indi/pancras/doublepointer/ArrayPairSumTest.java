package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/15 11:02
 */
class ArrayPairSumTest {

    @Test
    void test() {
        ArrayPairSum t = new ArrayPairSum();

        assertEquals(1, t.run(new int[]{1, 2}));
        assertEquals(1, t.run(new int[]{1}));
        assertEquals(4, t.run(new int[]{1, 2, 3}));
    }
}
package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/16 16:41
 */
class FindMinInRotateArrayTest {

    @Test
    void test() {
        FindMinInRotateArray t = new FindMinInRotateArray();

        assertEquals(1, t.run(new int[]{1}));
        assertEquals(1, t.run(new int[]{2, 3, 4, 5, 1}));
        assertEquals(1, t.run(new int[]{4, 5, 1, 2, 3}));
        assertEquals(1, t.run(new int[]{1, 2, 3, 4, 5}));
    }
}
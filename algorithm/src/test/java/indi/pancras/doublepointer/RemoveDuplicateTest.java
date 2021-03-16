package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/16 16:51
 */
class RemoveDuplicateTest {

    @Test
    void test() {
        RemoveDuplicate t = new RemoveDuplicate();

        assertEquals(1, t.run(new int[]{1, 1, 1, 1}));
        assertEquals(2, t.run(new int[]{1, 1, 2, 2}));
        assertEquals(2, t.run(new int[]{-1, -1, 2, 2}));
        assertEquals(5, t.run(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
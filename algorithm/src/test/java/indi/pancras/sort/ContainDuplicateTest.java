package indi.pancras.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/4/2 10:43
 */
class ContainDuplicateTest {

    @Test
    void test() {
        ContainDuplicate t = new ContainDuplicate();

        assertFalse(t.run(null));
        assertFalse(t.run(new int[]{}));
        assertFalse(t.run(new int[]{1, 2, 3, 4}));
        assertTrue(t.run(new int[]{4, 3, 2, 1, 3}));
    }
}
package indi.pancras.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/4/1 19:40
 */
class ContainsDuplicateTest {

    @Test
    void test() {
        ContainsDuplicate t = new ContainsDuplicate();
        assertTrue(t.run(new int[]{1, 2, 3, 4, 5, 1}));
        assertFalse(t.run(new int[]{}));
        assertFalse(t.run(new int[]{1}));
    }
}
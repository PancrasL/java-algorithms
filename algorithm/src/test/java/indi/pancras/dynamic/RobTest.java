package indi.pancras.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/8 15:59
 */
class RobTest {

    @Test
    void test() {
        Rob t = new Rob();
        assertEquals(4, t.run(new int[]{1, 2, 3, 1}));
        assertEquals(12, t.run(new int[]{2, 7, 9, 3, 1}));
    }
}

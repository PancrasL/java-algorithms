package indi.pancras.byteoperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/3 15:26
 */
class SingleNumberTest {

    @Test
    void test() {
        SingleNumber t = new SingleNumber();

        assertEquals(4, t.run(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 5}));
        assertEquals(1, t.run(new int[]{1}));
    }
}
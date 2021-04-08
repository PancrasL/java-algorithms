package indi.pancras.bitoperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/8 16:58
 */
class HammingWeightTest {

    @Test
    void test() {
        HammingWeight t = new HammingWeight();
        assertEquals(0, t.run(0));
        assertEquals(1, t.run(1));
        assertEquals(3, t.run(7));
    }
}
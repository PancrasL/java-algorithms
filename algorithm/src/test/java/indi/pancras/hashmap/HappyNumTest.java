package indi.pancras.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/4/6 15:58
 */
class HappyNumTest {

    @Test
    void test() {
        HappyNum t = new HappyNum();

        assertTrue(t.run(19));


        assertFalse(t.run(2));
    }
}
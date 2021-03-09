package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/15 19:45
 */
class MinSubArrayLenTest {

    @Test
    void test() {
        MinSubArrayLen t = new MinSubArrayLen();

        // 有解
        assertEquals(1, t.run(5, new int[]{1, 2, 3, 5, 6}));
        // 无解
        assertEquals(1, t.run(5, new int[]{1, 2, 3, 5}));

        // 解在中间
        assertEquals(2, t.run(4, new int[]{1, 2, 2, 2, 1}));


    }
}
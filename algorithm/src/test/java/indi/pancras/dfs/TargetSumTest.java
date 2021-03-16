package indi.pancras.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/23 15:39
 */
class TargetSumTest {

    @Test
    void test() {
        TargetSum t = new TargetSum();

        assertEquals(5, t.run(new int[]{1, 1, 1, 1, 1}, 3));
        assertEquals(2, t.run(new int[]{1, 0}, 1));
    }
}
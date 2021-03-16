package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/15 14:36
 */
class TwoSumTest {

    @Test
    void test() {
        TwoSum t = new TwoSum();

        // 二分查找法
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, t.run(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{2, 7, 11, 15}, 9));

        // 双指针法
        assertArrayEquals(new int[]{1, 2}, t.run1(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, t.run1(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, t.run1(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 2}, t.run1(new int[]{2, 7, 11, 15}, 9));

    }
}
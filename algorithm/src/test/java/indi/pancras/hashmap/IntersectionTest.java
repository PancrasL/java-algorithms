package indi.pancras.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/4/1 20:31
 */
class IntersectionTest {

    @Test
    void test() {
        Intersection t = new Intersection();

        assertArrayEquals(new int[]{2}, t.run(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{1, 2}, t.run(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 1, 1, 2, 2, 7, 8, 9}));
        assertArrayEquals(new int[]{}, t.run(new int[]{}, new int[]{}));

    }
}
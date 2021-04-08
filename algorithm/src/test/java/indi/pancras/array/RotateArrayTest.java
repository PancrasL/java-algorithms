package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/4/2 10:04
 */
public class RotateArrayTest {

    @Test
    void test() {
        RotateArray t = new RotateArray();

        assertArrayEquals(new int[]{}, t.run(new int[]{}, 1));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, t.run(new int[]{1, 2, 3, 4, 5}, 0));
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, t.run(new int[]{1, 2, 3, 4, 5}, 1));
        assertArrayEquals(new int[]{}, t.run(new int[]{}, 1));
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, t.run(new int[]{1, 2, 3, 4, 5}, 6));
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, t.run(new int[]{1, 2, 3, 4, 5}, 3));
        assertArrayEquals(new int[]{3, 4, 1, 2}, t.run(new int[]{1, 2, 3, 4}, 2));
    }


}

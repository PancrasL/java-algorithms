package indi.pancras.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/4/3 16:10
 */
class ArraysIntersectTest {

    @Test
    void run() {
        ArraysIntersect t = new ArraysIntersect();

        int[] result = t.run(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Arrays.sort(result);
        assertArrayEquals(new int[]{2, 2}, result);
        result = t.run(new int[]{4, 5, 9}, new int[]{9, 4, 9, 8, 4});
        Arrays.sort(result);
        assertArrayEquals(new int[]{4, 9}, result);
        result = t.run(new int[]{4, 5, 9, 9}, new int[]{9, 4, 9, 8, 4});
        Arrays.sort(result);
        assertArrayEquals(new int[]{4, 9, 9}, result);

    }
}
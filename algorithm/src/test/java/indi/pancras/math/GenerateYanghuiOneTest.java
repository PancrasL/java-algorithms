package indi.pancras.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author pancras
 * @create 2021/3/15 22:00
 */
class GenerateYanghuiOneTest {

    @Test
    void test() {
        GenerateYanghuiOne t = new GenerateYanghuiOne();

        List<List<Integer>> result = t.run(5);

        assertIterableEquals(Arrays.asList(1), result.get(0));
        assertIterableEquals(Arrays.asList(1, 1), result.get(1));
        assertIterableEquals(Arrays.asList(1, 2, 1), result.get(2));
        assertIterableEquals(Arrays.asList(1, 3, 3, 1), result.get(3));
        assertIterableEquals(Arrays.asList(1, 4, 6, 4, 1), result.get(4));


    }
}
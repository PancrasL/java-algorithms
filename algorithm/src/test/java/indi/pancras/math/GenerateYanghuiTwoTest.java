package indi.pancras.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author pancras
 * @create 2021/3/15 22:23
 */
class GenerateYanghuiTwoTest {

    @Test
    void test() {
        GenerateYanghuiTwo t = new GenerateYanghuiTwo();

        assertIterableEquals(Arrays.asList(1, 4, 6, 4, 1), t.run(4));
        assertIterableEquals(Arrays.asList(1), t.run(0));
    }
}
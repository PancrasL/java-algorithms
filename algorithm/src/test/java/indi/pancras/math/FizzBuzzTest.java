package indi.pancras.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author pancras
 * @create 2021/4/8 16:32
 */
class FizzBuzzTest {

    @Test
    void test() {
        FizzBuzz t = new FizzBuzz();
        assertIterableEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), t.run(15));
    }
}
package indi.pancras.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author pancras
 * @create 2021/3/22 19:41
 */
class DailyTemperaturesTest {

    @Test
    void test() {
        DailyTemperatures t = new DailyTemperatures();

        assertArrayEquals(new int[0], t.run(null));
        assertArrayEquals(new int[0], t.run(new int[0]));

        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, t.run(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
package indi.pancras.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author pancras
 * @create 2021/3/22 11:14
 */
class NumSquaresTest {

    @Test
    void test() {
        NumSquares t = new NumSquares();

        assertEquals(3, t.run(12));
        assertEquals(1, t.run(9));
        assertEquals(2, t.run(2));
    }
}
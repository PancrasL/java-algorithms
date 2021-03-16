package indi.pancras.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/22 20:34
 */
class EvalRPNTest {

    @Test
    void test() {
        EvalRPN t = new EvalRPN();
        assertEquals(6, t.run(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(9, t.run(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(22, t.run(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        }));

    }
}
package indi.pancras.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/3/22 18:50
 */
class ValidParenthesesTest {

    @Test
    void test() {
        ValidParentheses t = new ValidParentheses();

        // assertTrue(t.run(""));
        // assertTrue(t.run(null));
        assertTrue(t.run("({{[]}})"));

        assertFalse(t.run("{{{{{"));
        assertFalse(t.run("{{{}}"));
        assertFalse(t.run(")"));
        assertFalse(t.run("("));
    }
}
package indi.pancras.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/22 18:12
 */
class MinStackTest {

    @Test
    void test() {
        MinStack t = new MinStack();

        t.push(3);
        t.push(2);
        t.push(1);

        assertEquals(1, t.getMin());

        t.pop();
        assertEquals(2, t.getMin());

        t.push(1);
        t.push(1);
        t.push(1);
        t.pop();
        t.pop();
        assertEquals(1, t.getMin());
        t.pop();
        assertEquals(2, t.getMin());

    }
}
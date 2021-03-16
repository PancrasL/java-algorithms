package indi.pancras.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/3/16 21:08
 */
class CircularQueueTest {

    @Test
    void testEnQueue() {
        CircularQueue t = new CircularQueue(4);
        assertTrue(t.enQueue(1));
        assertTrue(t.enQueue(2));
        assertTrue(t.enQueue(3));
        assertTrue(t.enQueue(4));
        assertFalse(t.enQueue(5));
        assertEquals(4, t.rear());
    }

    @Test
    void testDeQueue() {
        CircularQueue t = new CircularQueue(4);
        assertTrue(t.enQueue(1));
        assertTrue(t.enQueue(2));

        assertTrue(t.deQueue());
        assertEquals(2, t.front());
        assertTrue(t.deQueue());
        assertFalse(t.deQueue());
    }

    @Test
    void testAll() {
        CircularQueue t = new CircularQueue(4);
        t.enQueue(1);
        t.enQueue(2);
        t.enQueue(3);
        t.enQueue(4);
        assertTrue(t.isFull());

        t.deQueue();
        t.deQueue();
        t.enQueue(6);
        t.enQueue(7);
        assertEquals(3, t.front());
        assertEquals(7, t.rear());

    }
}
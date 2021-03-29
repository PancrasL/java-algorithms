package indi.pancras.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/29 19:06
 */
class SingleListTest {

    @Test
    void test() {
        SingleList t = new SingleList();

        t.addAtHead(1);
        t.addAtTail(3);
        t.addAtIndex(1, 2);
        assertEquals(1, t.get(0));
        assertEquals(2, t.get(1));
        assertEquals(3, t.get(2));
        assertEquals(-1, t.get(-1));
        assertEquals(-1, t.get(4));
        t.deleteAtIndex(0);
        t.deleteAtIndex(0);
        t.deleteAtIndex(0);
        t.deleteAtIndex(0);

    }
}
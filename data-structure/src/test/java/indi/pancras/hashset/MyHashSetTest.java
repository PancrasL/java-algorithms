package indi.pancras.hashset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/3/31 21:56
 */
class MyHashSetTest {

    @Test
    void test() {
        MyHashSet t = new MyHashSet();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(11);
        t.add(1);

        assertTrue(t.contains(1));
        assertTrue(t.contains(2));
        assertTrue(t.contains(3));

        t.remove(1);
        t.remove(3);

        assertFalse(t.contains(1));
        assertTrue(t.contains(11));
        //System.out.println(t.toString());
    }


}
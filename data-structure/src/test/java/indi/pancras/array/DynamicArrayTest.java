package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicArrayTest {
    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArray(-1));
    }

    @Test
    public void testAddOutOfBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            DynamicArray<Integer> array = new DynamicArray<Integer>();

            array.add(3, 5);
        });
    }

    @Test
    public void testRemoveOutOfBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            DynamicArray<Integer> array = new DynamicArray<Integer>();
            array.add(1);
            array.add(2);
            array.add(3);

            array.remove(9);
        });
    }

    @Test
    public void testCapacity() {
        DynamicArray<Integer> array = new DynamicArray<Integer>();

        int max = 200000;
        for (int i = 0; i < max; i++) {
            array.add(i);
        }
        assertEquals(max, array.size());
        assertEquals(max - 1, (int) array.get(max - 1));
    }

    @Test
    public void testDynamicArray() {
        DynamicArray<Integer> array = new DynamicArray<Integer>();

        assertTrue(array.isEmpty());

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        assertFalse(array.isEmpty());

        array.add(9, 2);
        assertEquals(9, (int) array.get(2));

        array.remove(2);
        assertEquals(3, (int) array.get(2));
        assertEquals(4, array.size());

        array.put(9, 1);
        assertEquals(9, (int) array.get(1));

    }
}

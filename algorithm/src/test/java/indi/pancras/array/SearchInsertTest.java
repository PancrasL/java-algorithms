package indi.pancras.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/11 16:49
 */
class SearchInsertTest {

    @Test
    void test() {
        SearchInsert t = new SearchInsert();

        assertEquals(0, t.run(new int[]{}, -1));
        assertEquals(0, t.run(new int[]{}, 1));

        assertEquals(0, t.run(new int[]{1}, -1));
        assertEquals(1, t.run(new int[]{1}, 3));

        assertEquals(0, t.run(new int[]{1, 3}, -1));
        assertEquals(1, t.run(new int[]{1, 3}, 2));
        assertEquals(2, t.run(new int[]{1, 3}, 6));

        assertEquals(0, t.run(new int[]{1, 3, 5}, -1));
        assertEquals(1, t.run(new int[]{1, 3, 5}, 2));
        assertEquals(2, t.run(new int[]{1, 3, 5}, 4));
        assertEquals(3, t.run(new int[]{1, 3, 5}, 6));
    }
}
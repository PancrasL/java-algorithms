package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/15 15:11
 */
class RemoveElementTest {

    @Test
    void test() {
        RemoveElement t = new RemoveElement();

        // 不含val
        assertEquals(4, t.run(new int[]{4, 4, 4, 4}, 5));
        // 只含val
        assertEquals(0, t.run(new int[]{5, 5, 5, 5}, 5));
        // val连续出现在末尾
        assertEquals(1, t.run(new int[]{4, 5, 5, 5}, 5));
        // val全部出现在中间
        assertEquals(2, t.run(new int[]{4, 5, 5, 4}, 5));
        // val交替出现在中间
        assertEquals(3, t.run(new int[]{4, 5, 4, 5, 4}, 5));
        // val出现在两侧
        assertEquals(2, t.run(new int[]{3, 2, 2, 3}, 3));
        // val出现在右侧
        assertEquals(1, t.run(new int[]{4, 5}, 5));
        // val出现在左侧
        assertEquals(1, t.run(new int[]{5, 4}, 5));

    }
}
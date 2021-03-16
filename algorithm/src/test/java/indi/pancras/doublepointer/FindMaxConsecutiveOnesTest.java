package indi.pancras.doublepointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/15 17:24
 */
class FindMaxConsecutiveOnesTest {

    @Test
    void test() {
        FindMaxConsecutiveOnes t = new FindMaxConsecutiveOnes();

        // 不含1
        assertEquals(0, t.run(new int[]{0, 0, 0}));
        // 只含1
        assertEquals(3, t.run(new int[]{1, 1, 1}));

        // 最长序列在末尾
        assertEquals(3, t.run(new int[]{1, 1, 0, 1, 1, 1}));
        // 最长序列在开头
        assertEquals(3, t.run(new int[]{1, 1, 1, 0, 1, 1}));
        // 最长序列在中间
        assertEquals(3, t.run(new int[]{0, 1, 1, 1, 0, 1}));


    }
}
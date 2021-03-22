package indi.pancras.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/19 15:20
 */
class OpenLockTest {

    @Test
    void test() {
        OpenLock t = new OpenLock();
        assertEquals(1, t.run(new String[]{"8888"}, "0090"));
        assertEquals(-1, t.run(new String[]{"1000", "0100", "0010", "0001", "9000", "0900", "0090", "0009"}, "1111"));
        assertEquals(6, t.run(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        assertEquals(-1, t.run(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        assertEquals(3, t.run(new String[]{"2110", "0202", "1222", "2221", "1010"}, "2010"));

    }
}
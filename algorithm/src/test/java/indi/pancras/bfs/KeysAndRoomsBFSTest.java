package indi.pancras.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author pancras
 * @create 2021/3/25 11:06
 */
class KeysAndRoomsBFSTest {

    @Test
    void test() {
        KeysAndRoomsBFS t = new KeysAndRoomsBFS();
        List<List<Integer>> lists1 = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0));
        assertFalse(t.run(lists1));

        List<List<Integer>> lists2 = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
        assertTrue(t.run(lists2));

    }
}
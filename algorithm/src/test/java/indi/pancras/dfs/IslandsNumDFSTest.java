package indi.pancras.dfs;

import org.junit.jupiter.api.Test;

import indi.pancras.bfs.IslandsNumBFS;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/3/17 10:14
 */
class IslandsNumDFSTest {

    @Test
    void test() {
        IslandsNumBFS t = new IslandsNumBFS();

        assertEquals(1, t.run(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        assertEquals(3, t.run(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
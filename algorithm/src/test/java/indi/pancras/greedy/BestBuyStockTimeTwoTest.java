package indi.pancras.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pancras
 * @create 2021/4/1 15:41
 */
class BestBuyStockTimeTwoTest {

    @Test
    void run() {
        BestBuyStockTimeTwo t = new BestBuyStockTimeTwo();
        assertEquals(0, t.run(new int[]{}));
        assertEquals(0, t.run(new int[]{1}));
        assertEquals(4, t.run(new int[]{1, 2, 3, 4, 5}));
        assertEquals(7, t.run(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
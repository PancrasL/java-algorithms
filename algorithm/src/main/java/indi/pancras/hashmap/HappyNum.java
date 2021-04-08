package indi.pancras.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pancras
 * @tip 哈希表 数学
 * @create 2021/4/1 20:38
 * @see <a href="https://leetcode-cn.com/leetbook/read/hash-table/xh1k9i/">快乐数</a>
 */
public class HappyNum {
    public boolean run(int n) {
        return new Solution().isHappy(n);
    }

    class Solution {
        public boolean isHappy(int n) {
            Map<Integer, Integer> map = new HashMap<>();

            while (!map.containsKey(n) && n != 1) {
                map.put(n, 1);

                int temp = 0;
                while (n != 0) {
                    int t = n % 10;
                    temp += t * t;
                    n /= 10;
                }
                n = temp;
            }

            return n == 1;
        }
    }
}

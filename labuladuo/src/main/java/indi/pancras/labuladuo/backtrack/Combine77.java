package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(n, 1, k, new ArrayList<>());
            return result;
        }

        // 总共n个数，正在决策第index个数，还需要加入k个数
        private void backtrack(int n, int index, int k, List<Integer> cur) {
            if (k == 0) {// 已经选取了k个数，构成一种方案
                ArrayList<Integer> list = new ArrayList<>(cur);
                result.add(list);
                return;
            }
            if (n - index+1 < k) {// 即使把剩下的所有数都加入，也不够k个数，剪枝处理
                return;
            }

            // 分支1：加入index
            cur.add(index);
            backtrack(n, index + 1, k-1, cur);
            cur.remove(cur.size() - 1);
            // 分支2：不加入index
            backtrack(n, index + 1, k, cur);
        }
    }
}

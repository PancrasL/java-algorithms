package indi.pancras.recursion;

/**
 * @author pancras
 * @create 2021/4/1 14:31
 * @see <a href="https://leetcode-cn.com/leetbook/read/recursion/46lfr/">第k个语法符号</a>
 */
public class KthChar {
    class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1 && K == 1)
                return 0;
            return (kthGrammar(N - 1, (K + 1) / 2) == (K % 2)) ? 1 : 0;
        }
    }
}

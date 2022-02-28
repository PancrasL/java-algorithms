package indi.pancras.labuladuo.math;

//计算尾数0的个数即计算因子10的个数，10=2*5，即计算因子2和5的对数
//由于因子2的个数一定多于5，每个5必定有一个2和其配对，因此因子5的个数就是0的个数
//因子5的个数可以通过n/5获得
public class TrailingZeroes172 {
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while (n / 5 > 0) {
                res += n / 5;
                n = n / 5;
            }
            return res;
        }
    }
}

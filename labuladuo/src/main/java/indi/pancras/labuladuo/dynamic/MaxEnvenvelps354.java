package indi.pancras.labuladuo.dynamic;

import java.util.Arrays;

public class MaxEnvenvelps354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Envelop[] envelopList = new Envelop[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                envelopList[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
            }
            Arrays.sort(envelopList, ((o1, o2) -> {
                if (o1.height == o2.height) {
                    return o1.width - o2.width;
                }
                return o1.height - o2.height;
            }));

            // dp[i]记录能装入第i个信封的数量
            int[] dp = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (envelopList[i].height > envelopList[j].height && envelopList[i].width > envelopList[j].width) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for (int i : dp) {
                res = Math.max(res, i);
            }
            return res;
        }

        class Envelop {
            int width;
            int height;

            public Envelop(int width, int height) {
                this.width = width;
                this.height = height;
            }
        }
    }
}


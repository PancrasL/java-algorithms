package indi.pancras.labuladuo.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindCelebrity277 {
    class Solution {
        public int findCelebrity(int n) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(i);
            }
            while (queue.size() >= 2) {
                int a = queue.poll();
                int b = queue.poll();
                boolean anb = knows(a, b);
                boolean bna = knows(b, a);
                if (anb && bna) {// ab相互认识，他们都不可能是名人
                    continue;
                } else if (anb && !bna) {// a认识b，b不认识a，则a肯定不是名人
                    queue.add(b);
                } else if (!anb && bna) {// a不认识b，b认识a，则b肯定不是名人
                    queue.add(a);
                } else {// a不认识b，b不认识a，则他们都不可能是名人（因为名人被所有人认识，而a、b至少不被一个人认识）
                    continue;
                }
            }
            if(queue.isEmpty()){
                return -1;
            }
            int candicate = queue.poll();
            for (int i = 0; i < n; i++) {
                if(i==candicate){
                    continue;
                }
                if(knows(candicate,i)){
                    return -1;
                }
                if(!knows(i,candicate)){
                    return -1;
                }
            }
            return candicate;
        }

        private boolean knows(int a, int b) {
            return true;
        }
    }
}

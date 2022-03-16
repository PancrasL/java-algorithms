package indi.pancras.labuladuo.hot;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SplitArrayToSubSeq659 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
    }

    static class Solution {
        public boolean isPossible(int[] nums) {
            // key是以nums[i]结尾的序列，value是这些序列的长度。
            HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            PriorityQueue<Integer> queue = new PriorityQueue();
            queue.add(1);
            map.put(nums[0], queue);
            for (int i = 1; i < nums.length; i++) {
                // 存在以nums[i]-1结尾的序列，将nums[i]接在序列长度最短的序列上
                if (map.containsKey(nums[i] - 1)) {
                    // 将原序列弹出
                    PriorityQueue<Integer> q = map.get(nums[i] - 1);
                    Integer seqLen = q.poll();
                    if (q.isEmpty()) {
                        map.remove(nums[i] - 1);
                    }
                    // 获得以nums[i]结尾的新序列
                    PriorityQueue<Integer> newQueue = map.computeIfAbsent(nums[i], v -> new PriorityQueue<>());
                    // 新序列的长度为原长度+1
                    newQueue.add(seqLen + 1);
                    map.put(nums[i], newQueue);
                } else {// 不存在以nums[i]-1的序列，创建一个以nums[i]为开头的新序列
                    PriorityQueue<Integer> newQueue = map.computeIfAbsent(nums[i], v -> new PriorityQueue<>());
                    // 新序列的长度为1
                    newQueue.add(1);
                    map.put(nums[i], newQueue);
                }
            }

            // 判断一下是否存在长度小于3的序列
            for (PriorityQueue<Integer> q : map.values()) {
                for (Integer i : q) {
                    if (i < 3) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

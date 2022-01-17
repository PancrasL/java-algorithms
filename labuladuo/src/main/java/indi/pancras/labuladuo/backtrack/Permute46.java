package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute46 {
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int[] cur = new int[nums.length];
            Arrays.fill(cur, Integer.MIN_VALUE);
            backtrack(nums, 0, cur);
            return result;
        }

        private void backtrack(int[] nums, int index, int[] cur) {
            if (index == nums.length) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i : cur) {
                    list.add(i);
                }
                result.add(list);
                return;
            }

            for (int i = 0; i < cur.length; i++) {
                if (cur[i] == Integer.MIN_VALUE) {// 有效的可以放置的位置
                    cur[i] = nums[index];
                    backtrack(nums, index + 1, cur);
                    cur[i] = Integer.MIN_VALUE;
                }
            }
        }
    }
}

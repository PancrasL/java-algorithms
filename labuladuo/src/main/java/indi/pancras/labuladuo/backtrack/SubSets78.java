package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubSets78 {
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0, new ArrayList<>());
            return result;
        }

        private void backtrack(int[] nums, int index, List<Integer> cur) {
            if (index == nums.length) {
                result.add(new ArrayList<>(cur));
                return;
            }
            // 添加当前元素的分支
            cur.add(nums[index]);
            backtrack(nums, index + 1, cur);
            cur.remove(cur.size() - 1);

            // 不添加当前元素的分支
            backtrack(nums, index + 1, cur);
        }
    }
}

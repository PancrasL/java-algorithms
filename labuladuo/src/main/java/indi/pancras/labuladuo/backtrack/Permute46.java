package indi.pancras.labuladuo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int[] validPos = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                validPos[i] = i;
            }
            int[] arr = new int[nums.length];
            backtrack(nums, 0, validPos, arr);
            return ans;
        }

        // flag为true：先加入元素再向后遍历 flag为false：先向后遍历再加入元素
        private void backtrack(int[] nums, int index, int[] validPos, int[] arr) {
            if (index == nums.length) {
                ArrayList<Integer> finish = new ArrayList<>();
                for (int i : arr) {
                    finish.add(i);
                }
                ans.add(finish);
            }
            for (int i = 0; i < validPos.length; i++) {
                if (validPos[i] != -1) {
                    int pos = validPos[i];
                    validPos[i] = -1;
                    arr[index] = nums[pos];
                    backtrack(nums, index + 1, validPos, arr);
                    validPos[i] = pos;
                }
            }
        }
    }
}

package indi.pancras.labuladuo.datastructure.array;

public class RemoveElement27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] == val) {
                    fast++;
                    continue;
                } else if (slow != fast) {
                    nums[slow] = nums[fast];
                }
                slow++;
                fast++;
            }
            return slow;
        }
    }
}

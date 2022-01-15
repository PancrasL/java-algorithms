package indi.pancras.labuladuo.datastructure.array;

public class MoveZeroes283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = 0;
            int zeroCnt = 0;
            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    zeroCnt++;
                    fast++;
                    continue;
                }
                nums[slow++] = nums[fast++];
            }
            while (slow < nums.length) {
                nums[slow] = 0;
                slow++;
            }
        }
    }
}

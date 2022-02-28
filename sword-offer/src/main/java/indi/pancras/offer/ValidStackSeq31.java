package indi.pancras.offer;

import java.util.Stack;

public class ValidStackSeq31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            int pushIndex = 0;
            int popIndex = 0;
            while (true) {
                while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
                if (popIndex == popped.length) {
                    return true;
                }
                if (pushIndex == pushed.length) {
                    return false;
                }
                stack.push(pushed[pushIndex++]);
            }
        }
    }
}

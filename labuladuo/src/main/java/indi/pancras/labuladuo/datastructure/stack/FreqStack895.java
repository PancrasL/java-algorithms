package indi.pancras.labuladuo.datastructure.stack;

import java.util.HashMap;
import java.util.Stack;

public class FreqStack895 {
    class FreqStack {

        private HashMap<Integer, Stack<Integer>> freqToStack = new HashMap<>();
        private HashMap<Integer, Integer> kToFreq = new HashMap<>();
        private int maxFreq = 1;

        public FreqStack() {

        }

        public void push(int val) {
            int f = kToFreq.getOrDefault(val, 0) + 1;
            kToFreq.put(val, f);
            if (f > maxFreq) {
                maxFreq = f;
            }
            Stack<Integer> stack = freqToStack.computeIfAbsent(f, v -> new Stack<>());
            stack.push(val);
        }

        public int pop() {
            Stack<Integer> stack = freqToStack.get(maxFreq);
            Integer key = stack.pop();
            if (stack.isEmpty()) {
                freqToStack.remove(maxFreq);
                maxFreq--;
            }
            int f = kToFreq.get(key) - 1;
            if (f == 0) {
                kToFreq.remove(key);
            } else {
                kToFreq.put(key, f);
            }
            return key;
        }
    }
}
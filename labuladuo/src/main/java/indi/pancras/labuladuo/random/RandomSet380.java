package indi.pancras.labuladuo.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomSet380 {
    class RandomizedSet {
        private HashMap<Integer, Integer> valToIndex = new HashMap<>();
        private ArrayList<Integer> arr = new ArrayList<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            arr.add(val);
            valToIndex.put(val, arr.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            // 将val和arr的最后一个元素交换位置，然后移除最后一个元素，并更新哈希索引
            int i = valToIndex.get(val);
            int lastVal = arr.get(arr.size() - 1);
            arr.set(i, lastVal);
            valToIndex.put(lastVal, i);
            valToIndex.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }

        public int getRandom() {
            int random = new Random().nextInt(arr.size());
            return arr.get(random);
        }
    }
}

package indi.pancras.labuladuo.slidewindow;

import java.util.HashMap;

public class MinWindow76 {
    static class Solution {
        private HashMap<Character, Integer> window = new HashMap<>();
        private HashMap<Character, Integer> target = new HashMap<>();

        private int left = 0, right = -1;
        int satisfy;
        int satisfyTarget;
        String ans = "";

        public String minWindow(String s, String t) {
            caculateCharOf(t);

            while (true) {
                if (!moveRight(s, t)) {
                    break;
                }
                moveLeft(s, t);
            }
            return ans;
        }

        // 统计字符串t出现的字符个数
        private void caculateCharOf(String t) {
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                target.merge(c, 1, Integer::sum);
            }
            satisfyTarget = target.size();
            satisfy = 0;
        }

        // 执行完毕后，窗口中包含t的所有字符
        private boolean moveRight(String s, String t) {
            right++;
            while (right < s.length()) {
                // 更新窗口中的词频
                char c = s.charAt(right);
                window.merge(c, 1, Integer::sum);
                // 如果字符c覆盖了串t中的c
                if (window.get(c).equals(target.get(c))) {
                    satisfy++;
                }
                // 窗口包含了串t
                if (satisfy == satisfyTarget) {
                    return true;
                }
                right++;
            }
            return false;
        }

        private boolean moveLeft(String s, String t) {
            while (left <= right) {
                char c = s.charAt(left);
                Integer cnt = window.get(c);
                window.put(c, cnt - 1);
                if (target.containsKey(c) && window.get(c) < target.get(c)) {
                    updateMin(s);
                    satisfy--;
                    left++;
                    return true;
                }
                left++;
            }
            return false;
        }

        private void updateMin(String s) {
            if (ans.isEmpty()) {
                ans = s.substring(left, right + 1);
            } else if (right - left + 1 < ans.length()) {
                ans = s.substring(left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minWindow("cabwefgewcwaefgcf", "cae");
    }
}

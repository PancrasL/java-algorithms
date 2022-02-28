package indi.pancras.offer;

public class TranslateNum46 {
    class Solution {
        int res = 0;

        public int translateNum(int num) {
            String numStr = Integer.toString(num);
            translate(numStr, 0);
            return res;
        }

        private void translate(String num, int index) {
            if (index == num.length()) {
                res++;
                return;
            }
            translate(num, index + 1);
            if (canConvert(num, index)) {
                translate(num, index + 2);
            }
        }

        private boolean canConvert(String num, int index) {
            if (index + 1 >= num.length()) {
                return false;
            }
            switch (num.charAt(index)) {
                case '0':
                    return false;
                case '1':
                    return true;
                case '2':
                    char second = num.charAt(index + 1);
                    return second >= '0' && second <= '5';
            }
            return false;
        }
    }
}

package indi.pancras.sort;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    // 库排序函数
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> stringList = new ArrayList<>();
            for (int num : nums) {
                stringList.add(String.valueOf(num));
            }
            stringList.sort(((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
            StringBuilder sb = new StringBuilder();
            for (String s : stringList) {
                sb.append(s);
            }
            if (sb.charAt(0) == '0') {
                return "0";
            }
            return sb.toString();
        }
    }

    public String largestNumber01(int[] nums) {
        return "";
    }
}

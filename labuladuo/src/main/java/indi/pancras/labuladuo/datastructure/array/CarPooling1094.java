package indi.pancras.labuladuo.datastructure.array;

import java.util.Arrays;

public class CarPooling1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] arr = new int[1002];
            for (int[] trip : trips) {
                int num = trip[0];
                int start = trip[1];
                int end = trip[2];
                arr[start]+=num;
                arr[end+1]-=num;
            }
            int passengerNum = arr[0];
            if(passengerNum > capacity){
                return false;
            }

            String s = Arrays.toString(arr);
            System.out.println(s);
            for (int i = 1; i < arr.length; i++) {
                passengerNum = passengerNum+arr[i];
                if(passengerNum>capacity){
                    System.out.println("pos:"+i+","+passengerNum+","+capacity);
                    return false;
                }
            }
            return true;
        }
    }
}

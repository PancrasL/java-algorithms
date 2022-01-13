package indi.pancras.labuladuo.datastructure.array;

public class StatisticFlight1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] arr = new int[n +2];
            for (int[] booking : bookings) {
                int start = booking[0];
                int end = booking[1];
                int inc = booking[2];
                arr[start] += inc;
                arr[end + 1] -= inc;
            }
            int[] result = new int[n];
            result[0] = arr[1];
            for (int i = 2; i <= result.length; i++) {
                result[i-1] = result[i -2 ] + arr[i];
            }
            return result;
        }
    }
}

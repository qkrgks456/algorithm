package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        long m = Long.parseLong(strings[1]);
        long[] longs = new long[n];
        for (int i = 0; i < n; i++) {
            longs[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }
}

package baekjoon.v2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long[] ints = new long[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(ints);
        long right = ints[ints.length - 1];
        long left = 0;
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (ints[i] > mid) {
                    sum += ints[i] - mid;
                }
            }
            if (sum >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}

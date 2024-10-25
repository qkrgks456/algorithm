package baekjoon.v2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, ints[i]);
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        int right = max;
        int left = 0;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += Math.min(ints[i], mid);
            }
            if (sum <= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);

    }
}

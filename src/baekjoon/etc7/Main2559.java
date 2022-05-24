package baekjoon.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] ints = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int start = 0;
        int end = k;
        // 합 구하기
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += ints[i];
        }
        int max = sum;
        while (end < ints.length) {
            sum -= ints[start];
            sum += ints[end];
            max = Math.max(sum, max);
            start++;
            end++;
        }
        System.out.println(max);
    }
}

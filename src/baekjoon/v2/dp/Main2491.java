package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = 1;
        int count = 1;

        // 증가 부분 수열 체크
        for (int i = 1; i < n; i++) {
            if (ints[i - 1] <= ints[i]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1; // 카운트 초기화
            }
        }
        result = Math.max(result, count); // 마지막 증가 부분 수열 체크

        count = 1;

        // 감소 부분 수열 체크
        for (int i = 1; i < n; i++) {
            if (ints[i - 1] >= ints[i]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count); // 마지막 감소 부분 수열 체크
        System.out.println(result);
    }
}

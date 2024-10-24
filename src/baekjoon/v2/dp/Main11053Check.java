package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11053Check {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // dp 배열을 모두 1로 초기화 (모든 원소는 최소 자기 자신을 포함하는 부분 수열이 되기 때문)
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 각 원소에 대해 그 앞의 값들과 비교
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // LIS를 찾으면 dp 업데이트
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}

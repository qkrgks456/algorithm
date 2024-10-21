package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11060Check {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; // 초기화
        }

        // 점프를 통해 도달하는 최소 횟수 계산
        for (int i = 0; i < n; i++) {
            if (dp[i] != Integer.MAX_VALUE) { // 현재 위치에 도달할 수 있는 경우
                for (int j = 1; j <= ints[i] && i + j < n; j++) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        // 마지막 위치의 값이 여전히 MAX_VALUE라면 도달할 수 없는 경우
        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1]);
        }

    }
}

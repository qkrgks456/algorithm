package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1]; // j-1에서 오는 경우
                if (j < 9) dp[i][j] += dp[i - 1][j + 1]; // j+1에서 오는 경우
                dp[i][j] %= 1000000000; // 모듈러 연산 적용
            }
        }
        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[n][j]) % 1000000000;
        }
        System.out.println(result);
    }
}

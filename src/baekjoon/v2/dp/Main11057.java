package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }
        int result = 0;
        for (int l = 0; l <= 9; l++) {
            result = (result + dp[n][l]) % 10007;
        }
        System.out.println(result);


    }
}

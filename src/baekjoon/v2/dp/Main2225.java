package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[][] dp = new int[201][201];
        for (int i = 1; i < dp.length; i++) {
            dp[1][i] = i;
            dp[i][1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[i].length; j++) {
                dp[i][j] = ((dp[i - 1][j] % 1000000000) + (dp[i][j - 1] % 1000000000)) % 1000000000;
            }
        }
        System.out.println(dp[n][k]);
    }
}

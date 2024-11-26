package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] ints = new int[2][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[1][j] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[2][n + 1];
            dp[0][0] = ints[0][0];
            dp[1][0] = ints[1][0];
            dp[0][1] = ints[0][1] + ints[1][0];
            dp[1][1] = ints[1][1] + ints[0][0];
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1] + ints[0][j], Math.max(dp[0][j - 2] + ints[0][j], dp[1][j - 2] + ints[0][j]));
                dp[1][j] = Math.max(dp[0][j - 1] + ints[1][j], Math.max(dp[0][j - 2] + ints[1][j], dp[1][j - 2] + ints[1][j]));
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}

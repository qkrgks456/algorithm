package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[10001];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[10001];
        dp[0] = ints[0];
        dp[1] = ints[0] + ints[1];
        dp[2] = Math.max(ints[0] + ints[2], Math.max(ints[0] + ints[1], ints[1] + ints[2]));
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(ints[i] + ints[i - 1] + dp[i - 3], Math.max(dp[i - 1], ints[i] + dp[i - 2]));
        }
        System.out.println(dp[n]);

    }
}

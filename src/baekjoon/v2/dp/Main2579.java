package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[301];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(ints[0]);
            return;
        }
        if (n == 2) {
            System.out.println(ints[0] + ints[1]);
            return;
        }
        int[] dp = new int[301];
        dp[0] = ints[0];
        dp[1] = ints[0] + ints[1];
        dp[2] = Math.max(ints[0] + ints[2], ints[1] + ints[2]);
        for (int i = 3; i <= n; i++) {
            int first = ints[i] + ints[i - 1] + dp[i - 3];
            int second = ints[i] + dp[i - 2];
            dp[i] = Math.max(first, second);
        }
        System.out.println(dp[n - 1]);

    }
}

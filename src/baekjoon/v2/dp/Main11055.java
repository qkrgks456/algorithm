package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11055 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            dp[i] = num;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[j] < ints[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + ints[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }
}

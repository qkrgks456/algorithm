package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[1001];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int j : dp) {
            result = Math.max(result, j);
        }
        System.out.println(result);
    }
}

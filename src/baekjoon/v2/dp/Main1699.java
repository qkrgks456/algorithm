package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }

    public static int findLargestSquare(int n) {
        // 제곱근 계산
        int sqrt = (int) Math.sqrt(n);
        // 제곱근의 제곱 반환
        return sqrt * sqrt;
    }
}

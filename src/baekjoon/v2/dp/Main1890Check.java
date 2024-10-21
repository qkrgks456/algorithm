package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1890Check {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) {
                    continue;  // 방법이 없거나 도착점인 경우 패스
                }

                int jump = ints[i][j];  // 현재 위치에서 점프할 수 있는 거리

                // 아래쪽으로 점프할 경우
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }

                // 오른쪽으로 점프할 경우
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}

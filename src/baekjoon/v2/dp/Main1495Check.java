package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1495Check {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] grid = new int[N];
        for (int i = 0; i < N; i++) {
            grid[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] dp = new int[N + 1][M + 1];
        dp[0][S] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] == 1) {
                    // M보다 작거나 같을경우 연주가능
                    if (j + grid[i - 1] <= M) {
                        dp[i][j + grid[i - 1]] = 1;
                    }
                    // 0보다 작으면 안된다
                    if (j - grid[i - 1] >= 0) {
                        dp[i][j - grid[i - 1]] = 1;
                    }
                }
            }
        }

        // 마지막 곡에서 가능한 최대 볼륨 찾기
        int result = -1;
        for (int j = 0; j <= M; j++) {
            if (dp[N][j] == 1) {
                result = Math.max(result, j);
            }
        }
        System.out.println(result);
    }
}

package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9465 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 아 DP 줭나 어려워 진짜로 살려주세요
    // 아 스트레스 너무 받누
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] ints = new int[2][N + 1];
            int[][] result = new int[2][N + 1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 1; k <= N; k++) {
                    ints[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            result[0][1] = ints[0][1];
            result[1][1] = ints[1][1];
            for (int k = 2; k <= N; k++) {
                result[0][k] = Math.max(result[1][k - 1], result[1][k - 2]) + ints[0][k];
                result[1][k] = Math.max(result[0][k - 1], result[0][k - 2]) + ints[1][k];
            }
            stringBuilder.append(Math.max(result[0][N], result[1][N]) + "\n");
        }
        System.out.println(stringBuilder);
    }
}

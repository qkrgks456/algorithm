package baekjoon.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    // 아 DP 진짜 너무 힘들다 이게 어떻게 실버1인가
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[n + 1][n + 1];
        int[][] result = new int[n + 1][n + 1];
        for (int i = 1; i < ints.length; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < ints[i].length; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j] - result[i - 1][j - 1] + ints[i][j];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(stringTokenizer.nextToken());
            int startY = Integer.parseInt(stringTokenizer.nextToken());
            int endX = Integer.parseInt(stringTokenizer.nextToken());
            int endY = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(result[endX][endY] - result[endX][startY - 1] - result[startX - 1][endY] + result[startX - 1][startY - 1] + "\n");
        }
        System.out.println(stringBuilder);
    }
}

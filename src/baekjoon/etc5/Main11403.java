package baekjoon.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11403 {
    public static void main(String[] args) throws Exception {
        // 플로이드 와샬 ?? 개 열받네
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ints[j][i] == 1 && ints[i][k] == 1) {
                        ints[j][k] = 1;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(ints[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}

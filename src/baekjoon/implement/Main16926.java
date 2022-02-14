package baekjoon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16926 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int check = 0;
        // 0번
        for (int j = 0; j < m - 1; j++) {
            check = ints[0][j];
            ints[0][j] = ints[0][j + 1];
            ints[0][j + 1] = check;
        }
        // 마지막번
        for (int j = m - 1; j > 0; j--) {
            check = ints[n - 1][j];
            ints[n - 1][j] = ints[n - 1][j - 1];
            ints[n - 1][j - 1] = check;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }

    }
}

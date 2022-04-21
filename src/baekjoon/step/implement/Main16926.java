package baekjoon.step.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16926 {
    static int r, count, checkCount;
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        checkCount = Math.min(n, m) / 2;
        for (int i = 0; i < r; i++) {
            count = 0;
            recursion(0, 0, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void recursion(int startN, int startM, int n, int m) {
        if (count == checkCount) {
            return;
        }
        int check = 0;
        count++;
        // 첫째
        for (int i = startM; i < m - 1; i++) {
            check = ints[startM][i];
            ints[startM][i] = ints[startM][i + 1];
            ints[startM][i + 1] = check;
        }

        // 둘째
        for (int i = startN; i < n - 1; i++) {
            check = ints[i][m - 1];
            ints[i][m - 1] = ints[i + 1][m - 1];
            ints[i + 1][m - 1] = check;
        }

        //셋째
        for (int i = m - 1; i > startM; i--) {
            check = ints[n - 1][i];
            ints[n - 1][i] = ints[n - 1][i - 1];
            ints[n - 1][i - 1] = check;
        }

        //넷째
        for (int i = n - 1; i > startN + 1; i--) {
            check = ints[i][startN];
            ints[i][startN] = ints[i - 1][startN];
            ints[i - 1][startN] = check;
        }
        recursion(startN + 1, startM + 1, n - 1, m - 1);
    }
}

package baekjoon.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
    static int n, l;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        l = Integer.parseInt(stringTokenizer.nextToken());
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                row[i][j] = num;
                col[j][i] = num;
            }
        }
        int count1 = rowCol(row);
        int count2 = rowCol(col);
        System.out.println(count1 + count2);
    }

    public static int rowCol(int[][] ints) {
        int result = 0;
        int[][] ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n - 1; j++) {
                if (ints[i][j] + 1 == ints[i][j + 1]) {
                    // 지보다 1크다면
                    for (int k = j, count = l; count > 0; k--, count--) {
                        if (k < 0 || ints[i][j] != ints[i][k] || ch[i][k] == 1) {
                            check = false;
                            break;
                        }
                    }
                } else if (ints[i][j] - 1 == ints[i][j + 1]) {
                    // 지보다 1작다면
                    for (int k = j + 1, count = l; count > 0; k++, count--) {
                        if (k >= n || ints[i][j + 1] != ints[i][k]) {
                            check = false;
                            break;
                        }
                        ch[i][k] = 1;
                    }
                } else if (Math.abs(ints[i][j] - ints[i][j + 1]) >= 2) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        return result;
    }
}

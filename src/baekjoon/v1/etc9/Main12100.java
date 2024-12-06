package baekjoon.v1.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12100 {
    static int[] check = new int[5];
    static int result = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        DFS(0, ints);
        System.out.println(result);
    }

    public static void DFS(int level, int[][] ints) {
        if (level == 5) {
            for (int num : check) {
                // 왼쪽으로 이동 완료 그 직후 동일한 녀석들 합치기
                int[][] firstMove = move(num, ints);
                int[][] sum = numSum(num, firstMove);
                ints = move(num, sum);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(ints[i][j], max);
                }
            }
            result = Math.max(max, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            check[level] = i;
            DFS(level + 1, ints);
        }
    }

    private static int[][] numSum(int num, int[][] ints) {
        switch (num) {
            case 0:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (ints[i][j] == ints[i][j + 1]) {
                            ints[i][j] *= 2;
                            ints[i][j + 1] = 0;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j > 0; j--) {
                        if (ints[i][j] == ints[i][j - 1]) {
                            ints[i][j] *= 2;
                            ints[i][j - 1] = 0;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (ints[j][i] == ints[j + 1][i]) {
                            ints[j][i] *= 2;
                            ints[j + 1][i] = 0;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j > 0; j--) {
                        if (ints[j][i] == ints[j - 1][i]) {
                            ints[j][i] *= 2;
                            ints[j - 1][i] = 0;
                        }
                    }
                }
                break;
        }
        return ints;
    }

    private static int[][] move(int num, int[][] ints) {
        int[][] ch = new int[n][n];
        switch (num) {
            // 왼쪽
            case 0:
                for (int i = 0; i < n; i++) {
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (ints[i][j] > 0) {
                            ch[i][count] = ints[i][j];
                            count++;
                        }
                    }
                }
                break;
            // 오른쪽
            case 1:
                for (int i = 0; i < n; i++) {
                    int count = n - 1;
                    for (int j = n - 1; j >= 0; j--) {
                        if (ints[i][j] > 0) {
                            ch[i][count] = ints[i][j];
                            count--;
                        }
                    }
                }
                break;
            // 위
            case 2:
                for (int i = 0; i < n; i++) {
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (ints[j][i] > 0) {
                            ch[count][i] = ints[j][i];
                            count++;
                        }
                    }
                }
                break;
            // 아래
            case 3:
                for (int i = 0; i < n; i++) {
                    int count = n - 1;
                    for (int j = n - 1; j >= 0; j--) {
                        if (ints[j][i] > 0) {
                            ch[count][i] = ints[j][i];
                            count--;
                        }
                    }
                }
                break;
        }
        return ch;
    }
}

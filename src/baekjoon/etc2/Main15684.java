package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684 {
    static int N, M, H, result;
    static int[][] ints, check, check2;
    static boolean answer;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[H][N];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            ints[n1 - 1][n2] = 1;
            ints[n1 - 1][n2 - 1] = 1;
        }
        result = 0;
        while (true) {
            check2 = new int[H][N];
            stick(0, 0, 0);
            if (answer) {
                System.out.println(result);
                break;
            }
            result++;
            if (result > 3) {
                System.out.println(-1);
                break;
            }
        }
    }

    public static void stick(int count, int x, int y) {
        if (count == result) {
            for (int i = 0; i < N; i++) {
                check = new int[H][N];
                answer = false;
                DFS(0, i, i);
                if (!answer) {
                    break;
                }
            }
            return;
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (check2[i][j] == 0 && ints[i][j] == 0 && ints[i][j + 1] == 0) {
                    check2[i][j] = 1;
                    ints[i][j] = 1;
                    ints[i][j + 1] = 1;
                    stick(count + 1, i, j);
                    check2[i][j] = 0;
                    ints[i][j] = 0;
                    ints[i][j + 1] = 0;
                }
            }
        }
    }

    public static void DFS(int x, int y, int self) {
        if (y == N) {
            return;
        }
        if (x == H) {
            if (y == self) {
                answer = true;
                return;
            }
            return;
        }

        if (check[x][y] == 0) {
            check[x][y] = 1;
            if (ints[x][y] == 1) {
                if (y - 1 < 0) {
                    DFS(x + 1, y + 1, self);
                } else if (y + 1 >= N) {
                    DFS(x + 1, y - 1, self);
                } else {
                    if (ints[x][y - 1] == 1) {
                        DFS(x + 1, y - 1, self);
                    } else if (ints[x][y + 1] == 1) {
                        DFS(x + 1, y + 1, self);
                    }
                }
            } else {
                DFS(x + 1, y, self);
            }
        }
    }
}

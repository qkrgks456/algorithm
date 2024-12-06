package baekjoon.v1.step.divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    static int[][] ints;
    static int mOneCount = 0;
    static int zeroCount = 0;
    static int OneCount = 0;
    // 3번연속 비슷한 부류라
    // 잘 풀어냈당 히히
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        DFS(0, 0, n);
        System.out.println(mOneCount);
        System.out.println(zeroCount);
        System.out.println(OneCount);
    }

    public static void DFS(int x, int y, int n) {
        if (numCheck(x, y, n)) {
            if (ints[x][y] == 1) {
                OneCount++;
            } else if (ints[x][y] == -1) {
                mOneCount++;
            } else {
                zeroCount++;
            }
            return;
        }
        int size = n / 3;
        int two = size * 2;
        DFS(x, y, size);
        DFS(x, y + size, size);
        DFS(x, y + two, size);
        DFS(x + size, y, size);
        DFS(x + size, y + size, size);
        DFS(x + size, y + two, size);
        DFS(x + two, y, size);
        DFS(x + two, y + size, size);
        DFS(x + two, y + two, size);
    }

    public static boolean numCheck(int x, int y, int n) {
        int num = ints[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (num != ints[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

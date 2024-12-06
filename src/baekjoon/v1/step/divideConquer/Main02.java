package baekjoon.v1.step.divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main02 {
    static int[][] ints;
    static StringBuilder stringBuilder = new StringBuilder();
    // 풀이 안 보고 푸니까 개 뿌듯하네 ㅋㅋ
    // 괄호만 잘 넣어주니까 풀린듯

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split("");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }

        DFS(0, 0, n);
        System.out.println(stringBuilder);
    }

    public static void DFS(int x, int y, int n) {
        if (numCheck(x, y, n)) {
            stringBuilder.append(ints[x][y]);
            return;
        }
        int size = n / 2;
        stringBuilder.append("(");
        DFS(x, y, size);
        DFS(x, y + size, size);
        DFS(x + size, y, size);
        DFS(x + size, y + size, size);
        stringBuilder.append(")");
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

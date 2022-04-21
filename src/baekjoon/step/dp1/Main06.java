package baekjoon.step.dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
    static int n;
    static int[][] ints;
    static Integer[][] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        ch = new Integer[n][n];
        ints[0][0] = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j <= i; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
                if (i == n - 1) {
                    ch[i][j] = Integer.parseInt(strings[j]);
                }
            }
        }
        if (n == 1) {
            System.out.println(ints[0][0]);
        }else{
            System.out.println(DFS(0, 0));
        }

    }

    public static int DFS(int num, int idx) {
        if (ch[num][idx] != null) {
            return ch[num][idx];
        }
        if (num == n - 1) {
            return ch[num][idx];
        }
        return ch[num][idx] = Math.max(DFS(num + 1, idx), DFS(num + 1, idx + 1)) + ints[num][idx];
    }
}

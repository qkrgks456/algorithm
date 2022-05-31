package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15683 {
    static int test = 0;
    static int count = 0;
    static int[] result;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] > 0 && ints[i][j] < 5) {
                    list.add(ints[i][j]);
                    count++;
                }
            }
        }
        result = new int[count];
        DFS(0, 0);
    }

    public static void DFS(int n, int level) {
        if (level == count) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            result[level] = i;
            DFS(i, level + 1);
        }
    }
}

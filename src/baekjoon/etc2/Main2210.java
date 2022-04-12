package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2210 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] result;
    static int[][] ints, ch;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ints = new int[5][5];
        result = new int[6];
        ch = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 5; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[0] = ints[i][j];
                DFS(i, j, 1);
            }
        }
        System.out.println(hashSet.size());
    }

    public static void DFS(int x, int y, int level) {
        if (level == 6) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int n : result) {
                stringBuilder.append(n);
            }
            hashSet.add(Integer.parseInt(String.valueOf(stringBuilder)));
            return;
        }
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                result[level] = ints[nx][ny];
                DFS(nx, ny, level + 1);
            }
        }
    }
}

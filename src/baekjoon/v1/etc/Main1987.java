package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
    static int r, c, max;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] graph;
    static int[][] result;
    static int[] ch2 = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        graph = new char[r][c];
        result = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < c; j++) {
                graph[i][j] = strings[j].charAt(0);
            }
        }
        ch2[graph[0][0] - 65] = 1;
        DFS(0, 0, 1);
        System.out.println(max);
    }

    public static void DFS(int x, int y, int count) {
        max = Math.max(max, count);
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && ch2[graph[nx][ny] - 65] == 0) {
                ch2[graph[nx][ny] - 65] = 1;
                DFS(nx, ny, count + 1);
                ch2[graph[nx][ny] - 65] = 0;
            }
        }
    }
}

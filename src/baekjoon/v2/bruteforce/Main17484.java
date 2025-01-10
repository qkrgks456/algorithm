package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17484 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        // 에이 그냥 부르트 포스로 조지자 사이즈도 작은데
        for (int i = 0; i < m; i++) {
            recursion(graph, 0, i, graph[0][i], "");
        }

        System.out.println(min);
    }

    public static void recursion(int[][] graph, int x, int y, int sum, String dir) {
        if (x == graph.length - 1) {
            min = Math.min(min, sum);
            return;
        }

        if (y - 1 >= 0 && !dir.equals("l")) {
            recursion(graph, x + 1, y - 1, sum + graph[x + 1][y - 1], "l");
        }

        if (y + 1 < graph[0].length && !dir.equals("r")) {
            recursion(graph, x + 1, y + 1, sum + graph[x + 1][y + 1], "r");
        }

        if (!dir.equals("m")) {
            recursion(graph, x + 1, y, sum + graph[x + 1][y], "m");
        }
    }
}

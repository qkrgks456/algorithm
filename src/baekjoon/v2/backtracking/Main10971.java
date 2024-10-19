package baekjoon.v2.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {
    static int n, result;
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        check = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        // 어떤 지점에서 출발하든지
        for (int i = 0; i < n; i++) {
            DFS(i, i, 0, 0);
        }
        System.out.println(result);
    }

    public static void DFS(int first, int start, int sum, int deep) {
        // 결국 도착지점이 조건으로 들어가야되네
        if (deep == n && first == start) {
            result = Math.min(result, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 같은 인덱스는 0이라고 했으니까 0이 아닐경우만
            if (check[start] == 0 && graph[start][i] != 0) {
                check[start] = 1;
                DFS(first, i, sum + graph[start][i], deep + 1);
                check[start] = 0;
            }
        }

    }
}

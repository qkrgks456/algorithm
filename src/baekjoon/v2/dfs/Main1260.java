package baekjoon.v2.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {

    static List<List<Integer>> graph;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int v = Integer.parseInt(stringTokenizer.nextToken());
        graph = new ArrayList<>();
        check = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        // 정렬 추가
        for (List<Integer> list : graph) {
            Collections.sort(list);
        }
        DFS(v);
        System.out.println();
        check = new int[n + 1];
        BFS(v);
    }

    public static void DFS(int n) {
        check[n] = 1;
        System.out.print(n + " ");
        for (int num : graph.get(n)) {
            if (check[num] == 0) DFS(num);
        }
    }

    public static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int num : graph.get(node)) {
                if (check[num] == 0) {
                    check[num] = 1;
                    queue.add(num);
                }
            }
        }
    }
}

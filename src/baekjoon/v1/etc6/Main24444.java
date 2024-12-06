package baekjoon.v1.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main24444 {
    static StringBuilder stringBuilder = new StringBuilder();
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int[] ch, result;
    static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        ch = new int[N + 1];
        result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        BFS(R);
        for (int i = 1; i < result.length; i++) {
            stringBuilder.append(result[i] + "\n");
        }
        System.out.print(stringBuilder);
    }

    public static void BFS(int n) {
        ch[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            result[integer] = count;
            count++;
            for (int num : list.get(integer)) {
                if (ch[num] == 0) {
                    ch[num] = 1;
                    queue.add(num);
                }
            }
        }
    }
}

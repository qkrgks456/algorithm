package baekjoon.v1.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main24480 {
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
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        ch[R] = 1;
        DFS(R);
        for (int i = 1; i < result.length; i++) {
            stringBuilder.append(result[i] + "\n");
        }
        System.out.print(stringBuilder);
    }

    public static void DFS(int n) {
        result[n] = count;
        count++;
        for (int num : list.get(n)) {
            if (ch[num] == 0) {
                ch[num] = 1;
                DFS(num);
            }
        }
    }
}

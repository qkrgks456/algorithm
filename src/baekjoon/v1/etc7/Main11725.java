package baekjoon.v1.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11725 {
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] ch;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ch = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        BFS();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(map.get(i) + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        ch[1] = 1;
        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            for (int n : list.get(integer)) {
                if (ch[n] == 0) {
                    ch[n] = 1;
                    map.put(n, integer);
                    queue.add(n);
                }
            }
        }
    }
}

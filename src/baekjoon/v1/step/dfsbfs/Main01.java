package baekjoon.v1.step.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main01 {
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list;
    static int[] ch;
    static int[] ch1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        list = new ArrayList<>();
        String[] strings = s.split(" ");
        int point = Integer.parseInt(strings[0]);
        int node = Integer.parseInt(strings[1]);
        int start = Integer.parseInt(strings[2]);
        ch = new int[point + 1];
        ch1 = new int[point + 1];
        ch[start] = 1;
        ch1[start] = 1;
        for (int i = 0; i <= point; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < node; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split(" ");
            list.get(Integer.parseInt(strings1[0])).add(Integer.parseInt(strings1[1]));
            list.get(Integer.parseInt(strings1[1])).add(Integer.parseInt(strings1[0]));
        }
        for (int i = 0; i <= point; i++) {
            Collections.sort(list.get(i));
        }
        DFS(start);
        stringBuilder.append("\n");
        BFS(start);
        System.out.println(stringBuilder);
    }

    public static void DFS(int num) {
        stringBuilder.append(num + " ");
        for (int n : list.get(num)) {
            if (ch[n] == 0) {
                ch[n] = 1;
                DFS(n);
            }
        }
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        stringBuilder.append(num + " ");
        while (!queue.isEmpty()) {
            for (int n : list.get(queue.poll())) {
                if (ch1[n] == 0) {
                    ch1[n] = 1;
                    stringBuilder.append(n + " ");
                    queue.add(n);
                }
            }
        }
    }
}

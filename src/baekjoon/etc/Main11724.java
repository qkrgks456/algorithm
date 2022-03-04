package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main11724 {
    static int[] ch;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        ch = new int[n];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            strings = bufferedReader.readLine().split(" ");
            list.get(Integer.parseInt(strings[0])).add(Integer.parseInt(strings[1]));
            list.get(Integer.parseInt(strings[1])).add(Integer.parseInt(strings[0]));
        }
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                BFS(i);
            }
        }
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        ch[num] = 1;
        for (int n : list.get(num)) {
            queue.add(n);
        }
        while (!queue.isEmpty()) {
            queue.poll();
        }
    }
}

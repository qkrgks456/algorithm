package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main11724 {
    static int[] ch;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        ch = new int[n + 1];
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
                result++;
                BFS(i);
            }
        }
        System.out.println(result);
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        ch[num] = 1;
        while (!queue.isEmpty()) {
            int number = queue.poll();
            for (int n : list.get(number)) {
                if (ch[n] == 0) {
                    ch[n] = 1;
                    queue.add(n);
                }
            }
        }
    }
}

package baekjoon.v1.step.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main02 {
    static ArrayList<ArrayList<Integer>> list;
    static int count = 0;
    static int[] ch;

    public static void main(String[] args) throws Exception {
        list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int point = Integer.parseInt(bufferedReader.readLine());
        int node = Integer.parseInt(bufferedReader.readLine());
        ch = new int[point + 1];
        ch[1] = 1;
        for (int i = 0; i <= point; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < node; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            list.get(Integer.parseInt(strings[0])).add(Integer.parseInt(strings[1]));
            list.get(Integer.parseInt(strings[1])).add(Integer.parseInt(strings[0]));
        }
        BFS(1);
        System.out.println(count);
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while (!queue.isEmpty()) {
            for (int n : list.get(queue.poll())) {
                if (ch[n] == 0) {
                    ch[n] = 1;
                    queue.add(n);
                    count++;
                }
            }
        }
    }
}

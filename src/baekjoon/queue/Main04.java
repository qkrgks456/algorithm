package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String s1 = bufferedReader.readLine();
            String[] strings = s.split(" ");
            int num = Integer.parseInt(strings[1]);
            String[] strings1 = s1.split(" ");
            for (int j = 0; j < strings1.length; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(j, Integer.parseInt(strings1[j]));
                queue.add(map);
            }
            while (true) {
                queue.poll().get(1);

            }
        }
    }
}

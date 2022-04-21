package baekjoon.step.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int[] ints = new int[10];
            Queue<ArrayList<Integer>> queue = new LinkedList<>();
            String s = bufferedReader.readLine();
            String s1 = bufferedReader.readLine();
            String[] strings = s.split(" ");
            int num = Integer.parseInt(strings[1]);
            String[] strings1 = s1.split(" ");
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < strings1.length; j++) {
                max = Math.max(max, Integer.parseInt(strings1[j]));
                ints[Integer.parseInt(strings1[j])]++;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0, Integer.parseInt(strings1[j]));
                list.add(1, j);
                queue.add(list);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = queue.poll();
                if (list.get(0) == max) {
                    count++;
                    ints[max]--;
                    for (int j = max; j >= 1; j--) {
                        if (ints[j] > 0) {
                            max = j;
                            break;
                        }
                    }
                    if (list.get(1) == num) {
                        break;
                    }
                } else {
                    queue.add(list);
                }
            }
            System.out.println(count);
        }
    }
}

package inflearn.stackqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main06 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        int num1 = Integer.parseInt(strings[0]);
        int num2 = Integer.parseInt(strings[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num1; i++) {
            queue.add(i);
        }
        int count = 0;
        while (queue.size() != 1) {
            if (count == num2 - 1) {
                queue.poll();
                count = 0;
            } else {
                queue.add(queue.poll());
                count++;
            }
        }
        System.out.println(queue.poll());
    }
}

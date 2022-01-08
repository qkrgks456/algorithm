package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            if (count == n1) {
                if (queue.size() == 0) {
                    stringBuilder.append(num + ">");
                } else {
                    stringBuilder.append(num + ", ");
                }
                count = 0;
            } else {
                queue.add(num);
            }
        }
        System.out.println(stringBuilder);
    }
}

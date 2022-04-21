package baekjoon.step.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        int[] ints = new int[n1];
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        for (int i = 0; i < n1; i++) {
            ints[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            int check = 0;
            int front = deque.peekFirst();
            if (ints[i] == front) {
                deque.pollFirst();
            } else {
                for (int num : deque) {
                    if (num == ints[i]) {
                        break;
                    }
                    check++;
                }
                if (deque.size() - check > check) {
                    while (true) {
                        int n2 = deque.pollFirst();
                        if (n2 == ints[i]) {
                            break;
                        }
                        deque.addLast(n2);
                        count++;
                    }
                } else {
                    while (true) {
                        int n2 = deque.pollLast();
                        count++;
                        if (n2 == ints[i]) {
                            break;
                        }
                        deque.addFirst(n2);
                    }
                }
            }
        }
        System.out.println(count);
    }
}

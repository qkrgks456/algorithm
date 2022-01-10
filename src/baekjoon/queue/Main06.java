package baekjoon.queue;

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
        int check = 0;
        int frontResult = 0;
        int backResult = 0;
        for (int i = 0; i < ints.length; i++) {
            int front = deque.peekFirst();
            int last = deque.peekLast();
            if (ints[i] == front) {
                deque.pollFirst();
            } else if (ints[i] == last) {
                deque.pollLast();
            } else {
                while (true) {
                    int num = deque.pollFirst();
                    deque.addLast(num);
                    if (last == num) {
                        break;
                    } else if (num == ints[i]) {
                        frontResult = check;
                    }
                    check++;
                }
                while (true) {
                    int num = deque.pollLast();
                    deque.addFirst(num);
                    if (last == num) {
                        break;
                    } else if (num == ints[i]) {
                        backResult = check;
                    }
                    check++;
                    System.out.println(frontResult + " " + backResult);
                }
            }
        }
        System.out.println(count);
    }
}

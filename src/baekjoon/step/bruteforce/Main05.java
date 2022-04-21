package baekjoon.step.bruteforce;

import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(666);
        } else {
            int count = 1;
            int front = 0;
            int num = 0;
            while (true) {
                if ((front % 10000) / 10 == 666 && front % 10 != 6) {
                    num = 0;
                    for (int i = 0; i < 1000; i++) {
                        if (count == n) {
                            System.out.println(front * 1000 + num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    front++;
                } else if (front % 1000 == 666) {
                    num = 0;
                    for (int i = 0; i < 1000; i++) {
                        if (count == n) {
                            System.out.println(front * 1000 + num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    front++;
                } else if (front % 100 == 66) {
                    num = 600;
                    for (int i = 0; i < 100; i++) {
                        if (count == n) {
                            System.out.println(front * 1000 + num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    front++;
                } else if (front % 10 == 6) {
                    num = 660;
                    for (int i = 0; i < 10; i++) {
                        if (count == n) {
                            System.out.println(front * 1000 + num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    front++;
                } else {
                    num = 666;
                    if (count == n) {
                        System.out.println(front * 1000 + num);
                        return;
                    }
                    count++;
                    front++;
                }
            }
        }
    }
}

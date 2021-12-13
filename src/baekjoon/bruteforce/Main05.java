package baekjoon.bruteforce;

import java.util.Scanner;

public class Main05 {
    /* 6660_000  666660
       0666_000 66660
       0066_600  6660
       0006_660  660*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((n % 10000));
        if (n == 1) {
            System.out.println(666);
        } else {
            int count = 1;
            int front = 0;
            int num = 0;
            while (true) {
                if ((front % 10000) / 10 == 666 && front % 10 != 6) {

                }

            }
        }
    }
}

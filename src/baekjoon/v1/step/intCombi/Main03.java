package baekjoon.v1.step.intCombi;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        // 유클리드 호제법으로 최대공약수랑 최소공배수를 구하자
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        int oneNum = n;
        int twoNum = n1;
        int num = 0;
        int result = 0;
        if (n > n1) {
            while (true) {
                num = n % n1;
                if (num == 0) {
                    result = n1;
                    System.out.println(result);
                    break;
                }
                n = n1;
                n1 = num;
            }
        } else {
            while (true) {
                num = n1 % n;
                if (num == 0) {
                    result = n;
                    System.out.println(result);
                    break;
                }
                n1 = n;
                n = num;
            }
        }
        System.out.println((oneNum / result) * (twoNum / result) * result);
    }
}


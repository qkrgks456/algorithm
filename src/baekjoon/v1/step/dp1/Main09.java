package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        // 규칙성이 있다
        // 0번은 이전 1번 9번은 이전 8번갯수
        // 나머지는 n-1 + n+1
        // 끝났으면 모듈러 연산 법칙에 따라서 a%n + b%n = (a+b)%n
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] ints = new long[10];
        long[] ch = new long[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
        }

        boolean check = true;
        long sum = 0;
        if (n == 1) {
            sum = 9;
        }
        for (int i = 1; i < n; i++) {
            sum = 0;
            if (check) {
                ch[0] = ints[1] % 1000000000;
                ch[9] = ints[8] % 1000000000;
                for (int j = 1; j < 9; j++) {
                    ch[j] = (ints[j - 1] + ints[j + 1]) % 1000000000;
                    sum += ch[j];
                }
                sum += ch[9];
                check = false;
            } else {
                ints[0] = ch[1] % 1000000000;
                ints[9] = ch[8] % 1000000000;
                for (int j = 1; j < 9; j++) {
                    ints[j] = (ch[j - 1] + ch[j + 1]) % 1000000000;
                    sum += ints[j];
                }
                sum += ints[9];
                check = true;
            }
        }
        System.out.println(sum % 1000000000);
    }
}

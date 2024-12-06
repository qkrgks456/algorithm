package baekjoon.v1.step.divideConquer;

import java.util.Scanner;

public class Main05 {
    // 최대 4000000
    // 곱셈의 역원을 어떻게 구해야 하는지 전혀 모르겠다
    // 이걸보고 조졌다고 한다 ㅋㅋㅋ
    // 와 골1문제 레전드네 개 어렵다 진짜
    static long num = 1000000007;
    static long[] longs = new long[4000001];
    static long bc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        longs[0] = 1;
        longs[1] = 1;
        for (int i = 2; i < longs.length; i++) {
            longs[i] = longs[i - 1] * i % num;
        }
        // 여기식이 제일 어려움
        // 페르마의 소정리 증명하는 방법이 너무 어려움
        long a = longs[n];
        bc = longs[k] * longs[n - k] % num;
        System.out.println(a * DFS(num - 2) % num);
    }

    // 지수 분할 정복하는거 이건 전에 해봐서 할만했음
    public static long DFS(long n2) {
        if (n2 == 1) {
            return bc % num;
        }
        long check = DFS(n2 / 2);
        if (n2 % 2 == 1) {
            return (check * check % num) * bc % num;
        }
        return check * check % num;
    }
}

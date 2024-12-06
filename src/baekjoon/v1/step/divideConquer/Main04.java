package baekjoon.v1.step.divideConquer;

import java.util.Scanner;

public class Main04 {
    // 2147483647
    // 이러면 속도초과 날것 같은데 시부러 ..
    // 배열에 담자니 21억개 배열 만드는것도 이상하고 ㅋㅋ
    // 모듈러 연산 개 빡치네 ㅋㅋㅋ
    // 나머지 정리 잘 못해서 자꼬 틀리네
    static long a = 0;
    static long c = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        long b = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println(DFS(b));
    }

    // 지수법칙이랑 모듈러 연산법칙 잘 활용하면 됨
    public static long DFS(long b) {
        if (b == 1) {
            return a % c;
        }
        long check = DFS(b / 2);
        if (b % 2 == 1) {
            return (check * check % c) * a % c;
        }
        return check * check % c;
    }
}

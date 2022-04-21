package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main08 {
    // ㅋㅋ 콤비네이션 표 그려봐서
    // 공식 찾으면 됨
    // 원래 하던식으로 하면 안됨
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        int[][] factorial = new int[1001][1001];
        factorial[1][0] = 1;
        factorial[1][1] = 1;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i][0] = 1;
            factorial[i][i] = 1;
            for (int j = 1; j <= i; j++) {
                factorial[i][j] = factorial[i - 1][j - 1] + factorial[i - 1][j];
            }
        }
        System.out.println(factorial[n][n1]);
    }
}

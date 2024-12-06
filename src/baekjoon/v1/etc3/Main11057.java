package baekjoon.v1.etc3;

import java.util.Scanner;

public class Main11057 {
    // 풀이가 말도 안된다 미쳤다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ints = new int[1001][10];

        // 다 1로 초기화
        for (int i = 0; i < ints[0].length; i++) {
            ints[0][i] = 1;
        }

        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    ints[i][j] += ints[i - 1][k] % 10007;
                }
            }
        }
        System.out.println(ints[n][0] % 10007);
    }
}

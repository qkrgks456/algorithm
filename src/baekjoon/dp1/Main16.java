package baekjoon.dp1;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] ch = new int[n + 1][k + 1];
        int[][] ints = new int[n][2];
        for (int i = 1; i < ch.length; i++) {
            int n1 = scanner.nextInt();
            ints[i - 1][0] = n1;
            for (int j = 1; j < ch[i].length; j++) {
                if (j == n1) {
                    int n2 = scanner.nextInt();
                    ch[i][j] = n2;
                    ints[i - 1][1] = n2;
                }
            }
        }
        // 식은 개 단순해 보이는데 진짜 힘들었다
        // 최댓값을 구할껀데
        // 1. 검사중인 물건을 넣지 않았을때 (한칸위 값)
        // 2. 한칸위에서 검사중인 무게에서 자기무게를 뺀 값 (예시로 7에서 3을빼면 4가 남는다) + 가치
        // 두개 맥스값
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < ch.length; i++) {
            for (int j = 1; j < ch[i].length; j++) {
                if (ints[i - 1][0] <= j) {
                    ch[i][j] = Math.max(ch[i - 1][j], ch[i - 1][j - ints[i - 1][0]] + ints[i - 1][1]);
                } else {
                    ch[i][j] = ch[i - 1][j];
                }
                max = Math.max(max, ch[i][j]);
            }
        }
        System.out.println(max);
    }
}

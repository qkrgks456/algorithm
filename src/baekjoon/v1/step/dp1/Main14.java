package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        // LCS 숫자 배열 만들기
        int[][] ints = new int[s1.length() + 1][s2.length() + 1];
        String[] strings1 = s1.split("");
        String[] strings2 = s2.split("");
        for (int i = 1; i < ints.length; i++) {
            for (int j = 1; j < ints[i].length; j++) {
                // 문자가 같으면 대각선 방향 + 1
                if (strings1[i - 1].equals(strings2[j - 1])) {
                    ints[i][j] = ints[i - 1][j - 1] + 1;
                } else {
                    // 같지 않으면 x축 이전 혹은 y축 이전 최댓값 넣기
                    ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
                }
            }
        }
        // 이차원 배열 마지막 값이 곧 최장길이
        System.out.println(ints[s1.length()][s2.length()]);
    }
}
